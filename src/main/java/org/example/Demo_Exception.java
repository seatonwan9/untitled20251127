package org.example;

/*
* 自定义异常
* */
public class Demo_Exception {

    public static void main(String[] args) throws Exception {

        String account = "admin";
        String password = "123456r";

        try {
            login(account, password);
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void login(String account, String password) throws Exception {
        if (!account.equals("admin")) {
            throw new LoginException("账号不存在");
        }
        if (!password.equals("123456")) {
            throw new LoginException("密码错误");
        }
        System.out.println("登录成功");
    }
}

class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}
