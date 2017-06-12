package com.camlait.global.erp.domain.helper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;

import com.ibm.icu.text.RuleBasedNumberFormat;

public final class NumberHelper {

    private NumberHelper() {
        // no-op.
    }

    public static String convertToLetter(BigDecimal toConvert, Locale locale) {
        final RuleBasedNumberFormat r = new RuleBasedNumberFormat(locale, RuleBasedNumberFormat.SPELLOUT);
        return r.format(toConvert);
    }

    public static String convertToLetter(BigInteger toConvert, Locale locale) {
        final RuleBasedNumberFormat r = new RuleBasedNumberFormat(locale, RuleBasedNumberFormat.SPELLOUT);
        return r.format(toConvert);
    }
}
