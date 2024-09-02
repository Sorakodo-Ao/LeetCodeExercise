package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//电话号码的字母组合
public class LeetCode17 {
    @Test
    void test() {
        List<String> result = letterCombinations("999");
        System.out.println(result);
    }

    /*  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    示例 1：
    输入：digits = "23"
    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    示例 2：
    输入：digits = ""
    输出：[]
    示例 3：
    输入：digits = "2"
    输出：["a","b","c"]
    */
    public List<String> letterCombinations(String digits) {
        Map map = new HashMap<String, String>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> result = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return result;
        }
        if (digits.length() == 1) {
            String value = (String) map.get(digits);
            for (int i = 0; i < value.length(); i++) {
                String str = String.valueOf(value.charAt(i));
                result.add(str);
            }
            return result;
        }

        String[] arr = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            String str = String.valueOf(digits.charAt(i));
            String value = (String) map.get(str);
            arr[i] = value;
        }
        backtracking(new ArrayList<String>(), result, arr, 0);
        return result;
    }

    public void backtracking(List<String> path, List<String> result, String[] arr, int index) {
        if (index == arr.length) {
            String resultStr = String.join("", path); // 不使用分隔符拼接
            result.add(resultStr);
            return;
        }
        String str = arr[index];
        for (int i = 0; i < str.length(); i++) {
            String param = String.valueOf(str.charAt(i));
            path.add(param);
            backtracking(path,result,arr,index+1);
            path.remove(path.size()-1);//不能是path.remove(param) 仔细想想
        }
    }
}
