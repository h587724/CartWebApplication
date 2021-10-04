package Supplements;

import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShortTextTagHandler extends SimpleTagSupport {

    private StringWriter sw = new StringWriter();
    private String limit;

    public void doTag() throws JspException, IOException {
        if (limit != null) {
            getJspBody().invoke(sw);
            JspWriter out = getJspContext().getOut();
            out.print(limitText(Integer.parseInt(limit), sw.toString())+"...");
        } else {
            getJspBody().invoke(sw);
            JspWriter out = getJspContext().getOut();
            out.print(limitText(Integer.parseInt("10"), sw.toString())+"...");
        }
    }

    public void setLimit (String limit){
        this.limit = limit;
    }

    public String limitText (int limit, String text){
        return text.substring(0, Math.min(text.length(), limit));
    }
}
