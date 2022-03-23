package chess.domain.piece;

public abstract class Piece {

    private final Color color;

    public Piece(final Color color) {
        this.color = color;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }
}
