package net.erchen.adventofcode.day21;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Food {

    private final List<Ingredient> ingredients;
    private final List<Allergen> allergens;

    public static Food fromInput(String input) {
        var split = input.split("\\(");

        var ingredients = Arrays.stream(split[0].split(" ")).map(Ingredient::new).collect(toList());
        var allergens = split.length > 1 ? Arrays.stream(split[1].replaceAll("contains|\\)| ", "").split(",")).map(Allergen::new).collect(toList()) : List.<Allergen>of();

        return new Food(ingredients, allergens);
    }

}
