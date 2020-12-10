package io.team.work.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传表单工具类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 19:39
 */
public class FileUploadHelper {
    private final Map<String, String> parameterMap = new HashMap<>();
    private FileItem fileItem;
    private String filename;

    public FileUploadHelper(HttpServletRequest request) {
        if (ServletFileUpload.isMultipartContent(request)) {
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            try {
                List<FileItem> items = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : items) {
                    if (fileItem.isFormField()) {
                        parameterMap.put(fileItem.getFieldName(), fileItem.getString());
                    } else {
                        this.filename = FilenameUtils.getName(fileItem.getName());
                        this.fileItem = fileItem;
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return 参数名-值对表
     */
    public Map<String, String> getParameterMap() {
        return parameterMap;
    }

    /**
     * @return 文件.
     */
    public FileItem getFileItem() {
        return fileItem;
    }

    /**
     * @return 文件名.
     */
    public String getFilename() {
        return filename;
    }
}
