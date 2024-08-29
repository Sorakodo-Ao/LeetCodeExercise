package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//组合总和 III
public class LeetCode216 {
    @Test
    void test() {
        List<List<Integer>> res = combinationSum3(3, 7);
        System.out.println(res);
    }

    /*  找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
        只使用数字1到9
        每个数字 最多使用一次
        返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
        示例 1:
        输入: k = 3, n = 7
        输出: [[1,2,4]]
        解释:    1 + 2 + 4 = 7
        没有其他符合的组合了。
    */

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int length = 9;
        /*backtracking(length, 1, k, n);*/
        backtracking(length, 1, k, n, 0);
        return result;
    }

    /*    public void backtracking(int length, int startIndex, int k, int sum) {
            if (path.size() == k) {
                int pathSum = 0;
                for (Integer pathParam : path) {
                    pathSum += pathParam;
                }
                if (pathSum == sum) {
                    //path 的元素和等于sum
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            for (int i = startIndex; i <= length; i++) {
                path.add(i);
                backtracking(9, i + 1, k, sum);
                path.remove(Integer.valueOf(i));
            }
        }*/
    //剪枝and优化
    public void backtracking(int length, int startIndex, int k, int target, int sum) {
        if(sum > target){
            return;
        }
        if (path.size() == k) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= length - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(9, i + 1, k, target, sum);
            path.remove(Integer.valueOf(i));
            sum -= i;
        }
    }
}
