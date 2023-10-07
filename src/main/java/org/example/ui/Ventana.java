package org.example.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OptionalDataException;

public class Ventana extends JFrame{
    private JPanel panel;
    private JTextField texto;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a9Button;
    private JPanel columna1;
    private JPanel columna2;
    private JPanel columna3;
    private JButton sumar;
    private JButton restar;
    private JButton multiplicar;
    private JButton dividir;
    private JPanel operaciones;
    private JButton a0Button;
    private JButton igual;
    private JButton punto;
    private JPanel numeros;
    private JPanel arriba;
    private JPanel abajo;


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
