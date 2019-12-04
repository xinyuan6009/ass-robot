package com.xinyuan.assist.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * FileUtil
 *
 * @author liangyh
 * @date 2018/7/25
 */
public class FileUtil {

    /**
     * 从资源目录读取文件内容
     *
     * @param resourcePath
     * @return
     */
    public static String readFileFromResource(String resourcePath) {
        try {
            InputStream is = FileUtil.class.getClassLoader().getResourceAsStream(resourcePath);
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    /**
     * 转换文件内容为字符串
     *
     * @param file
     * @return
     */
    public static String text2String(File file) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        InputStreamReader read = null;
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(file);
            read = new InputStreamReader(
                    fi, "utf-8");
            reader = new BufferedReader(read);
            String s;
            while ((s = reader.readLine()) != null) {
                sb.append(System.lineSeparator() + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
