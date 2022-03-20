package muc.java_class.second_homework.stringoperator;

public class StringOPDemo {
    public static void main(String[] args) {
        StringOperator stringOperator = new StringOperator();
        String pwd1 = new String("onelast4kis");

        boolean sucess = StringOperator.matchInput();
        if (sucess) {
            System.out.println("your input password successful");
        } else {
            System.out.println("wrong");
        }

        StringBuffer stringBuffer = new StringBuffer("onelast4kis");
        StringOperator.changePwd(pwd1);
        System.out.println("修改后的String:" + pwd1);
        StringOperator.changePwdBuffer(stringBuffer);
        System.out.println("修改后的StringBuffer:" + stringBuffer);


        pwd1 = StringOperator.checkPwd(pwd1);
        System.out.println("检验后的密码：" + pwd1);

    }
}
