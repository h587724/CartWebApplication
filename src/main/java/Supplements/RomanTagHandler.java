package Supplements;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.util.TreeMap;

public class RomanTagHandler extends TagSupport {

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    private String since;
    protected String copyright = "\u00a9";
    protected StringWriter sw = new StringWriter();

    public void doTag() throws JspException, IOException {
        if (since != null){
            JspWriter out = pageContext.getOut();
            out.print(copyright + " " + toRoman(Integer.parseInt(since)));
        }
    }

    public final static String toRoman (int year) {
        int match = map.floorKey(year);
        if (year == match){
            return map.get(year);
        }
        return map.get(match) + toRoman(year-match);
    }

    public void setSince (String since){
        this.since = since;
    }

}
