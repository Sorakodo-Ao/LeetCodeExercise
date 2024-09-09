package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// 斐波那契数
public class LeetCode509 {
    @Test
    void test() {
        int fib = fib(3);
        System.out.println(fib);
    }

    /*  斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
        该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
        F(0) = 0，F(1) = 1
        F(n) = F(n - 1) + F(n - 2)，其中 n > 1
        给定 n ，请计算 F(n) 。
        示例 1：
        输入：n = 2
        输出：1
        解释：F(2) = F(1) + F(0) = 1 + 0 = 1
        示例 2：
        输入：n = 3
        输出：2
        解释：F(3) = F(2) + F(1) = 1 + 1 = 2*/
    public int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(1);
        for (int i = 2; i <= n - 1; i++) {
            dp.add(dp.get(i - 1) + dp.get(i - 2));
        }
        return dp.get(n - 1);
    }
}
