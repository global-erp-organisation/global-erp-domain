package com.camlait.global.erp.domain.keys;

import java.io.Serializable;

import com.camlait.global.erp.domain.translation.Language;
import com.camlait.global.erp.domain.translation.Term;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class TermLanguageKey implements Serializable{
    private Term term;
    private Language language;
}
