import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor, digite a altura: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida, você deve digitar um número decimal, 1,75 por exxemplo.");
            sc.next();
        }
        double altura = sc.nextDouble();
        System.out.print("Agora por favor, digite o peso: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida, você deve digitar um número decimal, 80 por exxemplo.");
            sc.next();
        }
        double peso = sc.nextDouble();

        double imc = calculaImc(altura, peso);
        String classificacao = classificaImc(imc);
        double pesoIdeal = calculaPesoIdeal(altura);

        String resultadoAdequado = retornaResultado(classificacao, pesoIdeal,imc);
        System.out.println(resultadoAdequado);

    }

    public static double calculaImc(double altura, double peso) {
        return peso / (altura * altura);
    }

    public static String classificaImc(double imc) {
        if (imc < 18.5) {
            return "Magreza";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Normal";
        } else if (imc >= 22 && imc < 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30.0 && imc < 34.9) {
            return "Obesidade grau I";
        } else if (imc >= 35.0 && imc < 39.9) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }

    public static double calculaPesoIdeal(double altura) {
        return (altura * altura) * 24.9;
    }

    public static String retornaResultado(String classificacao, double pesoIdeal, double imc) {
        if (classificacao.equals("Normal")) {
            return String.format("\nResultado:\n" +
                    "Seu IMC é de: %.2f kg/m²\n" +
                    "Parabéns!\n" +
                    "De acordo com a OMS, seu IMC é considerado %s.\n" +
                    "Para manter valor de IMC normal, seu peso deve ser de: %.2f kg."
                    , imc, classificacao, pesoIdeal);
        } else {
            return String.format("\nResultado:\n" +
                    "Seu IMC é de: %.2f kg/m²\n" +
                    "Atenção!\n" +
                    "De acordo com a OMS, seu IMC é considerado %s.\n" +
                    "Para ter o valor de IMC normal, seu peso deve ser de: %.2f kg.", imc, classificacao, pesoIdeal);
        }
    }
}



