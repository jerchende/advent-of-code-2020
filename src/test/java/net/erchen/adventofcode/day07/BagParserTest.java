package net.erchen.adventofcode.day07;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.Collections.emptyMap;
import static org.assertj.core.api.Assertions.assertThat;

class BagParserTest {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day07/demo.txt"));
    }

    @Test
    void shouldParseAllBags() throws IOException {
        List<Bag> bags = BagParser.parseBags(demoInput());

        assertThat(bags).extracting("color").containsExactlyInAnyOrder("light red", "dark orange", "bright white", "muted yellow", "shiny gold", "dark olive", "vibrant plum", "faded blue", "dotted black");

        assertThat(bags)
                .contains(new Bag("faded blue", emptyMap()))
                .contains(new Bag("dotted black", emptyMap()));
    }
}