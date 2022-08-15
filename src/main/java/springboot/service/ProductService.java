package springboot.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Entity.Product;
import springboot.Exception.ProductException;
import springboot.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired 
	ProductRepository myfriend;
	
	public Product addProduct(Product p) throws ProductException {
		if(p.getLibelle().isEmpty()) {
		
			throw new ProductException("libelle reqiured");
		}
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1");
		 if(p.getPrix()<=0) {
		
			throw new ProductException("prix invalid");
		}
			//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2");
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa0"+myfriend.findByLibelle(p.getLibelle()));
		if(myfriend.findByLibelle(p.getLibelle())!=null) {
			throw new ProductException("libelle déja existe");
		}
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa3");
		p = myfriend.save(p);//tsob fil base de donneé baad trajaa 
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa4");
			return p;
	}

	public Product updateProduct(long ProductId,Product p) {
		p.setProductid(ProductId);//tarbet maa id eli fi bd 
		p  = myfriend.save(p);
		return p;
	}
	
	///return list<product>
	public List<Product> consultProduct() {
	    List<Product> products=	myfriend.findAll();//findall() return type list
	    return  products; 
	}
	
	public List<Product> getproduct(String prix){
		return myfriend.findByLibelleContaining(prix);
	}
	
	public void deleteProduit(long ProductId) {
		myfriend.deleteById(ProductId);
	}
	
}
