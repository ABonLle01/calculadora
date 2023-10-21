package org.example.ui;

import javax.swing.*;

public class VentanaCalculadora extends JFrame{

    //almacena el valor de las operaciones
    private double total = 0.0;

    //almacena el operador utilizado
    private char op = ' ';

    private JPanel panel;

    //botones de la calculadora
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

    // Campo de texto para mostrar resultados
    private JTextField resTextField;
    private JLabel info;

    //Indica si se ha producido un error en la calculadora
    private boolean error = false;
    //Indica si se inicia una nueva operacion
    private boolean nuevaOperacion = true;


    public VentanaCalculadora(){
        this.setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,500);
        setTitle("Calculadora");
        setLocationRelativeTo(null);
        setResizable(false);


        button0.addActionListener(e -> agregarNumero(button0));

        button1.addActionListener(e -> agregarNumero(button1));

        button2.addActionListener(e -> agregarNumero(button2));

        button3.addActionListener(e -> agregarNumero(button3));

        button4.addActionListener(e -> agregarNumero(button4));

        button5.addActionListener(e -> agregarNumero(button5));

        button6.addActionListener(e -> agregarNumero(button6));

        button7.addActionListener(e -> agregarNumero(button7));

        button8.addActionListener(e -> agregarNumero(button8));

        button9.addActionListener(e -> agregarNumero(button9));


        sumaButton.addActionListener(e -> operacionBasica('+'));

        restaButton.addActionListener(e -> operacionBasica('-'));

        multButton.addActionListener(e -> operacionBasica('*'));

        divideButton.addActionListener(e -> operacionBasica('/'));


        CEButton.addActionListener(e -> borrarEntradaActual());

        cButton.addActionListener(e -> reiniciarCalculadora());

        borrarButton.addActionListener(e -> borrarCaracter());


        masMenosButton.addActionListener(e -> cambiarSigno());

        a1XButton.addActionListener(e -> dividir());

        sqrtButton.addActionListener(e -> raizCuadrada());

        powerButton.addActionListener(e -> elevarCuadrado());

        porcentajeButton.addActionListener(e -> porcentaje());


        igualButton.addActionListener(e -> igual());

        comaButton.addActionListener(e -> añadirDecimal());

    }

//metodos de operaciones basicas------------------------------------------------------

    /**
     * Agrega un número al campo de texto cuando se pulsa en un botón numérico.
     *
     * @param b El botón numerico que se ha presionado.
     * Si hay un error previo, no se hace nada.
     * Si se inicia una nueva operación, establece el número del botón como valor en el campo de texto.
     * De lo contrario, agrega el número al valor existente en el campo de texto.
     */
    private void agregarNumero(JButton b) {
        if (error)
            return;
        if (nuevaOperacion) {
            resTextField.setText(b.getText());
            nuevaOperacion = false;
        } else {
            resTextField.setText(resTextField.getText() + b.getText());
        }
    }

    /**
     * Realiza una operación básica (+, -, *, /) cuando se pulsa sobre el botón correspondiente.
     *
     * @param operador El operador que representa la operación a realizar.
     */
    private void operacionBasica(char operador) {
        if (!error) {
            if (op != ' ') {
                realizarOperacion();
            }
            op = operador;
            total = Double.parseDouble(resTextField.getText());
            nuevaOperacion = true;
        }
    }

    /**
     * Realiza la operación pendiente con el número actual en el campo de texto y muestra el resultado.
     * La operación se basa en el operador previamente establecido.
     * Si el campo de texto contiene un número válido y no se está realizando una nueva operación, se realiza la operación y se muestra el resultado.
     * En caso de un formato de número incorrecto o una división por cero, se muestra un mensaje de error.
     * Después de la operacion, el operador se restablece a ' ' y se prepara la calculadora para una nueva operacion.
     */
    private void realizarOperacion() {
        if (!nuevaOperacion) {
            try {
                double numero = Double.parseDouble(resTextField.getText());
                switch (op) {
                    case '+' -> total += numero;
                    case '-' -> total -= numero;
                    case '*' -> total *= numero;
                    case '/' -> {
                        if (numero != 0) {
                            total /= numero;
                        } else {
                            resTextField.setText("Error: División por cero");
                            error = true;
                            return;
                        }
                    }
                }
                resTextField.setText(Double.toString(total));
            } catch (NumberFormatException ex) {
                resTextField.setText("Error: Formato de número incorrecto");
                error = true;
            }
        }
        op = ' ';
        nuevaOperacion = true;
    }


//metodos de borrado--------------------------------------------------------------

    /**
     * Borra la entrada actual en el campo de texto.
     */
    private void borrarEntradaActual() {
        resTextField.setText("");
        error=false;
    }

    /**
     * Borra el último carácter en el campo de texto actual.
     * Si el campo de texto no está vacío y no contiene un mensaje de error, se elimina el último carácter.
     */
    private void borrarCaracter() {
        String textoActual = resTextField.getText();
        if (!textoActual.isEmpty() && (!textoActual.startsWith("Error: "))) {
            textoActual = textoActual.substring(0, textoActual.length() - 1);
            resTextField.setText(textoActual);
        }
    }

    /**
     * Reinicia la calculadora a su estado inicial.
     * Establece el campo de texto en blanco, el operador a nulo (' '), el valor total a 0.0 y elimina cualquier error previo.
     */
    private void reiniciarCalculadora() {
        resTextField.setText("");
        total = 0.0;
        op = ' ';
        error=false;
    }


//metodos de otras operaciones------------------------------------------------------

    /**
     * Cambia el signo del número actual en el campo de texto.
     * Si el campo de texto no está vacío y no muestra un mensaje de error,
     * cambia el signo del número actual (positivo a negativo o viceversa) y actualiza el campo de texto con el nuevo valor.
     */
    private void cambiarSigno() {
        String textoActual = resTextField.getText();
        if (!resTextField.getText().isEmpty() && !textoActual.startsWith("Error: ") ) {
            double valor = Double.parseDouble(resTextField.getText());
            valor = -valor;
            resTextField.setText(Double.toString(valor));
        }
    }

    /**
     * Calcula el cuadrado del número actual en el campo de texto y muestra el resultado.
     * Si el campo de texto no está vacío y el número es válido, se eleva al cuadrado.
     * En caso de un formato de número incorrecto, se muestra un mensaje de error.
     */
    private void elevarCuadrado() {
        try {
            if (!resTextField.getText().isEmpty()) {
                double valor = Double.parseDouble(resTextField.getText());
                valor = Math.pow(valor, 2);
                resTextField.setText(Double.toString(valor));
            }
        } catch (NumberFormatException ex) {
            resTextField.setText("Error: Formato de número incorrecto");
            error=true;
        }
    }

    /**
     * Calcula la raíz cuadrada del número actual en el campo de texto y muestra el resultado.
     * Si el campo de texto no está vacío y el número es no negativo, se calcula la raíz cuadrada.
     * En caso de un formato de número incorrecto o un número negativo, se muestra un mensaje de error.
     */
    private void raizCuadrada() {
        if (!resTextField.getText().isEmpty()) {
            try {
                double valor = Double.parseDouble(resTextField.getText());
                if (valor >= 0) {
                    valor = Math.sqrt(valor);
                    resTextField.setText(Double.toString(valor));
                } else {
                    resTextField.setText("Error: Raíz cuadrada de número negativo");
                    error=true;
                }
            } catch (NumberFormatException ex) {
                resTextField.setText("Error: Formato de número incorrecto");
                error=true;
            }
        }
    }

    /**
     * Calcula el inverso (1/x) del número actual en el campo de texto y muestra el resultado.
     * Si el campo de texto no está vacío y el número es distinto de cero, se calcula el inverso.
     * En caso de un formato de número incorrecto o una división por cero, se muestra un mensaje de error.
     */
    private void dividir() {
        if (!resTextField.getText().isEmpty()) {
            try {
                double valor = Double.parseDouble(resTextField.getText());
                if (valor != 0) {
                    valor = 1 / valor;
                    resTextField.setText(Double.toString(valor));
                } else {
                    resTextField.setText("Error: División por cero");
                    error=true;
                }
            } catch (NumberFormatException ex) {
                resTextField.setText("Error: Formato de número incorrecto");
                error=true;
            }
        }
    }

    /**
     * Calcula el porcentaje del número actual en el campo de texto y muestra el resultado.
     * Si el campo de texto no está vacío, el número se divide por 100 para obtener el porcentaje.
     * En caso de un formato de número incorrecto, se muestra un mensaje de error.
     */
    private void porcentaje() {
        try {
            if (!resTextField.getText().isEmpty()) {
                double valor = Double.parseDouble(resTextField.getText());
                valor = valor / 100.0;
                resTextField.setText(Double.toString(valor));
            }
        } catch (NumberFormatException ex) {
            resTextField.setText("Error: Formato de número incorrecto");
            error=true;
        }
    }


//otros metodos---------------------------------------------------------------------------

    /**
     * Realiza la operación pendiente cuando se presiona el boton.
     * Si no hay un error previo y se ha establecido un operador, realiza la operación.
     */
    private void igual() {
        if (!error) {
            if (op != ' ') {
                realizarOperacion();
                nuevaOperacion=true;
            }
        }
    }

    /**
     * Añade un punto decimal al número actual en el campo de texto si no lo contiene.
     * Si el campo de texto no contiene un punto decimal y no muestra un mensaje de error, se agrega "0." al principio del número.
     */
    private void añadirDecimal() {
        String textoActual = resTextField.getText();
        if (!resTextField.getText().contains(".") && !textoActual.startsWith("Error: ")) {
            resTextField.setText("0."+resTextField.getText());
        }
    }



    public void load(){
        this.setVisible(true);
    }

}
