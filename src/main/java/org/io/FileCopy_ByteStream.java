package org.io;

import java.io.*;

/*
* 字节流复制（适合音视频，图片，ZIP等）
* */
public class FileCopy_ByteStream {
    public static void main(String[] args) {
        // 源文件
        String srcFile = "D:\\idea2025\\untitled20251127\\src\\main\\resources\\world.txt";
        // 目标文件
        String destFile = "D:\\idea2025\\untitled20251127\\src\\main\\resources\\world.txt.copy";

        // 字节输入流
        FileInputStream fis = null;
        // 字节输出流
        FileOutputStream fos = null;

        // 输入缓冲流
        BufferedInputStream bis = null;
        // 输出缓冲流
        BufferedOutputStream bos = null;

        // 缓冲区
        byte[] cache = new byte[1024];

        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            /*// 每次读取一个字节，效率低
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }*/

            /*// 批量读取, 大块数据一次性写入（容量由buffer决定），无内存缓冲区，性能低
            int len;
            while ((len = fis.read(cache)) != -1) {
                fos.write(cache, 0, len);
            }*/

            // 批量读取，有内存缓冲区（内存容量由buffer决定），系统操作次数更少，性能高
            int len;
            while ((len = bis.read(cache)) != -1) {
                bos.write(cache, 0, len);
            }

            System.out.println("复制完成");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
