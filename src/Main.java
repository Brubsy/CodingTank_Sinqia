/* Você deve construir um programa em Java que vai calcular as médias aritméticas e harmônicas de N números.
O seu programa deve solicitar ao usuário a quantidade de números a serem digitados e posteriormente todos os números que vão ser usados no cálculo das médias.
O programa deve realizar apenas uma das médias, aritmética ou harmônica, de movo que o usuário quem deve escolher qual das duas médias ele quer calcular. Caso o usuário digite ARITMETICA ele irá calcular a média aritmética, caso ele digite HARMONICA o programa deve calcular a média harmônica.
Ao final da execução do programa ele deve imprimir todos os números digitados, qual foi a média escolhida e qual o valor da média.
Lembrando que o usuário nem sempre vai fazer tudo aquilo que deve ser feito e seu programa deve dar a chance do usuário ficar tentando até conseguir executar o programa com sucesso.
O código da aplicação deve estar no GITHUB e a entrega será feita pelo link do projeto, lembre-se de deixa-lo público. A resposta deve ser o link do GITHUB.
Média harmônica: https://pt.wikipedia.org/wiki/M%C3%A9dia_harm%C3%B4nica */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i = 0;
        int totalNumbers;

        ArrayList<Double> listOfNumbers = new ArrayList<>();

        boolean notMean = true;

        double userNumber;
        double arithmeticMean;
        double harmonicMean;
        double arithmeticSum = 0;
        double harmonicSum = 0;

        System.out.println("Calculadora de média aritmética e harmônica.");
        System.out.print("Digite a quantidade de números de que você quer calcular a média: ");

        try {
            totalNumbers = sc.nextInt();

        } catch (InputMismatchException e){
            System.err.println("Operação inválida. Digite um número inteiro:");
            sc.nextLine();
            totalNumbers = sc.nextInt();
        }

        while (i < totalNumbers) {
            System.out.println("Digite os números a entrarem no cálculo:");

            try {
                userNumber = sc.nextDouble();

            } catch (InputMismatchException e){
                System.err.println("Operação inválida. Digite um número:");
                sc.nextLine();
                userNumber = sc.nextDouble();
            }

            listOfNumbers.add(userNumber);
            arithmeticSum += userNumber;
            harmonicSum += 1/userNumber;

            i++;
        }

        System.out.println("Qual das médias você quer calcular? Digite ARITMETICA ou HARMONICA.");

        while (notMean) {
            String chosenMean = sc.next();

            if ((chosenMean.equalsIgnoreCase("ARITMETICA")) || (chosenMean.equalsIgnoreCase("ARITMÉTICA"))) {
                arithmeticMean = arithmeticSum / totalNumbers;
                System.out.println("Seus números :" + listOfNumbers + ".\n" + "A média escolhida foi a aritmética.\nResultado da média aritmética: " + arithmeticMean + ".");
                notMean = false;

            } else if ((chosenMean.equalsIgnoreCase("HARMONICA")) || (chosenMean.equalsIgnoreCase("HARMÔNICA"))) {
                harmonicMean = totalNumbers / harmonicSum;
                System.out.println("Seus números :" + listOfNumbers + ".\n" + "A média escolhida foi a harmônica.\nResultado da média harmônica: " + harmonicMean + ".");
                notMean = false;

            } else {
                System.err.println("Operação inválida. Digite ARITMETICA ou HARMONICA.");
                sc.nextLine();
            }
        }
    }
}
