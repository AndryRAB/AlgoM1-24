/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ANDRY-PC
 */
public class Solution {
    private Probleme probleme;
    private int tab[];

    
    public Solution(Probleme probleme) {
        this.probleme = probleme;
        this.tab = new int[probleme.nbObjets()];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = 0;
        }
    }
    public Solution(Solution original) {
        this.probleme = original.probleme;
        this.tab = new int[probleme.nbObjets()];
       
        System.arraycopy(original.tab, 0, tab, 0, tab.length);
    }
    
    public Solution prendre(int index){
        this.tab[index] = 1;
        return this;
    }
    
    public float getTotalValue(){
        float total = 0.0f;
        for (int i = 0; i < tab.length; i++) {
            total+= tab[i]*probleme.getValue(i);
        }
        return total;
    }
    
    public float getTotalWeight(){
        float total = 0.0f;
        for (int i = 0; i < tab.length; i++) {
            total+= tab[i]*probleme.getWeight(i);
        }   
        return total;
    }
    
    public static Solution generateRandom(Probleme p){
        Solution s = new Solution(p);
        for (int i = 0; i < s.tab.length; i++) {
            if (Math.random()>0.5) s.tab[i] = 1; 
            else s.tab[i] = 0;
        }
        return s;
    }

    @Override
    public String toString() {
        return Arrays.toString(tab) + "\n\t. valeur:"+getTotalValue()+ "\n\t. poids:"+getTotalWeight();
    }
    
}
