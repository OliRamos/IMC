import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor, digite a altura: ");
        double altura = sc.nextDouble();
        System.out.print("Agora por favor, digite seu peso: ");
        double peso = sc.nextDouble();

        double imc = calculaImc(altura, peso);
        System.out.printf("Seu IMC é de: %.2f kg/m²\n", imc );

        String classificacao = classificaImc(imc);
        System.out.printf("A classificação de seu IMC é: %s\n", classificacao);

        double pesoIdeal = calculaPesoIdeal(altura);
        System.out.printf("Seu peso ideal é de %.2f kg.", pesoIdeal);




    }
    public static double calculaImc(double altura, double peso) {
        return peso / (altura * altura);
    }

    public static String classificaImc(double imc){
            if(imc < 18.5){
                return "Magreza";
        }
            else if(imc >= 18.5 && imc < 24.9){
                return "Normal";
        }
            else if (imc >= 22 && imc < 29.9){
                return "Sobrepeso";
            } else if (imc >= 30.0 && imc < 34.9) {
                return "Obesidade grau I";
            } else if (imc >= 35.0 && imc < 39.9) {
                return "Obesidade grau II";
            } else {
                return "Obesidade grau III";
        }

    }

    public static double calculaPesoIdeal(double altura){
        return (altura * altura) * 24.9;
    }


}
