package ru.pogorelov.alexey;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        System.out.println(validate("Н664ОА99"));
        System.out.println(validateTestTask("4773ВА77"));
    }

    public static boolean validate(String st) {
        Pattern p = Pattern.compile("^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$");
        Matcher m = p.matcher(st);
        return m.find();
    }

    public static boolean validateTestTask(String st) {
        Pattern p = Pattern.compile("^\\d{4}(?<!0000)[АВЕКМНОРСТУХ]{2}\\d{2}$");
        Matcher m = p.matcher(st);
        return m.find();
    }
}