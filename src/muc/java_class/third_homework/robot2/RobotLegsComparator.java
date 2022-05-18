package muc.java_class.third_homework.robot2;

import java.util.Comparator;

public class RobotLegsComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Robot r1 = (Robot) o1;
        Robot r2 = (Robot) o2;
        if (r1.getNumLegs() > r2.getNumLegs())
            return 1;
        else if (r1.getNumLegs() < r2.getNumLegs())
            return -1;
        else
            return 0;
    }
}
