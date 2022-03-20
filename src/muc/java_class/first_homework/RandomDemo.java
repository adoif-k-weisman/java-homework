package muc.java_class.first_homework;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 20; i++)
            System.out.println(i + "=====" + random.nextInt(2));
    }
}
