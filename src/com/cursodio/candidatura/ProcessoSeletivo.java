package com.cursodio.candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        imprimirSelecionados();
    }
    static void entrandoEmContato (String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso!");
        } while (continuarTentando && tentativasRealizadas < 3);
        if (atendeu)
            System.out.println("Conseguimos contato com o(a) candidato(a) " + candidato + " na tentativa " +
                    tentativasRealizadas);
        else
            System.out.println("Não conseguimos contato com o(a) candidato(a) " + candidato);
    }
    static void selecaoCandidato () {
        String[] candidatos = {"Márcio", "Paulo", "Matheus", "Lucas", "Richard", "Daniela", "Isadora", "Geraldo"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidatos[candidatoAtual] + " solicitou este valor: " + salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static void imprimirSelecionados () {
        String[] candidatos = {"Márcio", "Paulo", "Matheus", "Lucas", "Richard"};
        System.out.println("Imprimindo os selecionados com seus indices: ");
        for (int i = candidatos.length-1; i >= 0; i--) {
            System.out.println("Candidato " + (i+1) + ": " + candidatos[i]);
        }
        System.out.println("Impressão abreviada: ");
        for (String candidato : candidatos) {
            System.out.println(candidato);
        }
    }
    static double valorPretendido () {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato (double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        }else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        }else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
    static boolean atender () {
        return new Random().nextInt(3)==1;
    }
}
