package muc.java_class.second_homework.robot;

/*
1.（1）创建一个Robot类，包含三个数据成员名字(String name)，腿数量（int numLegs），电量级（float powerLevel）。定义两个方法：
void talk(String phrase)：如果电量高于或者等于1.0，打印phrase，并降低电量一个等级，反之提示电量过低。
void charge(float amount): 给某个Robot充电，电量提高amount等级。
并创建构造方法和toString()方法。
 */
public class Robot {
    private String name;
    private int numLegs;
    private float powerLevel;

    public Robot(String name, int numLegs, float powerLevel) {
        this.name = name;
        this.numLegs = numLegs;
        this.powerLevel = powerLevel;
    }

    public Robot() {
        this.name = "gey";
        this.numLegs = 4;
        this.powerLevel = 3.0F;
    }

    void talk(String phrase) {
        if (this.powerLevel >= 1.0) {
            System.out.println(phrase);
            powerLevel -= 1.0F;
        } else {
            System.out.println("机器人" + this.name + "电量过低");
        }
    }

    void charge(float amount) {
        this.powerLevel += amount;//充电
    }

    public String toString() {
        return "Robot[name : " + name + ",have " + numLegs + " numLegs" + "powerLevel is " + powerLevel + "]";
    }

    /*
    在Robot类中添加一个复制构造方法(copy constructor), 复制构造方法的功能是一个对象作为参数，此对象的数据全部复制给新对象。
     */
    Robot(Robot a) {
        this.name = a.name;
        this.numLegs = a.numLegs;
        this.powerLevel = a.powerLevel;
    }
}
