package com.caiwei.object;


// 是否存在重复元素

/*不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
       实现 MyHashSet 类：
       void add(key) 向哈希集合中插入值 key 。
       bool contains(key) 返回哈希集合中是否存在这个值 key 。
       void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
*/
class LeetCode705 {

    boolean[] arr;

    public LeetCode705() {
        arr = new boolean[10000];
    }

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        arr[key] = false;
    }

    public boolean contains(int key) {
        if (!arr[key]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode705 leetCode705 = new LeetCode705();
        leetCode705.add(1);
        leetCode705.remove(5);
        boolean contains = leetCode705.contains(2);
        System.out.println(contains);
    }
}