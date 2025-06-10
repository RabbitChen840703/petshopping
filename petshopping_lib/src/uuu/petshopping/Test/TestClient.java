package uuu.petshopping.Test;

import uuu.petshopping.Entity.Client;

public class TestClient {

	public static void main(String[] args) {
		Client client = new Client();
		client.setId("A123123123");
		System.out.printf("client.id: %s\n", client.getId());
		client.setPassword("3939889fish");
		System.out.printf("client.password: %s\n", client.getPassword());
		client.setName("貓貓兔兔");
		System.out.printf("client.name: %s\n", client.getName());
		client.setEmail("19880423sakana@gmail.com");
		System.out.printf("client.mail: %s\n", client.getEmail());
		client.setAddress("台北市中正區重慶南路122號");
		System.out.printf("client.address: %s\n", client.getAddress());
		client.setPhone("0987654321");
		System.out.printf("client.phone: %s\n", client.getPhone());
		client.setGender('M');
		System.out.printf("client.gender: %s\n", client.getGender());
		client.setBirthday(1995,07,03);
		System.out.printf("client.birthday: %s\n", client.getBirthday());
		System.out.printf("client.age: %s\n", client.getAge());
		System.out.printf("client.toString: %s\n ", client);

	}

}
