import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        do {

            Scanner scanner = new Scanner(System.in);
            String consoleInput = scanner.nextLine().trim().replaceAll(" ", "");
            String []  characters = new String[2];
            characters = consoleInput.split("[+\\-*/]");

            if (characters.length < 2 ) {
                throw new Exception("throws Exception //т.к. строка не является математической операцией");
            }
            else  if (characters.length > 2){
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            String x3 = consoleInput.substring(characters[0].length(), characters[0].length() + 1);
            int result, x1, x2;

            if ((!isPresent(characters[0]) & isPresent(characters[1])) | (!isPresent(characters[1]) & isPresent(characters[0]))){
                throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
            }
            else if (!(isPresent(characters[0]) & isPresent(characters[1]))) {
                 x1 = Integer.parseInt(characters[0]);
                 x2 = Integer.parseInt(characters[1]);
                System.out.println(calculateIt(x1,x2,x3));

            }

            else if ((isPresent(characters[0]) & isPresent(characters[1]))){
                 x1 = romanNumbers.valueOf(characters[0]).ordinal() + 1;
                 x2 = romanNumbers.valueOf(characters[1]).ordinal() + 1;
                 if ((calculateIt(x1,x2,x3)-1) < 1) {
                     throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
                 }
                System.out.println(romanNumbers.values()[calculateIt(x1,x2,x3)-1]);
            }





        } while (true);

    }

    static boolean isPresent(String n) {
        for (romanNumbers testEnum : romanNumbers.values()) {
            if (Objects.equals(testEnum.code, n)) {
                return true;
            }
        }
        return false;
    }
    static Integer  calculateIt (int x1, int x2, String x3) throws Exception {
        int result = 0 ;
        if (x1 > 0 && x1 <= 10 && x2 <= 10 && x2 > 0) {

            switch (x3) {
                case "+":
                    result = x1 + x2;
                    break;
                case "-":
                    result = x1 - x2;
                    break;
                case "*":
                    result = x1 * x2;
                    break;
                case "/":
                    result = x1 / x2;
                    break;
                default:
                    result = 999;

            }

        } else if (x1 > 10 | x2 > 10) {
            throw new Exception("throws Exception //т.к. вводятся числа больше 10");
        }
        return result;
    }
}

