package muc.java_class.first_homework;

import java.util.Random;

public class ThrowDice {
    public static void main(String[] args) {
        //丢筛子 算二次平均值
        Random random = new Random();
        int first = random.nextInt(6) + 1;
        System.out.println("The first die come up " + first);
        int second = random.nextInt(6) + 1;
        System.out.println("The second die come up " + second);
        System.out.println("Your total roll is " + (first + second));
        System.out.println("The average roll is " + (first + second) / 2);

    }
}
