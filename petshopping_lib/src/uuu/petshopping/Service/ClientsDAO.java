package uuu.petshopping.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import uuu.petshopping.Entity.Client;
import uuu.petshopping.Entity.VIP;
import uuu.petshopping.Exception.PETDataInvalidException;
import uuu.petshopping.Exception.PETException;
class ClientsDAO {
	private static final String SLECT_CLIENT_BY_ID = "SELECT id, password, name, email, address, phone, gender, "
			+ " birthday, discount FROM clients WHERE id=? And password=?;";

	Client SelectClientById(String id, String password) throws PETException {
		Client c = null;
		try (Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SLECT_CLIENT_BY_ID);){
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery();){
				while (rs.next()){
					int discount = rs.getInt("discount");
					if(discount > 0){
						c = new VIP();
						((VIP) c).setDiscount(discount);
					}else c = new Client();
					c.setId(rs.getString("id"));
					c.setPassword(rs.getString("password"));
					c.setName(rs.getString("name"));
					c.setEmail(rs.getString("email"));
					c.setAddress(rs.getString("address"));
					c.setPhone(rs.getString("phone"));
					c.setBirthday(rs.getString("birthday"));
				}
				return c;
			}
		}catch(SQLException e){
			throw new PETException("使用id查詢客戶失敗", e);
		}
	}

	private static final String ISERT_CLIENT = "INSERT INTO clients "
			+ " (id, password, name, email, address, phone, gender, birthday, discount)"
			+ "  VALUES (?,?,?,?,?,?,?,?,0)";

	void insertClient(Client client) throws PETException {
		try (Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(ISERT_CLIENT);){
			pstmt.setString(1, client.getId());
			pstmt.setString(2, client.getPassword());
			pstmt.setString(3, client.getName());
			pstmt.setString(4, client.getEmail());
			pstmt.setString(5, client.getAddress());
			pstmt.setString(6, client.getPhone());
			pstmt.setString(7, String.valueOf(client.getGender()));
			pstmt.setString(8, String.valueOf(client.getBirthday()));
			pstmt.executeUpdate();
		}catch(SQLIntegrityConstraintViolationException e){
			if(e.getMessage().lastIndexOf("PRIMARY") >= 0)
				throw new PETDataInvalidException("身分證號已被重複註冊" + e.getErrorCode());
			else if(e.getMessage().lastIndexOf("email_UNIQUE") >= 0)
				throw new PETDataInvalidException("郵件地址已被重複註冊" + e.getErrorCode());
			else if(e.getMessage().lastIndexOf("phone_UNIQUE") >= 0)
				throw new PETDataInvalidException("電話號碼已被重複註冊" + e.getErrorCode());
			else throw new PETException("新增會員失敗", e);
		}catch(SQLException e){
			throw new PETException("新增會員失敗", e);
		}
	}

	private static final String UPDATE_CLIENT = "UPDATE clients SET "
			+ " password=?, name=?, email=?, address=?, phone=?, gender=?, birthday=? WHERE id=?;";

	void updateClient(Client client) throws PETException {
		try (Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_CLIENT);){
			pstmt.setString(8, client.getId());
			pstmt.setString(1, client.getPassword());
			pstmt.setString(2, client.getName());
			pstmt.setString(3, client.getEmail());
			pstmt.setString(4, client.getAddress());
			pstmt.setString(5, client.getPhone());
			pstmt.setString(6, String.valueOf(client.getGender()));
			pstmt.setString(7, String.valueOf(client.getBirthday()));
		}catch(SQLIntegrityConstraintViolationException e){
			if(e.getMessage().lastIndexOf("email_UNIQUE") >= 0)
				throw new PETDataInvalidException("修改會員失敗, email不得與其他會員重複" + e.getErrorCode());
			else if(e.getMessage().lastIndexOf("phone_UNIQUE") >= 0)
				throw new PETDataInvalidException("修給會員失敗, 電話不得與其他會員重複" + e.getErrorCode());
			else throw new PETException("修改會員失敗", e);
		}catch(SQLException e){
			throw new PETException("修改會員失敗", e);
		}
	}
}
