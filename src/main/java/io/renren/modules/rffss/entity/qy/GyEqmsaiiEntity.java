package io.renren.modules.rffss.entity.qy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:42
 */
@Data
@TableName("gy_eqmsaii")
public class GyEqmsaiiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
	/**
	 * 质量安全总监职位职责
	 */
	private Long jroqasd;
	/**
	 * 质量安全员岗守则
	 */
	private Long cocfaqso;
	/**
	 * 企业产品质量安全管控清单
	 */
	private Long epqascl;
	/**
	 * 日管控时间
	 */
	private String dailyControlTime;
	/**
	 * 是否进行日管控(0否 1是)
	 */
	private String isDailyControl;
	/**
	 * 产品质量安全日管控情况
	 */
	private Long dcopqas;
	/**
	 * 未进行管控原因
	 */
	private String rfnbc;
	/**
	 * 外键id
	 */
	private String entId;
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
