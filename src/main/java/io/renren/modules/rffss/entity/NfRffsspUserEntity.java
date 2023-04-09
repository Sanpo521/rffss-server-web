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
 * @create 2022-11-03 13:40
 * @desc 外网用户与主体关联表
 **/
@Data
@TableName("nf_rffssp_user")
public class NfRffsspUserEntity  implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 冷藏冷冻食品贮存服务提供者id: NfRffsspEntity id
     */
    @NotBlank(message="备案ID不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String rffsspid;
    /**
     * 用户ID
     */
    @NotBlank(message="用户ID不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long userid;
    /**
     * 状态  0：解绑   1：正常
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 最后操作时间
     */
    private Date lasttime;
}
