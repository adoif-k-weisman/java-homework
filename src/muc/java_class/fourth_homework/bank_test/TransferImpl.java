package muc.java_class.fourth_homework.bank_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TransferImpl implements Transfer {

    public void transfer(Account fromAccount, Account toAccount, int amount) {

        int fromHashCode = fromAccount.getId().hashCode();
        int toHashCode = toAccount.getId().hashCode();

        Account left = fromAccount;
        Account right = toAccount;

        // 按从小到大排序
        if (fromHashCode > toHashCode) {
            left = toAccount;
            right = fromAccount;
        }

        synchronized (left) {
            // 获取right的锁
            synchronized (right) {
                // 两个锁都获取到执行操作
                if (fromAccount.getBalance() <= amount) {
                    System.out.println(Thread.currentThread().getName() + "->" + fromAccount.getName() + "账户余额不足，无法进行转账" + " 余额：" + fromAccount.getBalance() + "<" + amount);
                    return;
                }
                fromAccount.debit(amount);
                System.err.println(Thread.currentThread().getName() + "->" + fromAccount.getName() + "**转出**" + amount + "**剩余**" + fromAccount.getBalance());
                toAccount.credbit(amount);
                System.out.println(Thread.currentThread().getName() + "->" + toAccount.getName() + "--被【" + fromAccount.getName() + "】转入--" + amount + "--剩余--" + toAccount.getBalance());
            }
        }

    }

    public static void main(String[] args) {

        List<Account> allAccount = new ArrayList<Account>();

        allAccount.add(new Account("1", "张三", 100));
        allAccount.add(new Account("2", "李四", 100));
        allAccount.add(new Account("3", "小梅", 100));
        allAccount.add(new Account("4", "小明", 100));

        for (int i = 0; i < 10; i++) {
            int findex = ThreadLocalRandom.current().nextInt(4);
            int toindex = ThreadLocalRandom.current().nextInt(4);

            int amount = ThreadLocalRandom.current().nextInt(50, 80);
            if (findex != toindex) {
                Runnable r = new TransferThread(allAccount.get(findex), allAccount.get(toindex), amount, allAccount);
                new Thread(r).start();
            }
        }
    }

    public static class TransferThread implements Runnable {

        private Account fromAccount;
        private Account toAccount;
        private int amount;
        private List<Account> allAccount;

        public TransferThread(Account fromAccount, Account toAccount, int amount, List<Account> allAccount) {
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
            this.amount = amount;
            this.allAccount = allAccount;
        }

        public void run() {
            new TransferImpl().transfer(fromAccount, toAccount, amount);

            int total = 0;

            for (Account account : allAccount) {
                total = total + account.getBalance();
            }
            System.err.println(Thread.currentThread().getName() + "-> total:" + total);
        }
    }

}

