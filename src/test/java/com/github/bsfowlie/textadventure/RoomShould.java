package com.github.bsfowlie.textadventure;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class RoomShould implements WithAssertions {

    @Test
    void haveDescription() {

        assertThat(new Room("with description").description()).isEqualTo("with description");

    }

    @Test
    void requireDescription() {

        assertThatNullPointerException().isThrownBy(() -> new Room(null))
                .withMessage("Must provide a room description");

    }

    @Test
    void getItemNamesWithNoItems() {

        assertThat(new Room("with no items").itemNames()).isNotNull().isEmpty();

    }

}
