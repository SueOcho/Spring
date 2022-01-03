package com.springdata.data.service;

import com.springdata.data.model.Sale;
import com.springdata.data.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService implements BaseService<Sale,Integer>{



    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Optional<Sale> findById(Integer id) {

        return saleRepository.findById(id);
    }

    @Override
    public Optional<List<Sale>> findAll() {
        return Optional.of(saleRepository.findAll());
    }

    @Override
    public Sale saveOrUpdate(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public boolean deleteById(Integer id) {

        return findById(id).map(sale-> {saleRepository.delete(sale);
        return true;}).orElse( false) ;
    }
}
