package com.github.bsfowlie.textadventure;

import java.io.PrintStream;
import java.util.Collection;
import java.util.stream.Collectors;

public class Game {

    private final Room currentRoom;

    private final EndCondition ending;

    public Game(final Room startingRoom, final EndCondition endCondition) {

        currentRoom = startingRoom;
        ending = endCondition;

    }

    public boolean isRunning() {

        return !ending.isEndReached();

    }

    void showCurrentLocation(final PrintStream out) {

        out.println(currentRoom.description());
        Collection<String> itemNames = currentRoom.itemNames();
        if (!itemNames.isEmpty()) {
            out.println(itemNames.stream().collect(Collectors.joining(", ", "You see: ", "")));
        }
    }

}
