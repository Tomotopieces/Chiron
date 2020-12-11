package io.team.work.util;

import io.team.work.model.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户工具类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/8 15:54
 */
public class UserUtil {
    // 用户类型
    public static final String ADMIN_TYPE = "admin";
    public static final String TEACHER_TYPE = "teacher";
    public static final String STUDENT_TYPE = "student";

    // 用户主页
    public static final String ADMIN_SPACE = "adminSpace.html";
    public static final String TEACHER_SPACE = "teacherSpace.html";
    public static final String STUDENT_SPACE = "studentSpace.html";

    private static final Map<Integer, String> NUMBER_TYPE_MAP = new HashMap<>();
    private static final Map<Character, String> CHARACTER_TYPE_MAP = new HashMap<>();
    private static final Map<String, String> TYPE_SPACE_MAP = new HashMap<>();

    static {
        NUMBER_TYPE_MAP.put(0, ADMIN_TYPE);
        NUMBER_TYPE_MAP.put(1, TEACHER_TYPE);
        NUMBER_TYPE_MAP.put(2, STUDENT_TYPE);

        CHARACTER_TYPE_MAP.put('a', ADMIN_TYPE);
        CHARACTER_TYPE_MAP.put('t', TEACHER_TYPE);
        CHARACTER_TYPE_MAP.put('s', STUDENT_TYPE);

        TYPE_SPACE_MAP.put(ADMIN_TYPE, ADMIN_SPACE);
        TYPE_SPACE_MAP.put(TEACHER_TYPE, TEACHER_SPACE);
        TYPE_SPACE_MAP.put(STUDENT_TYPE, STUDENT_SPACE);
    }

    /**
     * 检查用户名是否对应用户类型.
     *
     * @param username 用户名
     * @param type     用户类型
     * @return 二者是否对应
     */
    public static boolean typeCheck(String username, String type) {
        return (type.equals(ADMIN_TYPE) || type.equals(TEACHER_TYPE) || type.equals(STUDENT_TYPE)) &&
                username.startsWith(String.valueOf(type.charAt(0)));
    }

    /**
     * 根据用户获取用户类型数字对应类型.
     *
     * @param user 用户
     * @return 类型
     */
    public static String getType(User user) {
        return NUMBER_TYPE_MAP.get(user.getType());
    }

    /**
     * 根据用户名获取用户类型.
     *
     * @param username 用户名
     * @return 类型
     */
    public static String getType(String username) {
        return CHARACTER_TYPE_MAP.get(username.charAt(0));
    }

    /**
     * 获取用户类型对应主页.
     *
     * @param type 用户类型
     * @return 用户主页
     */
    public static String getSpace(String type) {
        return TYPE_SPACE_MAP.get(type);
    }
}
