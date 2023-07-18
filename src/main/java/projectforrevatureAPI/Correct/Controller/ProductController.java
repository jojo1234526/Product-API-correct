package projectforrevatureAPI.Correct.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectforrevatureAPI.Correct.Model.Product;
import projectforrevatureAPI.Correct.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/sorted")
    public List<Product> getAllProductsSortedByPrice() {
        return productService.getAllProductsSortedByPrice();
    }

}
