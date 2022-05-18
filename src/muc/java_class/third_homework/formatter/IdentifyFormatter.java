package muc.java_class.third_homework.formatter;

public class IdentifyFormatter implements Formatter {

    //验证输入的是否是字母，正确返回输入
    @Override
    public String format(String a) {

        if (a == null) {
            return null;
        }
        for (int i = 0; i < a.length(); i++) {
            if (!(Character.isLetter(a.charAt(i)) || a.charAt(i) == ' ')) {
                return null;
            }
        }
        return a;
    }
}
