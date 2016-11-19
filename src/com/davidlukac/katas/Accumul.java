package com.davidlukac.katas;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="http://www.codewars.com/kata/mumbling/train/java"/>
 *
 * Everything is static because of comaptibility with Codewars editor.
 */
public class Accumul {

    /**
     * Entry point function.
     *
     * @param s Input string.
     *
     * @return Result
     */
    public static String accum(String s) {
        List<Character> letters = new ArrayList<>(s.length());
        for (char c : s.toCharArray()) letters.add(c);

        return mumble(letters, 1, "");
    }

    /**
     * Takes List of characters, how many times should be a character repeated and resulting string.
     *
     * Recursive function. Repeats 'head' as long there is one, attaches result to the 'result' string and calls itself
     * on the 'tail'.
     *
     * @param chars (Remaining) Characters to process.
     * @param n Number of repetitions for "current" character.
     * @param result Compiled resulting string.
     * @return Resulting string.
     */
    private static String mumble(List<Character> chars, Integer n, String result) {
        if (chars.isEmpty()) return result;

        Character head = chars.get(0);

        List<Character> tail;
        String delimiter;
        if (chars.size() > 1) {
            tail = chars.subList(1, chars.size());
            delimiter = "-";
        } else {
            tail = new ArrayList<>(0);
            delimiter = "";
        }

        String baseString = result.concat(repeat(head, n) + delimiter);

        return mumble(tail, n + 1, baseString);
    }

    /**
     * Repeats given character 'n' times, first is capitalized, rest is in low caps.
     * @param c Character to repeat.
     * @param n Number of repetitions.
     * @return Resulting string.
     */
    @NotNull
    private static String repeat(Character c, Integer n) {
        return c.toString().toUpperCase().concat(new String(new char[n-1]).replace("\0", c.toString().toLowerCase()));
    }

    public static void main(String[] args) {
        String res = accum("AvCdeDFf");
        System.out.print(String.format("The result is: '%s'.", res));
    }

}
