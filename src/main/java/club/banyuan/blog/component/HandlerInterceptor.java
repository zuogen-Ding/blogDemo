package club.banyuan.blog.component;

import club.banyuan.blog.bean.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("USER");
        if (user != null) {
            return true;
        } else {
            response.sendRedirect("/login?next=" + request.getRequestURI());
            return false;
        }
    }
}

