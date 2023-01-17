package com.tekupminiproject.TekupMiniProject.Services;

import com.tekupminiproject.TekupMiniProject.entities.Category;
import com.tekupminiproject.TekupMiniProject.entities.Product;
import com.tekupminiproject.TekupMiniProject.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public  void addProduct(Product product){
        productRepository.save(product);
    }
    public void removeProduct(long id){
        productRepository.deleteById(id);
    }
    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }
    public List<Product> getAllProductsByCategoryId(int id ){
        return productRepository.findAllByCategory_Id(id);
    }
    public void deleteProduct(long id ){
         productRepository.deleteById(id);
    }
}
