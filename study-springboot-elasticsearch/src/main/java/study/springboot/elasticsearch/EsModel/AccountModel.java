package study.springboot.elasticsearch.EsModel;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guyun
 * @package study.springboot.elasticsearch.EsModel
 * @class PayInfoModel
 * @date 2018/9/119:09
 * @description
 */
@Data
@Document(indexName = "asset", type = "account", shards = 3)
public class AccountModel implements Serializable {
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.text)
    private String userCode;

    @Field(type = FieldType.text)
    private String userName;

    @Field(type = FieldType.text, store = true)
    private String accountName;

    @Field(type = FieldType.text)
    private String accountCode;

    @Field(type = FieldType.Double)
    private BigDecimal balance;

    @Field(type = FieldType.Boolean)
    private Boolean isActive;

    @Field(type = FieldType.Date)
    private Date createTime;

    @Field(type = FieldType.Date)
    private Date updateTime;

}