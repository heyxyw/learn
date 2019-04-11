package com.zhouq.jvm.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与instanceof 关键字演示
 * 不同的类加载器与instanceof关键字的运行结果的影响
 *
 * @author: zhouq
 * @email zhouqiao@gmail.com
 * @date: 2019/1/2 12:12
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    return defineClass(fileName, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };


        Object obj = classLoader.loadClass("com.zhouq.jvm.classloading.NotInitialization").newInstance();

        System.out.println(obj.getClass());

        System.out.println(obj instanceof com.zhouq.jvm.classloading.NotInitialization);


    }
}
