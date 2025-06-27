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
import uuu.petshopping.Entity.VIP;
import uuu.petshopping.Exception.PETDataInvalidException;
import uuu.petshopping.Exception.PETException;
import uuu.petshopping.Service.ClientService;
/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/update.do")
public class UpdateMemberServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMemberServlet(){
		super();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<String> errorsList = new ArrayList<>();
		HttpSession session = request.getSession();
		Client member = (Client) session.getAttribute("member");// 更新前的member
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String newPwd = request.getParameter("newPwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String captCha = request.getParameter("captCha");
		if(member == null || !member.getId().equals(id)) errorsList.add("身分證號不得竄改");
		if(password == null || (password = password.trim()).length() == 0) errorsList.add("請輸入密碼");
		if(name == null || (name = name.trim()).length() == 0) errorsList.add("必須輸入姓名");
		if(email == null || (email = email.trim()).length() == 0) errorsList.add("必須輸入email");
		if(phone == null || (phone = phone.trim()).length() == 0) errorsList.add("必須輸入手機號碼");
		if(gender == null || (gender = gender.trim()).length() == 0) errorsList.add("必須選擇性別");
		if(birthday == null || (birthday = birthday.trim()).length() == 0) errorsList.add("必須輸入生日");
		if(captCha == null || (captCha = captCha.trim()).length() == 0)
			errorsList.add("必須輸入驗證碼");
		else{
			String stdCaptCha = (String) session.getAttribute("captCha");
			if(!captCha.equalsIgnoreCase(stdCaptCha)) errorsList.add("驗證碼不正確");
		}
		session.removeAttribute("captCha");
		if(errorsList.isEmpty()){
			try{
				Client nMember;
				if(member instanceof VIP){
					nMember = new VIP();
					((VIP) nMember).setDiscount(((VIP) member).getDiscount());
				}else nMember = new Client();
				nMember.setId(member.getId());
				nMember.setPassword((newPwd == null || (newPwd = newPwd.trim()).length() == 0) ? password : newPwd);
				nMember.setName(name);
				nMember.setEmail(email);
				nMember.setAddress(address);
				nMember.setPhone(phone);
				nMember.setGender(gender.charAt(0));
				nMember.setBirthday(birthday);
				ClientService cService = new ClientService();
				cService.update(nMember);
				session.setAttribute("member", nMember);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/member/update_ok.jsp");
				dispatcher.forward(request, response);
				return;
			}catch (PETDataInvalidException e){
				errorsList.add(e.getMessage());
			}catch (PETException e){
				this.log(e.getMessage() + ", 請聯絡admin", e);
				errorsList.add(e.getMessage() + ", 請聯絡admin");
			}catch (Exception e){
				this.log("系統發生非預期性錯誤" + e.getMessage(), e);
				errorsList.add("系統錯誤" + e + "請聯絡admin");
			}
		}
		request.setAttribute("errorsList", errorsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/update.jsp");
		dispatcher.forward(request, response);
		return;
	}
}
