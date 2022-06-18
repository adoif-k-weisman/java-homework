package muc.java_class.fourth_homework.escapefromdanger;

public class TranferThread implements Runnable {
    private Account fromAccout;
    private Account toAccount;
    private int amount;

    public TranferThread() {
    }

    public TranferThread(Account fromAccout, Account toAccount, int amount) {
        this.fromAccout = fromAccout;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        new TranferMoney().transferMoney(fromAccout, toAccount, amount);

    }
}
