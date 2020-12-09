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
     * 请求参数名.
     */
    public static final class RequestParameterName {
        // 登录

        public static final String LOGIN_USERNAME = "username";
        public static final String LOGIN_PASSWORD = "password";

        // 重设密码

        public static final String RESET_PASSWORD_OLD_PASSWORD = "oldPassword";
        public static final String RESET_PASSWORD_NEW_PASSWORD = "newPassword";

        // 评阅作业

        public static final String REVIEW_HOMEWORK_REVIEW_CONTENT = "reviewContent";
        public static final String REVIEW_HOMEWORK_ID = "reviewHomeworkId";

        // 布置作业

        public static final String ASSIGN_HOMEWORK_TITLE = "homeworkTitle";
        public static final String ASSIGN_HOMEWORK_DESCRIBE = "homeworkDescribe";
        public static final String ASSIGN_HOMEWORK_END_TIME = "homeworkEndTime";
        public static final String ASSIGN_HOMEWORK_CLASS_ID = "homeworkClassId";

        // 留言

        public static final String MESSAGE_TITLE = "messageTitle";
        public static final String MESSAGE_CONTENT = "messageContent";
//        public static final String MESSAGE_CREATE_TIME = "createTime";

        // 添加新用户

        public static final String ADD_USER_TYPE = "type";
        public static final String ADD_USER_USERNAME = "username";
//        public static final String ADD_USER_PASSWORD = "password"; // 默认给123456或者000000
        public static final String ADD_USER_NAME = "name";
        public static final String ADD_USER_SEX = "sex";
        public static final String ADD_USER_AGE = "age";
        public static final String ADD_USER_CLASS = "class";

        // 移除用户

        public static final String REMOVE_USER_ID = "userId";

        // 添加班级

        public static final String ADD_CLASS_CLASS_NO = "classNo";
        public static final String ADD_CLASS_CLASS_NAME = "className";

        // 移除班级

        public static final String REMOVE_CLASS_ID = "classId";

        // 移除留言

        public static final String REMOVE_MESSAGE_ID = "messageId";

        // 添加公告

        public static final String ADD_NOTICE_TITLE = "noticeTitle";
        public static final String ADD_NOTICE_CONTENT = "noticeContent";
//        public static final String ADD_NOTICE_CREATE_TIME = "createTime";

        // 移除公告

        public static final String REMOVE_NOTICE_ID = "noticeId";

        // 更新公告

        public static final String UPDATE_NOTICE_ID = "noticeId";
        public static final String UPDATE_NOTICE_PROPERTY_NAME = "propertyName";
        public static final String UPDATE_NOTICE_PROPERTY_VALUE = "propertyValue";
    }

    /**
     * 会话属性名.
     */
    public static final class SessionAttributeName {
        public static final String USER = "user";
    }

    /**
     * 回填通用信息.
     */
    public static final class ResponseMessage {
        public static final String TRUE = "true";
        public static final String FALSE = "false";
        public static final String ILLEGAL_USERNAME = "非法用户名。";
        public static final String WRONG_USERNAME_OR_PASSWORD = "账户不存在或密码不正确。";
    }
}
