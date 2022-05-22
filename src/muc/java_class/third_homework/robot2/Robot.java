package muc.java_class.third_homework.robot2;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

/*
1.（1）创建一个Robot类，包含三个数据成员名字(String name)，腿数量（int numLegs），电量级（float powerLevel）。定义两个方法：
void talk(String phrase)：如果电量高于或者等于1.0，打印phrase，并降低电量一个等级，反之提示电量过低。
void charge(float amount): 给某个Robot充电，电量提高amount等级。
并创建构造方法和toString()方法。
 */
public class Robot implements Serializable {
    private static final long serialVersionUID = 666L;//不使用计算机自动计算的，自定义序列号，以防修改类信息时，序列号变化
    private static long id = 1;
    private String name;
    private float weight;
    private int numLegs;
    private float powerLevel;
    private String color;

    private static String[] colorFiled = new String[]{"white", "black", "gray"};

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public void setPowerLevel(float powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
//        return Float.compare(robot.weight, weight) == 0 && numLegs == robot.numLegs && Float.compare(robot.powerLevel, powerLevel) == 0 && Objects.equals(name, robot.name) && Objects.equals(color, robot.color);
        return Float.compare(robot.weight, weight) == 0 && numLegs == robot.numLegs && Objects.equals(name, robot.name) && Objects.equals(color, robot.color);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, numLegs, color);
    }

    public Robot(String name, float weight, int numLegs, float powerLevel, String color1) {
        this.name = name;
        this.weight = weight;
        this.numLegs = numLegs;
        this.powerLevel = powerLevel;
        this.color = color1;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public float getPowerLevel() {
        return powerLevel;
    }

    public Robot() {
        this.name = "shiina" + id + "号";
        this.weight = 20;
        this.numLegs = 4;
        this.powerLevel = 3.0F;
        Random r = new Random();
        int colorChoice = r.nextInt(3);
        this.color = colorFiled[colorChoice];//default color
        id++;
    }

    //重载的talk方法，参数个数是可变的
    void talk(String phrase) {
        if (this.powerLevel >= 1.0) {
            System.out.println(phrase);
            powerLevel -= 1.0F;
        } else {
            System.out.println("机器人" + this.name + "电量过低");
        }
    }

    void talk(String first, String... strings) {
        if (this.powerLevel >= 1.0) {
            System.out.println(first);
            for (String s : strings) {
                System.out.println(s);
            }
            powerLevel -= 1.0F;
        } else {
            System.out.println("机器人" + this.name + "电量过低");
        }
    }

    void charge(float amount) {
        this.powerLevel += amount;//充电
    }

    public String toString() {
        return "Robot[name : " + name + "  it's color is " + this.color + "  weights: " + this.weight + " kg " + ",have " + numLegs + " numLegs" + ",powerLevel is " + powerLevel + "]";
    }

    /*
    在Robot类中添加一个复制构造方法(copy constructor), 复制构造方法的功能是一个对象作为参数，此对象的数据全部复制给新对象。
     */
    Robot(Robot a) {
        this.name = a.name;
        this.numLegs = a.numLegs;
        this.powerLevel = a.powerLevel;
        this.weight = a.weight;
        this.color = a.color;
    }
}
