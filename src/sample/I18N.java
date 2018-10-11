package sample;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Singleton Helper class for I18N.
 */
public class I18N {

    private ResourceBundle rb;
    private Locale l;
    private static I18N ourInstance = new I18N();

    public static I18N getInstance() {
        return ourInstance;
    }


    void setLocale(Locale lo) {
        l = lo;
        rb = ResourceBundle.getBundle("sample.Resources.Resource", l);
    }

    public Locale getLocale () {
        return l;
    }

    public ResourceBundle getResources () {
        return rb;
    }

    private I18N() {

    }
}
