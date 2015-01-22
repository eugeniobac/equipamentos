package br.com.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.bean.LoginBean;
import br.com.gerenciador.entity.Usuario;

public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Usuario usuario = (Usuario) httpServletRequest.getSession().getAttribute(LoginBean.USUARIO_LOGADO);

		String pagina = httpServletRequest.getRequestURI();

		if (validaPagina(usuario, pagina)) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect("index.xhtml");
		}

	}

	private boolean validaPagina(Usuario usuario, String pagina) {
		return usuario != null || pagina.contains("index") || pagina.contains(".css")
				|| (pagina.contains(".js") && !pagina.contains(".jsf")) || pagina.contains("/img/");
	}

}