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
/**
 * Servlet Filter implementation class CharSetFilter
 */
@WebFilter({ "*.jsp", "*.do" })
public class CharSetFilter extends HttpFilter implements Filter{
	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public CharSetFilter(){
		super();
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy(){
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		// System.out.println("CharSetFilter已經建立物件開始工作"); // For ConsoleTest
		request.setCharacterEncoding("UTF-8");
		request.getParameterNames();
		response.setCharacterEncoding("UTF-8");
		response.getWriter();
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException{
	}
}
