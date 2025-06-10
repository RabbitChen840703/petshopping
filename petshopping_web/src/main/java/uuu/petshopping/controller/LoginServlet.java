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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet(){
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
		String captCha = request.getParameter("captCha");
		if(id == null || (id = id.trim()).length() == 0) errorsList.add("請輸入帳號");
		if(password == null || (password = password.trim()).length() == 0) errorsList.add("請輸入密碼");
		if(captCha == null || (captCha.trim()).length() == 0){
			errorsList.add("請輸入驗證碼");
		}else{
			String stdCaptCha = (String) session.getAttribute("captCha");
			if(!captCha.equalsIgnoreCase(stdCaptCha)) errorsList.add("驗證碼錯誤");
		}
		session.removeAttribute("captCha"); // captCha不論對錯一定要刪除
		if(errorsList.isEmpty()){
			try{
				ClientService cService = new ClientService();
				Client member = cService.login(id, password);
				session.setAttribute("member", member);
				RequestDispatcher dispatcher = request.getRequestDispatcher("login_ok.jsp");
				dispatcher.forward(request, response);
				return;
			}catch (PETDataInvalidException e){
				errorsList.add(e.getMessage());
			}catch (PETException e){
				this.log(e.getMessage() + ", 請聯絡admin", e);
				errorsList.add(e.getMessage() + ", 請聯絡admin");
			}catch (Exception e){
				this.log("登入失敗，發生非預期錯誤" + e.getMessage(), e);
				errorsList.add("登入失敗" + e + "請聯絡admin");
			}
		} // 3.2 產生失敗的jsp
		request.setAttribute("errorsList", errorsList); // 錯誤是當次錯誤, 放在request就好, 不用放在session, 不然下次還會看到上次錯誤
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
}
