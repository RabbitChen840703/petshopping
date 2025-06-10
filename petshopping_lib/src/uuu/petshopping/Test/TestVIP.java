package uuu.petshopping.Test;

import uuu.petshopping.Entity.VIP;

public class TestVIP {

	public static void main(String[] args){
		VIP vip = new VIP(); 
		
		vip.setId("A123123123");
		System.out.printf("Id : %s\n", vip.getId());
		vip.setEmail("test3939@gmail.com");
		System.out.printf("Email : %s\n", vip.getEmail());
		vip.setPhone("0988563563");
		System.out.printf("Phone : %s\n", vip.getPhone());
		vip.setPassword("NTOU954321");
		System.out.printf("PWD: %s\n", vip.getPassword());
		vip.setName("雪福");
		System.out.printf("Name: %s\n", vip.getName());
		vip.setGender('F');
		System.out.printf("Gender: %s\n", vip.getGender());
		vip.setBirthday("2005-12-13");
		System.out.printf("Birthday: %s\n", vip.getBirthday());
		vip.setAddress("新北市板橋區文化路二段");
		System.out.printf("Address: %s\n", vip.getAddress());
		
		//TODO: 取得Customer必要欄位並且印出
		
		vip.setDiscount(2);
		System.out.printf("會員折扣: %s\n", vip.getDiscountString());
		System.out.printf("toString: %s \n", vip);

	}

}
