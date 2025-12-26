package org.io;

import java.io.*;

/*
* 对象的序列化和反序列化
* */
public class ObjectStream {
    public static void main(String[] args) {
        // 数据文件对象
        String dataFile = "D:\\idea2025\\untitled20251127\\src\\main\\resources\\User.dat";

        // 对象输出流
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;

        // 对象输入流
        ObjectInputStream ois = null;
        FileInputStream fis = null;

        try {

            System.out.println("对象写入中...");
            // 向文件中写入对象
            fos = new FileOutputStream(dataFile);
            oos = new ObjectOutputStream(fos);

            User user = new User();
            oos.writeObject(user);
            oos.flush();

            System.out.println("写入完成！");
            System.out.println("==============================================");
            System.out.println("读取对象：");
            // 从文件中读取对象
            fis = new FileInputStream(dataFile);
            ois = new ObjectInputStream(fis);
            User user1 = (User) ois.readObject();
            System.out.println(user1);
            
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// 实现Serializable来序列化对象
class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public User() {
        this.name = "张三";
        this.age = 18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
