package muc.java_class.first_homework;

import java.util.ArrayList;
import java.util.Scanner;

public class JudgeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.println("请输入数的个数及差值：");
        int nums = sc.nextInt();
        int diff_value = sc.nextInt();
        System.out.println("请输入" + nums + "个整数:");
        for (int i = 0; i < nums; i++) {
            arr.add(sc.nextInt());
        }
        // 判断部分
        for (int j = 0; j < arr.size() - 1; j++) {
            //int num1 = arr.get(j).intValue();
            //int num2 = arr.get(j + 1).intValue();
            //  if (Math.abs(num1 - num2) > diff_value) {
            if (Math.abs(arr.get(j) - arr.get(j + 1)) > diff_value) {
                System.out.println("数列从第" + (j + 1) + "个数开始中断");
                return;
            }
        }
        System.out.println("这是" + nums + "个数组成的连续数列，差值为" + diff_value);
    }
}
