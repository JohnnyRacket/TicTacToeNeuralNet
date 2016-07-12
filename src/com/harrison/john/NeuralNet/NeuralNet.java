package com.harrison.john.NeuralNet;

import java.util.ArrayList;

/**
 * Created by John on 7/2/2016.
 */
public class NeuralNet {

    private int numInputs;
    private int numOutputs;
    private int numHiddenlayers;
    private int numNeuronsPerHiddenLayer;

    private int numWeights;

    private ArrayList<NeuronLayer> neuronLayers = new ArrayList<>();

    public NeuralNet(){//should probably change this to dependency injection
        this.numInputs = Parameters.NUM_INPUTS;
        this.numOutputs = Parameters.NUM_OUTPUTS;
        this.numHiddenlayers = Parameters.NUM_HIDDEN_LAYERS;
        this.numNeuronsPerHiddenLayer = Parameters.NUM_NEURONS_PER_LAYER;

        this.numWeights = numInputs + numHiddenlayers*numNeuronsPerHiddenLayer + numInputs; //this might not be right

        createNet();
    }

    public void createNet(){
        if(numHiddenlayers > 0){
            neuronLayers.add(new NeuronLayer(numNeuronsPerHiddenLayer, numInputs));

            for(int i = 0; i < numHiddenlayers - 1; ++i){
                neuronLayers.add(new NeuronLayer(numNeuronsPerHiddenLayer, numNeuronsPerHiddenLayer));
            }//end for i

            neuronLayers.add(new NeuronLayer(numOutputs, numNeuronsPerHiddenLayer));
        }else{
            neuronLayers.add(new NeuronLayer(numOutputs, numInputs));
        }
    }

    public ArrayList<Double> getWeights(){
        ArrayList<Double> weights = new ArrayList<>();

        for(int i = 0; i < numHiddenlayers + 1; ++i){ //+1 accounts for output layer i believe
            for(int j = 0; j < neuronLayers.get(i).getNumNeurons(); ++j){
                for(int k = 0; k < neuronLayers.get(i).getNeuron(j).getNumInputs(); ++k){
                    weights.add(neuronLayers.get(i).getNeuron(j).getWeight(k));
                } //end for k
            } //end for j
        } //end for i
        return weights;
    }

    public int getNumWeights(){
        return numWeights;//suspect about my calculations on this above
    }

    public void putWeights(ArrayList<Double> weights){
        int currentWeight = 0;
        for(int i = 0; i < numHiddenlayers + 1; ++i){ //+1 accounts for output layer i believe
            for(int j = 0; j < neuronLayers.get(i).getNumNeurons(); ++j){
                for(int k = 0; k < neuronLayers.get(i).getNeuron(j).getNumInputs(); ++k){
                    neuronLayers.get(i).getNeuron(j).setWeight(k, weights.get(currentWeight++));
                } //end for k
            } //end for j
        } //end for i
    }

    public ArrayList<Double> update( ArrayList<Double> inputs){ //this function is a TDA nightmare rn

        ArrayList<Double> outputs = new ArrayList<>();
        int weight = 0;

        //input validation
        if(inputs.size() != this.numInputs){
            //maybe throw an exception here?
            System.out.println("Incorrect number of inputs");
            return outputs;
        }

        for(int i = 0; i < numHiddenlayers + 1; ++i){
            if(i > 0){
                inputs = outputs;
            }
            outputs.clear();
            weight = 0;
            for(int j = 0; j < neuronLayers.get(i).getNumNeurons(); ++j){
                double netInput = 0;
                int numInputs = neuronLayers.get(i).getNeuron(j).getNumInputs();

                for(int k = 0; k < numInputs; ++k) {//recheck
                    netInput += neuronLayers.get(i).getNeuron(j).getWeight(k);
                }//end for k
                //add in bias
                netInput += neuronLayers.get(i).getNeuron(j).getThreshhold();

                outputs.add(sigmoid(netInput, Parameters.ACTIVATION_RESPONSE));
                weight = 0;
            }//end for j
        }//end for i
        return outputs;
    }

    public static double sigmoid(double activation, double response){
        return (1 / (1 + Math.exp((-activation) / response))); //check signage
    }
}
