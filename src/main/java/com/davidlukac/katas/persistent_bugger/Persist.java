package com.davidlukac.katas.persistent_bugger;

import java.util.ArrayList;
import java.util.List;

/**
 * Persistent Bugger kata from Codewars
 *
 * @see <a href="https://www.codewars.com/kata/persistent-bugger">Persistent Bugger</a>
 */
class Persist {
    public static int persistence(long n) {
        Persist p = new Persist();
        return p.findPersistence(n, 0);
    }

    private int findPersistence(long number, int count) {
        List<Integer> digits = this.toDigits(number);

        if (digits.size() <= 1) return count;

        return findPersistence(multiply(digits), count + 1);
    }

    /**
     * Convert 'long' number to list of digits.
     * @param n Number to convert.
     * @return List of digits.
     */
    private List<Integer> toDigits(long n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(((int) (n % 10)));
            n = n / 10;
        }
        return digits;
    }

    private long multiply(List<Integer> digits) {
        return digits.stream().map(x->x).reduce(1, Math::multiplyExact);
    }

}
