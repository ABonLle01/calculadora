package org.example;

import org.example.ui.Ventana;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var ventana = new Ventana();
        ventana.load();
    }
}