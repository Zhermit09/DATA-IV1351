package se.soundgood;

import org.jooq.codegen.GenerationTool;

public class JooqGenerator {
    public static void main(String... args) {
        try {
            var config = GenerationTool.load(JooqGenerator.class.getResourceAsStream("/jooq-conf.xml"));
            GenerationTool.generate(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
