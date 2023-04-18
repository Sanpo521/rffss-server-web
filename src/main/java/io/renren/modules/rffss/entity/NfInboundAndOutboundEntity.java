package io.renren.modules.rffss.entity;



import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * 冷冻出库入库
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-04-18 09:58:55
 */
@Data
@TableName("nf_inbound_and_outbound")
public class NfInboundAndOutboundEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	/**
	 * 冷藏备案id
	 */
	private Long rffsspId;
	/**
	 * 0入库1出库
	 */
	private Integer type;
	/**
	 * 操作时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date operateTime;
	/**
	 * 1食品2食用农产品
	 */
	private Integer typesOf;
	/**
	 * 数量
	 */
	private Long num;
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createtime;
	/**
	 * 操作时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date lasttime;

}
