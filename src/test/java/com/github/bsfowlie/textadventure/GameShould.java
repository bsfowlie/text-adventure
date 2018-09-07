package com.github.bsfowlie.textadventure;

import info.solidsoft.mockito.java8.api.WithMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameShould implements WithAssertions, WithMockito {

    @Mock
    private Room starting;

    @Mock
    private EndCondition ending;

    @Test
    void exist() {

        assertThat(new Game(starting, ending)).isNotNull();

    }

    @Test
    void knowWhenItIsNotRunning() {

        when(ending.isEndReached()).thenReturn(true);

        assertThat(new Game(starting, ending).isRunning()).isFalse();

    }

    @Test
    void knowWhenItIsRunning() {

        when(ending.isEndReached()).thenReturn(false);

        assertThat((new Game(starting, ending).isRunning())).isTrue();

    }

}
