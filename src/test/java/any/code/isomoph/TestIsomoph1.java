package any.code.isomoph;

import any.code.isomorph.Isomoph3;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestIsomoph1 {

    @Test
    public void test_1() {
        var s1 = "tea";
        var s2 = "sea";

        var res = Isomoph3.comp(s1, s2);

        assertThat(res)
                .isTrue();
    }

    @Test
    public void test_2() {
        var s1 = "egg";
        var s2 = "add";

        var res = Isomoph3.comp(s1, s2);

        assertThat(res)
                .isTrue();
    }

    @Test
    public void test_3() {
        var s1 = "foo";
        var s2 = "bar";

        var res = Isomoph3.comp(s1, s2);

        assertThat(res)
                .isFalse();
    }

    @Test
    public void test_4() {
        var s1 = "paper";
        var s2 = "title";

        var res = Isomoph3.comp(s1, s2);

        assertThat(res)
                .isTrue();
    }

    @Test
    public void test_5() {
        var s1 = "a";
        var s2 = "a";

        var res = Isomoph3.comp(s1, s2);

        assertThat(res)
                .isTrue();
    }

    @Test
    public void test_6() {
        var s1 = "a";
        var s2 = "aa";

        var res = Isomoph3.comp(s1, s2);

        assertThat(res)
                .isFalse();
    }
}
