import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    public static boolean valueReg(String str) {
        Pattern pattern = Pattern.compile("^((\\s*)(\\d{1,2})(\\s*)+(\\+|-|\\*|/)(\\s*)+(\\d{1,2})(\\s*))|((\\s*)([IVX]{1,4})(\\s*)+(\\+|-|\\*|/)(\\s*)+([IXV]{1,4})(\\s*))$");
        Matcher matcher = pattern.matcher(str);
        boolean b;

        b = matcher.find();

        return b;
    }
}