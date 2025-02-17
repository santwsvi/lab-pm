package questao05;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        recebeAMensagem();
    }

    public static void recebeAMensagem() {
        Scanner leitorDeEntrada = new Scanner(System.in);

        while (true) {
            System.out.println("Digite a mensagem criptografada:");
            String mensagemCriptografada = leitorDeEntrada.nextLine();

            if ("-1".equals(mensagemCriptografada)) {
                break;
            }

            if (!mensagemEhValida(mensagemCriptografada)) {
                System.out.println("Mensagem inválida! Envie uma mensagem dentro do padrão.");
                continue;
            }

            System.out.println(descriptografaAMensagem(mensagemCriptografada));
        }
    }

    public static boolean mensagemEhValida(String mensagem) {
        if (!mensagem.contains("*")) {
            return false;
        }

        String[] colunas = mensagem.split("\\*");
        int tamanhoEsperado = colunas[0].length();

        for (String coluna : colunas) {
            if (coluna.length() != tamanhoEsperado) {
                return false;
            }
        }

        return true;
    }

    public static String descriptografaAMensagem(String mensagemCriptografada) {
        String[] colunas = mensagemCriptografada.split("\\*");
        int numeroDeLinhas = colunas[0].length();
        int numeroDeColunas = colunas.length;

        char[][] matriz = new char[numeroDeLinhas][numeroDeColunas];

        for (int coluna = 0; coluna < numeroDeColunas; coluna++) {
            for (int linha = 0; linha < numeroDeLinhas; linha++) {
                matriz[linha][coluna] = colunas[coluna].charAt(linha);
            }
        }

        StringBuilder mensagemDescriptografada = new StringBuilder();
        for (int linha = 0; linha < numeroDeLinhas; linha++) {
            for (int coluna = 0; coluna < numeroDeColunas; coluna++) {
                mensagemDescriptografada.append(matriz[linha][coluna]);
            }
        }

        return mensagemDescriptografada.toString().trim();
    }
}
