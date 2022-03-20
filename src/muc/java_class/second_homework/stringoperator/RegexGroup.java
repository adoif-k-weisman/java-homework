package muc.java_class.second_homework.stringoperator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGroup {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "Hello,World! in Java.";
        Pattern pattern = Pattern.compile("W(or)(ld!).(in)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            //只有当匹配操作成功，才可以使用start()，end()，group()三个方法，否则会抛出java.lang.IllegalStateException，
            // 也就是当matches()，lookingAt()，find()其中任意一个方法返回 true 时，才可以使用。
            //所以要加上while()
            //group()得到分组数
            System.out.println("groupcnt===" + matcher.groupCount());// groupcnt===2
            //得到第0组字符串——整个匹配的字符串
            System.out.println("Group 0:" + matcher.group(0));//Group 0:World! in
            //得到第一组匹配的——与(or)匹配的字符串
            System.out.println("Group 1:" + matcher.group(1));//Group 1:or
            //得到第二组匹配——与(ld!)匹配的，组也就是子表达式
            System.out.println("Group 2:" + matcher.group(2));//Group 2:ld!
            //总匹配的索引
            System.out.println("Start 0:" + matcher.start(0) + " End 0:" + matcher.end(0));//Start 0:6 End 0:15
            //第一组匹配的索引
            System.out.println("Start 1:" + matcher.start(1) + " End 1:" + matcher.end(1));//Start 1:7 End 1:9
            //第二组匹配的索引
            System.out.println("Start 2:" + matcher.start(2) + " End 2:" + matcher.end(2));//Start 2:9 End 2:12
            ////从总匹配开始索引到第1组匹配的结束索引之间子串——Wor
            System.out.println(str.substring(matcher.start(0), matcher.end(1)));
        }

        //举个例子：
        //一段文本，里面有很多数字，而且这些数字是分开的，我们现在要将文本中所有数字都取出来。
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("我的QQ是:123456 我的电话是:078911 我的邮箱是:15281897239@163.com");
        while (m.find()) {
            System.out.println(m.group());
            System.out.print("start:" + m.start());
            System.out.println(" end:" + m.end());
        }
    /*
    123456
    start:6 end:12
    078911
    start:19 end:25
    15281897239
    start:32 end:43
    163
    start:44 end:47

     */

        method1();


    }

    private static void method1() {
        // 生成 Pattern 对象并且编译一个简单的正则表达式"cat"
        Pattern p = Pattern.compile("cat");
        // 用 Pattern 类的 matcher() 方法生成一个 Matcher 对象
        Matcher m = p.matcher("fatcatfatcatfat");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            //此时sb为fatdogfatdog，cat被替换为dog,并且将最后匹配到之前的子串都添加到sb对象中
            m.appendReplacement(sb, "dog");
            System.out.println("sb=======" + sb);
        }
        //此时sb为fatdogfatdogfat，将最后匹配到后面的子串添加到sb对象中
        m.appendTail(sb);
        //输出内容为fatdogfatdogfat
        System.out.println("sb:" + sb);
    }

}