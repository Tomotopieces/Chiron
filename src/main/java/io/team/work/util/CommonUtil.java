package io.team.work.util;

import com.google.gson.Gson;

/**
 * Servlet工具类.
 * <p>
 * 静态常量字符串皆为表单字段或回填数据.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 9:27
 */
public class CommonUtil {
    public static final Gson GSON = new Gson();
    // 项目路径
    public static final String PROJECT_PATH = "/Chiron";

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

        public static final String REVIEW_HOMEWORK_REVIEW_CONTENT = "content";
        public static final String REVIEW_HOMEWORK_ID = "homeworkId";

        // 布置作业

        public static final String ASSIGN_HOMEWORK_TITLE = "title";
        public static final String ASSIGN_HOMEWORK_DESCRIBE = "describe";
        public static final String ASSIGN_HOMEWORK_END_TIME = "endTime";
        public static final String ASSIGN_HOMEWORK_CLASS_ID = "classId";

        // 分页获取已布置作业

        public static final String GET_ASSIGN_HOMEWORK_BY_PAGE_ID_PAGE_NO = "pageNo";
        public static final String GET_ASSIGN_HOMEWORK_BY_PAGE_PAGE_SIZE = "pageSize";

        // 提交作业

        public static final String SUBMIT_HOMEWORK_HOMEWORK_ID = "homeworkId"; // 教师布置作业的id
        public static final String SUBMIT_HOMEWORK_TITLE = "title";
        public static final String SUBMIT_HOMEWORK_DESCRIBE = "describe";

        // 分页获取提交作业

        public static final String GET_SUBMIT_HOMEWORK_BY_PAGE_PAGE_NO = "pageNo";
        public static final String GET_SUBMIT_HOMEWORK_BY_PAGE_PAGE_SIZE = "pageSize";

        // 文件下载

        public static final String DOWNLOAD_FILE_TYPE = "type";
        public static final String DOWNLOAD_FILE_ID = "id";

        // 留言

        public static final String MESSAGE_TITLE = "title";
        public static final String MESSAGE_CONTENT = "content";

        // 分页获取用户

        public static final String GET_USER_BY_PAGE_PAGE_NO = "pageNo";
        public static final String GET_USER_BY_PAGE_PAGE_SIZE = "pageSize";

        // 添加新用户

        public static final String ADD_USER_TYPE = "type";
        public static final String ADD_USER_USERNAME = "username";
        public static final String ADD_USER_NAME = "name";
        public static final String ADD_USER_SEX = "sex";
        public static final String ADD_USER_AGE = "age";
        public static final String ADD_USER_CLASS = "class";

        // 移除用户

        public static final String REMOVE_USER_ID = "id";

        // 查找用户

        public static final String GET_USER_USER_ID = "id";

        // 分页获取班级

        public static final String GET_CLASS_BY_PAGE_PAGE_NO = "pageNo";
        public static final String GET_CLASS_BY_PAGE_PAGE_SIZE = "pageSize";

        // 添加班级

        public static final String ADD_CLASS_CLASS_NO = "classNo";
        public static final String ADD_CLASS_CLASS_NAME = "className";

        // 移除班级

        public static final String REMOVE_CLASS_ID = "id";

        // 查找班级

        public static final String GET_CLASS_CLASS_ID = "classId";

        // 移除留言

        public static final String REMOVE_MESSAGE_ID = "id";

        // 获取留言

        public static final String GET_MESSAGE_ID = "id";

        // 分页获取留言

        public static final String GET_MESSAGE_BY_PAGE_PAGE_NO = "pageNo";
        public static final String GET_MESSAGE_BY_PAGE_PAGE_SIZE = "pageSize";

        // 添加公告

        public static final String ADD_NOTICE_TITLE = "title";
        public static final String ADD_NOTICE_CONTENT = "content";

        // 移除公告

        public static final String REMOVE_NOTICE_ID = "id";

        // 获取公告

        public static final String GET_NOTICE_ID = "id";

        // 分页获取公告

        public static final String GET_NOTICE_BY_PAGE_PAGE_NO = "pageNo";
        public static final String GET_NOTICE_BY_PAGE_PAGE_SIZE = "pageSize";

        // 更新公告

        public static final String UPDATE_NOTICE_ID = "id";
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
        public static final String MESSAGE_ILLEGAL_USERNAME = "非法用户名";
        public static final String MESSAGE_WRONG_USERNAME_OR_PASSWORD = "账户或密码错误";
        public static final String MESSAGE_FILE_UPLOAD_FAILED = "文件上传失败";
        //        public static final String MESSAGE_USER_NOT_LOGGED_IN = "用户未登录";
        public static final String ADD_DATA_EMPTY_VALUE = "请输入所有的信息";
    }

    public static final class CommonPagePath {
        public static final String PAGE_NOT_LOGGED_IN = "/notLoggedIn.html";
        public static final String PAGE_NO_PERMISSION = "/noPermission.html";
    }

    /**
     * 响应数据包装类.
     * <p>
     * 将操作结果与其他数据包装起来.
     */
    public static class ResponseDataWrapper {
        private final Boolean result;
        private final Object data;

        private ResponseDataWrapper(boolean result, Object data) {
            this.result = result;
            this.data = data;
        }

        /**
         * 只有结果, 数据为 null.
         *
         * @param result 结果
         * @return 包装后JSON
         */
        public static String of(boolean result) {
            return GSON.toJson(new ResponseDataWrapper(result, null));
        }

        /**
         * @param result 结果
         * @param data   数据
         * @return 包装后JSON
         */
        public static String of(boolean result, Object data) {
            return GSON.toJson(new ResponseDataWrapper(result, GSON.toJson(data)));
        }

        /**
         * 结果为 true.
         *
         * @param data 数据
         * @return 包装后JSON
         */
        public static String of(Object data) {
            return GSON.toJson(new ResponseDataWrapper(true, GSON.toJson(data)));
        }
    }
}
