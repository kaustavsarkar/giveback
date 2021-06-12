package org.giveback.problems;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public final class WildCardMatchingTest {

    @Test
    public void match_dp_test1() {
        var wcm = new WildCardMatching();
        var isMatch = wcm.isMatchDp("aa", "a");
        assertFalse(isMatch);
    }

    @Test
    public void matchopt_test1() {
        var wcm = new WildCardMatching();
        var isMatch = wcm.isMatchOpt("aa", "a");
        assertFalse(isMatch);
    }

    @Test
    public void match_dp_test2() {
        var wcm = new WildCardMatching();
        var isMatch = wcm.isMatchDp("aa", "*");
        assertTrue(isMatch);
    }

    @Test
    public void match_opt_test2() {
        var wcm = new WildCardMatching();
        var isMatch = wcm.isMatchOpt("aa", "*");
        assertTrue(isMatch);
    }

    @Test
    public void match_dp_test3() {
        var wcm = new WildCardMatching();
        var isMatch = wcm.isMatchDp("cb", "?a");
        assertFalse(isMatch);
    }

    @Test
    public void match_opt_test3() {
        var wcm = new WildCardMatching();
        var isMatch = wcm.isMatchOpt("cb", "?a");
        assertFalse(isMatch);
    }

    @Test
    public void match_dp_test4() {
        var wcm = new WildCardMatching();
        var isMatch = wcm.isMatchDp("adceb", "*a*b");
        assertTrue(isMatch);
    }

    @Test
    public void match_opt_test4() {
        var wcm = new WildCardMatching();
        var isMatch = wcm.isMatchOpt("adceb", "*a*b");
        assertTrue(isMatch);
    }

    @Test
    public void match_dp_test5() {
        var wcm = new WildCardMatching();
        var isMatch = wcm.isMatchDp("acdcb", "a*c?b");
        assertFalse(isMatch);
    }

    @Test
    public void match_opt_test5() {
        var wcm = new WildCardMatching();
        var isMatch = wcm.isMatchOpt("acdcb", "a*c?b");
        assertFalse(isMatch);
    }

}
