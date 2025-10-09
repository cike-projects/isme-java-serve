package cn.dhbin.isme.pms;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import cn.dev33.satoken.exception.NotLoginException;
import cn.hutool.jwt.JWTException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionAdvice {

  @ResponseStatus(UNAUTHORIZED)
  @ExceptionHandler({NotLoginException.class, JWTException.class})
  public void notLoginException(Exception e) {}

}
