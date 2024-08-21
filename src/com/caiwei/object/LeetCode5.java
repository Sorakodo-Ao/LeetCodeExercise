package com.caiwei.object;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//最长回文数
class LeetCode5 {
    @Test
    void test() {
        String str = longestPalindrome("ac");
        System.out.println(str);
    }

    /*  输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    */
    //暴力法
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        //所有回文数list
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                boolean isPalindrome = true;
                String subStr = s.substring(i, j + 1);
                for (int k = 0; k < subStr.length() / 2; k++) {
                    if (subStr.charAt(k) != subStr.charAt(subStr.length() - 1 - k)) {
                        //不是回文数
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    resultList.add(subStr);
                }
            }
        }
        //找出最长回文数
        String result = null;
        if (resultList.size() > 1) {
            result = resultList.get(0);
            for (int i = 1; i < resultList.size(); i++) {
                if (result.length() < resultList.get(i).length()) {
                    result = resultList.get(i);
                }
            }
            System.out.println(result);
            return result;
        } else if (resultList.size() == 1) {
            System.out.println(resultList.get(0));
            return resultList.get(0);
        }
        return s.charAt(0) + "";

    }

}