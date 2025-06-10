package uuu.petshopping.Test;

import uuu.petshopping.Entity.SpecialOffer;

public class TestSpecialOffer {

	public static void main(String[] args){
		SpecialOffer sp = new SpecialOffer();
		sp.setId(2);
		System.out.printf("sp.id: %s\n", sp.getId());
		sp.setName("BC34 離乳貓與母貓專用乾糧");
		System.out.printf("sp.name: %s\n", sp.getName());
		sp.setUnitPrice(120); 
		System.out.printf("sp.UnitPrice: %s\n", sp.getUnitPrice());
		sp.setPhotoUrl("https://img3.momoshop.com.tw/expertimg/0009/141/334/mobile/img_02.jpg?t=1718358714894");
		System.out.printf("sp.PhotoUrl: %s\n", sp.getPhotoUrl());
		sp.setStock(900);
		System.out.printf("sp.stock: %s\n", sp.getStock());
		sp.setCategory("貓媽小貓糧食");
		System.out.printf("sp.category: %s\n", sp.getCategory());
		sp.setDescription(null);
		System.out.printf("sp.description: %s\n", sp.getDescription());
		sp.setReleaseDate("2005-12-05");
		System.out.printf("sp.releaseDate: %s\n", sp.getReleaseDate());
		sp.setPlaceOfProduct(null);
		System.out.printf("sp.placeOfProduct: %s\n", sp.getPlaceOfProduct());
		sp.setDiscount(2);
		System.out.printf("sp.discount: %s\n", sp.getDiscountString());
		System.out.printf("sp.unitPrice: %s\n", sp.getUnitPrice());
		System.out.printf("sp.listPrice: %s\n", sp.getListPrice());
		System.out.printf("toString(): %s\n" , sp);

	}

}
