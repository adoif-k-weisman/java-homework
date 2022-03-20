package muc.java_class.second_homework.stringop;

public class StringOperation {
    /**
     * Repeats a string for n times and append to the back of the original one
     *
     * @param str the original string
     * @param n   how many times the string is going to be appended
     * @return a new string
     */
    static String stringAppend(String str, int n) {
        return str.repeat(n + 1);
    }

    static void strBuilderAppend(StringBuilder inStringBuilder, int n) {
        StringBuilder orgString = new StringBuilder(inStringBuilder);
        for (int i = 0; i < n; i++) {
            inStringBuilder.append(orgString);
        }
    }

    /**
     * Represents two or more occurrence of a character with a number of its occurrence.
     *
     * @param stringIn string that is going to be compressed
     * @return compressed string
     */
    static String stringCompress(String stringIn) {
        if (stringIn.isEmpty()) return "";
        StringBuilder compressedString = new StringBuilder();
        int cnt = 1;
        char previousChar = stringIn.charAt(0);
        for (int i = 1; i < stringIn.length(); ++i) {
            if (stringIn.charAt(i) == previousChar) ++cnt;
            else {
                compressedString.append(previousChar);
                if (cnt > 1) compressedString.append(cnt);
                previousChar = stringIn.charAt(i);
                cnt = 1;
            }
        }
        compressedString.append(previousChar);
        if (cnt > 1) compressedString.append(cnt);
        return compressedString.toString();
    }

    /**
     * Caesar cipher: Move each character in the string several positions back in the alphabet.
     *
     * @param stringIn input string
     * @param n        the offset
     * @return a new string after being operated
     */
    static String stringEncryption(String stringIn, int n) {
        StringBuilder encryptedStr = new StringBuilder();
        for (char ch : stringIn.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                encryptedStr.append((char) ((ch - 'A' + n) % 26 + 'A'));
            } else if (ch >= 'a' && ch <= 'z') {
                encryptedStr.append((char) ((ch - 'a' + n) % 26 + 'a'));
            } else encryptedStr.append(ch);
        }
        return encryptedStr.toString();
    }

    /**
     * Check whether two string has a same substring at the length of n;
     *
     * @param a   some string
     * @param b   another string
     * @param len the length of the substring
     * @return true if such a substring exists
     */
    static boolean stringIntersection(String a, String b, int len) {
        if (a.length() < len || b.length() < len) return false;
        String shorterString;
        if (a.length() < b.length()) {
            shorterString = a;
        } else {
            shorterString = b;
        }
        for (int i = 0; i < shorterString.length() - len + 1; i++) {
            if (a.contains(b.substring(i, i + len))) return true;
        }
        return false;
    }
}
