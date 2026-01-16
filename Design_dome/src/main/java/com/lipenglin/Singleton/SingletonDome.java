package com.lipenglin.Singleton;

public class SingletonDome {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();
        // 因为隐藏了构造函数，不能通过new 创建对象，保证对象唯一

        //获取唯一可用的对象
        SingleObject singleObject = SingleObject.getInstance();
//        singleObject.sayhello();
    }
}
