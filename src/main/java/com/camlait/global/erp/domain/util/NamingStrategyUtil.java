package com.camlait.global.erp.domain.util;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

@SuppressWarnings("serial")
public class NamingStrategyUtil extends PhysicalNamingStrategyStandardImpl {

    public static final NamingStrategyUtil INSTANCE = new NamingStrategyUtil();
    private final static char SEPARATOR = '-';

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return Identifier.toIdentifier(addSeparators(name.getText()));
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return Identifier.toIdentifier(addSeparators(name.getText()));
    }
    
    private static String addSeparators(String name) {
        StringBuffer buf = new StringBuffer(name.replace('.', SEPARATOR));
        for (int i = 1; i < buf.length() - 1; i++) {
            if (Character.isLowerCase(buf.charAt(i - 1)) 
                    && Character.isUpperCase(buf.charAt(i)) 
                    && Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, SEPARATOR);
            }
        }
        final String result = buf.toString().toLowerCase();
        return "`" + result + "`";
    }
}
