package org.jichuang.hope6537.utils;

import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Administrator on 2014/10/10.
 */
public class FileUtil {

    private FileUtil() {
    }

    /**
     * 创建文件
     *
     * @param name    文件名（需带文件类型）
     * @param content 文件内容
     * @param path    文件保存路径
     */
    public static boolean createFile(String name, String content, String path) {
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(path + File.separator + name);
            boolean result = file.createNewFile();
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(content);
            output.close();
            return result;
        } catch (IOException e) {
            LoggerFactory.getLogger(FileUtil.class).error("ERROR", e);
            return false;
        }
    }

    /**
     * 读取文件
     *
     * @param path 文件所在位置
     */
    public static String readFile(String path) {
        File file = new File(path);
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = input.readLine()) != null) {
                content.append(temp).append("\n");
            }
            input.close();
        } catch (IOException e) {
            LoggerFactory.getLogger(FileUtil.class).error("ERROR", e);
        }
        return content.toString();
    }

    /**
     * 删除文件
     *
     * @param path 文件所在位置
     */
    public static boolean deleteFile(String path) {
        File file = new File(path);
        return file.delete();
    }

    /**
     * 复制文件或文件夹
     *
     * @param oldPath 源文件位置/文件夹目录
     * @param newPath 目标文件夹
     */
    public static boolean copyFolder(String oldPath, String newPath) {
        boolean flag = false;
        try {
            flag = new File(newPath).mkdirs();
            File filePath = new File(oldPath);
            String[] file = filePath.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }
                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + File.separator +
                            (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {
                    copyFolder(oldPath + File.separator + file[i], newPath + File.separator + file[i]);
                }
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(FileUtil.class).error("ERROR", e);
        }
        return flag;
    }


    /**
     * 上传文件
     *
     * @param multipartFile
     * @param fileName
     * @param uploadPath
     * @return
     * @throws java.io.IOException
     */
    public static boolean readWriteFile(MultipartFile multipartFile, String fileName, String uploadPath) throws IOException {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists() && !uploadDir.mkdirs()) {
            return false;
        }
        InputStream is = multipartFile.getInputStream();
        OutputStream os = new FileOutputStream(new File(uploadPath, fileName));
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        ;
        is.close();
        os.close();
        return true;
    }

    /**
     * @param path
     * @return
     */
    public static boolean createDirects(String path) {
        File newDirect = new File(path);
        if (!newDirect.exists()) {
            return newDirect.mkdirs();
        }
        return false;
    }

    /**
     * 删除目录
     *
     * @param delpath
     * @return
     * @throws Exception
     */
    public static boolean deleteFiles(String delpath) throws Exception {
        try {

            File file = new File(delpath);
            if (!file.isDirectory()) {
                file.delete();
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(delpath + "\\" + filelist[i]);
                    if (!delfile.isDirectory()) {
                        delfile.delete();
                    } else if (delfile.isDirectory()) {
                        deleteFiles(delpath + "\\" + filelist[i]);
                    }
                }
                file.delete();
            }

        } catch (FileNotFoundException e) {
            LoggerFactory.getLogger(FileUtil.class).error("ERROR", e);
        }
        return true;
    }

    /**
     * 获取文件夹大小
     *
     * @param file
     * @return
     */
    public static long getTotalSizeOfFilesInDir(final File file) {
        if (file.isFile())
            return file.length();
        final File[] children = file.listFiles();
        long total = 0;
        if (children != null)
            for (final File child : children)
                total += getTotalSizeOfFilesInDir(child);
        return total;
    }
}
