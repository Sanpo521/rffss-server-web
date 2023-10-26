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
@TableName("gy_market_regulated_information")
public class GyMarketRegulatedInformationEntity implements Serializable {
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
	 * 检查时间
	 */
	private Date inspectionTime;
	/**
	 * 是否发现问题0否1是
	 */
	private String didYouIssues;
	/**
	 * 市场所全覆盖监督检查情况文件id
	 */
	private Long marketCoverageUpid;
	/**
	 * 接受市场所产品质量行政处罚情况文件id
	 */
	private Long productQualityMarketUpid;

}
