package com.springdata.data.repository;

import com.springdata.data.model.Sale;
import com.springdata.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
