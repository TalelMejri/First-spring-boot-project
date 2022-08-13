package springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springboot.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
	@Query(value="SELECT * FROM produit WHERE prix<:prix",nativeQuery=true)
	List<Product> getproduct(float prix);
	
}
