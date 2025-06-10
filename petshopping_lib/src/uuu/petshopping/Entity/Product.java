package uuu.petshopping.Entity;
import java.time.LocalDate;
import uuu.petshopping.Exception.PETDataInvalidException;
public class Product{
	private int id; // PKey AutoIncrement
	private String name; // Required Unique Index 1~60字元
	private double unitPrice; // Required >0 價格類建議使用double型別
	private int stock; // required, >=0 因為隨時變動，不建議使用建構式設定
	private String photoUrl; // Optional
	private String category; // Required, 2~10字元
	private String description = "";
	private LocalDate releaseDate; // Required
	private String placeOfProduct; // Optional

	public Product(){
		super();
	}
	public Product(int id, String name, double unitPrice){
		// this.id = id; this.name = name; this.unitPrice = unitPrice;
		this.setId(id);
		this.setName(name);
		this.setUnitPrice(unitPrice);
	}
	public Product(int id, String name, double unitPrice, int stock){
		this(id, name, unitPrice);
		this.setStock(stock);
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public static final int MIN_NAME_LENGTH = 1, MAX_NAME_LENGTH = 60;

	public String getName(){
		return name;
	}
	public void setName(String name){
		if(name != null && MIN_NAME_LENGTH < (name = name.trim()).length() && (name = name.trim()).length() >= MAX_NAME_LENGTH)
			this.name = name;
		else{
			String errMsg = String.format("產品名稱必須%d~%d字元間: %s\n", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public double getUnitPrice(){
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice){
		this.unitPrice = unitPrice;
	}
	public int getStock(){
		return stock;
	}
	public void setStock(int stock){
		this.stock = stock;
	}
	public String getPhotoUrl(){
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl){
		if(photoUrl == null)
			this.photoUrl = "";
		else this.photoUrl = photoUrl;
	}

	public static final int MIN_CATEGORY_LENGTH = 2, MAX_CATEGORY_LENGTH = 10;

	public String getCategory(){
		return category;
	}
	public void setCategory(String category){
		if(category != null && MIN_CATEGORY_LENGTH <= (category = category.trim()).length()
				&& category.length() <= MAX_CATEGORY_LENGTH)
			this.category = category;
		else{
			String errMsg = String.format("產品分類名稱必須%d~%d個字\n", MIN_CATEGORY_LENGTH, MAX_CATEGORY_LENGTH);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		if(description == null) description = "";
		this.description = description;
	}
	public LocalDate getReleaseDate(){
		return releaseDate;
	}
	public void setReleaseDate(String dateString){
		LocalDate date = LocalDate.parse(dateString);
		this.setReleaseDate(date);
	}
	public void setReleaseDate(LocalDate date){
		if(date != null)
			this.releaseDate = date;
		else{
			String errMsg = String.format("請設定正確上架日期: %s\n", releaseDate);
			throw new PETDataInvalidException(errMsg);
		}
	}
	public String getPlaceOfProduct(){
		return placeOfProduct;
	}
	public void setPlaceOfProduct(String placeOfProduct){
		if(placeOfProduct == null) placeOfProduct = "產地尚未被登入";
		this.placeOfProduct = placeOfProduct;
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "\n[產品編號= " + this.id + ", 名稱= " + this.name + ", 單價= " + this.unitPrice + ", 庫存= "
				+ this.stock + ", 圖片網址= " + this.photoUrl + ", 產品分類= " + this.category + ", \n商品介紹= " + this.description + ",\n上架日期= "
				+ this.releaseDate + ", 產地= " + this.placeOfProduct + "]";
	}
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}
	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj instanceof Product){
			boolean rtn = this.id == (((Product) obj).id);
			return rtn;
		}
		return false;
	}
}
