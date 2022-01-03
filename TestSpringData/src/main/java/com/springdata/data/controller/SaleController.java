package com.springdata.data.controller;

import com.springdata.data.exception.ModeloNotFoundException;
import com.springdata.data.model.Sale;
import com.springdata.data.service.SaleService;
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
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getSales(){

        return saleService.findAll().map(sale->sale.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(sale,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSale(@PathVariable("id") Integer id){
        if(saleService.findById(id).isEmpty()){
            throw new ModeloNotFoundException("ID  NO ENCONTRADO " +id);
        }

        return saleService.findById(id).map(sale -> new ResponseEntity(sale,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND) );

    }
/*    @PostMapping
    public ResponseEntity<Sale> save(@Valid @RequestBody Sale sale) {
        return new ResponseEntity<>(saleService.saveOrUpdate(sale), HttpStatus.CREATED);
    }*/

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Sale sale) {
        Sale obj=saleService.saveOrUpdate(sale);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Sale>  update(@Valid @RequestBody Sale sale){
        return new ResponseEntity<>(saleService.saveOrUpdate(sale), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return saleService.findById(id).isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(saleService.deleteById(id),HttpStatus.OK);

    }
}
