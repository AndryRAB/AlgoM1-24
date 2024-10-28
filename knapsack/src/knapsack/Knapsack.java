/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

/**
 *
 * @author ANDRY-PC
 */
public class Knapsack {

    public static void main(String[] args) {
        Probleme p = new Probleme(20)
                    .addObject(200, 4)
                    .addObject(250, 6)
                    .addObject(425, 7)
                    .addObject(450, 10)
                    .addObject(150, 2);
    
        System.out.println(randomKnapSack(p, 1000, 100000));
        doBacktracking(p, 0, new Solution(p));
    }
    public static Solution randomKnapSack(Probleme p, float target, int limit){
        
        for (int i = 0; i < limit; i++) 
        {
            Solution s = Solution.generateRandom(p);
            if ((s.getTotalWeight()<=p.getCapacity())&&(s.getTotalValue()>=target))
                return s;
        }
        return null;
    }
    
    public static void doBacktracking(Probleme p, int niv, Solution temp){
        if (niv==p.nbObjets()) {
            System.out.println(temp);
            return;
        }
        doBacktracking(p, niv+1, new Solution(temp));
        doBacktracking(p, niv+1, new Solution(temp).prendre(niv));
    }
  
}
