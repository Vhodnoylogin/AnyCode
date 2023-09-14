package any.code.isomorph;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Isomoph3 {
    public static boolean comp(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        Map<Character, Character> s1ToS2 = new HashMap<>();
        Map<Character, Character> s2ToS1 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            var ch1 = s1.charAt(i);
            var ch2 = s2.charAt(i);

            if (s1ToS2.getOrDefault(ch1, ch2) != ch2)
                return false;
            if (s2ToS1.getOrDefault(ch2, ch1) != ch1)
                return false;

            s1ToS2.put(ch1, ch2);
            s2ToS1.put(ch2, ch1);
        }

        return true;
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        var s1 = in.nextLine();
        var s2 = in.nextLine();

        var res = comp(s1, s2);

        System.out.print(res);
    }
}
