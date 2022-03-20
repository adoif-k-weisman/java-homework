package muc.java_class.first_homework;

public class Corporation {
    static void salaryCalculator(double hours, double wage) {
        if (wage < 8.0) {
            System.out.println("基本工资过低，不符合要求");
            System.out.println("错误");
            return;
        }
        if (hours > 60) {
            System.out.println("工作时间过长，不符合要求");
            System.out.println("错误");
            return;
        }

        System.out.println("员工的工资总数为:" + hours * wage);

    }

    public static void main(String[] args) {
        //员工一： 7.5 35
        System.out.println("员工1：基本工资 7.5  工作时数：35，工资为:");
        salaryCalculator(35, 7.5);
        //员工二: 8.2  47
        System.out.println("员工2：基本工资 8.2  工作时数：47，工资为:");
        salaryCalculator(47, 8.2);
        //员工三： 10.00 73
        System.out.println("员工3：基本工资 10.00  工作时数：73，工资为:");
        salaryCalculator(73, 10.00);
    }

}
