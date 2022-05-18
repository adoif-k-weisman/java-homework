package muc.java_class.third_homework.robot2;

public class CarrierRobotFactory implements RobotProvider {
    @Override
    public AbstractRobot produce() {
        return new CarrierRobot();
    }
}
