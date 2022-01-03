package com.springdata.data.controller;

import com.springdata.data.exception.ModeloNotFoundException;
import com.springdata.data.model.Customer;
import com.springdata.data.service.CustomerService;
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
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){

        return customerService.findAll().map(customer->customer.isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(customer,HttpStatus.OK)).orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer id){
        if(customerService.findById(id).isEmpty()){
            throw new ModeloNotFoundException("ID  NO ENCONTRADO " +id);
        }

        return customerService.findById(id).map(customer -> new ResponseEntity(customer,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND) );

    }
/*    @PostMapping
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.saveOrUpdate(customer), HttpStatus.CREATED);
    }*/

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Customer customer) {
        Customer obj=customerService.saveOrUpdate(customer);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Customer>  update(@Valid @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.saveOrUpdate(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id ){

        return customerService.findById(id).isEmpty()?new ResponseEntity(HttpStatus.NO_CONTENT)
                :new ResponseEntity(customerService.deleteById(id),HttpStatus.OK);

    }
}
