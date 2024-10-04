package com.demo.ecomerce.sales.service;

import com.demo.ecomerce.sales.client.CoreClient;
import com.demo.ecomerce.sales.entity.Product;
import com.demo.ecomerce.sales.entity.Sale;
import com.demo.ecomerce.sales.model.SaleProductResponse;
import com.demo.ecomerce.sales.model.SaleRequest;
import com.demo.ecomerce.sales.model.SaleResponse;
import com.netflix.discovery.converters.Auto;
import feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService implements ISaleService{

//    @Autowired
//    private CoreClient productClient;
//
//    public SalesService(CoreClient productClient) {
//        this.productClient = productClient;
//    }
//
//    public List<Product> fetchAllProducts() {
//        return productClient.getProducts();
//    }
//
//    public Product fetchProductById(Long id) {
//        return productClient.getProductById(id);
//    }

    @Override
    public SaleResponse generateSale(SaleRequest request) {
        return null;
    }

    @Override
    public void calculateSale(SaleRequest request, Sale sale, List<String> errors) {

    }

    @Override
    public SaleResponse getSaleById(int id) {
        Sale sale = new Sale();
        sale.setSaleId(id);
        return buildSaleResponse(sale);
    }

    private SaleResponse buildSaleResponse(Sale sale) {
        SaleResponse saleResponse = new SaleResponse();
        saleResponse.setId(sale.getSaleId());
        saleResponse.setTotalPay(sale.getTotalPay());
        saleResponse.setSubtotal(sale.getSubtotal());
        saleResponse.setTotalDiscount(sale.getTotalDiscount());
        saleResponse.setTaxes(sale.getTaxes());
        saleResponse.setDate(sale.getDate());

        return saleResponse;
    }

}