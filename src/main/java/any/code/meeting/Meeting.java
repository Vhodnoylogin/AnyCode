package any.code.meeting;

/*
Найти ближайшее время для встречи

Имеются два сотрудника A и B, которые хотят провести встречу. Каждый сотрудник предоставляет список "свободных окон". Каждое такое окно представляет собой полуинтервал, у которого есть начало (start, включительно) и конец (end, невключительно). Гарантируется, что start < end, т.е. все интервалы непустые. Кроме того гарантируется, что интервалы отсортированы по времени начала, не пересекаются и не "соприкасаются" (не существует такого индекса i в списке интервалов, что interval[i].end == interval[i + 1].start). Нужно найти ближайшее (наиболее раннее) временное окно, в которое оба сотрудника смогут участвовать во встрече, если оно существует.
Формат ввода

Во входном файле input.txt (или в стандартном потоке ввода) первая строка содержит требуемую продолжительность встречи в минутах duration. Следующая строка содержит количество доступных для встреч окон сотрудника A countAcountA. В следующих countAcountA строках содержатся времена начал и концов свободных окон сотрудника A в минутах, соединённые через пробел по одной встрече в каждой строке. Следующая строка содержит количество доступных для встреч окон сотрудника B countBcountB. В следующих countBcountB строках содержатся времена начал и концов свободных окон сотрудника B в минутах, соединённые через пробел по одной встрече в каждой строке.
Формат вывода

В единственную строку выходного файла output.txt (или стандартный поток вывода) запишите время начала и конца найденной возможности для встречи в минутах, соединённое через пробел. Если встреча с заданными условиями невозможна, запишите в ответ строку −1−1−1−1.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Meeting {
    public static Interval qql(List<Interval> l1, List<Interval> l2, Integer duration) {
        if (l1.isEmpty() || l2.isEmpty())
            return new Interval(-1, -1);

        var ptr1 = 0;
        var ptr2 = 0;

        while (ptr1 < l1.size() && ptr2 < l2.size()) {
            var interval1 = l1.get(ptr1);
            var interval2 = l2.get(ptr2);

            var res = interval1.intersection(interval2);
            if (res.dur() >= duration) {
                return res;
            }

            if (interval1.end < interval2.end) {
                ptr1++;
            } else {
                ptr2++;
            }
        }

        return new Interval(-1, -1);
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        int duration = Integer.parseInt(in.nextLine());

        int lenA = in.nextInt();
        List<Interval> intervalsA = new ArrayList<>();
        for (int i = 0; i < lenA; i++) {
            var s = in.nextLine().split(" ");
            var begin = Integer.parseInt(s[0]);
            var end = Integer.parseInt(s[1]);
            intervalsA.add(new Interval(begin, end));
        }

        int lenB = in.nextInt();
        List<Interval> intervalsB = new ArrayList<>();
        for (int i = 0; i < lenB; i++) {
            var s = in.nextLine().split(" ");
            var begin = Integer.parseInt(s[0]);
            var end = Integer.parseInt(s[1]);
            intervalsB.add(new Interval(begin, end));
        }

        var res = qql(intervalsA, intervalsB, duration);
        System.out.print(res.begin + " " + res.end);
    }

    public static class Interval {
        public final Integer begin;
        public final Integer end;

        public Interval(int begin, int end) {
            if (end <= begin && begin > 0 && end > 0) throw new RuntimeException();
            this.begin = begin;
            this.end = end;
        }

        public Integer dur() {
            return end - begin;
        }

        public Interval intersection(Interval d) {
            if (this.begin > d.end || this.end < d.begin)
                return new Interval(-1, -1);

            var begin = Math.max(this.begin, d.begin);
            var end = Math.min(this.end, d.end);
            return new Interval(begin, end);
        }

        public boolean isIntersection(Interval d) {
            return !(this.begin > d.end || this.end < d.begin);
        }

        public boolean isEarlier(Interval d) {
            return (this.end < d.begin);
        }
    }
}
