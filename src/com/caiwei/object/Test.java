package com.caiwei.object;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        String result = String.join("", arr);
        System.out.println(result);
        arr.remove("a");
        System.out.println(arr);
/*        String format = String.format("java"+"c:/main.java");
        System.out.println(format);*/
    }
}
