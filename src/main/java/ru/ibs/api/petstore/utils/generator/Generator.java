package ru.ibs.api.petstore.utils.generator;

import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Generator {

    public static String getRandomString(int size) {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        return new Random().ints(size, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Objects::toString)
                .collect(Collectors.joining());
    }

    public static String getRandomStatus() {
        String[] statuses = {"available", "pending", "sold"};
        return statuses[(int) (Math.random() * 3)];
    }
}
