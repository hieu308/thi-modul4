package com.example.demo.service;

import com.example.demo.model.Sale;
import com.example.demo.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ISaleService {
    @Autowired
    private ISaleRepository saleRepository;

    @Override
    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

    @Override
    public void addSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public Sale getSaleById(long id) {
        return saleRepository.findById(id).get();
    }

    @Override
    public void updateSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public void deleteSale(long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public List<Sale> findByPriceSale(double price) {
        return saleRepository.findByPriceSale(price);
    }
}
