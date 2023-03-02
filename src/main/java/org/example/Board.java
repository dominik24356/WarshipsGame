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

    public void se

}
