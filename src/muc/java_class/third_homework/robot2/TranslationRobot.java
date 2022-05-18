package muc.java_class.third_homework.robot2;

import java.util.HashSet;
import java.util.Scanner;

public class TranslationRobot extends AbstractRobot {

    // private static HashMap<String, Color> colorFiled = new HashMap<>();//这款机器人所有的颜色类型
    private static HashSet<String> colorFiled = new HashSet<>();//这款机器人所有的颜色类型

    static {
        colorFiled.add("white");
        colorFiled.add("black");
        colorFiled.add("pink");
        colorFiled.add("bule");
        colorFiled.add("red");
    }

    public TranslationRobot(String name, float weight, int numLegs, float powerLevel, String color1) {
        super(name, weight, numLegs, powerLevel, color1);

    }

    public TranslationRobot() {
        super();

    }

    public TranslationRobot(TranslationRobot a) {
        super(a);

    }

    //翻译实现 talk 时调用translate
    @Override
    void talk(String first, String... strings) {
        super.talk(first);
        translate("翻译后:" + first);
        for (String s : strings) {
            super.talk(s);
            //翻译操作 模拟过程
            translate("翻译后:" + s);
        }
    }

    //模拟实现翻译的功能，即talk时实现“翻译”原有的phase替换为substitute。
    void translate(String substitute) {
        System.out.println(substitute);
    }

    //重写charge(float amount)方法，实现双倍的充电
    @Override
    void charge(float amount) {
        super.charge(2 * amount);
    }

    @Override
    void greet() {
        talk("TranslationRobot : master,it's my pleasure to serve you!");
        translate("主人，为你服务是我的荣幸!");
    }

    @Override
    void color() {
        System.out.println("all color you can choose :");
        System.out.println(colorFiled);
        System.out.println("Please enter the color you want to set:");
        Scanner sc = new Scanner(System.in);
        String colorName = sc.nextLine();
        if (colorFiled.contains(colorName)) {
            super.setColor(colorName);
        } else {
            System.out.println("This kind TranslationRobot doesn't have such a color! The current color is still the original color");
        }
        System.out.println("this TranslationRobot color is " + super.getColor());
    }
}
