package questao04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        recebeAMensagem();
    }

    public static void recebeAMensagem() {
        Scanner leitorDeEntrada = new Scanner(System.in);

        while (true) {
            System.out.println("Digite a mensagem:");

            String mensagem = leitorDeEntrada.nextLine();

            if ("-1".equals(mensagem)) {
                break;
            }

            System.out.println(criptografaAMensagem(mensagem));
        }
    }

    public static String criptografaAMensagem(String mensagem) {
        List<String> colunas = preparaAsColunas(mensagem);
        return adicionaOsAsteriscos(colunas);
    }

    public static List<String> preparaAsColunas(String mensagem) {
        int numeroDeColunas = 5;
        int numeroDeLinhas = (int) Math.ceil((double) mensagem.length() / numeroDeColunas);

        char[][] matriz = new char[numeroDeLinhas][numeroDeColunas];

        int index = 0;
        for (int i = 0; i < numeroDeLinhas; i++) {
            for (int j = 0; j < numeroDeColunas; j++) {
                if (index < mensagem.length()) {
                    matriz[i][j] = mensagem.charAt(index);
                    index++;
                } else {
                    matriz[i][j] = ' ';
                }
            }
        }

        List<String> palavrasResultantes = new ArrayList<>();
        for (int coluna = 0; coluna < numeroDeColunas; coluna++) {
            StringBuilder novaPalavra = new StringBuilder();
            for (int linha = 0; linha < numeroDeLinhas; linha++) {
                novaPalavra.append(matriz[linha][coluna]);
            }
            palavrasResultantes.add(novaPalavra.toString());
        }

        return palavrasResultantes;
    }

    public static String adicionaOsAsteriscos(List<String> palavras) {
        return String.join("*", palavras);
    }
}
