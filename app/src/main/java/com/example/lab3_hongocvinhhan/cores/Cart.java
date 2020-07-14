package com.example.lab3_hongocvinhhan.cores;

import com.example.lab3_hongocvinhhan.databases.FoodService;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private static List<Food> foods = new LinkedList<>();

    public static List<Food> getFoods() {
        return foods;
    }

    public static void addFood(Food food) {
        Food existingFood = foods.stream().filter(x -> x.getId() == food.getId()).findFirst().orElse(null);

        if (existingFood != null) {
            existingFood.plus(food.getQuantity());
        } else {
            foods.add(new Food(food.getId(), food.getName(), food.getPrice(), food.getImage(), food.getQuantity()));
        }
    }

    public static void removeFood(Food food) {
        foods.remove(food);
    }

    public static String getCartInfo() {
        String foodList = foods.stream().map(food -> String.format("%s x %d", food.getName(), food.getQuantity())).collect(Collectors.joining(", "));
        int totalPrice = foods.stream().reduce(0, (acc, food) -> acc + food.getQuantity() * food.getPrice(), Integer::sum);

        return String.format("%s.\nTotal price: %s", foodList, FoodService.formatPrice(totalPrice));
    }

    public static void clear() {
        foods.clear();
    }
}
