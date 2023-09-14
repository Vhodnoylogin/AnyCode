package any.code.isomorph;

import java.util.*;

/*
Изоморфизм строк

Даны две строки s и t. Определите изоморфны ли они.

Две строки s и t называются изоморфными, если можно сделать замену символов в строке s, чтобы получить строку t, при этом: 1. Все вхождения заменяемого символа должны быть заменены заменяющим символом 2. Никакие два разных символа не могут быть заменены на один и тот же символ 3. Символ может быть заменен сам на себя
Формат ввода

Во входном файле input.txt (или в стандартном потоке ввода) первая строка содержит первую строку ss, вторая строка - вторую строку tt.
Формат вывода

В единственную строку выходного файла output.txt (или стандартный поток вывода) запишите true, если строки являются изоморфными, или false, если не являются.

 */


public class Isomoph {
    Map<Character, List<Integer>> skeleton;

    public Isomoph(String str) {
        this.skeleton = this.prep(str);
    }

    public static boolean comp(Isomoph s1, Isomoph s2) {
        return s1.comp(s2);
    }

    public static boolean comp(String s1, String s2) {
        var i1 = new Isomoph(s1);
        var i2 = new Isomoph(s2);
        return Isomoph.comp(i1, i2);
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        var s1 = in.nextLine();
        var s2 = in.nextLine();

        var res = Isomoph.comp(s1, s2);

        System.out.print(res);
    }

    private Map<Character, List<Integer>> prep(String str) {
        Map<Character, List<Integer>> res = new HashMap<>();
        var len = str.length();
        for (int i = 0; i < len; i++) {
            Character ch = str.charAt(i);
            var obj = res.getOrDefault(ch, new ArrayList<>());
            obj.add(i);
            res.put(ch, obj);
        }
        return res;
    }

    Set<List<Integer>> superRes() {
        Set<List<Integer>> res = new HashSet<>();
        this.skeleton.forEach((x, y) -> res.add(y));
        return res;
    }

    public boolean comp(Isomoph s2) {
        var set1 = this.superRes();
        var set2 = s2.superRes();

        return Objects.equals(set1, set2);
    }
}
