package org.example;

import java.util.Random;

public class BattleshipGame {

    private final Board gameBoard = new Board();

    public Board getGameBoard() {
        return gameBoard;
    }

    protected void automaticShipDeployment() {
        Random random = new Random();

        Ship[] ships = {Ship.SHIP_OF_SIZE_4, Ship.SHIP_OF_SIZE_3, Ship.SHIP_OF_SIZE_2, Ship.SHIP_OF_SIZE_1};

        for (Ship ship : ships) {
            for (int i = 0; i < ship.getNumOfShips(); i++) {
                placeShipRandomly(random, ship);
            }
        }
    }

    private void placeShipRandomly(Random random, Ship ship) {
        boolean canAdd = false;
        do {
            int randomRow = random.nextInt(10);
            int randomColumn = random.nextInt(10);
            int randomDirectionIndex = random.nextInt(4);
            Direction randomDirection = Direction.values()[randomDirectionIndex];

            canAdd = gameBoard.canAddShip(randomRow, randomColumn, randomDirection, ship);

            if (canAdd) {
                gameBoard.addShip(randomRow, randomColumn, randomDirection, ship);
            }
        } while (!canAdd);
    }



    @Override
    public String toString() {
        return gameBoard.toString();
    }
}
