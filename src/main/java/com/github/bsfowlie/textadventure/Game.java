package com.github.bsfowlie.textadventure;

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

}
