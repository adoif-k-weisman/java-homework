package muc.java_class.third_homework.robot2;

//这就相当于一个接口，所有机器人都实现这个抽象类
abstract public class AbstractRobot extends Robot {
    public AbstractRobot(String name, float weight, int numLegs, float powerLevel, String color) {
        super(name, weight, numLegs, powerLevel, color);
    }

    public AbstractRobot() {
        super();
    }

    public AbstractRobot(Robot a) {
        super(a);
    }

    abstract void greet();

    abstract void color();  //
}
