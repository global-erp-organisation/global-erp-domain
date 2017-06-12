package com.camlait.global.erp.domain.helper;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

@SuppressWarnings("serial")
public class NamingStrategyHelper extends PhysicalNamingStrategyStandardImpl {

    public static final NamingStrategyHelper INSTANCE = new NamingStrategyHelper();
    private final static char SEPARATOR = '-';
    private final static String QUOTE = "`";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return Identifier.toIdentifier(rename(name.getText()));
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return Identifier.toIdentifier(rename(name.getText()));
    }

    private static String rename(String name) {
        StringBuffer buf = new StringBuffer(name.replace('.', SEPARATOR));
        for (int i = 1; i < buf.length() - 1; i++) {
            if (Character.isLowerCase(buf.charAt(i - 1))
                    && Character.isUpperCase(buf.charAt(i)) 
                    && Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, SEPARATOR);
            }
        }
        buf.insert(0, QUOTE).append(QUOTE);
        return buf.toString().toLowerCase();
    }
}
