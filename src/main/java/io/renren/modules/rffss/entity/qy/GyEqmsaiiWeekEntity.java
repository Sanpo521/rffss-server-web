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
 * @date 2023-10-23 15:02:41
 */
@Data
@TableName("gy_eqmsaii_week")
public class GyEqmsaiiWeekEntity implements Serializable {
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
	 * 周排查时间
	 */
	private String weeklyInspectionTime;
	/**
	 * 是否进行周排查(0否 1是)
	 */
	private String isWeeklyInspection;
	/**
	 * 产品质量周排查情况
	 */
	private Long dcopqas;
	/**
	 * 未进行排查原因
	 */
	private String rfnci;
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
