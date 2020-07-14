package com.test1.ch01.hello;

public class HelloWorld {

    private String username;

    public HelloWorld() {
        System.out.println("HelloWorld()");
    }

    public HelloWorld(String username) {
        this.username = username;
        System.out.println("HelloWorld(String)");
    }

    public String getUsername() {
        System.out.println("getUsername()");
        return username;
    }

    public void setUsername1(String username) {
        System.out.println("setUsername()");
        this.username = username;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "username='" + username + '\'' +
                '}';
    }

    public void work(){
        System.out.printf(username+"正在工作...");
    }
}
