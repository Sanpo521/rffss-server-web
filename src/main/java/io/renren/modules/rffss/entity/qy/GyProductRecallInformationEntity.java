package io.renren.modules.rffss.entity.qy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:43
 */
@Data
@TableName("gy_product_recall_information")
public class GyProductRecallInformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
	/**
	 *
	 */
	private Long entId;
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
	/**
	 * 生产单位实施召回时间
	 */
	private Date recallTime;
	/**
	 * 实施召回原因
	 */
	private String reasonForRecall;
	/**
	 *
对召回产品保证产品质量采取的措施
	 */
	private String recalledProducts;

}
