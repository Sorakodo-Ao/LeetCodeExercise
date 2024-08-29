package com.caiwei.object;

import org.junit.jupiter.api.Test;

//有效的字母异位词
public class LeetCode242 {
    @Test
    void test() {
        //boolean anagram = isAnagram("anagram", "nagaram");
        boolean anagram = isAnagram("rac", "cat");
        System.out.println(anagram);
    }

    /*  给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。s 和 t 仅包含小写字母
        字母异位词 是通过重新排列不同单词或短语的字母而形成的单词或短语，通常只使用所有原始字母一次。
        示例 1:
        输入: s = "anagram", t = "nagaram"
        输出: true
        示例 2:
        输入: s = "rat", t = "car"
        输出: false
    */
    /*暴力哈希map匹配
    public boolean isAnagram(String s, String t) {
        //字符串为空，false
        if (s == null || s.equals("")|| t == null || t.equals("")) {
            return false;
        }
        //字符串长度不相等，false
        if (s.length() != t.length()) {
            return false;
        }
        //两个字符串相等，true;
        if (s.equals(t)) {
            return true;
        }
        String sParam;
        String tParam;
        Map<String, Integer> sMap = new HashMap<>();
        Map<String, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sParam = String.valueOf(s.charAt(i));
            if (sMap.containsKey(sParam)) {
                sMap.replace(sParam, sMap.get(sParam) + 1);
            } else {
                sMap.put(sParam, 1);
            }
            tParam = String.valueOf(t.charAt(i));
            if (tMap.containsKey(tParam)) {
                tMap.replace(tParam, tMap.get(tParam) + 1);
            } else {
                tMap.put(tParam, 1);
            }
        }
        //两个map长度不相等
        if(sMap.size() != tMap.size()){
            return false;
        }
        //map的key的value 不相同
        for (String key : sMap.keySet()) {
            if(!tMap.containsKey(key) || !Objects.equals(tMap.get(key), sMap.get(key))){
                return false;
            }
        }
        return true;
    }*/
    /*public boolean isAnagram(String s, String t) {
        //字符串为空，false
        if (s == null || s.equals("") || t == null || t.equals("")) {
            return false;
        }
        //字符串长度不相等，false
        if (s.length() != t.length()) {
            return false;
        }
        //两个字符串相等，true;
        if (s.equals(t)) {
            return true;
        }
        //s 和 t 仅包含小写字母
        int[] arr = new int['z' + 1];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            arr[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i);
            arr[index]--;
        }

        boolean flag = true;
        for (int i : arr) {
            if(i != 0){
                flag = false;
                break;
            }
        }
        return flag;
    }*/
    //再数组简化
    public boolean isAnagram(String s, String t) {
        //字符串为空，false
        if (s == null || s.equals("") || t == null || t.equals("")) {
            return false;
        }
        //字符串长度不相等，false
        if (s.length() != t.length()) {
            return false;
        }
        //两个字符串相等，true;
        if (s.equals(t)) {
            return true;
        }
        //s 和 t 仅包含小写字母
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) -'a';
            arr[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) -'a';
            arr[index]--;
        }
        for (int i : arr) {
            if( i !=0){
                return false;
            }
        }
        return true;
    }
}
