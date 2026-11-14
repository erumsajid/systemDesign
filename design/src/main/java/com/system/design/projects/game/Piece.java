package com.system.design.projects.game;

public interface Piece {

    Cell isAllowedCell(Board board,Cell currentPosition,Cell nextPosition);
    Cell capture();

}

class King implements Piece {


    @Override
    public Cell isAllowedCell(Board board,Cell currentPosition,Cell nextPosition) {
        return null;
    }

    @Override
    public Cell capture() {
        return null;
    }
}
class Queen implements Piece {

    @Override
    public Cell isAllowedCell(Board board,Cell currentPosition,Cell nextPosition) {
        return null;
    }

    @Override
    public Cell capture() {
        return null;
    }
}
