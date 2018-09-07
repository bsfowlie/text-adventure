package com.github.bsfowlie.textadventure;

import info.solidsoft.mockito.java8.api.WithMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameShould implements WithAssertions, WithMockito {

    @Test
    void exist(@Mock Room starting, @Mock EndCondition ending) {

        assertThat(new Game(starting, ending)).isNotNull();
    }

}
