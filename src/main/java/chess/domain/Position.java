package chess.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Position {

    private static final String NOT_EXIST_POSITION = "[ERROR] 해당 포지션은 체스 보드에 존재하지 않습니다.";
    private static final Map<String, Position> CACHE = new HashMap<>();

    private final Abscissa abscissa;
    private final Ordinate ordinate;

    static {
        Arrays.stream(Abscissa.values())
            .forEach(Position::savePosition);
    }

    private Position(final Abscissa abscissa, final Ordinate ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    private static void savePosition(final Abscissa abscissa) {
        Arrays.stream(Ordinate.values())
            .forEach(ordinate -> CACHE.put(makeKey(abscissa,ordinate), new Position(abscissa, ordinate)));
    }

    private static String makeKey(final Abscissa abscissaValue, final Ordinate ordinateValue) {
        return abscissaValue.toString() + ordinateValue.getValue();
    }

    public static Position valueOf(final String key) {
        Position position = CACHE.get(key);
        if (position == null) {
            throw new IllegalArgumentException(NOT_EXIST_POSITION);
        }
        return position;
    }

    public static Position valueOf(final Abscissa abscissa, final Ordinate ordinate) {
        return valueOf(makeKey(abscissa,ordinate));
    }

    public boolean isSameAbscissa(Position position) {
        return abscissa == position.abscissa;
    }

    public boolean isSameOrdinate(Position position) {
        return ordinate == position.ordinate;
    }

    public int getOrdinateDifference(Position position) {
        return ordinate.getCoordinate() - position.ordinate.getCoordinate();
    }

    public int getAbscissaDifference(Position position) {
        return abscissa.getCoordinate() - position.abscissa.getCoordinate();
    }
}
