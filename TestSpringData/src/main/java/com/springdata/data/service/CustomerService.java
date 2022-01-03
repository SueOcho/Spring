package com.springdata.data.service;

import com.springdata.data.model.Customer;
import com.springdata.data.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements BaseService<Customer,Integer>{



    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findById(Integer id) {

        return customerRepository.findById(id);
    }

    @Override
    public Optional<List<Customer>> findAll() {
        return Optional.of(customerRepository.findAll());
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(customer-> {customerRepository.delete(customer);
        return true;}).orElse( false) ;
    }
}
