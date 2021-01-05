import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCompanies = scanner.nextInt();
        int[] income = new int[numCompanies];
        double[] taxesPerc = new double[numCompanies];
        for (int i = 0; i < numCompanies; i++) {
            income[i]  = scanner.nextInt();
        }
        for (int i = 0; i < numCompanies; i++) {
            taxesPerc[i]  = scanner.nextInt();
        }
        double maxTax = 0;
        int bestCompany = 0;
        for (int i = 0; i < numCompanies; i++) {
            double tax = income[i] * taxesPerc[i] / 100;
            if (tax > maxTax) {
                maxTax = tax;
                bestCompany = i + 1;
            }
        }
        System.out.println(bestCompany);


    }
}