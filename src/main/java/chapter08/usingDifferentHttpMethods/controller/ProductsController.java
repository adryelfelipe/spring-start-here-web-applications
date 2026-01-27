package chapter08.usingDifferentHttpMethods.controller;

import chapter08.usingDifferentHttpMethods.model.Product;
import chapter08.usingDifferentHttpMethods.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {
    // Attributes
    private ProductService productService;

    // Constructor
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    // Methods
    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.findAll());

        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             Model model) {
        Product product = new Product(price, name);
        productService.addProduct(product);
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping("/testing")
    public String test(Product product) {
        return "home.html";
    }
}
