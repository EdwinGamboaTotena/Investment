package com.credence.investment.domain.common.formater;

public class StringFormater {

    public static String trimp(String s) {
        if (s != null) {
            return s.trim();
        }

        return s;
    }
}
