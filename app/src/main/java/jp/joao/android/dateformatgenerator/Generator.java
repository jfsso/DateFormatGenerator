package jp.joao.android.dateformatgenerator;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Generator {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.printf("Syntax:\n" +
                    "  ./run.sh pattern\n" +
                    "  ./run.sh pattern [language_code ...]\n");
            System.exit(1);
            return;
        }

        String pattern = args[0];
        System.out.printf("pattern\t%s\n", pattern);

        Locale[] locales;
        if (args.length == 1)
            locales = Locale.getAvailableLocales();
        else {
            String[] argsLocales = Arrays.copyOfRange(args, 1, args.length);
            locales = new Locale[argsLocales.length];
            for (int i = 0; i < argsLocales.length; i++) {
                locales[i] = Locale.forLanguageTag(argsLocales[i]);
            }
        }

        for (Locale locale : locales) {
            String format = DateFormat.getBestDateTimePattern(locale, pattern);
            System.out.printf("%s\t%s\t%s\n", locale, format, new SimpleDateFormat(format, locale).format(new Date()));
        }
    }
}
