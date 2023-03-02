package org.example;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.placeShip(0, 0, Direction.RIGHT, Ship.THREE_MASTED);
        System.out.println(board);
    }
}