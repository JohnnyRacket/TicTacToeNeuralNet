package com.harrison.john.Game.Controller;

import com.harrison.john.Game.Model.TicTacToeBoard;

/**
 * Created by John on 7/5/2016.
 */
public class TicTacToeController {
    private int myMarker;
    private TicTacToeBoard gameBoard;

    public TicTacToeController(int markerType, TicTacToeBoard board){
        this.myMarker = markerType;
        this.gameBoard = board;
    }

    public boolean makeMove(int spot){
        switch (spot){
            case 0 : return gameBoard.addMarker(0,0,myMarker);
            case 1 : return gameBoard.addMarker(0,1,myMarker);
            case 2 : return gameBoard.addMarker(0,2,myMarker);
            case 3 : return gameBoard.addMarker(1,0,myMarker);
            case 4 : return gameBoard.addMarker(1,1,myMarker);
            case 5 : return gameBoard.addMarker(1,2,myMarker);
            case 6 : return gameBoard.addMarker(2,0,myMarker);
            case 7 : return gameBoard.addMarker(2,1,myMarker);
            case 8 : return gameBoard.addMarker(2,2,myMarker);
            default: System.out.println("Illegal move");
        }

        //gameBoard.checkBoard(myMarker);
        System.out.println("should not really get here ever");
        return false;
    }

    public int getMyMarker() {
        return myMarker;
    }

    public void setMyMarker(int myMarker) {
        this.myMarker = myMarker;
    }
}
