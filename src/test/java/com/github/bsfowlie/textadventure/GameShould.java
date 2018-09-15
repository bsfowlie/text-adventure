package com.github.bsfowlie.textadventure;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import info.solidsoft.mockito.java8.api.WithMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class GameShould implements WithAssertions, WithMockito {

    @InjectMocks
    private Game game;

    @Mock
    private Room room;

    @Mock
    private EndCondition ending;

    @Test
    void exist() {

        assertThat(game).isNotNull();

    }

    @Test
    void knowWhenItIsNotRunning() {

        when(ending.isEndReached()).thenReturn(true);

        assertThat(game.isRunning()).isFalse();

    }

    @Test
    void knowWhenItIsRunning() {

        when(ending.isEndReached()).thenReturn(false);

        assertThat(game.isRunning()).isTrue();

    }

    @Test
    void showItsCurrentLocationWithoutItems(@Mock PrintStream out) {

        when(room.description()).thenReturn("current room");
        when(room.itemNames()).thenReturn(Collections.emptyList());

        game.showCurrentLocation(out);

        verify(out).println("current room");
        verifyNoMoreInteractions(out);

    }

    @Test
    void showItsCurrentLocationWithOneItem(@Mock PrintStream out) {

        when(room.description()).thenReturn("current room");
        when(room.itemNames()).thenReturn(Collections.singletonList("item"));

        game.showCurrentLocation(out);

        verify(out).println("current room");
        verify(out).println("You see: item");
        verifyNoMoreInteractions(out);

    }

    @Test
    void showItsCurrentLocationWithMultipleItems(@Mock PrintStream out) {

        when(room.description()).thenReturn("current room");
        when(room.itemNames()).thenReturn(Arrays.asList("item", "object"));

        game.showCurrentLocation(out);

        verify(out).println("current room");
        verify(out).println("You see: item, object");
        verifyNoMoreInteractions(out);

    }

}
