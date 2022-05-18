package muc.java_class.third_homework.formatter;

public class ROT13Formatter implements Formatter {

    //返回输入的ROT132加密值
    @Override
    public String format(String a) {
        if (a == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == ' ') {
                sb.append(' ');
                continue;//空格就不加密了
            }
            char s = (char) (((a.charAt(i) - 'a') + 13) % 26 + 'a');
            sb.append(s);
        }

        return sb.toString();
    }
}
