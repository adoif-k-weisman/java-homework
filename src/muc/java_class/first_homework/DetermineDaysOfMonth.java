package muc.java_class.first_homework;

import java.util.Scanner;

public class DetermineDaysOfMonth {
    static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;
        return false;
    }

    //输入年月 判断该月天数
    public static void main(String[] args) {
        String month[] = {"January", "February", "March",
                "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days_[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner sc = new Scanner(System.in);
        System.out.println("Input year：");
        int year_ = sc.nextInt();
        System.out.println("Input the month：");
        int month_ = sc.nextInt();
        int day;
        if (isLeapYear(year_)) {
            day = days_[month_];
        } else {
            day = days[month_];
        }
        System.out.println(month[month_ - 1] + "," + year_ + " has " + day + " days");
    }


}
