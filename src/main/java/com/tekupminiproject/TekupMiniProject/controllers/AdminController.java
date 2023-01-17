package com.tekupminiproject.TekupMiniProject.controllers;

import com.tekupminiproject.TekupMiniProject.Services.CategoryService;
import com.tekupminiproject.TekupMiniProject.Services.ProductService;
import com.tekupminiproject.TekupMiniProject.dto.productDTO;
import com.tekupminiproject.TekupMiniProject.entities.Category;
import com.tekupminiproject.TekupMiniProject.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
    public static String uploadDir=System.getProperty("user.dir")+"/springboot-tekup-project/src/main/resources/static/productImages";
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }
// categories section
    @GetMapping("/admin/categories")
    public String getCat(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping ("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id  ){
        categoryService.delCategory(id);
        return "redirect:/admin/categories";
    }
    @GetMapping ("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id , Model model   ) {
        Optional<Category> category=categoryService.getCategoryById(id);
        if (category.isPresent()){
            model.addAttribute("category",category.get());
            return "categoriesAdd";
        }
        else
        return "404";
    }
    // product section
    @GetMapping("/admin/products")
    public String getProducts(Model model) {
        model.addAttribute("products",productService.getAllProduct());
        return "products";
    }
    @GetMapping("/admin/products/add")
    public String productAdd(Model model ){
        model.addAttribute("productDTO",new productDTO());
        model.addAttribute("categories",categoryService.getAllCategory());
        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO") productDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName")String imgName)throws IOException{
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDimension(productDTO.getDimension());
        product.setDescription(productDTO.getDescription());
        product.setContact(productDTO.getContact());
        String imageUUID;
        if (!file.isEmpty()){
            imageUUID =file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
            Files.write(fileNameAndPath ,file.getBytes());
        }else {
            imageUUID =imgName;
        }
        product.setImageName(imageUUID);
        productService.addProduct(product);



        return "redirect:/admin/products";
    }
    @GetMapping ("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable int id  ) {
        productService.deleteProduct(id);
        return "redirect:/admin/products";
    }
    @GetMapping ("/admin/product/update/{id}")
    public String updateProduct(@PathVariable int id , Model model   ) {
       Product product = productService.getProductById(id).get();
       productDTO productdto =new productDTO();
       productdto.setId(product.getId());
       productdto.setName(product.getName());
       productdto.setContact(product.getContact());
       productdto.setDescription(product.getDescription());
       productdto.setDimension(product.getDimension());
       productdto.setPrice(product.getPrice());
       productdto.setPrice(product.getPrice());
       productdto.setCategoryId(product.getCategory().getId());
       model.addAttribute("categories" ,categoryService.getAllCategory());
       model.addAttribute("productDTO",productdto);
       return "productsAdd";
    }












}
