/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojainformatica;

/**
 *
 * @author pedro
 */
public class Computador {
    private int IdComputador;
    private static String marca = "Pedro Augusto";
    private String HD;
    private String processador;

    public Computador() {
    }

    public Computador(String HD, String processador) {
        this.HD = HD;
        this.processador = processador;
    }

    public Computador(int IdComputador, String HD, String processador) {
        this.IdComputador = IdComputador;
        this.HD = HD;
        this.processador = processador;
    }
    
    public int getIdComputador() {
        return IdComputador;
    }

    public void setIdComputador(int IdComputador) {
        this.IdComputador = IdComputador;
    }
    
    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        Computador.marca = marca;
    }

    public String getHD() {
        return HD;
    }

    public void setHD(String HD) {
        this.HD = HD;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

}
