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
 * @date 2023-10-23 15:02:41
 */
@Data
@TableName("gy_ipli")
public class GyIpliEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
	/**
	 * 是否为工业产品许可证管理产品(0否 1是)
	 */
	private String iplmp;
	/**
	 * 工业产品生产许可证号
	 */
	private String ippln;
	/**
	 * 发证产品规格
	 */
	private String cpsamCode;
	/**
	 * 发证产品型号
	 */
	private String cpsamName;
	/**
	 * 发证机关
	 */
	private String issuingAuthority;
	/**
	 * 发证时间
	 */
	private Date dateOfIssuance;
	/**
	 * 有效期限
	 */
	private Date validityPeriod;
	/**
	 * 许可范围
	 */
	private String licenseScope;
	/**
	 * 是否为强制性认证产品(0否 1是)
	 */
	private String ccp;
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
