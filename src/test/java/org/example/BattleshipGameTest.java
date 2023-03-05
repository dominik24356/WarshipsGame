package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BattleshipGameTest {
    @Test
    void automaticDeploymentFieldsTest() {
        BattleshipGame game = new BattleshipGame();
        game.automaticShipDeployment();

        int correctNumOfShipFields = 0;
        for (Ship ship : Ship.values()) {
            correctNumOfShipFields += ship.getLength()*ship.getNumOfShips();
        }

        int numOfNewBoardShipFields = 0;
        for (Field[] row: game.getGameBoard().getFields()) {
            for (Field field: row) {
                if (field.equals(Field.SHIP)){
                    numOfNewBoardShipFields ++;
                }
            }
        }

        assertEquals(correctNumOfShipFields, numOfNewBoardShipFields);
    }


}