package com.aptech.util;

/**
 * Session 7: Code Example 4 (part 1 of 2)
 * A class in the package com.aptech.util. Its folder path MUST match the package name:
 *   com/aptech/util/TextTools.java
 */
public class TextTools {

    private TextTools() { }

    public static String repeat(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) sb.append(s);
        return sb.toString();
    }

    public static String center(String s, int width) {
        if (s.length() >= width) return s;
        int pad = (width - s.length()) / 2;
        return repeat(" ", pad) + s + repeat(" ", width - s.length() - pad);
    }
}
