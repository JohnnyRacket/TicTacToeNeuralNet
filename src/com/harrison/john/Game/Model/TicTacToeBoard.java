package com.harrison.john.Game.Model;


import java.util.ArrayList;

/**
 * Created by John on 7/5/2016.
 */
public class TicTacToeBoard {
    private TicTacToeSpace[][] spaces =  new TicTacToeSpace[3][3];
    private int numMarkersPlaced = 0;

    public static int TIC_TAC_TOE_X = 1;
    public static int TIC_TAC_TOE_O = 2;


    public TicTacToeBoard(){
        for(int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                spaces[i][j] = new TicTacToeSpace();
            }
        }
    }


    public boolean addMarker(int row, int col, int marker){
        if(spaces[row][col].addMarker(marker)){
            ++ numMarkersPlaced;
            return true;
        }else{
            return false;
        }
    }

    public void clearBoard(){
        spaces = new TicTacToeSpace[3][3];
    }

    public boolean isBoardFull(){
        if(numMarkersPlaced >= 9){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Double> getCurrentBoard(){
        ArrayList<Double> currentBoard = new ArrayList<>();
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                currentBoard.add((double)spaces[j][i].getMarker());
            }//end for j
        }//ed for i
        return currentBoard;
    }

    public boolean checkBoard(int marker){
        int inARow = 0;
        //check for vertical win
        for(int i = 0; i < 3; ++i){
            inARow = 0;
            for(int j = 0; j < 3; ++j){
                if(spaces[i][j].getMarker() == marker){
                    ++inARow;
                }
            }
            if(inARow >= 3){
                System.out.println("winner winner chicken dinner, " + marker + "'s win!");
                clearBoard();
                return true;
            }
        }
        //check for horizontal win
        for(int i = 0; i < 3; ++i){
            inARow = 0;
            for(int j = 0; j < 3; ++j){
                if(spaces[i][j].getMarker() == marker){
                    ++inARow;
                }
            }
            if(inARow >= 3){
                System.out.println("winner winner chicken dinner, " + marker + "'s win!");
                clearBoard();
                return true;
            }
        }
        inARow = 0;
        //diagonal win \
        for(int i = 0; i < 3; ++i){
            if(spaces[i][i].getMarker() == marker){
                ++inARow;
            }
        }
        if(inARow >= 3){
            System.out.println("winner winner chicken dinner, " + marker + "'s win!");
            clearBoard();
            return true;
        }

        //this is so lazy but diagonal win /
        if(spaces[0][2].getMarker() == marker &&
                spaces[1][1].getMarker() == marker &&
                spaces[2][0].getMarker() == marker){
            System.out.println("winner winner chicken dinner, " + marker + "'s win!");
            return true;
        }

        if(isBoardFull()){
            System.out.println("cats game, try again!");
            clearBoard();
            return false;
        }

        System.out.println("no winner yet");
        return false;
    }

    @Override
    public String toString() {
        return "\n" + spaces[0][0] + "|" + spaces[0][1] + "|" + spaces[0][2] +
                "\n-----" +
                "\n" + spaces[1][0] + "|" + spaces[1][1] + "|" + spaces[1][2] +
                "\n-----" +
                "\n" + spaces[2][0] + "|" + spaces[2][1] + "|" + spaces[2][2];
    }
}
