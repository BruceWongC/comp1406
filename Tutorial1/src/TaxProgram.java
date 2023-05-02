import java.util.Scanner;
public class TaxProgram {
    public static void main(String args[]) {
        double income, fedTax, provTax;
        int dependents;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your taxable income: ");
        income = input.nextDouble();
        System.out.print("Please enter your number of dependents: ");
        dependents = input.nextInt();
        System.out.println();
        fedTax = 0.0;
        provTax = 0.0;

        if (income <= 29590){
            fedTax = 0.17 * income;
        }
        else if ((income > 29590) && (income <59180)) {
            fedTax = (0.17 * 29590) + (0.26 * (income - 29590));
        }
        else {
            fedTax = (0.17 * 29590) + (0.26 * 29590) + (0.29 * (income - 59180));
        }

        double base, deduction;

        base = 0.425 * fedTax;
        deduction = 160.5 + 328 * dependents;

        if (base < deduction){
            provTax = 0;
        }
        else {
            provTax = base - deduction;
        }

        String strfedtax = "$" + String.format("%,.2f",fedTax);

        String strTotaltax = "$" + String.format("%,.2f",(fedTax + provTax));


        System.out.println("Here is your tax breakdown:\n");

        System.out.println(String.format("%-18s$%,9.2f","Income",income));

        System.out.println(String.format("Dependents %17d" ,dependents));

        System.out.println("----------------------------");

        System.out.println(String.format("Federal Tax %16s", strfedtax));

        System.out.println(String.format("%-19s$%,8.2f","Provincial Tax",provTax));

        System.out.println("============================");

        System.out.println(String.format("Total Tax %18s", strTotaltax));

    }
}