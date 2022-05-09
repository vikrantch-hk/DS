/*************************************************************************
 * NOTE:  Please put END after all inputs 
 * 
 * 
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25

END
* 
*************************************************************************/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxCalculator {
    public static void main (String[] args) {
        try {
            Taxer taxer = new Taxer();
            taxer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Taxer {

    private String[] import_array =  {"import"},
                     base_array = {"book", "chocolate", "pills"};
    private Scanner scanner = new Scanner(System.in);
    private final Pattern p_input = Pattern.compile("^Input (\\d):"),
                          p_money = Pattern.compile("(\\sat) ([0-9]+\\.[0-9]+)"),
                          p_empty = Pattern.compile("^\\s*$");
    private final double TAX5 = .05,
                         TAX10 = .10;
    private double tax_group_sum = 0,
                   price_group_sum = 0,
                   price,
                   tax_import,
                   tax_base;
    private String line;

    public void run() {
        while(scanner.hasNext()) {
            analyzeLine();
        }
    }

    private void analyzeLine () {
        Matcher  m_input,
                 m_money,
                 m_empty;
        line = scanner.nextLine();
        m_input = p_input.matcher(line);
        m_money = p_money.matcher(line);
        m_empty = p_empty.matcher(line);
        price = 0;
        // heading
        if (m_input.find()) {
            System.out.println("Output " + m_input.group(1) + ":" );
        // line containing money amount
        } else if (m_money.find()) {
            line = m_money.replaceFirst(": ");
            price = Double.parseDouble(m_money.group(2));
            checkTaxed();
            checkImports();
            addValues();
            printLine();
        // empty line
        } else if(m_empty.find()) {
            printTotal();
            tax_group_sum = 0;
            price_group_sum = 0;
        } else {
            System.out.println(line);
        }
    }

    private boolean checkImports () {
        Pattern p;
        Matcher m;
        tax_import = 0;
        for (String s : import_array) {
            p = Pattern.compile(s);
            m = p.matcher(line);
            if(m.find()) {
                tax_import = roundSingleValue(price * TAX5);
                return true;
            }
        }
        return false;
    }

    private boolean checkTaxed() {
        Pattern p;
        Matcher m;
        tax_base = 0;
        for (String s : base_array) {
            p = Pattern.compile(s);
            m = p.matcher(line);
            if(m.find()) {
                return false;
            }
        }
        tax_base = roundSingleValue(price * TAX10);
        return true;
    }

    private double roundSingleValue (double value) {
        double accuracy = 20;
        value = value * accuracy;
        value = Math.ceil(value);
        value = value / accuracy;
        return value;
    }
    private void addValues () {
        double tax_total = tax_base + tax_import;
        price = price + tax_total;
        tax_group_sum += tax_total;
        price_group_sum += price;
    }

    private void printTotal () {
        System.out.printf("Sales Taxes: %.2f%n", tax_group_sum);
        System.out.printf("Total: %.2f%n%n", price_group_sum);
    }

    private void printLine () {
        System.out.print(line);
        System.out.printf("%.2f%n", price);
    }
}

/*
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25

END
*/

/*
Output 1:
1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 box of imported chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68

END
*/