package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//组合
public class LeetCode77 {
    @Test
    void test() {
        List<List<Integer>> result = combine(4, 2);
        /*for (List<Integer> list : result) {
            System.out.println(list);
        }*/
        System.out.println(result);
    }

    /*  给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
        你可以按 任何顺序 返回答案。
    */
/*  输入：n = 4, k = 2
    输出： [
            [2,4],
            [3,4],
            [2,3],
            [1,2],
            [1,3],
            [1,4],
          ]
*/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(n, k, 1, path, result);
        return result;
    }

    /*    public void backtracking(int n, int k, int startIndex, List<Integer> path, List<List<Integer>> result) {
            if (path.size() == k) {
                System.out.println("path = " + path.toString());
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i <= n; i++) {
                path.add(i);
                backtracking(n, k, i + 1, path, result);
                path.remove(Integer.valueOf(i));
            }
        }*/
    //剪枝操作
    public void backtracking(int n, int k, int startIndex, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            System.out.println("path = " + path.toString());
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <=  n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1, path, result);
            path.remove(Integer.valueOf(i));
        }
    }
}
