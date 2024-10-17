package com.example.demo.service;

import com.example.demo.model.Sale;

import java.util.List;

public interface ISaleService {
    List<Sale> getSales();
    Sale getSaleById(long id);
    void addSale(Sale sale);
    void updateSale(Sale sale);
    void deleteSale(long id);
    List<Sale> findByPriceSale(double price);

}
