package projectforrevatureAPI.Correct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectforrevatureAPI.Correct.Model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByNameContainingIgnoreCase(String name);



}
