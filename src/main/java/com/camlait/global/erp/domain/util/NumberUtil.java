package com.camlait.global.erp.domain.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;

import com.ibm.icu.text.RuleBasedNumberFormat;

public final class NumberUtil {

    private NumberUtil() {
        // no-op.
    }

    public static String convertToLetter(BigDecimal number, Locale locale) {
        final RuleBasedNumberFormat r = new RuleBasedNumberFormat(locale, RuleBasedNumberFormat.SPELLOUT);
        return r.format(number);
    }

    public static String convertToLetter(BigInteger number, Locale locale) {
        final RuleBasedNumberFormat r = new RuleBasedNumberFormat(locale, RuleBasedNumberFormat.SPELLOUT);
        return r.format(number);
    }
}