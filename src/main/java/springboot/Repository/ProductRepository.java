package springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springboot.Entity.Product;

@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product,Long> {
	
	@Query(value="SELECT * FROM produit WHERE prix<:prix",nativeQuery=true)
	List<Product> getproduct(float prix);
	
	@Query(value="SELECT * from produit where libelle=:lib",nativeQuery=true)
	List<Product> listOfPrudcts(String lib);
	
	
	List<Product> findByLibelle(String libelle);
	List<Product> findByPrixLessThan(float prix);
	List<Product> findByLibelleContaining(String x);
	
	
}
