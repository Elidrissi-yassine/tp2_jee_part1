package ma.emsi.tp2.repository;

import ma.emsi.tp2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContains(String mot);
    List<Product> findByPriceGreaterThan(double price);

    @Query("select p from Product p where p.name like :x")
    List<Product> search(@Param("x") String mot);
    @Query("select p from Product p where p.price>:x")
    List<Product> searchByPrice(@Param("x") double price);
}
