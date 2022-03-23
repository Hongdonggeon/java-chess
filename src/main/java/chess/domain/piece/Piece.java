package chess.domain.piece;

import chess.domain.Position;

public abstract class Piece {

    protected final Color color;

    public Piece(final Color color) {
        this.color = color;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public abstract boolean isMovable(Position fromPosition, Position toPosition);
}
