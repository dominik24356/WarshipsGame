package org.example;

public enum Ship {
    ONE_MASTED,
    TWO_MASTED,
    THREE_MASTED,
    FOUR_MASTED;

    private int length;

    public int getLength() {
        return switch (this) {
            case ONE_MASTED -> 1;
            case TWO_MASTED -> 2;
            case THREE_MASTED -> 3;
            case FOUR_MASTED -> 4;
        };
    }
}
