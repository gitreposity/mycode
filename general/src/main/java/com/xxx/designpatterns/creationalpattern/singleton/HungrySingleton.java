package com.xxx.designpatterns.creationalpattern.singleton;

import java.io.*;

public class HungrySingleton implements Serializable{

    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton(){
        if (singleton != null){
            throw new RuntimeException();
        }
    }
    public static HungrySingleton getSingleton(){
        return singleton;
    }


    //测试
    public static void main(String[] args) throws Exception {
//        System.out.println(HungrySingleton.getSingleton());
//
//        // 反射
//        Class<HungrySingleton> hungrySingletonClass = (Class<HungrySingleton>) Class.forName("com.xxx.designpatterns." +
//                "creationalpattern.singleton.HungrySingleton");
//        Constructor<HungrySingleton> constructor =  hungrySingletonClass.getDeclaredConstructor(null);
//        constructor.setAccessible(true);
//        HungrySingleton hungrySingleton = constructor.newInstance();
//        System.out.println(hungrySingleton);

        // 序列化
        HungrySingleton h = HungrySingleton.getSingleton();
        String path = "/Users/guodq/Documents/mycode/general/src/main/java/com/xxx/designpatterns/creationalpattern/singleton/serializable.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(h);
        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HungrySingleton d = (HungrySingleton) objectInputStream.readObject();
        System.out.println(h.equals(d));
        fileInputStream.close();
        objectInputStream.close();
    }

    private Object readResolve() throws ObjectStreamException{
        return singleton;
    }

}


