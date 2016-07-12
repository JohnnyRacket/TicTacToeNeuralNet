package com.harrison.john.Game.Model;

/**
 * Created by John on 7/5/2016.
 */
public class TicTacToeSpace {

    private int marker = 0;

    public boolean addMarker(int marker){
        if(this.marker == 0){//dirty typecheckses
            this.marker = marker;
            return true;
        }else{
            return false;
        }
    }

    public void clearSpace(){
        marker = 0;
    }

    public int getMarker() {
        return marker;
    }

    public void setMarker(int marker) {
        this.marker = marker;
    }

    public String toString(){
        return Integer.toString(marker);
    }
}
