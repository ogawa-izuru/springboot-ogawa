package com.sample.sample.controller;

import java.util.List;

import com.sample.sample.entity.Product;
import com.sample.sample.repository.ProductRepository;
import com.sample.sample.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/product")
    @ResponseBody
    public List<Product> getArrayList() {

        System.out.println("a-----------------------------------------------------------------");
        List<Product> list = productRepository.findAll();
        System.out.println("b-----------------------------------------------------------------");
        System.out.println(list);
        System.out.println("c-----------------------------------------------------------------");
        return list;
    }

    // パラメータ一つ一つの設定するやり方。
    @RequestMapping(path = "/postRequestParam")
    @ResponseBody
    public Product submit(@ModelAttribute("product_name") String product_name,
            @ModelAttribute("product_price") int product_price) {

        Product product = new Product();
        product.setProduct_name(product_name);
        product.setProduct_price(product_price);

        return productRepository.saveAndFlush(product);
    }

    @RequestMapping("/product/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") int id) {
        return productRepository.findById(id);
    }

    // オブジェクトを丸々渡す方法
    // 例：this.http.post('http://localhost:8080/postRequestBody', product);
    // productは{product_nameとproduct_price}が入っている
    @RequestMapping(path = "/postRequestBody")
    @ResponseBody
    public Product postProduct(@RequestBody Product product) {

        return productRepository.saveAndFlush(product);
    }

    // 削除用メソッドです。。
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Product deleteProduct(@PathVariable("id") int id) {

        Product product = productRepository.findById(id);
        productRepository.delete(product);
        return product;
    }

}