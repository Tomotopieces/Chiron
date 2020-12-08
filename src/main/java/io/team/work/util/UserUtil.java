package io.team.work.util;

/**
 * 用户工具类
 *
 * @author Tomoto
 * <p>
 * 2020/12/8 15:54
 */
public class UserUtil {
    public static final int ADMIN_ACCOUNT = 1;
    public static final int TEACHER_ACCOUNT = 2;
    public static final int STUDENT_ACCOUNT = 3;
    public static final int UNDEFINED_ACCOUNT = -1;

    public static final String ADMIN_SPACE = "adminSpace.html";
    public static final String TEACHER_SPACE = "teacherSpace.html";
    public static final String STUDENT_SPACE = "studentSpace.html";

    /**
     * 检查用户类型.
     * <p>
     * 管理员 | 教师 | 学生 | 未定义账号类型
     *
     * @param username 用户名
     * @return 账号类型对应数字
     */
    public static Integer roleCheck(String username) {
        if (username.startsWith("a")) { // 管理员类型 administrator
            return ADMIN_ACCOUNT;
        } else if (username.startsWith("t")) { // 教师类型 teacher
            return TEACHER_ACCOUNT;
        } else if (username.startsWith("s")) { // 学生类型 student
            return STUDENT_ACCOUNT;
        } else { // 未定义类型
            return UNDEFINED_ACCOUNT;
        }
    }
}
