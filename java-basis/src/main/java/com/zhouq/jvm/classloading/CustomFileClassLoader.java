package com.zhouq.jvm.classloading;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 自定义类加载器的基本实现
 *
 * @author: zhouq
 * @email zhouqiao@gmail.com
 * @date: 2019/1/2 14:48
 */
public class CustomFileClassLoader extends ClassLoader {

    //根路径
    private String rootPath;

    public CustomFileClassLoader(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            byte[] result = getClassFromCoustomPath(name);

            if (result == null) {
                throw new FileNotFoundException(name);
            } else {
                return defineClass(name, result, 0, result.length);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCoustomPath(String className) throws Exception {

        String path = getClassNameToPath(className);

        try {
            FileInputStream ins = new FileInputStream(path);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[10240];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesNumRead);
            }

            return outputStream.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(className);
    }

    /**
     * 获取 class 路径
     *
     * @param className
     * @return
     */
    private String getClassNameToPath(String className) {
        return rootPath +  className.substring(className.lastIndexOf(".") + 1) + ".class";
    }

    public static void main(String[] args) {

        CustomFileClassLoader customClassLoader = new CustomFileClassLoader("F:\\");

        try {

            Class<?> clazz = Class.forName("com.zhouq.java8.Apple", true, customClassLoader);

            Object obj = clazz.newInstance();

            System.out.println(obj.getClass().getClassLoader());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
