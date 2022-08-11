package springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
	
}
