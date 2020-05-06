
import java.util.Scanner;

public class Logic {

          String line;
          String[] numb;
          String number1;
          String number2;
          Scanner scanner = new Scanner(System.in);
          Numbers numbers = new Numbers();

    public Logic(){

        System.out.println("Введите 2 числа от 0 до 10 арабскими или римскими цифрами, по образцу: \n" +
            "1 + 1 или V - III или X * X или 3 / 4 " +
            " (римские цифры указываются заглавными буквами I, V, X)");

        while (true) {

        line = scanner.nextLine();

        if (Checker.valueReg(line)){
            numb = line.split("(\\+|-|\\*|/)");
            number1 = numb[0].replace(" ", "");
            number2 = numb[1].replace(" ", "");
            numbers.answer(number1, number2, numbers.simbol(line));
        } else
            numbers.tryAgain();
        }
    }
}