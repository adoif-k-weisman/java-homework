package muc.java_class.third_homework.robot2;

import java.util.HashSet;
import java.util.Scanner;

public class CarrierRobot extends AbstractRobot {
    // private float capacity;
//    private static HashMap<String, Color> colorFiled = new HashMap<>();//这款机器人所有的颜色类型
    private static HashSet<String> colorFiled = new HashSet<>();//这款机器人所有的颜色类型

    static {
        colorFiled.add("white");
        colorFiled.add("black");
        colorFiled.add("gray");
        colorFiled.add("bule");
        colorFiled.add("red");
    }

    public CarrierRobot() {
        super();
    }

    public CarrierRobot(CarrierRobot a) {
        super(a);
        // this.capacity = a.capacity;

    }

    public CarrierRobot(String name_, float weight_, int numLegs_, float powerLevel_, String color) {//, float capacity) {
        super(name_, weight_, numLegs_, powerLevel_, color);
        // this.capacity = capacity;
    }


    //判断机器人的载重capacity是否超过其体重的1倍，如果超重，提示错误信息
    void carry(float capacity) {
        if (super.getWeight() < capacity) {
            System.out.println("Error : Overload! please reduce the capacity.");
        } else {
            System.out.println("a piece of cake.This weight is easy for me to carry");
        }
    }

    @Override
    void greet() {
        talk("CarrierRobot : Hello World");
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
            System.out.println("CarrierRobot doesn't have such a color! The current color is still the original color");
        }
        System.out.println("this CarrierRobot color is " + super.getColor());
    }
}
