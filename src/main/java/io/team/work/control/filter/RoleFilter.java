package io.team.work.control.filter;

import io.team.work.model.bean.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.team.work.util.CommonUtil.CommonPagePath.PAGE_NOT_LOGGED_IN;
import static io.team.work.util.CommonUtil.CommonPagePath.PAGE_NO_PERMISSION;
import static io.team.work.util.CommonUtil.PROJECT_PATH;
import static io.team.work.util.CommonUtil.SessionAttributeName.USER;
import static io.team.work.util.UserUtil.getSpace;
import static io.team.work.util.UserUtil.getType;

/**
 * 用户访问 filter.
 * <p>
 * 阻止用户进入不允许的页面.
 *
 * @author Tomoto
 * <p>
 * 2020/12/14 10:15
 */
@WebFilter("/user/*")
public class RoleFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute(USER);
        if (user == null) { // 未登录
            response.sendRedirect(PROJECT_PATH + PAGE_NOT_LOGGED_IN);
        } else { // 访问了错误的页面
            if (!request.getRequestURL().toString().endsWith(getSpace(getType(user)))) {
                response.sendRedirect(PROJECT_PATH + PAGE_NO_PERMISSION);
            } else {
                chain.doFilter(request, response);
            }
        }
    }
}
