package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @create 2022-10-31 14:09
 * @desc 材料表实体类
 **/
@Data
@TableName("nf_material")
public class NfMaterialEntity implements Serializable {
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
     * 材料类型：
     * 10 冷藏冷冻贮存场所布局图
     * 20 法定代表人或者负责人身份证明复印件人像面
     * 21 法定代表人或者负责人身份证明复印件国徽面
     * 30 所提交资料真实性承诺书
     */
    @NotBlank(message="材料类型不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String mtype;
    /**
     * 同材料类型的顺序号
     */
    @NotBlank(message="顺序号不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "morder")
    private Integer name;
    /**
     * 材料地址
     */
    @NotBlank(message="材料地址不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @TableField(value = "mpath")
    private String url;
    /**
     * 最后操作时间
     */
    private Date lasttime;
    /**
     * 创建时间
     */
    private Date createtime;
}
