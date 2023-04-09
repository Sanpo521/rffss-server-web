package io.renren.modules.rffssw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaoxiubin
 * @create 2022-11-01 11:09
 * @desc 外网用户Token
 **/
@Data
@TableName("nf_wuser_token")
public class NfUserTokenEntity  implements Serializable {
    private static final long serialVersionUID = 1L;

    //用户ID
    @TableId(type = IdType.INPUT)
    private Long id;
    //token
    private String token;
    //过期时间
    private Date expireTime;
    //更新时间
    private Date updateTime;
}
