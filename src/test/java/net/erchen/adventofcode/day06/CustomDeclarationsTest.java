package net.erchen.adventofcode.day06;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static net.erchen.adventofcode.day06.CustomDeclarations.parseCustomDeclarationForms;
import static org.assertj.core.api.Assertions.assertThat;

class CustomDeclarationsTest {

    static String solutionInput() throws IOException {
        return Files.readString(Path.of("src/test/resources/day06/input.txt"));
    }

    static String demoInput() throws IOException {
        return Files.readString(Path.of("src/test/resources/day06/demo.txt"));
    }

    @Test
    void part1Demo() throws IOException {
        assertThat(parseCustomDeclarationForms(demoInput()).countAllAnswers()).isEqualTo(11);
    }

    @Test
    void part1Solution() throws IOException {
        assertThat(parseCustomDeclarationForms(solutionInput()).countAllAnswers()).isEqualTo(6530);
    }

    @Test
    void part2Demo() throws IOException {
        assertThat(parseCustomDeclarationForms(demoInput()).countCommonAnswers()).isEqualTo(6);
    }

    @Test
    void solutionPart2() throws IOException {
        assertThat(parseCustomDeclarationForms(solutionInput()).countCommonAnswers()).isEqualTo(3323);
    }
}