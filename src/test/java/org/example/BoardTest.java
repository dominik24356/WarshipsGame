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

    @Test
    void placingCorrectlyOneShipTest() {
        Board correctBoard = new Board();
        Field[][] correctFields = correctBoard.getFields();
        correctFields[0][0] = Field.SHIP;
        correctFields[0][1] = Field.SHIP;
        correctFields[0][2] = Field.SHIP;
        correctFields[0][3] = Field.BUFFER_ZONE;
        correctFields[1][0] = Field.BUFFER_ZONE;
        correctFields[1][1] = Field.BUFFER_ZONE;
        correctFields[1][2] = Field.BUFFER_ZONE;
        correctFields[1][3] = Field.BUFFER_ZONE;

        correctBoard.setFields(correctFields);

        Board board = new Board();
        Field[][] newFields = board.getFields();
        board.addShip(0,0, Direction.RIGHT, Ship.SHIP_OF_SIZE_3);

        boolean resultOfComparison = Arrays.deepEquals(correctFields, newFields);
        assertTrue(resultOfComparison);
    }

    @Test
    void placingIncorrectlyOneShipTest() {
        Board board = new Board();
        board.addShip(1,1, Direction.LEFT, Ship.SHIP_OF_SIZE_3);
        Board clearBoard = new Board();

        boolean result = Arrays.deepEquals(board.getFields(), clearBoard.getFields());
        assertTrue(result);
    }



}


