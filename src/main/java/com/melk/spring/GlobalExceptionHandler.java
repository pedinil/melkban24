package com.melk.spring;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.JDBCException;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.orm.hibernate3.HibernateSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex) {
	logger.info("SQLException Occured:: URL=" + request.getRequestURL());
	return "database_error";
    }

    @ExceptionHandler(IOException.class)
    public void handleIOException() {
	logger.error("IOException handler executed");
	// returning 404 error code
    }

    @ExceptionHandler(QuerySyntaxException.class)
    public void QuerySyntaxException(QuerySyntaxException ex) {
	logger.error("QuerySyntaxException :" + ex.getMessage());
	// returning 404 error code
    }

    @ExceptionHandler(HibernateSystemException.class)
    public void HibernateException(HibernateSystemException ex) {
	logger.error("HibernateSystemException :" + ex.getMessage());
	// returning 404 error code
    }

    @ExceptionHandler(JDBCException.class)
    public void JDBCException(HttpServletRequest request, Exception ex) {
	logger.error("JDBCException :" + ex.getMessage() + "," + request.getRequestURL());
	// returning 404 error code
    }

    @ExceptionHandler(NullPointerException.class)
    public void NullPointerException(HttpServletRequest request, Exception ex) {
	logger.error("NullPointerException :" + ex.getMessage() + "," + request.getRequestURL());
	// returning 404 error code
    }

    @ExceptionHandler(Exception.class)
    public void Exception(HttpServletRequest request, Exception ex) {
	logger.error("Exception :" + ex.getMessage() + "," + request.getRequestURL());
	// returning 404 error code
    }

}