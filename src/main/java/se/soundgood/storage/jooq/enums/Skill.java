/*
 * This file is generated by jOOQ.
 */
package se.soundgood.storage.jooq.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;

import se.soundgood.storage.jooq.DefaultSchema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum Skill implements EnumType {

    Beginner("Beginner"),

    Intermediate("Intermediate"),

    Advanced("Advanced");

    private final String literal;

    private Skill(String literal) {
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
        return "skill";
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
    public static Skill lookupLiteral(String literal) {
        return EnumType.lookupLiteral(Skill.class, literal);
    }
}
