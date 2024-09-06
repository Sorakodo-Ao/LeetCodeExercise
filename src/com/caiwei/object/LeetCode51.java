package com.caiwei.object;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//N 皇后
public class LeetCode51 {
    @Test
    void test() {
        List<List<String>> result = solveNQueens(4);
        System.out.println(result);
    }


    /*    按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
        n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
        给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
        每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
        示例 1：
        输入：n = 4
        输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        解释：如上图所示，4 皇后问题存在两个不同的解法。
        示例 2：
        输入：n = 1
        输出：[["Q"]]
    */
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        if (n == 1) {
            List<String> param = new ArrayList<>();
            param.add("Q");
            result.add(param);
            return result;
        }
        //小于4行的不存在可能
        if (n < 4) {
            return result;
        }
        //构建棋盘
        String[][] arr = new String[n][n];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ".";
            }
        }

        backtracking(arr, n, 0, result);
        return result;
    }

    public void backtracking(String[][] arr, int n, int row, List<List<String>> result) {
        if (row == n) {
            List<String> param = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    builder.append(arr[i][j]);
                }
                param.add(builder.toString());
            }
            result.add(param);
            return;
        }

        for (int i = 0; i < n; i++) {
            //第row行第几个
            if (isSafe(arr, row, i)) {
                //这个位置可以放
                arr[row][i] = "Q";
                backtracking(arr, n, row + 1, result);
                arr[row][i] = ".";
            }
        }
    }

    public boolean isSafe(String[][] arr, int row, int rol) {
        boolean flag = true;
        for (int j = 0; j < arr[0].length; j++) {
            //同一列
            if (arr[row][j].equals("Q")) {
                return false;
            }
        }
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[i][rol].equals("Q")) {
                //同一行
                flag = false;
                break;
            }
            for (int j = 0; j < arr.length; j++) {
                if (Math.abs(i - row) == Math.abs(j - rol) && arr[i][j].equals("Q")) {
                    //在对角线上
                    return false;
                }
            }
        }
        return flag;
    }
}
