package com.caiwei.object;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);

        System.out.println(list.size());
        System.out.println(list.get(0));
        *//*int indexOfValue = list.indexOf(5);
        Integer removed = list.remove(indexOfValue);*//*
        boolean removed = list.remove(Integer.valueOf(5));
        System.out.println(removed);
        System.out.println(list.toString());*/
        /*Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        System.out.println(map.containsKey("a"));
        map.replace("a", 3);
        System.out.println(map);
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 3);
        System.out.println(Objects.equals(map.get("a"), map1.get("a")));*/
        Map<String, Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.forEach((key,value)->{
            System.out.println("key = "+ key + " value = " + value);
        });
    }
}
