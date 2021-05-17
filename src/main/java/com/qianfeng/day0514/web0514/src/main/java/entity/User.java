package entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sweeney 2021/5/14 17:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {

    Integer id;
    String name;
    String password;
    String tel;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    Date lastLoginTime;
}
