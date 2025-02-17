package questao01;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner leitorDeEntrada = new Scanner(System.in);

        while (true) {
            System.out.println("Digite, respectivamente, a altura e largura do retângulo a ser impresso.");

            int altura = leitorDeEntrada.nextInt();
            int largura = leitorDeEntrada.nextInt();

            imprimeRetangulo(altura, largura);

            leitorDeEntrada.nextLine();
            System.out.println("Digite '-1' para sair ou qualquer tecla para continuar.");
            String entrada = leitorDeEntrada.nextLine();

            if ("-1".equals(entrada)) {
                break;
            }
        }

        leitorDeEntrada.close();
    }

    private static void imprimeRetangulo(int altura, int largura) {
        if (altura <= 0 || largura <= 0) {
            System.out.println("Dimensões inválidas.");
            return;
        }

        imprimeLargura(largura);
        imprimeAltura(altura, largura);

        if (altura > 1) {
            imprimeLargura(largura);
        }
    }

    private static void imprimeLargura(int largura) {
        for (int i = 0; i < largura; i++) {
            System.out.print("X");
        }
        System.out.println();
    }

    private static void imprimeAltura(int altura, int largura) {
        for (int i = 0; i < altura - 2; i++) {
            imprimeLinhaMeio(largura);
        }
    }

    private static void imprimeLinhaMeio(int largura) {
        if (largura > 1) {
            System.out.print("X");
            for (int i = 0; i < largura - 2; i++) {
                System.out.print(" ");
            }
            System.out.println("X");
        } else {
            System.out.println("X");
        }
    }
}
