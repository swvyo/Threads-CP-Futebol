package edu.br.cp.criancas;

public class Crianca extends Thread {
    //Declara��o dos atributos
	private String nome;
    //Defini��o do atributo do tempo que cada crian�a estar� com a bola
	private static int TIME_IN_MILLISECONDS = 1000;
    private static Boolean turn = false;
    private static Object bola = new Object(); 

    public Crianca(String nome) {
        this.nome = nome;
    }

    public void run() {

        synchronized (Crianca.bola) {
            
            try {
                while(Crianca.turn)
                    Crianca.bola.wait();

                Crianca.turn = true;

                System.out.println(this.nome + " esta com a bola");
                Thread.sleep(TIME_IN_MILLISECONDS);
                System.out.println(this.nome + " soltou a bola");
                
                Crianca.turn = false;
                Crianca.bola.notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    } 

}