package net.erchen.adventofcode.day21;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FoodProcessorTest {

    static List<String> demoInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day21/demo.txt"));
    }

    static List<String> solutionInput() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/day21/input.txt"));
    }

    @Test
    void fromInput() throws IOException {
        var foodProcessor = FoodProcessor.fromInput(demoInput());

        assertThat(foodProcessor.getFoods()).hasSize(4);
    }

    @Test
    void ingredientsAllergenMapping() throws IOException {
        var foodProcessor = FoodProcessor.fromInput(demoInput());

        assertThat(foodProcessor.ingredientsAllergenMapping())
                .containsEntry(new Ingredient("mxmxvkd"), new Allergen("dairy"))
                .containsEntry(new Ingredient("sqjhc"), new Allergen("fish"))
                .containsEntry(new Ingredient("fvjkl"), new Allergen("soy"));
    }

    @Test
    void part1_Demo() throws IOException {
        var foodProcessor = FoodProcessor.fromInput(demoInput());

        assertThat(foodProcessor.countIngredientWithNoAllergens()).isEqualTo(5);
    }

    @Test
    void part1_Solution() throws IOException {
        var foodProcessor = FoodProcessor.fromInput(solutionInput());

        assertThat(foodProcessor.countIngredientWithNoAllergens()).isEqualTo(2374);
    }

    @Test
    void part2_Demo() throws IOException {
        var foodProcessor = FoodProcessor.fromInput(demoInput());

        assertThat(foodProcessor.canonicalDangerousIngredientList()).isEqualTo("mxmxvkd,sqjhc,fvjkl");
    }

    @Test
    void part2_Solution() throws IOException {
        var foodProcessor = FoodProcessor.fromInput(solutionInput());

        assertThat(foodProcessor.canonicalDangerousIngredientList()).isEqualTo("fbtqkzc,jbbsjh,cpttmnv,ccrbr,tdmqcl,vnjxjg,nlph,mzqjxq");
    }
}