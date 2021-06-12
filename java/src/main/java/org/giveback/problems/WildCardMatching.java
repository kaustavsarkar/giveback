package org.giveback.problems;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 * <p>
 * <li> '?' Matches any single character. '
 * <li> '*' Matches any sequence of characters
 * (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 */
public final class WildCardMatching {

    public boolean isMatchOpt(String s, String p) {

        if(s == null || s.isEmpty() && (p == null || p.isEmpty())) {
            return true;
        }

        if(p == null || p.isEmpty()) {
            return false;
        }

        if(p.equals("*")) {
            return true;
        }

        int sIndex = 0, pIndex = 0, patLength = p.length(), sLength = s.length();
        int wildStringIndex = -1, wildPatIndex = -1;

        while(sIndex < sLength) {

            // If the pattern matches the string we can move forward with
            // string and pattern..
            if(pIndex < patLength &&
                    (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;

                // If the pattern is a '*' we make a note of index at which
                // the string and pattern is. Then we move the pattern
                // counter ahead. The counter is moved ahead so that if the
                // next element matches it can continue.
            } else if(pIndex < patLength && p.charAt(pIndex) == '*') {
                wildStringIndex = sIndex;
                wildPatIndex = pIndex++;

                // If the prev element was wildcard,  we can move forward
                // with the string counter. We keep moving until we find a
                // string matching with the pattern and satisfy the first iff.
            } else if(wildPatIndex  != -1) {
                pIndex = wildPatIndex + 1;
                sIndex = wildStringIndex++;

            } else {
                return false;
            }
        }

        while(pIndex < patLength && p.charAt(pIndex) == '*') {
            pIndex++;
        }

        return pIndex == patLength;
    }

    /**
     * The following approach uses Dynamic Programming for detemining whether
     * the {@code pattern} matches with the {@code string}. However, rather than
     * using an m X n matrix we are choosing to use two separate arrays to save
     * on space.
     * <p>
     * The approach works because at point, we only check values in the previous
     * row or column.
     */
    public boolean isMatchDp(String string, String pattern) {
        if((string == null || string.isEmpty())&&(pattern == null || pattern.isEmpty())) {
            return true;
        }
        if(string == null || string.isEmpty()) {
            return false;
        }
        if(pattern.equals("*")) {
            return true;
        }

        boolean[] prevResult = new boolean[pattern.length()+1];
        boolean[] currResult = new boolean[pattern.length()+1];

        prevResult[0] = true;

        //Populate prev result
        for(int index = 0; index < pattern.length(); index++) {
            if(pattern.charAt(index) == '*'){
                prevResult[index+1] = prevResult[index];
            }

        }
        for(int stringIndex = 0; stringIndex < string.length(); stringIndex++) {

            for(int patIndex = 0; patIndex < pattern.length(); patIndex++) {

                if(pattern.charAt(patIndex) == string.charAt(stringIndex)) {
                    currResult[patIndex + 1] = prevResult[patIndex];
                } else if(pattern.charAt(patIndex) == '?') {
                    currResult[patIndex + 1] = prevResult[patIndex];
                } else if(pattern.charAt(patIndex) == '*'){
                    currResult[patIndex + 1] = prevResult[patIndex+1] || currResult[patIndex];
                } else {
                    currResult[patIndex + 1] = false;
                }

            }
            prevResult = currResult.clone();
        }
        return currResult[pattern.length()];
    }
}
