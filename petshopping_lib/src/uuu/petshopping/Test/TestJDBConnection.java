package uuu.petshopping.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TestJDBConnection {
	private static final String DRIVER;
	private static final String URL;
	private static final String USER_ID;
	private static final String PWD;
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("uuu.petshopping.service.mysql_jdbc");
		DRIVER = bundle.getString("jdbc.driver");
		System.out.printf("DRIVER = %s\n", DRIVER);
		URL = bundle.getString("jdbc.url");
		System.out.printf("URL = %s\n", URL);
		USER_ID = bundle.getString("jdbc.userid");
		System.out.printf("USER_ID = %s\n", USER_ID);
		PWD = bundle.getString("jdbc.pwd");
		System.out.printf("PWD = %s\n", PWD);
	}
	private static final String SELECT_CLIENT_BY_ID = "SELECT id, password, name, email, address, phone, gender, birthday, "
			+ " discount From clients WHERE id=? AND password=?;";

// 問號不放在單引號內
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("請輸入id");
//		String id = scanner.next();
//		System.out.println("請輸入密碼");
//		String password = scanner.next();
//		scanner.close();
		try {
			Class.forName(DRIVER);
			try {
				Connection connection = DriverManager.getConnection(URL, USER_ID, PWD);
				System.out.printf("connection.getCatalog = %s\n", connection.getCatalog());
				PreparedStatement pstmt = connection.prepareStatement(SELECT_CLIENT_BY_ID);
			} catch (SQLException e) {
				Logger.getLogger("").log(Level.SEVERE, "無法連線SQL或指令執行失敗", e);
				throw new RuntimeException("無法連線SQL或指令執行失敗");
			}
		} catch (ClassNotFoundException e) {
			Logger.getLogger("").log(Level.SEVERE, "無法載入JDBC Driver", e);
		}
	}
}
