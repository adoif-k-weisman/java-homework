package muc.java_class.fourth_homework.escapefromdanger;

//转账类
public class TranferMoney {

    //hash冲突时使用第三个锁
    private static final Object hashConflictShareLock = new Object();


    public void transferMoney(Account accountFrom, Account accountTo, int accountAmount) {
        //大Boss留下了一个表格， 里边是个算法，用来计算资源的大小，计算出来以后，永远按照从大到小的方式来获得锁
        //这里使用hash值作为算法计算资源大小
        System.out.println("当前准备转账线程为:" + Thread.currentThread().getName());
        int accountFromHash = System.identityHashCode(accountFrom);
        int accountToHash = System.identityHashCode(accountTo);
        if (accountFromHash > accountToHash) {//大的hash值先获得它的锁
            synchronized (accountFrom) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (accountTo) {
                    transferMoneyWorker(accountFrom, accountTo, accountAmount);
                }
            }
        } else if (accountFromHash < accountToHash) {
            synchronized (accountTo) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (accountFrom) {
                    transferMoneyWorker(accountFrom, accountTo, accountAmount);
                }
            }
        } else {//hash冲突
            synchronized (hashConflictShareLock) {
                synchronized (accountFrom) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (accountTo) {

                        transferMoneyWorker(accountFrom, accountTo, accountAmount);
                    }
                }
            }
        }

    }

    private void transferMoneyWorker(Account accountFrom, Account accountTo, int amount) {
        System.out.println("当前转账worker线程为:" + Thread.currentThread().getName());
        if (accountFrom.getBalance() < amount) {
            System.out.println(accountFrom.name + "账户余额不足以转账，请重新选择业务");

            return;
        } else {//正常转账
            accountFrom.setBalance(accountFrom.getBalance() - amount);
            accountTo.setBalance(accountTo.getBalance() + amount);
            System.out.println("执行线程为" + Thread.currentThread().getName() + "\t\t账户:" + accountFrom.name + "成功向账户:" + accountTo.name + "转账" + amount + "元");
        }
    }
}
