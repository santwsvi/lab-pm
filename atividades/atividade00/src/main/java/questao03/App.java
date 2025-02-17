package questao03;

import java.math.BigDecimal;
import java.util.*;

public class App {

    public static void main(String[] args) {
        recebeNotas();
    }

    public static void recebeNotas() {
        Scanner leitorDeEntrada = new Scanner(System.in);

        System.out.println("Digite as notas dos 4 exercícios realizados:");
        List<BigDecimal> notasExercicios = (List<BigDecimal>) segregaNotas(4, leitorDeEntrada);

        System.out.println("Digite a nota das 2 provas realizadas:");
        List<BigDecimal> notasProvas = (List<BigDecimal>) segregaNotas(2, leitorDeEntrada);

        System.out.println("Digite a nota do trabalho prático realizado:");
        BigDecimal notaTrabalho = (BigDecimal) segregaNotas(1, leitorDeEntrada);

        Map<String, Object> mapaGeralDeNotas = new HashMap<>();
        mapaGeralDeNotas.put("exercicios", notasExercicios);
        mapaGeralDeNotas.put("provas", notasProvas);
        mapaGeralDeNotas.put("trabalho", notaTrabalho);

        BigDecimal notaFinal = calculaNotaFinal(mapaGeralDeNotas);

        System.out.println("A nota final do aluno é: " + notaFinal);
    }

    public static Object segregaNotas(Integer quantidade, Scanner leitorDeEntrada) {
        if (quantidade < 2) {
            return BigDecimal.valueOf(leitorDeEntrada.nextInt());
        }

        List<BigDecimal> inputs = new ArrayList<>();

        while (inputs.size() < quantidade) {
            inputs.add(BigDecimal.valueOf(leitorDeEntrada.nextInt()));
            leitorDeEntrada.nextLine();
        }

        return inputs;
    }

    public static BigDecimal calculaNotaFinal(Map<String, Object> mapaGeralDeNotas) {
        List<BigDecimal> exercicios = (List<BigDecimal>) mapaGeralDeNotas.get("exercicios");
        List<BigDecimal> provas = (List<BigDecimal>) mapaGeralDeNotas.get("provas");
        BigDecimal trabalho = (BigDecimal) mapaGeralDeNotas.get("trabalho");

        BigDecimal somaExercicios = exercicios.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal mediaExercicios = somaExercicios.divide(BigDecimal.valueOf(exercicios.size()), BigDecimal.ROUND_HALF_UP);

        BigDecimal somaProvas = provas.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal mediaProvas = somaProvas.divide(BigDecimal.valueOf(provas.size()), BigDecimal.ROUND_HALF_UP);

        BigDecimal notaFinal = mediaExercicios.multiply(BigDecimal.valueOf(0.4))
                .add(mediaProvas.multiply(BigDecimal.valueOf(0.5)))
                .add(trabalho.multiply(BigDecimal.valueOf(0.1)));

        return notaFinal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
