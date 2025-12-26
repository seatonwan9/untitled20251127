package org.io;

import java.io.*;

/*
* 字符流复制(适合纯文本数据)
* */
public class FileCopy_CharStream {
    public static void main(String[] args) {
        // 源文件
        String srcFile = "D:\\idea2025\\untitled20251127\\src\\main\\resources\\world.txt";
        // 目标文件
        String destFile = "D:\\idea2025\\untitled20251127\\src\\main\\resources\\world.txt.copy";

        // 字符输入流
        BufferedReader reader = null;
        // 字符输出流
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(srcFile));
            writer = new PrintWriter(destFile);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.println(line + " 复制数据");
            }

            writer.flush();

            System.out.println("复制完成");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
