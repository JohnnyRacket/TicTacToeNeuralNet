package com.harrison.john.Game.Model;

import com.harrison.john.Game.Controller.TicTacToeController;
import com.harrison.john.NeuralNet.NeuralNet;

import java.util.ArrayList;

/**
 * Created by John on 7/5/2016.
 */
public class TicTacToePlayer {

    private NeuralNet brain = new NeuralNet();
    private TicTacToeController controller;
    private int fitness = 0;

    public TicTacToePlayer(TicTacToeController controller){
        this.controller = controller;
    }

    public void update(TicTacToeBoard board){

        ArrayList<Double> inputs = board.getCurrentBoard();
        ArrayList<Double> outputs = brain.update(inputs);

        double highestConfidence = 0;
        int decision = 0;
        for(int i = 0; i < outputs.size(); ++i){
            if (outputs.get(i) > highestConfidence){
                highestConfidence = outputs.get(i);
                decision = i;
            }
        }

        if(controller.makeMove(decision)){//managed a legal move lol
            System.out.println("legal move swag");
            fitness += 10;
        }else{
            System.out.println("l2p noob, illegal move");
        }
        if(board.checkBoard(controller.getMyMarker())){//managed to win
            fitness+=100;
        }
    }
    public TicTacToeController getController(){ //for testing only, probably should not exist
        return controller;
    }

    public void addFitness(int fitness){
        this.fitness += fitness;
    }

    public void resetFitness(){
        this.fitness = 0;
    }
}
