package com.gstu.tags;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class TextTag extends TagSupport {
    private static Logger log = Logger.getLogger(TextTag.class);
    private String value;

    private static final String LOCALE = "locale";

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int doStartTag() throws JspException {

        String locale;
        String lc = pageContext.getRequest().getParameter(LOCALE);


        HttpSession session = pageContext.getSession();
        System.out.println("SESSION : " + session.getAttribute("locale"));

        if (session.getAttribute(LOCALE) != null) {
            locale = (String) session.getAttribute(LOCALE);
        } else if (lc != null && !lc.equals("")) {
            locale = pageContext.getRequest().getParameter(LOCALE);
        } else {
            locale = "US";
        }
        ResourceBundle properties = ResourceBundle.getBundle("messages", Locale.forLanguageTag(locale));
        System.out.println("@@#   : " + Locale.forLanguageTag(locale));
        try {
            pageContext.getOut().write(properties.getString(value));
            } catch (IOException e) {
                e.printStackTrace();
                log.error(e);
            }
        return SKIP_BODY;
    }
}
