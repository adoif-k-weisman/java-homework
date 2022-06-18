package muc.java_class.fourth_homework.bankthreadpool;

public class Account {
    private String accountID;
    private double balance;
    private int transanctionNum;

    public Account(String accountID, double balance, int transanctionNum) {
        this.accountID = accountID;
        this.balance = balance;
        this.transanctionNum = transanctionNum;
    }

    public Account() {
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getTransanctionNum() {
        return transanctionNum;
    }

    public void setTransanctionNum(int transanctionNum) {
        this.transanctionNum = transanctionNum;
    }

    @Override
    public String toString() {
        return "accountID='" + accountID + '\'' +
                ", balance账户余额为:" + balance +
                ", transanctionNum交易次数:" + transanctionNum;
    }
}
