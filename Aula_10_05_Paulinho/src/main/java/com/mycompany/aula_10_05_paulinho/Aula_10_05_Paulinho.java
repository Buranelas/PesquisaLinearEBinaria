package com.mycompany.aula_10_05_paulinho;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Aula_10_05_Paulinho {
    public static void main(String[] args) {
        
        String input  = JOptionPane.showInputDialog("Digite a quantidade de números a serem cadastrados: ");
        int[] vetor = new int [Integer.parseInt(input)];
        
        for (int i = 0; i < vetor.length; i++) {
            String numeros = JOptionPane.showInputDialog("Digite o " + (i+1) + "º número: ");
            vetor[i] = Integer.parseInt(numeros);
        }
        
       for(int i=0;i<vetor.length-1;i++){
            for(int j=0;j<vetor.length-i-1;j++){
                if(vetor[j]>vetor[j+1]){
                    int aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }
        
        input = JOptionPane.showInputDialog("Escolha o tipo de pesquisa:" + 
        "\n 1. Pesquisa Linear" +
        "\n 2. Pesquisa Binária");
        Integer.parseInt(input);
        
        int numeroPesquisado = Integer.parseInt(JOptionPane.showInputDialog("Digite o número a ser pesquisado: "));
        
        if (Integer.parseInt(input) == 1) {
            JOptionPane.showMessageDialog(null, "O número " + numeroPesquisado + " está na posição: " + "\n" +
                    pesquisaLinear(vetor, numeroPesquisado) + " do vetor");
        } else if (Integer.parseInt(input) == 2) {
            JOptionPane.showMessageDialog(null, "O número " + numeroPesquisado + " está na posição: " + "\n" +
                    pesquisaBinaria(vetor, numeroPesquisado) + " do vetor");
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }
    
    public static int pesquisaLinear(int[] numeros, int numeroPesquisado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroPesquisado) {
                return i;
            }
        }
        return -1; 
    }
    
    public static int pesquisaBinaria(int[] numeros, int numeroPesquisado) {
        int esquerda = 0;
        int direita = numeros.length - 1;
        
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (numeros[meio] == numeroPesquisado) {
                return meio;
            } else if (numeros[meio] < numeroPesquisado) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        
        return -1; 
    }
}