package muc.java_class.third_homework.robot2;

//工厂接口，所有工厂类通过实现它进而创建对应的机器人
public interface RobotProvider {
    public AbstractRobot produce();
}
