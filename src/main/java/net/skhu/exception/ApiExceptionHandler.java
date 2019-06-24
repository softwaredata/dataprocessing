package net.skhu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public void SQLIntegrityConstraintViolationException(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('아이디 혹은 비밀번호를 확인해주세요'); history.go(-1);</script>");
        out.flush();
    }

}
