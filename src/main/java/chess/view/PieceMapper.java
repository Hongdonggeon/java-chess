package chess.view;

import chess.domain.piece.Bishop;
import chess.domain.piece.Color;
import chess.domain.piece.King;
import chess.domain.piece.Knight;
import chess.domain.piece.Pawn;
import chess.domain.piece.Piece;
import chess.domain.piece.Queen;
import chess.domain.piece.Rook;
import java.util.HashMap;
import java.util.Map;

public final class PieceMapper {

    private static final Map<String, String> MAPPER = new HashMap<>();
    private static final String PAWN_LETTER = "p";
    private static final String BISHOP_LETTER = "b";
    private static final String KNIGHT_LETTER = "n";
    private static final String KING_LETTER = "k";
    private static final String QUEEN_LETTER = "q";
    private static final String ROOK_LETTER = "r";

    static {
        MAPPER.put(Pawn.class.getName(), PAWN_LETTER);
        MAPPER.put(Bishop.class.getName(), BISHOP_LETTER);
        MAPPER.put(Knight.class.getName(), KNIGHT_LETTER);
        MAPPER.put(King.class.getName(), KING_LETTER);
        MAPPER.put(Queen.class.getName(), QUEEN_LETTER);
        MAPPER.put(Rook.class.getName(), ROOK_LETTER);
    }

    public static String from(Piece piece) {
        String letter = MAPPER.get(piece.getClass().getName());
        if (piece.isSameColor(Color.WHITE)) {
            return letter;
        }
        return letter.toUpperCase();
    }

    public static Piece of(String pieceName, Color color) {
        if (Pawn.class.getSimpleName().equals(pieceName)) {
            return new Pawn(color);
        }
        if (Bishop.class.getSimpleName().equals(pieceName)) {
            return new Bishop(color);
        }
        if (Knight.class.getSimpleName().equals(pieceName)) {
            return new Knight(color);
        }
        if (King.class.getSimpleName().equals(pieceName)) {
            return new King(color);
        }
        if (Queen.class.getSimpleName().equals(pieceName)) {
            return new Queen(color);
        }
        return new Rook(color);
    }
}
