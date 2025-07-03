package uuu.petshopping.Service;
import java.util.List;
import uuu.petshopping.Entity.Product;
import uuu.petshopping.Exception.PETException;
public class ProductsService{
	private ProductsDAO pDAO = new ProductsDAO();

	public List<Product> getAllProducts() throws PETException{
		return pDAO.selectAllProducts();
	}
	public List<Product> getProductsByKeyword(String keyword) throws PETException{
		return pDAO.selectProductsByKeyword(keyword);
	}
	public List<Product> getProductsByCategory(String category) throws PETException{
		return pDAO.selectProductsByCategory(category);
	}
	public List<Product> getLatestArrivalProducts()throws PETException{
		return pDAO.selectLatestArrivalProducts();
	}
	public Product getProductById(String productId)throws PETException{
		return pDAO.selectProductById(productId);
	}
}
