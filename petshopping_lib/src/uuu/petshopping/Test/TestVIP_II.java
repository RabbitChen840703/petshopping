package uuu.petshopping.Test;

import uuu.petshopping.Entity.VIP_II;

public class TestVIP_II {
	public static void main(String[] args){
		VIP_II v2 = new VIP_II();
		v2.setId("F126978410");
		System.out.printf("v2.id: %s\n", v2.getId());
		v2.setEmail(null);
		System.out.printf("v2.email: %s\n", v2.getEmail());
		v2.setPhone("0987654321");
		System.out.printf("v2,phone: %s\n", v2.getPhone());
		v2.setPassword("QWERTYUU");
		System.out.printf("v2.password: %s\n", v2.getPassword());
		v2.setName("貓貓兔寶寶");
		System.out.printf("v2.name: %s\n", v2.getName());
		v2.setGender('F');
		System.out.printf("v2.gender: %s\n", v2.getGender());
		v2.setBirthday(1995, 07, 03);
		System.out.printf("v2.birthday: %s\n", v2.getBirthday());
		v2.setAddress("台北市中正區重慶南路122號");
		System.out.printf("v2.address: %s\n", v2.getAddress());
		v2.setSubscribed(true);
		System.out.printf("v2.subscribed: %s\n", v2.isSubscribed());
		v2.setDiscount(12);
		System.out.printf("v2.discount: %s\n", v2.getDiscount());
		System.out.println(v2.toString());
	}
}
