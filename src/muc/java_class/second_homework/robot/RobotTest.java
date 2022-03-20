package muc.java_class.second_homework.robot;

/*
  创建一个RobotTest类，并在其中创建多个Robot对象进行测试。
 */
public class RobotTest {
    public static void main(String[] args) {
        Robot robot1 = new Robot();
        Robot robot2 = new Robot("happy", 8, 10.0F);
        Robot robot3 = new Robot("niuma", 4, 1.0F);
        //test talk
        robot1.talk("who is niuma");
        robot2.talk("not me");
        robot3.talk("yes,it is me");
        //test charge
        robot1.charge(-3.0F);
        robot2.charge(1.0F);
        robot3.charge(1.56F);
        //test ToString()
        System.out.println(robot1.toString());
        System.out.println(robot2.toString());
        System.out.println(robot3.toString());
        //调用拷贝构造函数
        Robot robot4 = new Robot(robot3);
        System.out.println(robot4);
    }
}
