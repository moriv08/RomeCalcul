import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {

    public String simbol( String str){
        for( int i =  0; i <  str.length(); i++){
        if (str.charAt(i) ==  '+'  ||  str.charAt(i) ==  '-'  ||  str.charAt(i) ==  '*'  ||  str.charAt(i) == '/')
            return str.valueOf(str.charAt(i));
        }
        return "";
    }

    public void answer( String a, String b, String simbol){

        Pattern wRoman = Pattern.compile("([IVX]{1,})");
        Matcher matcher1 = wRoman.matcher(a);

        boolean m1 =  matcher1.find();

        if (m1){
            isWRoman(a, b, simbol);
        } else {

            int i;
            int k;

            i = arabicNbr(a);
            k = arabicNbr(b);

            if ((i < 11 && i >= 0) && (k < 11 && k >= 0))
                switch (simbol) {
                    case "+":
                        System.out.println(i + k);
                        break;
                    case "-":
                        System.out.println(i - k);
                        break;
                    case "*":
                    System.out.println(i * k);
                        break;
                    case "/":
                        if (k ==  0) {
                            System.out.println("На ноль делить нельзя");
                            tryAgain();
                        } else {
                            if (i %  k != 0)
                                System.out.println((double) i /  k);
                            else
                                System.out.println(i / k);
                        }
                        break;
                    default:
                        tryAgain();
                }
            else {
                tryAgain();
            }
        }
    }

    public int arabicNbr( String src){

        int numb = 0;

        for( int i =  0; i <  src.length(); i++){

            numb *=  10;
            numb +=  src.charAt(i) - 48 ;
        }
            return numb;
    }

    public int romanNbr( String nbr){

        int ans = -1;

        if (nbr.equalsIgnoreCase("I")) ans =  1;

        else if (nbr.equalsIgnoreCase("II")) ans =  2;

        else if (nbr.equalsIgnoreCase("III")) ans =  3;

        else if (nbr.equalsIgnoreCase("IV")) ans =  4;

        else if (nbr.equalsIgnoreCase("V")) ans = 5;

        else if (nbr.equalsIgnoreCase("VI")) ans = 6;

        else if (nbr.equalsIgnoreCase("VII")) ans = 7;

        else if (nbr.equalsIgnoreCase("VIII")) ans = 8;

        else if (nbr.equalsIgnoreCase("IX")) ans = 9;

        else if (nbr.equalsIgnoreCase("X")) ans = 10;

        else {
            System.out.println("Данные римские цифры недопустимы");
        }

        return ans;
    }

    public void printRomanMns(int i){
        if (i == 0)
            System.out.println("Так-то должен быть 0, но римской цифры 0, вроде как нет(");
        else if (i ==  1)
            System.out.printf("I");
        else if (i ==  2)
            System.out.printf("II");
        else if (i ==  3)
            System.out.printf("III");
        else if (i ==  4)
            System.out.printf("IV");
        else if (i ==  5)
            System.out.printf("V");
        else if (i ==  6)
            System.out.printf("VI");
        else if (i ==  7)
            System.out.printf("VII");
        else if (i ==  8)
            System.out.printf("VIII");
        else if (i ==  9)
            System.out.printf("IX");
        else if (i ==  10)
            System.out.printf("X");
        }

    public void tryAgain(){
        System.err.println("Неправильно введены данные. Попробуйте ещё раз.\n");
        System.out.println("Введите 2 числа от 0 до 10 арабскими или римскими цифрами, по образцу: \n" +
        "1 + 1 или V - III или X * X или 3 / 4 " +
        " (римские цифры указываются заглавными буквами I, V, X)");
    }

    public void isWRoman( String a, String b, String simbol){

        int i;
        int k;

        i = romanNbr(a);
        k = romanNbr(b);

        switch (simbol){
            case "+":
                bigRomans(i +  k);
                break;
            case "-":
                if (i - k <  0){
                    System.out.printf("Не уверен, что римские цифры могут принимать отрицательное значение, поэтому либо это ошибка либо ответ = -");
                    printRomanMns(k - i);
                } else
                    printRomanMns(i - k);
                break;
            case "*":
                bigRomans(i * k);
                break;
            case "/":
                if (i %  k != 0)
                    System.out.println(a + " нельзя разделить на " + b + " без остатка. Римской цифры " + (((double) i) / k) + " нет");
                else
                    if (k ==  1)
                        printRomanMns(i);
                    else
                        printRomanMns(i / k);
                break;
            default:
                tryAgain();
        }
        System.out.println("\n");
    }

    public void bigRomans( int nbr){

        String sNumb =  String.valueOf(nbr);
        String sDigit;
        int lastNbr = 50;

        if (nbr <  40){
            for( int i =  10; i <  nbr; i+= 10){
                printRomanMns(10);
            }
        }
        else if (nbr > 39  &&  nbr <  90){
            if (nbr > 39  &&  nbr <  50){
                printRomanMns(10);
                lastNbr = 40;
            }
            System.out.printf("L");
            if (nbr != 50 && nbr != 40)
                bigRomans(nbr - lastNbr);
            return;
        }
        else if (nbr > 89) {
            sDigit =  (nbr ==  100) ? "C" :  "XC";
            System.out.printf(sDigit);
            return;
        }
        sDigit =  String.valueOf(sNumb.charAt(sNumb.length() -  1));
        lastNbr =  arabicNbr(sDigit);
        if (lastNbr == 0)
            lastNbr = 10;
        printRomanMns(lastNbr);
    }
}