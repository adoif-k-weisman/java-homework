package muc.java_class.fourth_homework.bankthreadpool;

//子线程
public class TransferRunable implements Runnable {
    private Account fromAccout;
    private Account toAccount;
    private int amount;
    //hash冲突时使用第三个锁
    private static final Object hashConflictShareLock = new Object();

    public TransferRunable(Account fromAccout, Account toAccount, int amount) {
        this.fromAccout = fromAccout;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        // System.out.println("当前准备转账线程为:" + Thread.currentThread().getName());
        int accountFromHash = System.identityHashCode(fromAccout);
        int accountToHash = System.identityHashCode(toAccount);
        if (accountFromHash > accountToHash) {//大的hash值先获得它的锁
            synchronized (fromAccout) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (toAccount) {
                    transferMoneyWorker(fromAccout, toAccount, amount);
                }
            }
        } else if (accountFromHash < accountToHash) {
            synchronized (toAccount) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fromAccout) {
                    transferMoneyWorker(fromAccout, toAccount, amount);
                }
            }
        } else {//hash冲突
            synchronized (hashConflictShareLock) {
                synchronized (fromAccout) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (toAccount) {

                        transferMoneyWorker(fromAccout, toAccount, amount);
                    }
                }
            }
        }
    }

    private void transferMoneyWorker(Account accountFrom, Account accountTo, int amount) {
        System.out.println("当前转账worker线程为:" + Thread.currentThread().getName());
        if (accountFrom.getBalance() < amount) {
            System.out.println(accountFrom.getAccountID() + "账户余额不足以转账，请重新选择业务");

            return;
        } else {//正常转账
            accountFrom.setBalance(accountFrom.getBalance() - amount);
            accountTo.setBalance(accountTo.getBalance() + amount);
            accountTo.setTransanctionNum(accountFrom.getTransanctionNum() + 1);
            accountFrom.setTransanctionNum(accountFrom.getTransanctionNum() + 1);

            System.out.println("执行线程为" + Thread.currentThread().getName() + "\t\t账户:" + accountFrom.getAccountID() + "成功向账户:" + accountTo.getAccountID() + "转账" + amount + "元");
        }
    }
}
