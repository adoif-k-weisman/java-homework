package muc.java_class.third_homework.robot2;

public class TranslationRobotFactory implements RobotProvider {
    @Override
    public AbstractRobot produce() {
        return new TranslationRobot();
    }
}
