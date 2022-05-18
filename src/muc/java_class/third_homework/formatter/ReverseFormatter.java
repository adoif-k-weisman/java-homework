package muc.java_class.third_homework.formatter;

public class ReverseFormatter implements Formatter {

    //将输入的字符串反转，例如：“I Love Java”改为“avaJ evoL I”
    @Override
    public String format(String a) {
        if (a == null) {
            return null;
        }
        /*
        StringBuffer sb = new StringBuffer("");
        for (int i = a.length(); i > 0; i--) {
            sb.append(a.charAt(i));
        }
        return sb.toString();
        */

        StringBuffer sb2 = new StringBuffer(a);
        sb2.reverse();
        return sb2.toString();
    }
}
