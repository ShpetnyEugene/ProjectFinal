package com.gstu.utils;

import com.gstu.dao.DataAccessException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewUtils {

    private static final String PREFIX = "/WEB-INF/views/";
    private static final String SUFFIX = ".jsp";


    private static Logger log = Logger.getLogger(ViewUtils.class);



    public static void doView(String viewName,HttpServletResponse response,HttpServletRequest request) {
        try {
            request.getRequestDispatcher(PREFIX + viewName + SUFFIX).forward(request,response);
        } catch (ServletException e) {
            log.error(e);
            // TODO
            throw new DataAccessException(e);
        } catch (IOException e) {
            log.error(e);
            // TODO
            throw new DataAccessException(e);
        }
    }

}
