package springboot.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.Entity.Product;
import springboot.service.ProductService;

@RestController
 @CrossOrigin// yaani ey waa7ed mel 3alem  enajem consomer les api mtena 
public class ProductRestController {
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product p) {
		return productservice.addProduct(p);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestParam(name="id") Long productId,@RequestBody Product p) {
		p=productservice.updateProduct(productId,p);
		return p;
	}
	
	@DeleteMapping("/deleteProduit")
	public void deleteproduct(@RequestParam(name="id") Long id) {
		productservice.deleteProduit(id);
	}
	
	@GetMapping("/getproduct")
	public List<Product> getproduct(@RequestParam(name="prix") float prix){
		return productservice.getproduct(prix);
   }
	
	@GetMapping("/ConsulterProduct")
	public List<Product> consultProduct(){
		return productservice.consultProduct();
	}
	
}
