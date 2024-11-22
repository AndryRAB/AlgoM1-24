/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author ANDRY-PC
 */
public class Noeud implements Comparable<Noeud>{
    private int nombres[] = new int[9];
    private Noeud pred;
    private int d;
    
    public Noeud(int []depart){
        nombres = Arrays.copyOf(depart, 9);
        pred = null;
        d = 0;
    }
    
    public Noeud getPred(){
        return this.pred;
    }
    
    public Noeud akorotana(int n){
        if (n==0) return this;
        int aleatoire = (int)(100*Math.random());
        return (this.getSucc().get(aleatoire%(this.getSucc().size()))).akorotana(n-1);
    }
    
    private Noeud(Noeud pred, int i1, int j1, int i2, int j2){
        this.pred = pred;
        this.nombres = Arrays.copyOf(pred.nombres, 9);
        int tmp = nombres[i1*3+j1]; /// tmp = nombres[i1][j1]
        nombres[i1*3+j1] = nombres[i2*3+j2];
        nombres[i2*3+j2] = tmp;
        this.d = pred.d+1; //cf A*
    }
    
    public ArrayList<Noeud> getSucc(){
        int pos;
        for (pos = 0; nombres[pos]!=0; pos++);
        ArrayList<Noeud> output = new ArrayList<>();
        int i = pos/3;
        int j = pos%3;
        if (i>0) output.add(new Noeud(this,i,j,i-1,j));
        if (i<2) output.add(new Noeud(this,i,j,i+1,j));
        if (j>0) output.add(new Noeud(this,i,j,i,j-1));
        if (j<2) output.add(new Noeud(this,i,j,i,j+1));
        return output;
    }
    
    public int getValue(int i, int j){
        return nombres[i*3+j];
    }
    
    public boolean isSuccess(){
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i]!=(i+1)%9) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < nombres.length; i++) {
            out+=nombres[i];
            if ((i+1)%3==0) out+="\n";
            else out+="\t";
        }
        return out;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.nombres);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Noeud other = (Noeud) o;
        if (!Arrays.equals(this.nombres, other.nombres)) {
            return false;
        }
        return true;
    }
    
    public int h(){
        int dist = 0;
        for (int i = 0; i < 9; i++) {
            if (nombres[i]!=(i+1)%9) dist++;
        }
        return dist; 
    }

    @Override
    public int compareTo(Noeud autre) {
        return (this.d+this.h())-(autre.d+autre.h());
    }
    
    
}
