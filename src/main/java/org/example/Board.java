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

    private void placeShip(int startingRow, int startingColumn, Direction direction, Ship ship) {
        // placing ship on board
        for (int i = 0; i < ship.getLength(); i++) {
            switch (direction) {
                case UP -> {
                    putShipField(startingRow - i, startingColumn);
                }
                case DOWN -> {
                    putShipField(startingRow + i, startingColumn);
                }
                case LEFT -> {
                    putShipField(startingRow, startingColumn - i);
                }
                case RIGHT -> {
                    putShipField(startingRow, startingColumn + i);
                }
            }
        }

        // creating buffered zone around ship
        for (int i = 0; i < ship.getLength()+2; i++) {
            switch (direction) {
                case UP -> {
                    putBufferedField(startingRow + 1 - i, startingColumn + 1);
                    putBufferedField(startingRow + 1 - i, startingColumn - 1);
                    putBufferedField(startingRow + 1 - i, startingColumn);
                }
                case DOWN -> {
                    putBufferedField(startingRow - 1 + i, startingColumn - 1);
                    putBufferedField(startingRow - 1 + i, startingColumn + 1);
                    putBufferedField(startingRow - 1 + i, startingColumn);
                }
                case LEFT -> {
                    putBufferedField(startingRow + 1, startingColumn + 1 - i);
                    putBufferedField(startingRow - 1, startingColumn + 1 - i);
                    putBufferedField(startingRow, startingColumn + 1 - i);
                }
                case RIGHT -> {
                    putBufferedField(startingRow + 1, startingColumn - 1 + i);
                    putBufferedField(startingRow - 1, startingColumn - 1 + i);
                    putBufferedField(startingRow, startingColumn - 1 + i);
                }
            }
        }
    }

    private void putBufferedField(int row, int column) {
        if (canPutField(row, column)) {
            fields[row][column] = Field.BUFFER_ZONE;
        }
    }

    private void putShipField(int row, int column) {
            fields[row][column] = Field.SHIP;
    }

    private boolean canPutField(int row, int column) {

        if (column > 10 || row > 10 || row < 0 || column < 0) {
            return false;
        }

        boolean result = true;
        Field currentField = fields[row][column];
        if (!currentField.equals(Field.SEA)) {
            result = false;
        }

        return result;
    }


    public void addShip(int startingRow, int startingColumn, Direction direction, Ship ship) {
        if (canAddShip(startingRow, startingColumn, direction, ship)) {
            placeShip(startingRow, startingColumn, direction, ship);
        }
    }

    private boolean canAddShip(int startingRow, int startingColumn, Direction direction, Ship ship) {
        boolean result = true;
        for (int i = 0; i < ship.getLength(); i++) {
            switch (direction) {
                case UP -> result = canPutField(startingRow - i, startingColumn);
                case DOWN -> result = canPutField(startingRow + i, startingColumn);
                case LEFT -> result = canPutField(startingRow, startingColumn - i);
                case RIGHT -> result = canPutField(startingRow, startingColumn + i);
            }
            if (!result) {
                break;
            }
        }

        return result;
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
