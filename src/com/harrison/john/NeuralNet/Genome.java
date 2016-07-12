package com.harrison.john.NeuralNet;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by John on 7/3/2016.
 */
public class Genome {

    private double fitness = 0;
    private ArrayList<Double> weights = new ArrayList<>();

    public Genome(ArrayList<Double> weights, double fitness){
        this.weights = weights;
        this.fitness = fitness;
    }

    //comparator to sort
    public static Comparator<Genome> genomeFitnessComparator = new Comparator<Genome>() {
        @Override
        public int compare(Genome o1, Genome o2) {
            return Double.compare(o1.getFitness(), o2.getFitness());
        }
    };
    //getters and setters

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void addWeight(double weight){
        weights.add(weight);
    }

    public ArrayList<Double> getWeights() {
        return weights;
    }

    public void setWeights(ArrayList<Double> weights) {
        this.weights = weights;
    }
}
