package muc.java_class.first_homework;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static private Scanner sc = new Scanner(System.in);
    static private Random random = new Random();

    //  -1 表示平局  0表示第二个胜利   1 表示 第一个胜利
    static int determineVictory(String fir_person, String sec_person) {
        if (fir_person.equals(sec_person)) {
            return -1;
        } else if ("石头".equals(fir_person) && "剪刀".equals(sec_person)) {
            return 1;
        } else if ("石头".equals(fir_person) && "布".equals(sec_person)) {
            return 0;
        } else if ("剪刀".equals(fir_person) && "布".equals(sec_person)) {
            return 1;
        } else if ("剪刀".equals(fir_person) && "食堂".equals(sec_person)) {
            return 0;
        } else if ("布".equals(fir_person) && "石头".equals(sec_person)) {
            return 1;
        } else if ("布".equals(fir_person) && "剪刀".equals(sec_person)) {
            return 0;
        }
        return -100;
    }


    static void playerVSPlayer() {
        System.out.println("欢迎来到玩家 VS 玩家互相PK版石头剪刀布！");
        System.out.println("请第一位玩家出 石头、剪刀、布中的一个：");
        String first = sc.next();
        System.out.println("请第二位玩家出 石头、剪刀、布中的一个：");
        String second = sc.next();
        System.out.println("第一位玩家出的是: " + first + "  , " + "第二位玩家出的是: " + second);
        int ans = determineVictory(first, second);
        if (ans == 1) {
            System.out.println("第一位玩家取得胜利！");
        } else if (ans == 0) {
            System.out.println("第二位玩家取得胜利！");
        } else if (ans == -1) {
            System.out.println("平局哟！");
        } else if (ans == -100) {
            System.out.println("无法判断游戏结果!");
        }
    }

    static void playerVSComputer() {
        System.out.println("欢迎来到人机模式版石头剪刀布！");
        System.out.println("请玩家出 石头、剪刀、布中的一个：");
        String first = sc.next();
        int computer_choice = random.nextInt(3) + 1;
        String computer_ans = new String();
        if (computer_choice == 1) {
            computer_ans = "石头";
        } else if (computer_choice == 2) {
            computer_ans = "剪刀";
        } else if (computer_choice == 3) {
            computer_ans = "布";
        }
        System.out.println("玩家出的是: " + first + "  , " + "电脑出的是: " + computer_ans);
        int ans = determineVictory(first, computer_ans);
        if (ans == 1) {
            System.out.println("玩家取得胜利！");
        } else if (ans == 0) {
            System.out.println("电脑取得胜利！");
        } else if (ans == -1) {
            System.out.println("平局哟！");
        } else if (ans == -100) {
            System.out.println("无法判断游戏结果!");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("Please select your game mode：1---PVP 2---PVE  3---exit program");
            char choice = sc.next().charAt(0);
            switch (choice) {
                case '1':
                    playerVSPlayer();
                    break;
                case '2':
                    playerVSComputer();
                    break;
                case '3':
                    System.out.println("exit program!!!");
                    System.exit(0);
                default:
                    System.out.println("Incorrect input selection");
                    break;
            }
        }
    }
}
