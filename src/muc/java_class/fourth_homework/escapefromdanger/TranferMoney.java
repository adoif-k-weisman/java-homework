package muc.java_class.fourth_homework.escapefromdanger;

//转账类
public class TranferMoney extends Thread {

    //hash冲突时使用第三个锁
    private static final Object hashConflictShareLock = new Object();

    @Override
    public void run() {

    }

    public static void transferMoney(Account accountFrom, Account accountTo, double accountAmount) {
        //大Boss留下了一个表格， 里边是个算法，用来计算资源的大小，计算出来以后，永远按照从大到小的方式来获得锁
        //这里使用hash值作为算法计算资源大小

        int accountFromHash = System.identityHashCode(accountFrom);
        int accountToHash = System.identityHashCode(accountTo);
        if (accountFromHash > accountToHash) {//大的hash值先获得它的锁
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    tansferMoneyWorker(accountFrom, accountTo, accountAmount);

                }
            }
        } else if (accountFromHash < accountToHash) {
            synchronized (accountTo) {
                synchronized (accountFrom) {
                    transferMoney(accountFrom, accountTo, accountAmount);
                }
            }
        } else {//hash冲突
            synchronized (hashConflictShareLock) {
                synchronized (accountFrom) {
                    synchronized (accountTo) {
                        transferMoney(accountFrom, accountTo, accountAmount);
                    }
                }
            }
        }

    }

    private static void tansferMoneyWorker(Account accountFrom, Account accountTo, double amount) {
        if (accountFrom.getBalance() < amount) {
            System.out.println(accountFrom.name + "账户余额不足以转账，请重新选择业务");
            return;
        } else {//正常转账
            accountFrom.setBalance(accountFrom.getBalance() - amount);
            accountTo.setBalance(accountTo.getBalance() + amount);
            System.out.println("账户" + accountFrom.name + "成功向账户" + accountTo.name + "转账" + amount + "元");
        }
    }
}
