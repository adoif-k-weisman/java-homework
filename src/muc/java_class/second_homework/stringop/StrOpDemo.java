package muc.java_class.second_homework.stringop;

public class StrOpDemo {
    public static void main(String[] args) {
        String abc = "abc";
        System.out.println(StringOperation.stringAppend(abc, 2));

        StringBuilder abb = new StringBuilder("abb");
        StringOperation.strBuilderAppend(abb, 3);
        System.out.println(abb);

        String someRedundantStr = "Ooooooops!";
        String someNormalStr = "Bye World.";
        System.out.println(StringOperation.stringCompress(someRedundantStr));
        System.out.println(StringOperation.stringCompress(someNormalStr));

        String stringA = "Annie has a pineapple.";
        String stringB = "Susan developed an app.";
        // Test for substring 'app', so len = 3.
        System.out.println(StringOperation.stringIntersection(stringA, stringB, 3));

        String message = "Meet at Teaching Building #1 tonight at 9 pm!";
        System.out.println(StringOperation.stringEncryption(message, 2));
    }
}
