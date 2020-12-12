package io.team.work.util;

import org.apache.commons.fileupload.FileItem;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件操作相关工具类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/11 14:18
 */
public class FileUtil {
    public static final String STUDENT_HOMEWORK_SAVE_PATH = "/resources/studentHomework/";
    public static final String HOMEWORK_SAVE_PATH = "/resources/homework/";

    public static void upload(HttpServletRequest request, FileItem fileItem, String filePath) throws Exception {
        fileItem.write(new File(request.getServletContext().getRealPath(filePath)));
    }

    public static void download(HttpServletResponse response, String filePath) throws IOException {
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);

        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; fileName=" + fileName);
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath));
             ServletOutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
                out.flush();
            }
        } // out will close automatically
    }
}
