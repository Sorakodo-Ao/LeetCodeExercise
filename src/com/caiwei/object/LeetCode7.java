package com.caiwei.object;


import org.junit.jupiter.api.Test;

//整数反转
class LeetCode7 {
    @Test
    void test() {
        int reverse = reverse(1463847412);
        System.out.println(reverse);
    }

    /*    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
    假设环境不允许存储 64 位整数（有符号或无符号）。
    示例 1：
    输入：x = 123
    输出：321
    */
    public int reverse(int x) {
        int newValue = x;
        if (x < 0) {
            newValue = -x;
        }
        int result = 0;
        while (newValue > 0) {
            int temp = newValue % 10;
            newValue = newValue / 10;
            //result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7)
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + temp;
        }
        return x < 0 ? -result : result;
    }

/*
    public int reverse(int x) {
        //转为字符串
        String param = x + "";
        //结果字符串
        String resultStr = "";
        //是否截取的字符串
        String substringParam = "";
        //前缀为- ，负数
        if (param.startsWith("-")) {
            substringParam = param.substring(1);
        }else{
            //正数
            substringParam = param;
        }
        //反转
        for (int i = substringParam.length() -1; i >= 0; i--) {
            resultStr += substringParam.charAt(i);
        }
        //转为int
        int result = 0;
        if (param.startsWith("-")) {
            resultStr = "-" + resultStr;
        }
        try{
            result = Integer.parseInt(resultStr);
        }catch (Exception e){
            return 0;
        }
        return result;
    }
*/

}