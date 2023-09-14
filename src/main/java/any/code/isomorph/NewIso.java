package any.code.isomorph;

import java.util.*;

public class NewIso {
    public static Set<Set<Integer>> prep(String str) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            var obj = map.getOrDefault(ch, new HashSet<>());
            obj.add(i);
            map.put(ch, obj);
        }
        return new HashSet<>(map.values());
    }


    public static boolean comp(String s1, String s2) {
        var i1 = prep(s1);
        var i2 = prep(s2);

        return Objects.equals(i1, i2);
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        var s1 = in.nextLine();
        var s2 = in.nextLine();

        var res = comp(s1, s2);

        System.out.print(res);
    }
}
