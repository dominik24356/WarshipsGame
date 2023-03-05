package org.example;

import org.junit.jupiter.api.Test;


class BattleshipGameTest {
    @Test
    void automaticDeploymentOfAllShipsTest() {
        BattleshipGame game = new BattleshipGame();
        game.automaticShipDeployment();
        System.out.println(game);
    }


}