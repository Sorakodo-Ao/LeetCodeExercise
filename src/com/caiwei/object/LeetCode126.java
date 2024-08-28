package com.caiwei.object;


import org.junit.jupiter.api.Test;

//斐波那契数列
class LeetCode126 {
    @Test
    void test() {
        int result = fib(45);
        System.out.println(result);
    }

    /*
    斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
    该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
    F(0) = 0，F(1) = 1
    F(n) = F(n - 1) + F(n - 2)，其中 n > 1
    给定 n ，请计算 F(n) 。
    */
/*  示例 1：输入：n = 2
        输出：1
        解释：F(2) = F(1) + F(0) = 1 + 0 = 1
    示例 2：输入：n = 3
        输出：2
        解释：F(3) = F(2) + F(1) = 1 + 1 = 2
    示例 3：输入：n = 4
        输出：3
        解释：F(4) = F(3) + F(2) = 2 + 1 = 3
*/
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int constant = 1000000007;
        int i = 0;
        int j = 1;
        int result = 0;
        while (n >= 2) {
            result = i + j;
            i = j % constant;
            j = result % constant;
            n--;
        }
        return j;
    }
}