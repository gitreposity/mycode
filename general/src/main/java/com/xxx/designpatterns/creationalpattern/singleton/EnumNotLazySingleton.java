package com.xxx.designpatterns.creationalpattern.singleton;

public class EnumNotLazySingleton {

    public enum EnumSingleton{
        Instance(1,"好");

        EnumSingleton(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        Integer code;

        String name;


        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        System.out.println(EnumSingleton.Instance);
        System.out.println(EnumSingleton.Instance);
        System.out.println(EnumSingleton.Instance);
        System.out.println(EnumSingleton.Instance);
    }
}
