package muc.java_class.third_homework.robot2;

import java.util.List;

public interface crudRobot<A, T> {
    void create(List<A> robot);//为robot数组 生成并增添对应的机器人

    void display(List<A> robot);//显示robot数组里的所有robot对象

    void delete(List<A> robot, T t); //删除元素t

    void update(List<A> robot, T t); //更改元素t

    A getRobot(List<A> robot);//获得一个指定的元素

    void search(List<A> robot);//查找元素

    //将多个机器人对象保存到一个文件中，
    void save(List<A> robot, String fileName);

    //并且能够从文件中读出来将信息显示到屏幕上。
    void readRobotInFile(String fileName);
}
