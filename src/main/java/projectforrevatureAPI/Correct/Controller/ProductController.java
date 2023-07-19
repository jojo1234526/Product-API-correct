package projectforrevatureAPI.Correct.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProductsByPriceRange(
            @RequestParam double minPrice, @RequestParam double maxPrice) {

        List<Product> products = productService.filterProductsByPriceRange(minPrice, maxPrice);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/products/count")
    public ResponseEntity<Long> getCountOfProducts() {
        Long count = productService.getCountOfProducts();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
        List<Product> products = productService.searchProductsByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
                                                 @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(productId, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }


}
