
package com.mycompany.containereditor;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
//import java.awt.Color;
class CreateFrame{
    public static JFrame create(){
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(0xffffff));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,95);
        frame.setTitle("Test1");

        return frame;
    }
    public static JLabel createLabel(){
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);
        return label;
    }
    public static JLabel[] createLabelArray(){
        JLabel[] labelArray = new JLabel[4];
        for(int i = 0; i<labelArray.length; i++){
            labelArray[i] = createLabel();
        }
        return labelArray;
    }
}

public class ContainerEditor {

    public static void main(String[] args) {
        /*
        the first label
        */
        JFrame newFrame = CreateFrame.create();
        JLabel[] label = CreateFrame.createLabelArray();
        label[0].setText("The");
        label[1].setText("last");
        label[2].setText("word is");
        label[3].setText("big");

        label[0].setFont(new Font("SansSerif",Font.BOLD,15));
        label[1].setFont(new Font("SansSerif",Font.ITALIC,15));
        label[2].setFont(new Font("SansSerif",Font.BOLD,15));
        label[3].setFont(new Font("SansSerif",Font.BOLD,25));

        for(JLabel x : label){
            newFrame.add(x);
        }

    }
}