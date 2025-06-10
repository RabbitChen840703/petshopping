package uuu.petshopping.Test;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.petshopping.Entity.Client;
import uuu.petshopping.Exception.PETDataInvalidException;
import uuu.petshopping.Exception.PETException;
import uuu.petshopping.Service.ClientService;
public class Test_ClientService_register {
	public static void main(String[] args) {
		try{
			Client client = new Client();
			ClientService cService = new ClientService();
			client.setId("A145380873");
			client.setPassword("Thunderbolt-2000");
			client.setName("Usagi Kanahei");
			client.setEmail("kanaheipinkusagi@gmail.com");
			client.setAddress("100台北市中正區重慶南路一段122號");
			client.setPhone("0987654123");
			client.setGender(Client.MALE);
			client.setBirthday(2000, 7, 3);
			cService.register(client);
		}catch(PETDataInvalidException e){
			System.err.println(e.getMessage());
		}catch(PETException e){
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
			System.err.println(e.getMessage() + ", 請聯絡admin");
		}catch(Exception e){
			Logger.getLogger("").log(Level.SEVERE, "發生非預期性錯誤: " + e.getMessage(), e);
			System.err.println("系統發生錯誤" + e + "請聯絡admin");
		}
		System.out.println("*****The End*****");
	}
}
