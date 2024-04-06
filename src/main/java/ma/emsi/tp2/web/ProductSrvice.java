package ma.emsi.tp2.web;

import ma.emsi.tp2.entities.Product;
import ma.emsi.tp2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductSrvice {
    @Autowired
    private ProductRepository pr_repo;

    @GetMapping("/products")
    public List<Product> products(){
        return pr_repo.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findproductid(@PathVariable Long id){

        Product product= pr_repo.findById(id).orElse(null);
        return product;
    }
}
