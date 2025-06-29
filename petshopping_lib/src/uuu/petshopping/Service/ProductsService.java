package uuu.petshopping.Service;
import java.util.List;
import uuu.petshopping.Entity.Product;
import uuu.petshopping.Exception.PETException;
public class ProductsService{
	private ProductsDAO pDAO = new ProductsDAO();

	public List<Product> getAllProducts() throws PETException{
		return pDAO.selectAllProducts();
	}
}
