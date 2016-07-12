package com.harrison.john.NeuralNet;

import java.util.ArrayList;

/**
 * Created by John on 7/3/2016.
 */
public class TestGeneticAlgorithm extends GeneticAlgorithm {

    public TestGeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate) {
        super(populationSize, mutationRate, crossoverRate);

        this.setTotalFitness(0);
        this.setGeneration(0);
        this.setFittestGenome(0);
        this.setBestFitness(0);
        this.setWorstFitness(9999999);
        this.setAvgFitness(0);

        for(int i = 0; i < populationSize; ++i){
            this.addGenome(new Genome(new ArrayList<Double>(), 0));//start with zero fitness and random wights

            for(int j = 0; j < getChromosomeLength(); ++j){
                this.getGenome(i).addWeight(Math.random());
            }//end for j
        } //end for i
    }

    @Override
    public ArrayList<Genome> epoch(ArrayList<Genome> oldPopulation) {

        this.setChromosomePopulation(oldPopulation);
        reset();
        getChromosomePopulation().sort(Genome.genomeFitnessComparator);//sort them by fitness
        calculateFitnessStats();

        ArrayList<Genome> newChromosomePopulation = new ArrayList<>();

        grabNbest(1,4,newChromosomePopulation);//todo make this not hardcoded

        while(newChromosomePopulation.size() < getChromosomePopulationSize()){

            Genome mother = getChromosomeRoulette();
            Genome father = getChromosomeRoulette();

            ArrayList<Double> child1 = new ArrayList<>(), child2 = new ArrayList<>();

            crossover(mother.getWeights(), father.getWeights(), child1, child2);

            mutate(child1);
            mutate(child2);

            newChromosomePopulation.add(new Genome(child1, 0));
            newChromosomePopulation.add(new Genome(child2, 0));
        }

        setChromosomePopulation(newChromosomePopulation);

        return getChromosomePopulation();//
    }

    @Override
    protected void crossover(ArrayList<Double> mother, ArrayList<Double> father, ArrayList<Double> child1, ArrayList<Double> child2) {
        if(Math.random() > this.getCrossoverRate() || mother.equals(father)){
            child1 = mother;
            child2 = father;
            return;
        }

        //get crossover point
        int crossoverPoint = (int)Math.round( Math.random() * (getChromosomeLength() - 1) );//i think this cast is prety safe

        //create babies hehehe
        for(int i = 0; i < crossoverPoint; ++i){
            child1.add(mother.get(i));
            child2.add(father.get(i));
        }

        for(int i = crossoverPoint; i < mother.size(); ++i){
            child1.add(father.get(i));
            child2.add(mother.get(i));
        }

        return;
    }

    @Override
    protected void mutate(ArrayList<Double> chromosome) {
        for(int i = 0; i < chromosome.size(); ++i){
            if(Math.random() < this.getMutationRate()){
                chromosome.set(i, chromosome.get(i) + (Math.random() * Parameters.MAX_PERTURBATION));
            }
        }
    }

    @Override
    protected Genome getChromosomeRoulette() {

        return getGenome((int)(Math.random() * getChromosomeLength()));//lol swag cast
    }

    @Override
    protected void grabNbest(int n, int numCopies, ArrayList<Genome> chromosomePopulation) {
        while(n-- > 0){
            for(int i = 0; i < numCopies; ++i){
                chromosomePopulation.add(getGenome(getChromosomePopulationSize() - 1 - n));//definitely have to check this LOL
            }
        }
    }

    @Override
    protected void calculateFitnessStats() {
        setTotalFitness(0);

        double highestFitness = 0;
        double lowestFitness = 9999999;

        for(int i = 0; i < getChromosomePopulationSize(); ++i){

            Genome currentGenome = getGenome(i);
            if(currentGenome.getFitness() > highestFitness){
                highestFitness = currentGenome.getFitness();
                setFittestGenome(i);
                setBestFitness(highestFitness);
            }

            if(currentGenome.getFitness() < lowestFitness){
                lowestFitness = currentGenome.getFitness();
                setWorstFitness(highestFitness);
            }
        }

        setAvgFitness(getTotalFitness()/getChromosomePopulationSize());
    }

    @Override
    protected void reset() {
        this.setTotalFitness(0);
        this.setBestFitness(0);
        this.setWorstFitness(9999999);
        this.setAvgFitness(0);
    }
}
