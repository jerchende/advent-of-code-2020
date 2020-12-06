package net.erchen.adventofcode.day06;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static net.erchen.adventofcode.day06.CustomDeclarationForm.parseCustomDeclarationForm;
import static net.erchen.adventofcode.day06.CustomDeclarationForm.parseCustomDeclarationForms;
import static org.assertj.core.api.Assertions.assertThat;

class CustomDeclarationFormTest {

    @Test
    void singleEntry() {
        assertThat(parseCustomDeclarationForm("abcdefg").getAnswers()).containsExactly('a', 'b', 'c', 'd', 'e', 'f', 'g');
        assertThat(parseCustomDeclarationForm("aaa").getAnswers()).containsExactly('a');
        assertThat(parseCustomDeclarationForm("aabb").getAnswers()).containsExactly('a', 'b');
    }

    @Test
    void allEntries() {
        assertThat(parseCustomDeclarationForms("""
                abc
                                
                a
                b
                c
                                
                ab
                ac
                                
                a
                a
                a
                a
                                
                b
                """))
                .extracting("answers")
                .containsExactlyInAnyOrder(
                        Set.of('a', 'b', 'c'),
                        Set.of('a', 'b', 'c'),
                        Set.of('a', 'b', 'c'),
                        Set.of('a'),
                        Set.of('b')
                );
    }
}