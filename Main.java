import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int pagantes = Integer.parseInt(sc.nextLine().trim());
        List<Contribuinte> contribuintes = new ArrayList<>();

        for (int i = 1; i <= pagantes; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            String tipo = sc.nextLine().trim();

            System.out.print("Name: ");
            String nome = sc.nextLine();

            System.out.print("Annual income: ");
            double renda = Double.parseDouble(sc.nextLine().trim());

            if (tipo.equalsIgnoreCase("i")) {
                System.out.print("Health expenditures: ");
                double gastosSaude = Double.parseDouble(sc.nextLine().trim());
                contribuintes.add(new PessoaFisica(nome, renda, gastosSaude));
            } else if (tipo.equalsIgnoreCase("c")) {
                System.out.print("Number of employees: ");
                int funcionarios = Integer.parseInt(sc.nextLine().trim());
                contribuintes.add(new PessoaJuridica(nome, renda, funcionarios));
            } else {
                System.out.println("Invalid type. Please enter 'i' for individual or 'c' for company.");
                i--;
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        double total = 0.0;
        for (Contribuinte c : contribuintes) {
            double imposto = c.calculaImposto();
            total += imposto;
            System.out.printf("%s: $ %.2f%n", c.getNome(), imposto);
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f%n", total);

        sc.close();
    }
}
