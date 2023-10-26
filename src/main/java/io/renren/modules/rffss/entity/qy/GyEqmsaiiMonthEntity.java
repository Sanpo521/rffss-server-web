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
 * @date 2023-10-23 15:02:40
 */
@Data
@TableName("gy_eqmsaii_month")
public class GyEqmsaiiMonthEntity implements Serializable {
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
	 * 月调度时间
	 */
	private String monthlySchedulingTime;
	/**
	 * 是否进行月调度(0否 1是)
	 */
	private String isMonthlyScheduling;
	/**
	 * 产品质量月调度情况
	 */
	private Long dcopqas;
	/**
	 * 未进调度原因
	 */
	private String rfns;
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
