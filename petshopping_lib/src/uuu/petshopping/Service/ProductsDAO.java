package uuu.petshopping.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uuu.petshopping.Entity.Product;
import uuu.petshopping.Entity.SpecialOffer;
import uuu.petshopping.Exception.PETException;
class ProductsDAO{
	private static final String SELECT_ALL_PRODUCTS = "SELECT id, name, unit_price, stock, photo_url, category, "
			+ " description, release_date, place_of_product, discount FROM products ORDER BY rand();";

	List<Product> selectAllProducts() throws PETException{
		List<Product> productsList = new ArrayList<>();
		try(Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_PRODUCTS);){
			try(ResultSet rs = pstmt.executeQuery();){
				while (rs.next()){
					Product product;
					int discount = rs.getInt("discount");
					if(discount > 0){
						product = new SpecialOffer();
						((SpecialOffer) product).setDiscount(discount);
					}else product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setUnitPrice(rs.getDouble("unit_price"));
					product.setStock(rs.getInt("stock"));
					product.setPhotoUrl(rs.getString("photo_url"));
					product.setCategory(rs.getString("category"));
					product.setDescription(rs.getString("description"));
					product.setReleaseDate(rs.getString("release_date"));
					product.setPlaceOfProduct(rs.getString("place_of_product"));
					productsList.add(product);
				}
			}
		}catch (SQLException e){
			throw new PETException("[查詢所有產品]失敗", e);
		}
		return productsList;
	}

	private static final String SELECT_PRODUCTS_BY_KEYWORD = "SELECT id, name, unit_price, stock, photo_url, category, "
			+ "  description, release_date, place_of_product, discount FROM products WHERE name LIKE ?;";

	List<Product> selectProductsByKeyword(String keyword) throws PETException{
		List<Product> productsList = new ArrayList<>();
		try(Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_KEYWORD);){
			pstmt.setString(1, "%" + keyword + "%");
			try(ResultSet rs = pstmt.executeQuery();){
				while (rs.next()){
					Product product;
					int discount = rs.getInt("discount");
					if(discount > 0){
						product = new SpecialOffer();
						((SpecialOffer) product).setDiscount(discount);
					}else product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setUnitPrice(rs.getDouble("unit_price"));
					product.setStock(rs.getInt("stock"));
					product.setPhotoUrl(rs.getString("photo_url"));
					product.setCategory(rs.getString("category"));
					product.setDescription(rs.getString("description"));
					product.setReleaseDate(rs.getString("release_date"));
					product.setPlaceOfProduct(rs.getString("place_of_product"));
					productsList.add(product);
				}
			}
		}catch (SQLException e){
			throw new PETException("[關鍵字查詢產品]失敗", e);
		}
		return productsList;
	}

	private static final String SELECT_PRODUCTS_BY_CATEGORY = "SELECT id, name, unit_price, stock, photo_url, category, "
			+ "  description, release_date, place_of_product, discount FROM products WHERE category =?;";

	List<Product> selectProductsByCategory(String category) throws PETException{
		List<Product> productsList = new ArrayList<>();
		try(Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_CATEGORY);){
			pstmt.setString(1, category);
			try(ResultSet rs = pstmt.executeQuery();){
				while (rs.next()){
					Product product;
					int discount = rs.getInt("discount");
					if(discount > 0){
						product = new SpecialOffer();
						((SpecialOffer) product).setDiscount(discount);
					}else product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setUnitPrice(rs.getDouble("unit_price"));
					product.setStock(rs.getInt("stock"));
					product.setPhotoUrl(rs.getString("photo_url"));
					product.setCategory(rs.getString("category"));
					product.setDescription(rs.getString("description"));
					product.setReleaseDate(rs.getString("release_date"));
					product.setPlaceOfProduct(rs.getString("place_of_product"));
					productsList.add(product);
				}
			}
		}catch (SQLException e){
			throw new PETException("[用類別查詢產品]失敗", e);
		}
		return productsList;
	}

	private static final String SELECT_LATEST_ARRIVAL_PRODUCTS = "SELECT id, name, unit_price, stock, photo_url, category, "
			+ "  description, release_date, place_of_product, discount FROM products ORDER BY release_date DESC LIMIT 5;";

	List<Product> selectLatestArrivalProducts() throws PETException{
		List<Product> productsList = new ArrayList<>();
		try(Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_LATEST_ARRIVAL_PRODUCTS);){
			try(ResultSet rs = pstmt.executeQuery();){
				while (rs.next()){
					Product product;
					int discount = rs.getInt("discount");
					if(discount > 0){
						product = new SpecialOffer();
						((SpecialOffer) product).setDiscount(discount);
					}else product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setUnitPrice(rs.getDouble("unit_price"));
					product.setStock(rs.getInt("stock"));
					product.setPhotoUrl(rs.getString("photo_url"));
					product.setCategory(rs.getString("category"));
					product.setDescription(rs.getString("description"));
					product.setReleaseDate(rs.getString("release_date"));
					product.setPlaceOfProduct(rs.getString("place_of_product"));
					productsList.add(product);
				}
			}
		}catch (SQLException e){
			throw new PETException("[查詢最新產品]失敗", e);
		}
		return productsList;
	}

	private static final String SELECT_PRODUCT_BY_ID = "SELECT id, name, unit_price, stock, photo_url, category, "
			+ " description, release_date, place_of_product, discount FROM products WHERE id =?;";

	Product selectProductById(String productId) throws PETException{
		Product product = null;
		try(Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCT_BY_ID);){
			pstmt.setString(1, productId);
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()) {
					int discount = rs.getInt("discount");
					if(discount >0) {
						product = new SpecialOffer();
						((SpecialOffer)product).setDiscount(discount);
					}else product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setUnitPrice(rs.getDouble("unit_price"));
					product.setStock(rs.getInt("stock"));
					product.setPhotoUrl(rs.getString("photo_url"));
					product.setCategory(rs.getString("category"));
					product.setDescription(rs.getString("description"));
					product.setReleaseDate(rs.getString("release_date"));
					product.setPlaceOfProduct(rs.getString("place_of_product"));
				}
			}
		}catch (SQLException e){
			throw new PETException("[用產品id查詢產品]失敗", e);
		}
		return product;
	}
}
