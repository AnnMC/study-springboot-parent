package study.springboot.all.study.springboot.all.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.springboot.all.study.springboot.all.content.ResponseContent;
import study.springboot.all.study.springboot.all.exception.BizException;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局的异常处理
 *
 * @ControllerAdvice注解：控制器增强，一个被@Component注册的组件。
 */
@RestControllerAdvice
public class WebExceptionHandler {
    /**
     * 业务异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    public ResponseContent handleBizException(HttpServletRequest request, BizException exception) {
        return new ResponseContent(1, exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseContent handleException(Exception e) {
        return new ResponseContent(1, e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseContent handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseContent(1, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
