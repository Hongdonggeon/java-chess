package chess.domain;

import java.util.Arrays;

public enum Rank {

    EIGHT("8"),
    SEVEN("7"),
    SIX("6"),
    FIVE("5"),
    FOUR("4"),
    THREE("3"),
    TWO("2"),
    ONE("1");

    private static final String NOT_EXIST_VALUE_IN_RANK = "[ERROR] Rank에 해당하는 번호가 없다.";

    private final String value;

    Rank(final String value) {
        this.value = value;
    }

    public static Rank findRank(int value) {
        return Arrays.stream(Rank.values())
                .filter(ordinate -> Integer.parseInt(ordinate.value) == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_VALUE_IN_RANK));
    }

    public int getRank() {
        return Integer.parseInt(value);
    }

    public String getValue() {
        return value;
    }
}
