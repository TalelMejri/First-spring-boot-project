package springboot.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Entity.Product;
import springboot.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired 
	ProductRepository myfriend;
	
	public Product addProduct(Product p) {
		p = myfriend.save(p);//tsob fil base de donneé baad trajaa 
		return p;
	}
	
	public Product updateProduct(long ProductId,Product p) {
		p.setProductid(ProductId);
		p  = myfriend.save(p);
		return p;
	}
	
	///return list<product>
	public List<Product> consultProduct() {
	    List<Product> products=	myfriend.findAll();//findall() return type list
	    return  products; 
	}
	
	public void deleteProduit(long ProductId) {
		myfriend.deleteById(ProductId);
	}
}
