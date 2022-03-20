package muc.java_class.second_homework.stringoperator;

import java.util.ArrayList;
import java.util.Scanner;

//
public class StringOperator {
    private static Scanner sc = new Scanner(System.in);
    private static final String REG_NUMBER = ".*\\d+.*";//数字

    private static final String REG_UPPERCASE = ".*[A-Z]+.*";    //大写字母

    private static final String REG_LOWERCASE = ".*[a-z]+.*";    //小写字母

    private static final String REG_SYMBOL = ".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*";//特殊符号(~!@#$%^&*()_+|<>,.?/:;'[]{}\)
    private static ArrayList<String> pwdLibrary = new ArrayList<>();

    //密码库存储的是加密后的密码 ,代码块进行初始化操作
    {
        pwdLibrary.add("Attttxzzzwwwwww@");//A3tx2z5w@  ---
        pwdLibrary.add("1xxx?5!aaaaaK");//12x?5!4aK
        pwdLibrary.add("arcadoif19L");//arcadoif190L
        pwdLibrary.add("Onelastkkkkkis~");//Onelast4kis~
    }

    /*
    （1）void changePwd(String pwd) ; void changePwdBuffer(StringBuffer pwd) ;  
    分别以String和StringBuffer/StringBuilder作为参数，比较两个方法的不同。
     */
    //String 底层使⽤ final 关键字修饰字符数组来保存字符串，所以是不可变的，而StringBuilder和StringBuffer均为字符串变量
    public static void changePwd(String pwd) {
        System.out.println("please input your new pwd:");
        pwd = sc.nextLine();
    }

    public static void changePwdBuffer(StringBuffer pwd) {
        System.out.println("please input your new pwd:");
        String pwd_ = sc.nextLine();
        pwd.replace(0, pwd.length(), pwd_);
    }

    //（2）String checkPwd(String pwd) ;  对输入的密码进行检查，要求密码中必须含有大小字母、数字和其他特殊字符，
    // 长度在8-12位之间，如果不满足要求，提示用户重新输入。
    public static String checkPwd(String pwd) {
        boolean lenLegal = true;
        while (true) {
            if (pwd == null || pwd.length() < 8 || pwd.length() > 12) {
                lenLegal = false;
            }
            int i = 0;
            if (pwd.matches(REG_UPPERCASE)) i++;
            if (pwd.matches(REG_LOWERCASE)) i++;
            if (pwd.matches(REG_SYMBOL)) i++;
            if (pwd.matches(REG_NUMBER)) i++;
            if (i != 4 || !lenLegal) {
                System.out.println("The password you entered is invalid");
                System.out.println("please input again:");
                pwd = sc.nextLine();
            } else {
                break;
            }
        }
        return pwd;
    }

    public StringOperator() {
    }
/*
    （3）String cryptPwd(String pwd) ;  对输入的密码进行加密，pwd中含有字母和数字，将数字n替换成n个该数字后面的字母，
    例如string "a3tx2z" 变成"attttxzzz", "12x" 变成"1xxx"。如果数字后面没有字母，可以不做替换，返回新生成的密码。
     */

    public static String cryptPwd(String pwd) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pwd.length() - 1; i++) {
            //判断是否是数字，并且下一位是字母，是就加密
            char old = pwd.charAt(i);
            char nxt = pwd.charAt(i + 1);
            if (Character.isDigit(old) && Character.isLetter(nxt)) {
                int cnt = old - '0';
                // StringBuffer rel = new StringBuffer();
                while (cnt > 0) {
                    //rel.append(nxt);
                    sb.append(nxt);
                    cnt--;
                }
                //sb.replace(i, i, String.valueOf(rel));
            } else {
                sb.append(old);
            }
        }
        sb.append(pwd.charAt(pwd.length() - 1));
        return sb.toString();
    }

    /*
    （4）Boolean machPwd(String pwd) ; 对加密后密码进行匹配验证，查询预保留的密码列表（自己在程序中用数组方式硬设）是否有相同的密码。
     */
    public static boolean matchInput() {//用户输入的是没加密的密码，而数据库存的是密码的摘要信息，即加密的密码
        System.out.println("please input your password：");
        String pwd = sc.nextLine();
        pwd = cryptPwd(pwd);//进行加密操作
        boolean flag = machPwd(pwd);
        return flag;
    }

    //传入输入的字符，供test使用
    public static boolean matchInput(String pwd) {
        pwd = cryptPwd(pwd);//进行加密操作
        boolean flag = machPwd(pwd);
        return flag;
    }

    private static Boolean machPwd(String pwd) {
        if (pwd == null) {
            return false;
        }
        for (String t : pwdLibrary) {
            if (pwd.equals(t)) {
                return true;
            }
        }
        return false;
    }

}
