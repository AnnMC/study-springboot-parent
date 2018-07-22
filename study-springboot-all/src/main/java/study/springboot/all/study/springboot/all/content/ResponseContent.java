package study.springboot.all.study.springboot.all.content;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回对象
 */
@ApiModel(value = "返回对象")
@Data
public class ResponseContent<T> {
    @ApiModelProperty(value = "返回code,1失败，0成功")
    private int code;

    @ApiModelProperty(value = "失败消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public ResponseContent() {
    }

    public ResponseContent(int code) {
        this.code = code;
    }

    public ResponseContent(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseContent(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseContent buildSuccess(String message) {
        return new ResponseContent(0, message);
    }

    public static <T> ResponseContent buildSuccess(String message, T data) {
        return new ResponseContent(0, message, data);
    }

    public static ResponseContent buildFial(String message) {
        return new ResponseContent(1, message);
    }
}
