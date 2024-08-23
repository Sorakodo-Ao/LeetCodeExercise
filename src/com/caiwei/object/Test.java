package com.caiwei.object;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.size());
        System.out.println(list.get(0));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.min(2,6));
    }
}
