package org.example;

public enum Ship {
    SHIP_OF_SIZE_1,
    SHIP_OF_SIZE_2,
    SHIP_OF_SIZE_3,
    SHIP_OF_SIZE_4;

    private int length;

    public int getLength() {
        return switch (this) {
            case SHIP_OF_SIZE_1 -> 1;
            case SHIP_OF_SIZE_2 -> 2;
            case SHIP_OF_SIZE_3 -> 3;
            case SHIP_OF_SIZE_4 -> 4;
        };
    }

    public int getNumOfShips() {
        return switch (this) {
            case SHIP_OF_SIZE_1 -> 4;
            case SHIP_OF_SIZE_2 -> 3;
            case SHIP_OF_SIZE_3 -> 2;
            case SHIP_OF_SIZE_4 -> 1;
        };
    }
}
