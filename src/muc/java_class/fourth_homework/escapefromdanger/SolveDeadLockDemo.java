package muc.java_class.fourth_homework.escapefromdanger;

public class SolveDeadLockDemo {
    public static void main(String[] args) {
        Account director = new Account("导演", 500000);
        Account actor = new Account("演员一号", 30000);
        Runnable dirToAct = new TranferThread(director, actor, 2000);
        Runnable actToDir = new TranferThread(actor, director, 3000);

        //二个线程运行
        //转账过程并非一定需要等待-通知机制，那么不用wait()和notifyall()方法也行
        new Thread(dirToAct).start();
        new Thread(actToDir).start();

    }
}
