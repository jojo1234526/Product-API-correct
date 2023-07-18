package projectforrevatureAPI.Correct.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectforrevatureAPI.Correct.Model.Product;
import projectforrevatureAPI.Correct.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        for(Product product : productRepository.findAll()) {
            products.add(product);
        }
        return products;
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProductsSortedByPrice() {
        List<Product> products = productRepository.findAll();
        products.sort(Comparator.comparing(Product::getPrice));
        return products;
    }

}