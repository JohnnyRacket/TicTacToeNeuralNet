package com.harrison.john.NeuralNet;

import java.util.ArrayList;

/**
 * Created by John on 7/2/2016.
 */
public class Neuron {

    private int numInputs;
    private double threshhold;
    private ArrayList<Double> weights = new ArrayList<>();

    public Neuron(int numInputs){//constructor
        this.numInputs = numInputs;
        this.threshhold = Math.random();

        for(int i = 0; i < numInputs; ++i){
            weights.add(Math.random());
        }
    }

    //getters and setters
    public ArrayList<Double> getWeights() {
        return weights;
    }

    public void setWeights(ArrayList<Double> weights) {
        this.weights = weights;
    }

    public double getThreshhold() {
        return threshhold;
    }

    public void setThreshhold(double threshhold) {
        this.threshhold = threshhold;
    }

    public int getNumInputs() {
        return numInputs;
    }

    public void setNumInputs(int numInputs) {
        this.numInputs = numInputs;
    }

    public double getWeight(int i){
        return this.weights.get(i);
    }

    public void setWeight(int i, double weight){
        this.weights.set(i,weight);
    }
}
