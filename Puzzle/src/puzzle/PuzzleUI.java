/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class PuzzleUI extends JFrame {
    Noeud nd;
    JLabel label[][];
    static Color TEXTE = Color.BLUE;
    static Color FOND = Color.YELLOW;
    public PuzzleUI(Noeud nd){
        label = new JLabel[3][3];
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(3,3));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                label[i][j] = new JLabel("_");
                label[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                label[i][j].setVerticalAlignment(SwingConstants.CENTER);
                label[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));;
                label[i][j].setBackground(FOND);
                label[i][j].setForeground(TEXTE);
                label[i][j].setFont(label[i][j].getFont().deriveFont(50.0f));
                label[i][j].setOpaque(true);
                this.add(label[i][j]);
            }   
        }
        this.nd = nd;
        this.update();
        setSize(400,400);
    }
    
    public void setNoeud(Noeud nd){
        this.nd = nd;
        update();
    }
    
    public void update(){
        if (nd!=null)
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (nd.getValue(i, j)!=0){
                        label[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));;
                        label[i][j].setBackground(FOND);
                        label[i][j].setForeground(TEXTE);
                        label[i][j].setText(""+nd.getValue(i, j));
                    }
                    else {
                        label[i][j].setBorder(null);
                        label[i][j].setBackground(Color.BLACK);
                        label[i][j].setForeground(Color.BLUE);
                        label[i][j].setText("");
                    }
                }
            }
    }
    
    
    
   

    
}
