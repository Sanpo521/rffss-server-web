package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaoxiubin
 * @create 2022-11-03 9:56
 * @desc 受理审核实体类
 **/
@Data
@TableName("nf_checked")
public class NfCheckedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId
    private Long id;
    /**
     * 业务id: NfBusinEntity id
     */
    @NotBlank(message="业务ID不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String businid;
    /**
     * 受理审核人员
     */
    @NotBlank(message="受理审核人员不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 受理审核结果： 1 为不通过  2  为通过
     */
    @NotBlank(message="受理审核结果不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String cresult;
    /**
     * 受理审核意见
     */
    @NotBlank(message="受理审核意见不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String opinions;
    /**
     * 受理审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @NotBlank(message="受理审核时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Date ctime;
    /**
     * 受理审核类型: 1 为受理    2  为审核
     */
    private String ctype;
    /**
     * 最后操作时间
     */
    private Date lasttime;
    /**
     * 创建时间
     */
    private Date createtime;
}
