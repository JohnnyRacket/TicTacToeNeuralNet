package com.harrison.john;

import com.harrison.john.Game.Controller.TicTacToeController;
import com.harrison.john.Game.Model.TicTacToeBoard;
import com.harrison.john.Game.Model.TicTacToePlayer;
import com.harrison.john.NeuralNet.GeneticAlgorithm;
import com.harrison.john.NeuralNet.Parameters;
import com.harrison.john.NeuralNet.TestGeneticAlgorithm;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TicTacToeBoard board = new TicTacToeBoard();
        System.out.println(board);

        TicTacToePlayer playerx = new TicTacToePlayer(new TicTacToeController(TicTacToeBoard.TIC_TAC_TOE_X, board));
        TicTacToePlayer playero = new TicTacToePlayer(new TicTacToeController(TicTacToeBoard.TIC_TAC_TOE_O, board));
        System.out.println(playerx.getBrain());
        GeneticAlgorithm genAlg = new TestGeneticAlgorithm(2, .2,.75);
//        while(!board.isBoardFull()){
//            playerx.update(board);
//            System.out.println(board);
//            playero.update(board);
//            System.out.println(board);
//        }
        playerx.update(board);
        System.out.println(board);

//        board.addMarker(0,0,TicTacToeBoard.TIC_TAC_TOE_O);
//        board.addMarker(0,1,TicTacToeBoard.TIC_TAC_TOE_O);
//        board.addMarker(0,2,TicTacToeBoard.TIC_TAC_TOE_O);
//        board.addMarker(2,2,TicTacToeBoard.TIC_TAC_TOE_O);
//        board.addMarker(2,1,TicTacToeBoard.TIC_TAC_TOE_O);
//        board.addMarker(2,0,TicTacToeBoard.TIC_TAC_TOE_O);
        playero.update(board);
        System.out.println(board);
        playerx.update(board);
        System.out.println(board);
        playero.update(board);
        System.out.println(board);
        playerx.update(board);
        System.out.println(board);
        playero.update(board);
        System.out.println(board);
    }
}
