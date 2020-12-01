package edu.br.cp.main;

import edu.br.cp.criancas.Crianca;

public class Main {
    public static void main(String[] args) {
    	//Instanciar a thread crianca e definição da quantidade de threads
        for (int i = 0; i < 10; ++i)
            new Crianca("Jogador #" + (i + 1)).start();
    }
}