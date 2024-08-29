package com.caiwei.object;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);

        System.out.println(list.size());
        System.out.println(list.get(0));
        /*int indexOfValue = list.indexOf(5);
        Integer removed = list.remove(indexOfValue);*/
        boolean removed = list.remove(Integer.valueOf(5));
        System.out.println(removed);
        System.out.println(list.toString());

    }
}
