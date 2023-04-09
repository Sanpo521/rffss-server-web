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
 * @create 2022-11-01 17:20
 * @desc 代理人实体类
 **/
@Data
@TableName("nf_agent")
public class NfAgentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 业务id: NfBusinEntity id
     */
    @NotBlank(message="业务ID不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String businid;
    /**
     * 代理人姓名
     */
    @NotBlank(message="代理人姓名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 代理人联系方式
     */
    @NotBlank(message="代理人联系方式不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String mobile;
    /**
     * 最后操作时间
     */
    private Date lasttime;
    /**
     * 创建时间
     */
    private Date createtime;
}
