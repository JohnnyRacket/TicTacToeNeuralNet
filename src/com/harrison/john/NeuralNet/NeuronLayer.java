package com.harrison.john.NeuralNet;

import java.util.ArrayList;

/**
 * Created by John on 7/2/2016.
 */
public class NeuronLayer {

    private int numNeurons;
    private ArrayList<Neuron> neurons = new ArrayList<>();

    public NeuronLayer(int numNeurons, int numInputsPerNeuron){
        this.numNeurons = numNeurons;
        for(int i = 0; i < numNeurons; ++i){
            neurons.add(new Neuron(numInputsPerNeuron));
        }

    }

    public Neuron getNeuron(int i){
        return this.neurons.get(i);
    }

    public int getNumNeurons() {
        return numNeurons;
    }

    public void setNumNeurons(int numNeurons) {
        this.numNeurons = numNeurons;
    }
}
