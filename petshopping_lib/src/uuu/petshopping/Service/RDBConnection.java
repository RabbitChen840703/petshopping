package uuu.petshopping.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.petshopping.Exception.PETException;
class RDBConnection {
	private static final String DRIVER;
	private static final String URL;
	private static final String USER_ID;
	private static final String PWD;
	static{
		// properties 或 Resource Bundle可讀取這個檔案 Resource Bundle只能讀不能改
		// 用Resource 可以用Zip檔壓縮而不是另外放容易被更改密碼
		// ResourceBundle只是一個區域變數
		ResourceBundle bundle = ResourceBundle.getBundle("uuu.petshopping.Service.mysql_jdbc");
		DRIVER = bundle.getString("jdbc.driver");
		// System.out.printf("DRIVER: %s\n", DRIVER);
		URL = bundle.getString("jdbc.url");
		// System.out.printf("URL: %s\n", URL);
		USER_ID = bundle.getString("jdbc.userid");
		// System.out.printf("USERID: %s\n", USER_ID);
		PWD = bundle.getString("jdbc.pwd");
		// System.out.printf("PWD: %s\n", PWD);
	}

	static Connection getConnection() throws PETException {
		try{ // 1. 載入Driver
			Class.forName(DRIVER);
			try{ // 2. 建立連線
				Connection connection = DriverManager.getConnection(URL, USER_ID, PWD);
				// System.out.printf("connection.getCatalog: %s\n", connection.getCatalog());
				return connection; // 建立連線是供給Client DAO使用, 不是自己使用
			}catch(SQLException e){
//				Logger.getLogger("").log(Level.SEVERE, "無法建立SQL連線", e);
				throw new PETException("無法建立SQL連線", e);
				// Logger僅有記錄功能, 不能回傳, 無法滿足商業程式的時效性, throw new 才能前拋錯誤訊息, 滿足商用程式時效性
			}
		}catch(ClassNotFoundException e){
//			Logger.getLogger("").log(Level.SEVERE, "無法載入JDBC Driver", e);
			throw new PETException("無法載入JDBC Driver", e);
		}
	}
}
