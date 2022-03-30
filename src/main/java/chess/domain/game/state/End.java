package chess.domain.game.state;

import chess.domain.Board;
import chess.domain.Position;
import chess.domain.piece.Color;

public abstract class End implements GameState{

    protected final Board board;

    public End(Board board) {
        this.board = board;
    }

    private static final String ALREADY_END_GAME = "[ERROR] 게임이 종료되어 지원하지 않는 기능입니다";

    @Override
    public GameState initBoard() {
        throw new IllegalStateException(ALREADY_END_GAME);
    }

    @Override
    public GameState movePiece(Position fromPosition, Position toPosition) {
        throw new IllegalStateException(ALREADY_END_GAME);
    }

    @Override
    public GameState end() {
        throw new IllegalStateException(ALREADY_END_GAME);
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public double calculateScore(Color color) {
        throw new IllegalStateException(ALREADY_END_GAME);
    }
}
