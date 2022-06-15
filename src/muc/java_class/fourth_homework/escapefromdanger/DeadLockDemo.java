package muc.java_class.fourth_homework.escapefromdanger;
//“我是一个线程”第三回“虎口脱险”，根据所描述的某导演和某演员银行账户之间转账的场景,实现如下：
// 程序1：模拟实现两个账户转账时出现死锁。

public class DeadLockDemo {

    public static void main(String[] args) {
        Object director = new Object();
        Object actor = new Object();

        //0x7954
        new Thread(() -> {
            while (true) {
                synchronized (director) {
                    System.out.println("导演账户取出3000元");
                    try {
                        Thread.sleep(300);//模拟线程中断    需要等待抢到CPU执行权
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //线程一 从导演向演员转账
                    synchronized (actor) {
                        System.out.println("导演成功向演员转账3000元");
                    }
                }
            }
        }).start();

        //0X3704
        new Thread(() -> {
            while (true) {
                synchronized (actor) {
                    System.out.println("演员账户取出40000元");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //线程二 从演员向导演转账
                    synchronized (director) {
                        System.out.println("演员向导演转账40000元");
                    }
                }
            }
        }).start();

    }
}
