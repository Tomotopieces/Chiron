package io.team.work.util;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet工具类.
 * <p>
 * 静态常量字符串皆为表单字段或回填数据.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 9:27
 */
public class ServletUtil {
    public static final Gson GSON = new Gson();

    // 项目路径
    public static final String PROJECT_PATH = "/Chiron";

    /**
     * 将返回值为Boolean类型的DAO函数的return值通过response的writer输出.
     *
     * @param result   DAO操作结果
     * @param response 一次请求Servlet的response
     */
    public static void writeResult(Boolean result, HttpServletResponse response) throws IOException {
        if (result) {
            response.getWriter().write(ResponseMessage.TRUE);
        } else {
            response.getWriter().write(ResponseMessage.FALSE);
        }
    }

    /**
     * 表单参数名.
     */
    public static final class RequestParameterName {
        // 登录
        public static final String LOGIN_USERNAME = "username";
        public static final String LOGIN_PASSWORD = "password";

        // 重设密码
        public static final String RESET_PASSWORD_OLD_PASSWORD = "oldPassword";
        public static final String RESET_PASSWORD_NEW_PASSWORD = "newPassword";

        // 审阅作业
        public static final String REVIEW_HOMEWORK_REVIEW_CONTENT = "reviewContent";
        public static final String REVIEW_HOMEWORK_ID = "homeworkId";

        // 布置作业
        public static final String ASSIGN_HOMEWORK_TITLE = "title";
        public static final String ASSIGN_HOMEWORK_DESCRIBE = "describe";
        public static final String ASSIGN_HOMEWORK_END_TIME = "endTime";
        public static final String ASSIGN_HOMEWORK_CLASS_ID = "classId";
    }

    /**
     * 会话属性名.
     */
    public static final class SessionAttributeName {
        // 会话属性
        public static final String USER = "user";
    }

    /**
     * 相应信息.
     */
    public static final class ResponseMessage {
        // 信息提示
        public static final String TRUE = "true";
        public static final String FALSE = "false";
        public static final String ILLEGAL_USERNAME = "非法用户名。";
        public static final String WRONG_USERNAME_OR_PASSWORD = "账户不存在或密码不正确。";
    }
}
