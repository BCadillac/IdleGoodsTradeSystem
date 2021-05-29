package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String uri = request.getRequestURI();
		// System.out.println(uri);
		if (uri.equals("/IdleGoodsTradeSystem/")) {
			response.sendRedirect("home");
			return;
		}
		if (uri.endsWith("login.jsp") || uri.endsWith("login") || uri.endsWith("register")
				|| uri.endsWith("register.jsp") || uri.endsWith("home") || uri.endsWith("home.jsp")
				|| uri.endsWith("test")) {
			chain.doFilter(request, response);
			return;
		}
		if (null == request.getSession().getAttribute("currentAccount")) {
			response.sendRedirect("login");
			return;
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}