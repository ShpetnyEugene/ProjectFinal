package com.gstu.utils;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * It contains methods that help display pages
 *
 * @author Shpetny Eugene
 * @version 1.0
 */

public class ViewUtils {

    private static final String PREFIX = "/WEB-INF/views/";
    private static final String SUFFIX = ".jsp";

    private static Logger log = Logger.getLogger(ViewUtils.class);

    /**
     * This method displays specified page
     *
     * @param viewName - Name displayed page views relative to the directory
     * @throws IllegalArgumentException - if page not found
     * @throws ServletException - if an exception occurs that interrupts normal work servlet
     */
    public static void doView(String viewName, HttpServletResponse response, HttpServletRequest request) {
        try {
            request.getRequestDispatcher(PREFIX + viewName + SUFFIX).forward(request, response);
        } catch (ServletException | IOException e) {
            log.error(e);
            throw new IllegalArgumentException(e);
        }
    }
}
