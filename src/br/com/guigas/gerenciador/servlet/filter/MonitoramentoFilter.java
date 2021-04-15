package br.com.guigas.gerenciador.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		long antes = System.currentTimeMillis();
		String acao = servletRequest.getParameter("acao");

		chain.doFilter(servletRequest, servletResponse);

		long depois = System.currentTimeMillis();

		System.out.println("Tempo da acao: " + acao + " -> " + (depois - antes));
	}

}
