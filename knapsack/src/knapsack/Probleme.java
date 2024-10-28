/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.ArrayList;

public class Probleme {
    private final ArrayList<Float> value;
    private final ArrayList<Float> weight;
    private final float capacity;
    
    public Probleme(float capacity){
        value = new ArrayList<>();
        weight = new ArrayList<>();
        this.capacity = capacity;
    }
    public Probleme addObject(float value, float weight){
        this.value.add(value);
        this.weight.add(weight);
        return this;
    }
    public float getValue(int i){
        return value.get(i);
    }
    public float getWeight(int i){
        return weight.get(i);
    }
    public int nbObjets(){
        return weight.size();
    }
    public float getCapacity(){
        return capacity;
    }
}

