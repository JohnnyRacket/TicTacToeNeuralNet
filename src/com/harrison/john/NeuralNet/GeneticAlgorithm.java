package com.harrison.john.NeuralNet;

import java.util.ArrayList;

/**
 * Created by John on 7/3/2016.
 */
public abstract class GeneticAlgorithm {

    private ArrayList<Genome> chromosomePopulation = new ArrayList<>();//probably rename
    private int populationSize;
    private int chromosomeLength;

    private double totalFitness;
    private double bestFitness;
    private double avgFitness;
    private double worstFitness;
    private int fittestGenome;

    private double mutationRate; //try .05 to .3
    private double crossoverRate; //try 0.7

    private int generation;

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate){
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        //this.chromosomeLength = numWeights; //think about naming
    }


    //accessors
    public ArrayList<Genome> getChromosomes(){
        return chromosomePopulation;
    }

    public double avgFitness(){
        return totalFitness/populationSize;
    }

    public double bestFitness(){
        return bestFitness;
    }

    //internal functions
    public abstract ArrayList<Genome> epoch(ArrayList<Genome> oldPopulation);

    protected abstract void crossover(ArrayList<Double> mother,ArrayList<Double> father, ArrayList<Double> child1, ArrayList<Double> child2);

    protected abstract void mutate(ArrayList<Double> chromosome);

    protected abstract Genome getChromosomeRoulette();

    protected abstract void grabNbest(int n, int numCopies, ArrayList<Genome> chromosomePopulation);

    protected abstract void calculateFitnessStats();

    protected abstract void reset();

    //getters and setters

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public int getChromosomeLength() {
        return chromosomeLength;
    }

    public void setChromosomeLength(int chromosomeLength) {
        this.chromosomeLength = chromosomeLength;
    }

    public double getTotalFitness() {
        return totalFitness;
    }

    public void setTotalFitness(double totalFitness) {
        this.totalFitness = totalFitness;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }

    public double getAvgFitness() {
        return avgFitness;
    }

    public void setAvgFitness(double avgFitness) {
        this.avgFitness = avgFitness;
    }

    public double getWorstFitness() {
        return worstFitness;
    }

    public void setWorstFitness(double worstFitness) {
        this.worstFitness = worstFitness;
    }

    public int getFittestGenome() {
        return fittestGenome;
    }

    public void setFittestGenome(int fittestGenome) {
        this.fittestGenome = fittestGenome;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    //custom accessors

    public void addGenome(Genome genome){
        this.chromosomePopulation.add(genome);
    }

    public Genome getGenome(int index){
        return this.chromosomePopulation.get(index);
    }

    public void clearChromosomePopulation(){
        this.chromosomePopulation.clear();
    }

    public int getChromosomePopulationSize(){
        return this.chromosomePopulation.size();
    }

    public ArrayList<Genome> getChromosomePopulation(){
        return this.chromosomePopulation;
    }

    public void setChromosomePopulation(ArrayList<Genome> chromosomePopulation){
        this.chromosomePopulation = chromosomePopulation;
    }
}
