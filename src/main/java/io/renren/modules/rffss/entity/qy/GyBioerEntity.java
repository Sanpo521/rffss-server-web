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
@TableName("gy_bioer")
public class GyBioerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
	/**
	 * 企业名称
	 */
	private String name;
	/**
	 * 生产单位(0否 1是)
	 */
	private String productionUnit;
	/**
	 * 销售单位(0否 1是)
	 */
	private String salesUnit;
	/**
	 * 统一社会信用代码
	 */
	private Long unifiedSocialCreditCode;
	/**
	 * 企业注册地址
	 */
	private String address;
	/**
	 * 企业生产经营地址
	 */
	private String productAddress;
	/**
	 * 法定代表人
	 */
	private String legalRepresentative;
	/**
	 * 法定代表人（与注册信息保持一样）
	 */
	private String legalRepresentativeTwo;
	/**
	 * 生产经营范围
	 */
	private String productionAndBusinessScope;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 区
	 */
	private String distinguish;
	/**
	 * 登记机关
	 */
	private String cityregistrationAuthority;
	/**
	 * 企业质量安全管理类别
	 */
	private String categoryOfEnterpriseQualityAndSafetyManagement;
	/**
	 * 身份证号
	 */
	private String idNumber;
	/**
	 * 任职时间
	 */
	private Date durationOfEmployment;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 入库原因
	 */
	private String reasonForStorage;
	/**
	 * 入库原因code
	 */
	private String reasonForStorageCode;
	/**
	 * 两个规定落实情况
	 */
	private String implementationOfTwoRegulations;
	/**
	 * 两个规定落实情况code
	 */
	private String implementationOfTwoRegulationsCode;
	/**
	 * 监管级别
	 */
	private String regulatoryLevel;
	/**
	 * 监管级别code
	 */
	private String regulatoryLevelCode;
	/**
	 * 风险等级
	 */
	private String riskLevel;
	/**
	 * 风险等级code
	 */
	private String riskLevelCode;
	/**
	 * 监管措施
	 */
	private String regulatoryMeasures;
	/**
	 * 监管措施code
	 */
	private String regulatoryMeasuresCode;
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
