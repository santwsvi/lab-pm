package questao02;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner leitorDeEntrada = new Scanner(System.in);

        while (true) {
            System.out.println("=============================================");
            System.out.println("1 - Somar dois números");
            System.out.println("2 - O maior de dois números");
            System.out.println("3 - Somar N números");
            System.out.println("4 - Contador de pares de uma sequência");
            System.out.println("0 - Sair");
            System.out.println("=============================================");
            System.out.print("Opção: ");

            int opcaoSelecionada = lerInteiroValido(leitorDeEntrada);

            if (opcaoSelecionada == 0) {
                System.out.println("Saindo...");
                leitorDeEntrada.close();
                break;
            }

            if (opcaoSelecionada < 0 || opcaoSelecionada > 4) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            selecionaOpcao(opcaoSelecionada, leitorDeEntrada);
        }
    }

    public static void selecionaOpcao(int opcaoSelecionada, Scanner leitorDeEntrada) {
        List<Integer> numeros = obtemListaDeNumeros(leitorDeEntrada);

        switch (opcaoSelecionada) {
            case 1 -> System.out.println("Soma dos números: " + somaNumeros(numeros));
            case 2 -> System.out.println("Maior número: " + verificaOMaior(numeros));
            case 3 -> System.out.println("Soma dos números: " + somaNumeros(numeros));
            case 4 -> System.out.printf("Números pares: %s (%s)%n", contaOsPares(numeros), exibeOsPares(numeros));
        }
    }

    public static List<Integer> obtemListaDeNumeros(int quantidade, Scanner leitorDeEntrada) {
        List<Integer> inputs = new ArrayList<>();

        System.out.println("Digite " + quantidade + " número(s):");
        while (inputs.size() < quantidade) {
            inputs.add(lerInteiroValido(leitorDeEntrada));
        }
        return inputs;
    }

    public static List<Integer> obtemListaDeNumeros(Scanner leitorDeEntrada) {
        System.out.print("Quantos números deseja inserir? ");
        int quantidade = lerInteiroValido(leitorDeEntrada);
        return obtemListaDeNumeros(quantidade, leitorDeEntrada);
    }

    public static int somaNumeros(List<Integer> numeros) {
        return numeros.stream().mapToInt(Integer::intValue).sum();
    }

    public static int verificaOMaior(List<Integer> numeros) {
        return numeros.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Não há números na lista."));
    }

    public static int contaOsPares(List<Integer> numeros) {
        return (int) numeros.stream()
                .filter(n -> n % 2 == 0)
                .count();
    }

    public static String exibeOsPares(List<Integer> numeros) {
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        return pares.isEmpty() ? "Nenhum número par encontrado." :
                pares.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));
    }

    public static int lerInteiroValido(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
