package com.system.design.projects.game;

public class Board {
    Cell[][] cells;
    Board(int n){
        cells = new Cell[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    public Cell moveToNextCell(Board board,Cell currentPosition,Cell nextPosition,Piece piece) {
        Cell cell = piece.isAllowedCell(board,currentPosition,nextPosition);
        //check capture
        return cell;

        //update current position if allowed
    }
    void updateBoard(Cell cell,Piece piece){
        int row = cell.getX();
        int col = cell.getY();
        cell.setCurrentObject(piece);
        cells[row][col] = cell;
    }
    String showBoard(){
        return cells.toString();
    }
    public boolean checkMate(){
        return true;
    }

}
