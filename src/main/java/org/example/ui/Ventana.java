package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Ventana extends JFrame{

    private double total1 = 0.0;
    private double total2 = 0.0;

    private char op;


    private JPanel panel;
    private JButton porcentajeButton;
    private JButton powerButton;
    private JButton button9;
    private JButton restaButton;
    private JButton sumaButton;
    private JButton borrarButton;
    private JButton a1XButton;
    private JButton button7;
    private JButton button4;
    private JButton button1;
    private JButton divideButton;
    private JButton button8;
    private JButton button5;
    private JButton button2;
    private JButton CEButton;
    private JButton multButton;
    private JButton button6;
    private JButton cButton;
    private JButton button3;
    private JButton masMenosButton;
    private JButton button0;
    private JButton comaButton;
    private JButton igualButton;
    private JButton sqrtButton;

    private JTextField resTextField;
    private JLabel info;

    private void getOperador(String botonTexto){
        op=botonTexto.charAt(0);
        total1=Double.parseDouble(resTextField.getText());
        resTextField.setText("");
    }

    public Ventana(){
        this.setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setTitle("Calculadora");
        setLocationRelativeTo(null);
        setResizable(false);

        button0.addActionListener(e -> {
            String button0Text = button0.getText();
            resTextField.setText(resTextField.getText()+button0Text);
        });

        button1.addActionListener(e -> {
            String button1Text = button1.getText();
            resTextField.setText(resTextField.getText()+button1Text);
        });

        button2.addActionListener(e -> {
            String button2Text = button2.getText();
            resTextField.setText(resTextField.getText()+button2Text);
        });

        button3.addActionListener(e -> {
            String button3Text = button3.getText();
            resTextField.setText(resTextField.getText()+button3Text);
        });

        button4.addActionListener(e -> {
            String button4Text = button4.getText();
            resTextField.setText(resTextField.getText()+button4Text);
        });

        button5.addActionListener(e -> {
            String button5Text = button5.getText();
            resTextField.setText(resTextField.getText()+button5Text);
        });

        button6.addActionListener(e -> {
            String button6Text = button6.getText();
            resTextField.setText(resTextField.getText()+button6Text);
        });

        button7.addActionListener(e -> {
            String button7Text = button7.getText();
            resTextField.setText(resTextField.getText()+button7Text);
        });

        button8.addActionListener(e -> {
            String button8Text = button8.getText();
            resTextField.setText(resTextField.getText()+button8Text);
        });

        button9.addActionListener(e -> {
            String button9Text = button9.getText();
            resTextField.setText(resTextField.getText()+button9Text);
        });


        sumaButton.addActionListener(e -> {
            String botonTexto = sumaButton.getText();
            getOperador(botonTexto);
        });

        restaButton.addActionListener(e -> {
            String botonTexto = restaButton.getText();
            getOperador(botonTexto);
        });

        multButton.addActionListener(e -> {
            String botonTexto = multButton.getText();
            getOperador(botonTexto);
        });

        divideButton.addActionListener(e -> {
            String botonTexto = divideButton.getText();
            getOperador(botonTexto);
        });



        igualButton.addActionListener(e -> {
            switch (op) {
                case '+' -> total2 = total1 + Double.parseDouble(resTextField.getText());
                case '-' -> total2 = total1 - Double.parseDouble(resTextField.getText());
                case '*' -> total2 = total1 * Double.parseDouble(resTextField.getText());
                case '/' -> total2 = total1 / Double.parseDouble(resTextField.getText());
            }
            resTextField.setText(Double.toString(total2));
            total1=0;
        });

        CEButton.addActionListener(e -> {
            total2=0;
            resTextField.setText("");
        });


        comaButton.addActionListener(e -> {
            if (resTextField.getText().isEmpty()) {
                resTextField.setText("0.");
            } else if (!resTextField.getText().contains(".")) {
                resTextField.setText(resTextField.getText() + ".");
            }
        });

        masMenosButton.addActionListener(e -> {
            if (!resTextField.getText().isEmpty()) {
                double valor = Double.parseDouble(resTextField.getText());
                valor = -valor;
                resTextField.setText(Double.toString(valor));
            }
        });

        a1XButton.addActionListener(e -> {
            if (!resTextField.getText().isEmpty()) {
                double valor = Double.parseDouble(resTextField.getText());
                if (valor != 0) {
                    valor = 1 / valor;
                    resTextField.setText(Double.toString(valor));
                } else {
                    // Manejar el caso de división por cero aquí
                    resTextField.setText("Error");
                }
            }
        });

        sqrtButton.addActionListener(e -> {
            if (!resTextField.getText().isEmpty()) {
                double valor = Double.parseDouble(resTextField.getText());
                if (valor >= 0) {
                    valor = Math.sqrt(valor);
                    resTextField.setText(Double.toString(valor));
                } else {
                    // Manejar el caso de raíz cuadrada de número negativo aquí
                    resTextField.setText("Error");
                }
            }
        });

        cButton.addActionListener(e -> {
            resTextField.setText("");
            total1 = 0.0;
            total2 = 0.0;
            op = ' ';
        });

        borrarButton.addActionListener(e -> {
            String textoActual = resTextField.getText();
            if (!textoActual.isEmpty()) {
                textoActual = textoActual.substring(0, textoActual.length() - 1);
                resTextField.setText(textoActual);
            }
        });

        powerButton.addActionListener(e -> {
            if (!resTextField.getText().isEmpty()) {
                double valor = Double.parseDouble(resTextField.getText());
                valor = Math.pow(valor, 2);
                resTextField.setText(Double.toString(valor));
            }
        });

        porcentajeButton.addActionListener(e -> {
            if (!resTextField.getText().isEmpty()) {
                double valor = Double.parseDouble(resTextField.getText());
                valor = valor / 100.0;
                resTextField.setText(Double.toString(valor));
            }
        });




    }


    public void load(){
        this.setVisible(true);
    }

}
