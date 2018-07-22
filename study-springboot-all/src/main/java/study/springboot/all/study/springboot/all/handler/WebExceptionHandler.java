package study.springboot.all.study.springboot.all.handler;

import org.springframework.context.MessageSource;
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
    public ResponseContent handleException() {
        return new ResponseContent(1, "系统异常，请联系管理员");
    }
}
