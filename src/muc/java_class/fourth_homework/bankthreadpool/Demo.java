package muc.java_class.fourth_homework.bankthreadpool;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> transInfo = new ArrayBlockingQueue<>(10);//容量：10

        Bank bank = new Bank(transInfo);
        BlockingQueueCooker blockingQueueCooker = new BlockingQueueCooker(transInfo);

        blockingQueueCooker.start();
        bank.start();

    }
}
