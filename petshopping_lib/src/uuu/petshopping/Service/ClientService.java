package uuu.petshopping.Service;
import uuu.petshopping.Entity.Client;
import uuu.petshopping.Exception.PETDataInvalidException;
import uuu.petshopping.Exception.PETException;
public class ClientService {
	private ClientsDAO dao = new ClientsDAO();

	public Client login(String id, String password) throws PETException {
		Client client = dao.SelectClientById(id, password);
		if(client != null && client.getPassword().equals(password)) return client;
		throw new PETDataInvalidException("登入失敗, 帳號或密碼不正確");
	}
	public void register(Client client) throws PETException {
		if(client == null) throw new IllegalArgumentException("註冊會員時, client物件不得為null");
		dao.insertClient(client);
	}
	public void update(Client client) throws PETException{
		if(client ==null) throw new IllegalArgumentException("修改會員時, client物件不得為null");
		dao.updateClient(client);
	}
	
}
