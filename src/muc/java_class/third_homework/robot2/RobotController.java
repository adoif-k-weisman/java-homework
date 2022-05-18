package muc.java_class.third_homework.robot2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RobotController {
    private static ArrayList<AbstractRobot> abstractRobots = new ArrayList<>();

    public static void main(String[] args) {

        //定义一个AbstractRobot数组及几个不同种类机器人对象，
        CarrierRobot carrierRobot1 = new CarrierRobot("carr_one", 100, 4, 10, "black");
        CarrierRobot carrierRobot2 = new CarrierRobot("carr_two", 120, 4, 12, "blue");

        TranslationRobot translationRobot1 = new TranslationRobot("tran_one", 3, 2, 20, "pink");
        TranslationRobot translationRobot2 = new TranslationRobot("tran_two", 2, 2, 30, "red");

        abstractRobots.add(carrierRobot1);
        abstractRobots.add(carrierRobot2);
        abstractRobots.add(translationRobot1);
        abstractRobots.add(translationRobot2);

        //test talk
        System.out.println("test talk function:");
        System.out.println("robot1:");
        abstractRobots.get(0).talk("As time goes by  ", "are you ok?");
        System.out.println("robot2:");
        abstractRobots.get(1).talk("maybe not bad ", "but I think ....", "  with tears, with silence");
        System.out.println("robot3:");
        abstractRobots.get(2).talk("yes,life is the hero narrative poem");

        //测试排序比较器
        System.out.println("abstractRobots数组未排序前:");
        for (AbstractRobot ab : abstractRobots) {
            System.out.println(ab);
        }
        System.out.println("按照机器人的powerLevel数量进行排序后:");
        Collections.sort(abstractRobots, new RobotPowerComparator());
        for (AbstractRobot ab : abstractRobots) {
            System.out.println(ab);
        }
        System.out.println("按照机器人的numLegs数量进行排序后:");
        Collections.sort(abstractRobots, new RobotLegsComparator());
        for (AbstractRobot ab : abstractRobots) {
            System.out.println(ab);
        }
        /*
        //采用方法的多态性，显示出不同的greet语句和颜色。
        for (AbstractRobot ab : abstractRobots) {
            ab.greet();
            ab.color();
            System.out.println("------------------------------");
        }*/
        //abstractRobots.get(0).greet();
        //abstractRobots.get(2).greet();


        System.out.println("Next test robot World and crudRobot implements method :");
        start();
    }

    public static void start() {
        Scanner sc = new Scanner(System.in);
        RobotWorld robotWorld = new RobotWorld();
        AbstractRobot ab;
        exitLoop:
        while (true) {
            System.out.println("欢迎进入机器人管理系统：");
            System.out.println("仅做测试功能试用");
            System.out.println("1.create 增加机器人数量\t 2.display 展示所有的机器人\t 3.delete 删除指定的机器人 ");
            System.out.println("4.update 更改指定的机器人信息\t 5.save 将所有机器人信息存入文件\t 6.read 从文件中读取所有的机器人 ");
            System.out.println("7.查找指定机器人\t  8.退出程序");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    robotWorld.create(abstractRobots);
                    break;
                case "2":
                    robotWorld.display(abstractRobots);
                    break;
                case "3":
                    ab = robotWorld.getRobot(abstractRobots);
                    robotWorld.delete(abstractRobots, ab);
                    break;
                case "4":
                    ab = robotWorld.getRobot(abstractRobots);
                    robotWorld.update(abstractRobots, ab);
                    break;
                case "5":
                    robotWorld.save(abstractRobots, "robot.txt");
                    break;
                case "6":
                    robotWorld.readRobotInFile("robot.txt");
                    break;
                case "7":
                    robotWorld.search(abstractRobots);
                    break;
                case "8":
                    System.out.println("exit the program ....");
                    break exitLoop;
                default:
                    System.out.println("你的输入有误，请重新输入");
                    break;
            }
        }
    }
}
