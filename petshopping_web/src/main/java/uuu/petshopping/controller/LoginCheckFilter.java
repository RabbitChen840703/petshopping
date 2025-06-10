package uuu.petshopping.controller;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uuu.petshopping.Entity.Client;
/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("/member/*")
public class LoginCheckFilter extends HttpFilter implements Filter{
	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public LoginCheckFilter(){
		super();
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy(){}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		HttpSession session = httpReq.getSession();
		Client member = (Client) session.getAttribute("member");
		if(member != null)
			chain.doFilter(request, response);
		else httpRes.sendRedirect(httpReq.getContextPath() + "/login.jsp");
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException{}
}
