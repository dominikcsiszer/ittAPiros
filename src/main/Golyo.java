package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Golyo implements ActionListener{
    private JFrame frame;
    private JButton gomb1;
    private JButton gomb2;
    private JButton gomb3, g;
    private JLabel cim, kiiras1;
    private JPanel panel1, panel2;
    int golyo;
    
    public Golyo(){
    ini();
}
    public void ini(){
        frame = new JFrame();
        frame.setSize(300,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        golyo = (int)(Math.random() * 3) +1;
        System.out.println(golyo);
        gomb1 = new JButton("1");
        gomb2 = new JButton("2");
        gomb3 = new JButton("3");
         
        cim = new JLabel("Itt a piros hol a piros");
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        panel1.add(cim);

        panel2.add(gomb1);  
        panel2.add(gomb2);
        panel2.add(gomb3);
        
        frame.getContentPane().add(panel1, BorderLayout.NORTH);
        frame.getContentPane().add(panel2, BorderLayout.SOUTH);
        
        gomb1.addActionListener(this);
        gomb2.addActionListener(this);
        gomb3.addActionListener(this);
    
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Golyo();
    }
        @Override
    public void actionPerformed(ActionEvent e) {
        g = (JButton) e.getSource();
        g.setEnabled(false);
        
        if(Integer.parseInt(g.getText()) == golyo) {
            g.setText("O");
            JOptionPane j = new JOptionPane();
            j.showMessageDialog(null, "Sikeresen eltalátad a golyót!", "Sikert", JOptionPane.INFORMATION_MESSAGE);
            ujra();
        } else
            g.setText("X");
    }
    
    public void ujra() {
        golyo = (int)(Math.random() * 3) +1;
        System.out.println(golyo);
        for (int i = 0; i < panel2.getComponentCount(); i++) {
            panel2.getComponent(i).setEnabled(true);
        }
        gomb1.setText("1");
        gomb2.setText("2");
        gomb3.setText("3");
    }
}
