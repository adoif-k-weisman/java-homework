package muc.java_class.first_homework;

import java.util.Random;

public class CountSnakeEyes {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            Random random = new Random();
            int first = random.nextInt(5) + 1;
            int second = random.nextInt(5) + 1;
            count++;
            if (first == second && first == 1) {
                break;
            }
        }
        System.out.println("The number of times Snake Eyes appears need " + count);
    }
}
