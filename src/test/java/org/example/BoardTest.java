package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void newCorrectBoardTest() {
        Board newBoard = new Board();
        Field[][] fields = newBoard.getFields();

        boolean isCorrect = true;
        for (Field[] column : fields) {
            outer:
            for (Field field : column) {
                if (field != Field.SEA) {
                    isCorrect = false;
                    break outer;
                }
            }
        }

        assertTrue(isCorrect);
    }

    @Test
    void newIncorrectBoardTest() {
        Board newBoard = new Board();
        Field[][] fields = newBoard.getFields();
        fields[1][1] = Field.SHIP;

        boolean isCorrect = true;
        for (Field[] column : fields) {
            outer:
            for (Field field : column) {
                if (field != Field.SEA) {
                    isCorrect = false;
                    break outer;
                }
            }
        }

        assertFalse(isCorrect);
    }
}


