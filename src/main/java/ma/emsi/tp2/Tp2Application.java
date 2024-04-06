package ma.emsi.tp2;

import ma.emsi.tp2.entities.Product;
import ma.emsi.tp2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner {
    @Autowired
    ProductRepository pr;
    public static void main(String[] args)  {

        SpringApplication.run(Tp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //pr.save(new Product(null,"pc_lenovo",5000,150));
        //pr.save(new Product(null,"pc_dell",5500,120));
        //pr.save(new Product(null,"pc_mac",15000,170));
        List<Product> list_produit=pr.findAll();
        list_produit.forEach(p->{System.out.println(p.toString());});
        Product product=pr.findById(Long.valueOf(1)).get();
        System.out.println("***************************");
        System.out.println(product.getName()+"    "+product.getPrice());
        System.out.println("***************************");
        List<Product> list=pr.findByNameContains("l");
        list.forEach(p->{System.out.println(p.toString());});
        System.out.println("***************************");
        List<Product> list2=pr.search("%l%");
        list2.forEach(p->{System.out.println(p.toString());});
        System.out.println("***************************");
        List<Product> list3=pr.searchByPrice(5300);
        list3.forEach(p->{System.out.println(p.toString());});
    }
}
