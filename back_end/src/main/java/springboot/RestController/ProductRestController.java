package springboot.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.Entity.Product;
import springboot.Exception.ProductException;
import springboot.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody Product p) throws ProductException {
		p=productservice.addProduct(p);
		if(p==null) {
		return new ResponseEntity<String>("Error !! ",HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Product>(p,HttpStatus.OK);
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
	public List<Product> getproduct(@RequestParam(name="prix") String prix){
		List<Product> listOfProducts =productservice.getproduct(prix);
		return listOfProducts;
   }
	
	@GetMapping("/ConsulterProduct")
	public List<Product> consultProduct(){
		return productservice.consultProduct();
	}
	
}
