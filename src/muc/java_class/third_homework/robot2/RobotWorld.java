package muc.java_class.third_homework.robot2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//就当做RobotController 类前端管理数据   后端使用工厂模式优化
public class RobotWorld implements crudRobot<AbstractRobot, AbstractRobot> {

    //private static ArrayList<AbstractRobot> abstractRobots = new ArrayList<>();
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    /*
    public static void main(String[] args) {

        //定义一个AbstractRobot数组及几个不同种类机器人对象，
        CarrierRobot carrierRobot1 = new CarrierRobot("carr_one", 100, 4, 10, Color.black);
        CarrierRobot carrierRobot2 = new CarrierRobot("carr_two", 120, 4, 12, Color.blue);

        TranslationRobot translationRobot1 = new TranslationRobot("tran_one", 3, 2, 20, Color.pink);
        TranslationRobot translationRobot2 = new TranslationRobot("tran_two", 2, 2, 30, Color.red);

        abstractRobots.add(carrierRobot1);
        abstractRobots.add(carrierRobot2);
        abstractRobots.add(translationRobot1);
        abstractRobots.add(translationRobot2);

        //test talk
        System.out.println("test talk function:");
        System.out.println("robot1:");
        abstractRobots.get(0).talk("As time goes by  ", "are you ok?");
        System.out.println("robot2:");
        abstractRobots.get(1).talk("maybe not bad ", "but I think ....", "  with tears, with silence");
        System.out.println("robot3:");
        abstractRobots.get(2).talk("yes,life is the hero narrative poem");

        System.out.println("abstractRobots数组未排序前:");
        //System.out.println(abstractRobots);

        System.out.println("按照机器人的powerLevel数量进行排序后:");
        Collections.sort(abstractRobots, new RobotPowerComparator());
        //System.out.println(abstractRobots);
        System.out.println("按照机器人的numLegs数量进行排序后:");
        Collections.sort(abstractRobots, new RobotLegsComparator());
        System.out.println(abstractRobots);

        //采用方法的多态性，显示出不同的greet语句和颜色。
        for (AbstractRobot ab : abstractRobots) {
            ab.greet();
            ab.color();
        }


    }
*/

    //get factory  可以进一步优化！！！降低耦合
    @Override
    public void create(List<AbstractRobot> robot) {
        //创建并添加robot对象
        while (true) {
            System.out.println("请输入你想要创建的机器人类型(CR---CarrierRobot,TR---TranslationRobot,exit---exit the method):");
            String name = null;
            try {
                name = bf.readLine();
            } catch (IOException e) {
                System.out.println(e);
                System.out.println("error input! Please try again");
            }
            if ("CR".equals(name)) {
                RobotProvider robotProvider = new CarrierRobotFactory();
                AbstractRobot ab = robotProvider.produce();
                robot.add(ab);
                System.out.println("Added successfully");
            } else if ("TR".equals(name)) {
                RobotProvider robotProvider = new TranslationRobotFactory();
                AbstractRobot ab = robotProvider.produce();
                robot.add(ab);
                System.out.println("Added successfully");
            } else if ("exit".equals(name)) {
                break;
            } else {
                System.out.println("error input! Please try again");
            }
        }

    }

    //打印所有的机器人
    @Override
    public void display(List<AbstractRobot> robot) {
        for (AbstractRobot abstractRobot : robot) {
            System.out.println(abstractRobot.toString());
        }
    }

    //删除
    @Override
    public void delete(List<AbstractRobot> robot, AbstractRobot t) {
        if (t == null) {
            System.out.println("输入机器人信息有误");
            return;
        }
        for (AbstractRobot r : robot) {
            if (r.equals(t)) {
                robot.remove(r);
            }
        }
    }

    //修改待定  使用工厂模式更新这个设计更重要
    @Override
    public void update(List<AbstractRobot> robot, AbstractRobot updateRobot) {
        if (updateRobot == null) {
            System.out.println("输入机器人信息有误！");
            return;
        }
        String name;
        int numLegs;
        float weight, powerLevel;
        System.out.println("Please enter the robot information you want to update:");
        try {
            System.out.println("robot name:");
            name = bf.readLine();
            System.out.println("robot weight:");
            weight = Float.parseFloat(bf.readLine());
            System.out.println("robot numLegs:");
            numLegs = Integer.parseInt(bf.readLine());
            System.out.println("robot powerLevel:");
            powerLevel = Float.parseFloat(bf.readLine());

        } catch (IOException e) {
            System.out.println(e);
            System.out.println("输入错误！重试");
            return;
        }
        for (AbstractRobot r : robot) {
            if (r.equals(updateRobot)) {
                r.setName(name);
                r.setWeight(weight);
                r.setNumLegs(numLegs);
                r.setPowerLevel(powerLevel);
                r.color();
                System.out.println("update robot info successful");
            }
        }
    }

    @Override
    public AbstractRobot getRobot(List<AbstractRobot> robot) {
        for (int i = 0; i < robot.size(); i++) {
            System.out.println("第" + (i + 1) + "号机器人信息为:" + robot.get(i));
        }
        int choice = -1;
        System.out.println("请选择你的目标机器人(输入对应的机器人编号):");
        try {
            choice = Integer.parseInt(bf.readLine());
        } catch (IOException e) {
            System.out.println("输入错误！");
            System.out.println("退出后重试");
            return null;
        }
        if (choice < 1 || choice > robot.size())//输入编号不合法
            return null;
        return robot.get(choice - 1);//输入时编号从1开始，故减1
    }

    @Override
    public void search(List<AbstractRobot> robot) {
        System.out.println("请输入你想要查找的机器人名字:");
        String robotName;
        try {
            robotName = bf.readLine();
        } catch (IOException e) {
            System.out.println("BufferedReader输入异常!");
            System.out.println("即将退出该方法...");
            return;
        }
        for (AbstractRobot ab : robot) {
            if (ab.getName().equals(robotName)) {
                System.out.println("已查询到目标机器人,信息如下:");
                System.out.println(ab);
                break;
            }
        }

    }

    @Override
    public void save(List<AbstractRobot> robot, String fileName) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(robot);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭对象写入流失败....");
                }
            }
        }
    }

    /*
    //Jdk 9以后的 新操作
    @Override
    public void save(List<AbstractRobot> robot, String fileName) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        try (oos) {
            oos.writeObject(robot);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("关闭对象写入流失败......");
        }
    }
*/

    @Override
    public void readRobotInFile(String fileName) {
        ObjectInputStream ois = null;
        ArrayList<AbstractRobot> robotArrayList = new ArrayList<>();
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            //进行强转
            robotArrayList = (ArrayList<AbstractRobot>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取流创建失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("指定的类文件对象不存在");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException("对象读取流关闭失败");
                }
            }
        }
        for (AbstractRobot r : robotArrayList) {
            System.out.println(r.toString());
        }
    }
}
