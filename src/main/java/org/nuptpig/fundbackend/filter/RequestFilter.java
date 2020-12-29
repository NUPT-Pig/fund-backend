//package org.nuptpig.fundbackend.filter;
//
//import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaWsdlMappingType;
//import org.nuptpig.fundbackend.util.JWTHelper;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.io.IOException;
//import java.util.Enumeration;
//
//@WebFilter(urlPatterns = {"/*"}, filterName = "requestFilter")
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class RequestFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequestWrapper requestWrapper = new
//                HttpServletRequestWrapper((HttpServletRequest) request) {
//                    @Override
//                    public String getHeader(String name) {
//                        if ("user_name".equals(name)){
//                            String token = super.getHeader("token");
//                            return JWTHelper.getUsername(token);
//                        }else{
//                            return super.getHeader(name);
//                        }
//                    }
//
//                    @Override
//                    public Enumeration<String> getHeaders(String name){
//                        if ("user_name".equals(name)){
//                            String token = super.getHeader("token");
//                            return JWTHelper.getUsername(token);
//                        }else{
//                            return super.getHeaders(name);
//                        }
//                    }
//                };
//        chain.doFilter(requestWrapper,response);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
