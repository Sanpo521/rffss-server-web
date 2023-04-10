package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaoxiubin
 * @create 2022-11-03 9:28
 * @desc 操作记录实体表
 **/
@Data
@TableName("nf_opt")
public class NfOptEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 业务id: NfBusinEntity id
     */
    private String businid;
    /**
     * 操作模块名称
     */
    private String module;
    /**
     * 操作人员ID
     */
    private Long ouser;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 执行时长(毫秒)
     */
    private Long duration;
    /**
     * 操作时间
     */
    private Date otime;
}
