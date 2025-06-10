package uuu.petshopping.Test;

import uuu.petshopping.Entity.Product;

public class TestProduct {
	public static void main(String[] args){
		Product product = new Product();
		product.setId(30);
		System.out.printf("product.id: %s\n", product.getId());
		product.setName("好吃貓罐罐");
		System.out.printf("product.name: %s\n", product.getName());
		product.setUnitPrice(57);
		System.out.printf("product.unitPrice: %s\n", product.getUnitPrice());
		product.setStock(6000);
		System.out.printf("product.stock: %s\n", product.getStock());
		product.setPhotoUrl(null);
		System.out.printf("product.photoUrl: %s\n", product.getPhotoUrl());
		product.setCategory(null);
		System.out.printf("product.category: %s\n", product.getCategory());
		product.setDescription(null);
		System.out.printf("product.description: %s\n", product.getDescription());
		product.setReleaseDate("2025-03-31");
		System.out.printf("product.releaseDate: %s\n", product.getReleaseDate());
		product.setPlaceOfProduct(null);
		System.out.printf("product.placeOfProduct: %s\n", product.getPlaceOfProduct());
		System.out.printf("toString: %s\n", product.toString());
	}

}
