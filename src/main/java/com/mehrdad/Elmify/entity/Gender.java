package com.mehrdad.Elmify.entity;


import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Gender {
    MALE("M"), Female("F");

    private final String symbol;

    Gender(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, Gender> stringToEnum = Stream.of(values())
            .collect(toMap(Object::toString, e -> e));

    public static Optional<Gender> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}
