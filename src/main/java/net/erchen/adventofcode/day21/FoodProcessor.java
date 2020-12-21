package net.erchen.adventofcode.day21;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FoodProcessor {

    private final List<Food> foods;

    public static FoodProcessor fromInput(List<String> input) {
        return new FoodProcessor(input.stream().map(Food::fromInput).collect(toList()));
    }

    public long countIngredientWithNoAllergens() {
        var ingredientAllergenMap = ingredientsAllergenMapping();

        return foods.stream()
                .flatMap(food -> food.getIngredients().stream())
                .filter(ingredient -> !ingredientAllergenMap.containsKey(ingredient))
                .count();

    }

    public String canonicalDangerousIngredientList() {
        return ingredientsAllergenMapping().entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .map(Ingredient::ingredient)
                .collect(joining(","));
    }

    Set<Allergen> allAllergens() {
        return foods.stream().flatMap(food -> food.getAllergens().stream()).collect(toSet());
    }

    Map<Ingredient, Allergen> ingredientsAllergenMapping() {
        Set<Allergen> allergens = new HashSet<>(allAllergens());
        Map<Ingredient, Allergen> processedAllergens = new HashMap<>();

        while (!processedAllergens.values().containsAll(allergens)) {
            allergens.stream()
                    .filter(allergen -> !processedAllergens.containsValue(allergen))
                    .forEach(unprocessedAllergen -> {
                        var foodContainingAllergen = foods.stream().filter(food -> food.getAllergens().contains(unprocessedAllergen)).collect(toList());

                        var ingredientsInCommon = foodContainingAllergen.stream()
                                .flatMap(food -> food.getIngredients().stream())
                                .filter(ingredient -> !processedAllergens.containsKey(ingredient))
                                .collect(groupingBy(Function.identity(), counting()))
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() == foodContainingAllergen.size())
                                .map(Map.Entry::getKey)
                                .collect(toList());

                        if (ingredientsInCommon.size() == 1) {
                            processedAllergens.put(ingredientsInCommon.get(0), unprocessedAllergen);
                        }
                    });
        }
        return processedAllergens;
    }
}
