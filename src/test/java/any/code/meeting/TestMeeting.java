package any.code.meeting;

import any.code.meeting.Meeting.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMeeting {
    @Test
    public void testMeetingTimeExample1() {
        int duration = 1;

        ArrayList<Interval> l1 = new ArrayList<>();
        l1.add(new Interval(2, 3));

        ArrayList<Interval> l2 = new ArrayList<>();
        l2.add(new Interval(1, 4));

        int[] expected = {2, 3};

        var res1 = Meeting.qql(l1, l2, duration);
        var res = new int[2];
        res[0] = res1.begin;
        res[1] = res1.end;

        assertThat(res).isEqualTo(expected);
    }

    @Test
    public void testMeetingTimeExample2() {
        int duration = 1;

        ArrayList<Interval> l1 = new ArrayList<>();
        l1.add(new Interval(2, 3));

        ArrayList<Interval> l2 = new ArrayList<>();
        l2.add(new Interval(3, 4));

        int[] expected = {-1, -1};

        var res1 = Meeting.qql(l1, l2, duration);
        var res = new int[2];
        res[0] = res1.begin;
        res[1] = res1.end;

        assertThat(res).isEqualTo(expected);
    }

    @Test
    public void testMeetingTimeExample3() {
        int duration = 6;

        ArrayList<Interval> l1 = new ArrayList<>();
        l1.add(new Interval(1, 10));

        ArrayList<Interval> l2 = new ArrayList<>();
        l2.add(new Interval(4, 12));

        int[] expected = {4, 10};

        var res1 = Meeting.qql(l1, l2, duration);
        var res = new int[2];
        res[0] = res1.begin;
        res[1] = res1.end;

        assertThat(res).isEqualTo(expected);
    }

    @Test
    public void testMeetingTimeExample4() {
        int duration = 5;

        ArrayList<Interval> l1 = new ArrayList<>();
        l1.add(new Interval(0, 0));

        ArrayList<Interval> l2 = new ArrayList<>();
        l2.add(new Interval(0, 0));

        int[] expected = {-1, -1};

        var res1 = Meeting.qql(l1, l2, duration);
        var res = new int[2];
        res[0] = res1.begin;
        res[1] = res1.end;

        assertThat(res).isEqualTo(expected);
    }

}
