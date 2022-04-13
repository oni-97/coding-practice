package Chapter1;

public class IsRotateString {
    public static void main(String[] args) {
        System.out.println(isRotateString("abcde", "deabc"));
        System.out.println(isRotateString("abcde", "deacb"));
    }

    static boolean isRotateString(String s1, String s2) {
        if (s1.length() <= 0 || s2.length() <= 0)
            return false;
        String s = s1 + s1;
        return isSubstring(s, s2);
    }

    static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }
}
