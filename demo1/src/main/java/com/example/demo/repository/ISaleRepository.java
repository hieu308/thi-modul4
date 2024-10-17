package com.example.demo.repository;

import com.example.demo.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
    @Query("SELECT p FROM Sale p WHERE p.priceSale = :price")
    List<Sale> findByPriceSale(double price);

}
