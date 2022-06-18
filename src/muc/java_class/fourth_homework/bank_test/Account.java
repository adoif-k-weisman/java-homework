package muc.java_class.fourth_homework.bank_test;

public class Account {
    private String id;
    private String name;// 账号
    private int balance;// 资金总额

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public void debit(int amount) {// 更新转出方余额
        this.balance -= amount;
    }

    public void credbit(int amount) {// 更新转入方余额
        this.balance += amount;
    }
}
