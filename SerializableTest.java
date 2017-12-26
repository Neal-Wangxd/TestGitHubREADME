package com.IO;


import java.io.*;

/**
 * 对象序列化测试类
 *
 * @auther wxd
 * @create 2017/12/14
 * @desc 对象序列化测试类
 */
public class SerializableTest {
    public static void main(String[] args) {
        try {
            dser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 对象序列化
     * @throws Exception
     */
    public static  void ser() throws Exception{
        ObjectOutputStream opt = new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\wxd\\Desktop\\CoreJavaCode\\Book.ser")));
        opt.writeObject(new Book("Java高并发编程",79.8,"Neal"));
        opt.close();
    }

    /**
     * 对象的反序列化
     * @throws Exception
     */
    public static  void dser() throws Exception{
        ObjectInputStream opi = new ObjectInputStream(new FileInputStream(new File("C:\\Users\\wxd\\Desktop\\CoreJavaCode\\Book.ser")));
        Object obj = opi.readObject();
        Book book = (Book)obj;
        System.out.println(book);
        opi.close();
    }
}

@SuppressWarnings("serial")
class Book implements Serializable{

    String title;
    double price;
    String auther;

    public Book (String title,double price,String auther){
        this.title = title;
        this.price = price;
        this.auther = auther;
    }
    @Override
    public String toString(){
        return "书名："+title+",价格:"+price+",作者："+auther;
    }

}
