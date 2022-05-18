package muc.java_class.second_homework.stringoperator;

import java.util.Scanner;

public class StringOPDemo {
    public static void main(String[] args) {
        StringOperator stringOperator = new StringOperator();
        String pwd1 = new String("onelast4kis");

        //test String checkPwd(String pwd)
        Scanner sc = new Scanner(System.in);
        String passworld = sc.nextLine();
        passworld = StringOperator.checkPwd(passworld);

        //test String cryptPwd(String pwd) ;  对输入的密码进行加密
        System.out.println("your input passworld is encrypted");
        System.out.println(StringOperator.cryptPwd(passworld));


        //test Boolean machPwd(String pwd) ; 对加密后密码进行匹配验证
        while (true) {
            boolean sucess = StringOperator.matchInput();
            if (sucess) {
                System.out.println("your input password successful");
                break;
            } else {
                System.out.println("wrong");
            }
        }

        //test String StringBuffer different
        StringBuffer stringBuffer = new StringBuffer("onelast4kis");
        StringOperator.changePwd(pwd1);
        System.out.println("修改后的String:" + pwd1);
        StringOperator.changePwdBuffer(stringBuffer);
        System.out.println("修改后的StringBuffer:" + stringBuffer);


        pwd1 = StringOperator.checkPwd(pwd1);
        System.out.println("检验后的密码：" + pwd1);

    }
}
