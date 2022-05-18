package muc.java_class.third_homework.formatter;

import java.util.LinkedList;
import java.util.Scanner;

public class MagicWords {

    public static void main(String[] args) {
        String str;
        LinkedList<Formatter> arr = new LinkedList<>();//使用接口类
        arr.add(new IdentifyFormatter());
        arr.add(new ReverseFormatter());
        arr.add(new ROT13Formatter());

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        str = sc.nextLine();
        System.out.println(arr.get(0).format(str));
        System.out.println(arr.get(1).format(str));
        System.out.println(arr.get(2).format(str));

    }
}
