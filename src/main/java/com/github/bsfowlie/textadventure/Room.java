package com.github.bsfowlie.textadventure;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Room {

    private final String description;

    public Room(final String description) {

        this.description = Objects.requireNonNull(description, "Must provide a room description");

    }

    String description() {

        return description;

    }

    Collection<String> itemNames() {

        return Collections.emptyList();

    }

}
