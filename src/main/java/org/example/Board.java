package org.example;

public class Board {
    private Field[][] fields = new Field[10][10];

    protected Board() {
        int gameBoardSize = fields.length;
        for (int column = 0; column < gameBoardSize; column++) {
            for (int row = 0; row < gameBoardSize; row++) {
                fields[row][column] = Field.SEA;
            }
        }
    }

    public Field[][] getFields() {
        return fields;
    }

    public void setFields(Field[][] fields) {
        this.fields = fields;
    }

    public void placeShip(int startingColumn, int startingRow, Direction direction, Ship ship) {
        for (int i = 0; i < ship.getLength(); i++) {
            switch (direction) {
                case UP -> {
                    fields[startingRow - i][startingColumn] = Field.SHIP;
                }
                case DOWN -> {
                    fields[startingRow + i][startingColumn] = Field.SHIP;
                }
                case LEFT -> {
                    fields[startingRow][startingColumn - i] = Field.SHIP;
                }
                case RIGHT -> {
                    fields[startingRow][startingColumn + i] = Field.SHIP;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder boardMap = new StringBuilder();
        for (Field[] column: fields) {
            for (Field field: column) {
                if (field.equals(Field.SHIP)){
                    boardMap.append("X ");
                } else {
                    boardMap.append("O ");
                }
            }
            boardMap.append("\n");
        }

        return boardMap.toString();
    }
}
