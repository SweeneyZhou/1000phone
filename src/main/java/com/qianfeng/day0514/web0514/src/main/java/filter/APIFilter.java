package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author sweeney 2021/5/14 20:26
 */
@WebFilter("/api/*")
public class APIFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    //api过滤器，编码设为utf-8编码 响应类型格式为json
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("application/json;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
