package org.example.ui;

import javax.swing.*;

public class Ventana extends JFrame{
    private JPanel panel;
    private JButton porcent;
    private JButton powerButton;
    private JButton a9Button1;
    private JButton button4;
    private JButton button5;
    private JButton borrarButton;
    private JButton a1XButton;
    private JButton a7Button1;
    private JButton a4Button;
    private JButton a1Button;
    private JButton button11;
    private JButton a8Button1;
    private JButton a5Button;
    private JButton a2Button;
    private JButton CEButton;
    private JButton button16;
    private JButton a6Button;
    private JButton cButton;
    private JButton a3Button;
    private JButton button21;
    private JButton a0Button;
    private JButton button23;
    private JButton button24;
    private JButton sqrtButton;
    private JTextField textField1;


    public Ventana(){
        this.setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setTitle("Calculadora");
        setLocationRelativeTo(null);
        setResizable(false);

    }

    private Integer pulsarNumero(Integer n) {
        System.out.println("Boton "+n+" pulsado");
        return n;
    }


    public void load(){
        this.setVisible(true);
    }


}
