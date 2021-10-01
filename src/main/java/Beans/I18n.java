package Beans;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {

    public ResourceBundle getLocale (String code) {
        switch (code) {
            case ("en"):
                return ResourceBundle.getBundle("messages", new Locale("en", "UK"));
            case ("no"):
                return ResourceBundle.getBundle("messages", new Locale("no", "NOR"));
            case ("es"):
                return ResourceBundle.getBundle("messages", new Locale("es", "SPA"));
            default:
                return ResourceBundle.getBundle("messages", new Locale("en", "UK"));
        }
    }

    public double convertCurrency (double price, String code){
        switch(code){
            case ("en"):
                return Math.round(price * 0.85);
            case ("no"):
                return Math.round(price * 10);
            case ("es"):
                return Math.round(price);
            default:
                return Math.round(price * 0.85);
        }
    }
}
