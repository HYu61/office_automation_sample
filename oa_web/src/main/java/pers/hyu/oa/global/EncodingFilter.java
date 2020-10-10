package pers.hyu.oa.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * Encoding filter
 */
public class EncodingFilter implements Filter {
    private String encoding;

    /***
     * Set the encoding according to the init param; if there is no init para, the encoding will be set to utf-8
     * @param filterConfig
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        if(this.encoding == null){
            this.encoding = "UTF-8";
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(this.encoding);
        response.setCharacterEncoding(this.encoding);
        filterChain.doFilter(request, response);
    }
}
