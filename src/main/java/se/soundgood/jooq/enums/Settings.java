/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;

import se.soundgood.jooq.DefaultSchema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum Settings implements EnumType {

    SETTINGS("SETTINGS");

    private final String literal;

    private Settings(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public String getName() {
        return "settings";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal. Returns
     * <code>null</code>, if no such value could be found, see {@link
     * EnumType#lookupLiteral(Class, String)}.
     */
    public static Settings lookupLiteral(String literal) {
        return EnumType.lookupLiteral(Settings.class, literal);
    }
}