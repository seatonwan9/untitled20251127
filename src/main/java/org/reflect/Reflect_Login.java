package org.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
* 反射登录
* */
public class Reflect_Login {
    public static void main(String[] args) throws Exception {
        // 获取类
        Class<User> userClass = User.class;
//        Class<?> userClass = Class.forName("org.reflect.User"); // 获取类的另一种方式
        // 获取构造方法
        Constructor<User> declaredConstructor = userClass.getDeclaredConstructor();
        // 创建对象
        Object user = declaredConstructor.newInstance();
        // 获取属性并赋值
        Field username = userClass.getDeclaredField("username");
        Field password = userClass.getDeclaredField("password");
        username.setAccessible(true); // 暴力反射
        password.setAccessible(true);
        username.set(user, "admin"); // 设置属性值
        password.set(user, "admin");
        // 获取登录方法
        Method login = userClass.getMethod("login", String.class, String.class);
        Object invoke = login.invoke(user, username.get(user), password.get(user));
        System.out.println(invoke);

    }
}

class User {

    private String username;

    private String password;

    public boolean login(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }
}
