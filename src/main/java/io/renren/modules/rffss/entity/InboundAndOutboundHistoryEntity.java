package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:17
 */
@Data
@TableName("nf_inbound_and_outbound_history")
public class InboundAndOutboundHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;

	private Long realid;
	/**
	 * 冷藏备案id
	 */
	private String rffsspId;
	/**
	 * 0入库1出库
	 */
	private Integer type;
	/**
	 * 操作时间
	 */
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
	private Date createtime;
	/**
	 * 操作时间
	 */
	private Date lasttime;

}
