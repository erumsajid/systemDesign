package com.system.design.projects.game;

import java.util.List;

public interface Game {
    Board startGame(List<Player> players);
}
class Chess implements Game{
    private int size;
    private Board board;
    private List<Player> players;
    private int currentPlayerIdx;
    @Override
    public Board startGame(List<Player> players) {
        board = new Board(8);
        this.players = players;
        currentPlayerIdx = 0;
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrentPlayerIdx() {
        return currentPlayerIdx;
    }
    public String showBoard(){
        return board.showBoard();
    }
    public void nextMove(Piece piece,Cell nextPosition,Cell currentPosition){
        Cell cell = board.moveToNextCell(board,currentPosition,nextPosition,piece);
        removeFromBoard(cell);
        board.updateBoard(nextPosition,piece);

    }
    public void removeFromBoard(Cell cell){

    }
}
