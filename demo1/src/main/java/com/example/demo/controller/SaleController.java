package com.example.demo.controller;

import com.example.demo.model.Sale;
import com.example.demo.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SaleController {
    @Autowired
    ISaleService iSaleService;
    @Autowired
    private SpringDataWebAutoConfiguration springDataWebAutoConfiguration;

    @GetMapping("/")
    public String index(Model model) {
        List<Sale> sales = iSaleService.getSales();
        model.addAttribute("sales", sales);
        return "home";
    }
    @GetMapping("/showSale")
    public String addSale(Model model) {
        System.out.println("alo");
        Sale sale = new Sale();
        model.addAttribute("sale", sale);
        return "addSale";
    }
    @PostMapping("/addSale")
    public String addSale(@ModelAttribute Sale sale, Model model) {
        iSaleService.addSale(sale);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String deleteSale(@RequestParam ("saleId") long id) {
        iSaleService.deleteSale(id);

        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editSale(@PathVariable("id") long id, Model model) {
        Sale sale = iSaleService.getSaleById(id);
        model.addAttribute("saleEdit", sale);
        return "editSale";
    }
    @PostMapping("/editSale")
    public String editSale(@ModelAttribute Sale sale, Model model) {
        System.out.println("alo xin xin");
        iSaleService.updateSale(sale);
        return "redirect:/";
    }
    @PostMapping("/search")
    public String search(@RequestParam("search") double search, Model model) {
        List<Sale> list = iSaleService.findByPriceSale(search);
        model.addAttribute("sales", list);
        return "home";
    }

}
