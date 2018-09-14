package br.com.cadastroEmail;

import java.io.*;

public class Email implements Serializable  {
    
    private static final long serialVersionUID = 1;
    private static int contador = 0;
    private int numero;
    private String nome;
    private String email;
    
    public Email(String nome, String email){
        this.numero = ++contador;
        this.nome = nome;
        this.email = email;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public void imprime(){
        System.out.println(" Número : "  + getNumero() + "\n Nome : " + getNome() + "\n Email : " + getEmail());
    }
    
}
