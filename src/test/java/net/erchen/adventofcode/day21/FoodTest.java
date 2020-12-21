package net.erchen.adventofcode.day21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoodTest {

    @Test
    void fromString_NoAllergens() {
        var food = Food.fromInput("mxmxvkd kfcds sqjhc nhms");
        assertThat(food.getIngredients()).containsExactly(new Ingredient("mxmxvkd"), new Ingredient("kfcds"), new Ingredient("sqjhc"), new Ingredient("nhms"));
        assertThat(food.getAllergens()).isEmpty();
    }

    @Test
    void fromString_WithAllergen() {
        var food = Food.fromInput("mxmxvkd kfcds sqjhc nhms (contains dairy)");
        assertThat(food.getIngredients()).containsExactly(new Ingredient("mxmxvkd"), new Ingredient("kfcds"), new Ingredient("sqjhc"), new Ingredient("nhms"));
        assertThat(food.getAllergens()).containsExactly(new Allergen("dairy"));
    }

    @Test
    void fromString_WithAllergens() {
        var food = Food.fromInput("mxmxvkd kfcds sqjhc nhms (contains dairy, fish)");
        assertThat(food.getIngredients()).containsExactly(new Ingredient("mxmxvkd"), new Ingredient("kfcds"), new Ingredient("sqjhc"), new Ingredient("nhms"));
        assertThat(food.getAllergens()).containsExactly(new Allergen("dairy"), new Allergen("fish"));
    }
}