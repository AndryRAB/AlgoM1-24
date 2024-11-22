/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDRY-PC
 */
public class Puzzle {
    static HashSet<Noeud> mark = new HashSet<>();
    
     public static Noeud DFS2(Noeud depart){
        
        if (depart.isSuccess()) return depart;
        if (mark.contains(depart)) return null;
        mark.add(depart); 
         //System.out.println(depart);
        
        for (Noeud i : depart.getSucc()) {
            if (!mark.contains(i)) {
                //mark.add(i);
                Noeud tmp = DFS2(i);
                if (tmp!=null) return tmp;
            }
        }
        return null;
    }
     
     public static Noeud aStar(Noeud depart){
         HashSet<Noeud> closedList = new HashSet<>();
         PriorityQueue<Noeud> openList = new PriorityQueue<>();
         openList.add(depart);
         while(!openList.isEmpty()){
             Noeud current = openList.poll(); // extraction de l'élémen prio
             if (current.isSuccess()) return current;
             closedList.add(current);
             for (Noeud s : current.getSucc()) {
                 if (!closedList.contains(s)){
                     openList.add(s);
                 }
             }
         }
         return null; ///pas de chemin
     }
     
    public static void main(String[] args) {
        Noeud nd = new Noeud(new int[]{1,2,3,4,5,6,7,8,0});
        Noeud target = nd;
     /*   System.out.println(nd);
        for (Noeud i : nd.getSucc()) {
            System.out.println(i);
        }*/
        System.out.println(nd);
        nd = nd.akorotana(40);
        
        PuzzleUI ui = new PuzzleUI(nd);
        ui.setVisible(true);
        System.out.println(nd);
        nd = aStar(nd);
        
        LinkedList<Noeud> liste = new LinkedList<>();
        
        while (nd!=null){
         //   System.out.println(nd);
            nd = nd.getPred();
            liste.addFirst(nd);
        }
        for (Noeud noeud : liste) {
            ui.setNoeud(noeud);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Puzzle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ui.setNoeud(target);
        
        
    }
    
}
