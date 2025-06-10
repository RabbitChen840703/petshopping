package uuu.petshopping.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uuu.petshopping.Entity.Client;
import uuu.petshopping.Exception.PETDataInvalidException;
import uuu.petshopping.Exception.PETException;
import uuu.petshopping.Service.ClientService;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet(){
		super();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		List<String> errorsList = new ArrayList<>();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");// 前端檢查不管怎麼樣都能被竄改，所以一定要在後端設定檢查
		String captCha = request.getParameter("captCha");
		if(id == null || (id = id.trim()).length() == 0) errorsList.add("必須輸入帳號");
		if(password == null || (password = password.trim()).length() == 0) errorsList.add("必須設定密碼");
		if(name == null || (name = name.trim()).length() == 0) errorsList.add("必須輸入姓名");
		if(email == null || (email = email.trim()).length() == 0) errorsList.add("必須輸入email");
		if(phone == null || (phone = phone.trim()).length() == 0) errorsList.add("必須輸入手機號碼");
		if(gender == null || (gender = gender.trim()).length() == 0) errorsList.add("必須輸入性別");
		if(birthday == null || (birthday = birthday.trim()).length() == 0) errorsList.add("必須輸入生日");
		if(captCha == null || (captCha.trim()).length() == 0){
			errorsList.add("必須輸入驗證碼");
		}else{
			String stdCaptCha = (String) session.getAttribute("captCha");
			if(!captCha.equalsIgnoreCase(stdCaptCha)) errorsList.add("驗證碼不正確");
		}
		if(errorsList.isEmpty()){
			try{
				Client member = new Client();
				ClientService cService = new ClientService();
				member.setId(id);
				member.setPassword(password);
				member.setName(name);
				member.setEmail(email);
				member.setAddress(address);
				member.setPhone(phone);
				member.setGender(gender.charAt(0));
				member.setBirthday(birthday);
				System.out.println(member);// for test
				cService.register(member);
				request.setAttribute("member", member);
				RequestDispatcher dispatcher = request.getRequestDispatcher("register_ok.jsp");
				dispatcher.forward(request, response);
				return;
			}catch (PETDataInvalidException e){
				errorsList.add(e.getMessage());
			}catch (PETException e){
				this.log(e.getMessage(), e);
				errorsList.add(e.getMessage() + ", 請聯絡admin");
			}catch (Exception e){
				this.log("系統發生非預期性錯誤" + e.getMessage(), e);
				errorsList.add("系統錯誤" + e + "請聯絡admin");
			}
		}
		request.setAttribute("errorsList", errorsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
		return;
	}
}
