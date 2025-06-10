package uuu.petshopping.Test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.petshopping.Entity.Client;
import uuu.petshopping.Exception.PETDataInvalidException;
import uuu.petshopping.Exception.PETException;
import uuu.petshopping.Service.ClientService;

public class Test_ClientService_login {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入id"); // A145380873
		String id = scanner.next();
		System.out.println("請輸入password");
		String password = scanner.next(); // Thunderbolt-2000
		scanner.close();
		ClientService cService = new ClientService();
		Client c;
		try {
			c = cService.login(id, password);
			System.out.printf("登入成功 %s\n", c);
		} catch (PETDataInvalidException e) {
			System.err.println(e.getMessage()); // junior
		} catch (PETException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e); // senior
			System.err.println(e.getMessage() + ", 請聯絡admin"); // junior
		} catch (Exception e) {
			Logger.getLogger("").log(Level.SEVERE, "發生非預期錯誤", e); // senior
			System.err.println("發生系統性錯誤" + e + "請聯絡admin"); // junior
		}
		System.out.println("*****The End*****");
	}
}
