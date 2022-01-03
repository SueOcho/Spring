package com.springdata.data.controller;

import com.springdata.data.exception.ModeloNotFoundException;
import com.springdata.data.model.Product;
import com.springdata.data.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

//@CrossOrigin(origins="localhost:4200")
@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){

        return productService.findAll().map(product->product.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(product,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id){
        if(productService.findById(id).isEmpty()){
            throw new ModeloNotFoundException("ID  NO ENCONTRADO " +id);
        }

        return productService.findById(id).map(product -> new ResponseEntity(product,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND) );

    }
/*    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productService.saveOrUpdate(product), HttpStatus.CREATED);
    }*/

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Product product) {
        Product obj=productService.saveOrUpdate(product);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Product>  update(@Valid @RequestBody Product product){
        return new ResponseEntity<>(productService.saveOrUpdate(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return productService.findById(id).isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(productService.deleteById(id),HttpStatus.OK);

    }
}
