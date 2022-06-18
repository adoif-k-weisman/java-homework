package muc.java_class.fourth_homework.bankthreadpool;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//消费者，产生子线程处理任务
public class Bank extends Thread {
    //存放银行账户
    ArrayList<Account> allAccount = new ArrayList<>();
    ArrayBlockingQueue<String> transferInfo;

    ThreadPoolExecutor threadPoolExecutor;


    public Bank(ArrayBlockingQueue<String> transferInfo) {
        this.transferInfo = transferInfo;

        //初始账户信息
        for (int i = 0; i < 20; i++) {
            Account account = new Account((i + 1) + "号账户", 5000, 0);
            allAccount.add(account);
        }
    }

    @Override
    public void run() {
        //使用线程池创建多个子线程执行转账任务
        threadPoolExecutor = new ThreadPoolExecutor(10, 50, 20,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        String[] oneInfo;
        while (true) {
            try {
                oneInfo = transferInfo.take().split(" ");//取出交易信息
                //交易过程
                //得到信息   数组下标从0开始
                int from = Integer.parseInt(oneInfo[0]);
                int to = Integer.parseInt(oneInfo[1]);
                int amount = Integer.parseInt(oneInfo[2]);
                //判断读取完成
                if (from == -1 && to == 0 && amount == 0) {
                    System.out.println("当前消费者线程运行结束");
                    threadPoolExecutor.shutdown();//关闭线程池
//                    return;
                    break;
                }

                //线程池处理  创建多个子线程
                threadPoolExecutor.submit(new TransferRunable(allAccount.get(from - 1), allAccount.get(to - 1), amount));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //判断线程池所有线程是否执行完-----> 执行完才能打印所有账户信息
        while (!threadPoolExecutor.isTerminated()) {

        }

        System.out.println("==================================================");
        System.out.println("线程池关闭，成功执行完所有转账任务！！！");
        System.out.println("====================================================");
        System.out.println("执行完所有转账任务的账户信息如下(注:如果转账失败的话，是不会记录已交易次数的):");
        for (Account acc : allAccount) {
            System.out.println(acc);
        }

    }
}
