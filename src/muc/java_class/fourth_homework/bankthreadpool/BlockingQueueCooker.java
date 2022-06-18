package muc.java_class.fourth_homework.bankthreadpool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

//主线程就是生产者
public class BlockingQueueCooker extends Thread {
    ArrayBlockingQueue<String> transInfo;

    public BlockingQueueCooker(ArrayBlockingQueue<String> transInfo) {
        this.transInfo = transInfo;
    }


    @Override
    public void run() {
        int cntInfo = 0;
        //主线程从一个文件中读取交易信息
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("Transfer_record.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (line != null) {
//            System.out.println("读取到的数据如下:" + line);
            try {
                transInfo.put(line);
                cntInfo++;
                // System.out.println("读入一条转账信息");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("成功读入" + (cntInfo - 1) + "条交易信息");// -1 0 0不算有效交易信息
        System.out.println("生产者线程运行完毕!!!");

    }
    
}
