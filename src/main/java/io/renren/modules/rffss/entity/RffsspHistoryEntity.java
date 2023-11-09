package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 冷藏冷冻食品贮存服务提供者
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:16
 */
@Data
@TableName("nf_rffssp_history")
public class RffsspHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 冷藏冷冻食品贮存服务提供者ID
	 */
	@TableId
	private String id;

	/**
	 * 冷藏冷冻食品贮存服务提供者ID
	 */
	private String realid;
	/**
	 * 状态 1 录入  2 提交  3 业务完成
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 最后操作时间
	 */
	private Date lasttime;
	/**
	 * 是否有效：1有效 0无效
	 */
	private Integer valid;
	/**
	 * 管理机构ID
	 */
	private String issueorg;
	/**
	 * 办理备案日期
	 */
	private Date applyTime;
	/**
	 * 申请人姓名
	 */
	private String applyName;
	/**
	 * 申请人联系方式
	 */
	private String applyContactInfo;
	/**
	 * 统一社会信用代码
	 */
	private String uniscId;
	/**
	 * 从事冷藏冷冻食品贮存业务的非食品生产经营者名称
	 */
	private String storageEntName;
	/**
	 * 法定代表人（负责人）
	 */
	private String leRep;
	/**
	 * 法定代表人（负责人）身份证号码
	 */
	private String leRepNo;
	/**
	 * 联系人
	 */
	private String contractName;
	/**
	 * 联系电话
	 */
	private String contractTel;
	/**
	 * 冷藏冷冻库名称
	 */
	private String storageName;
	/**
	 * 冷藏冷冻库地址（省）代码
	 */
	private String storageProvince;
	/**
	 * 冷藏冷冻库地址（省）
	 */
	private String storageProvName;
	/**
	 * 冷藏冷冻库地址（市）代码
	 */
	private String storageCity;
	/**
	 * 冷藏冷冻库地址（市）
	 */
	private String storageCityName;
	/**
	 * 冷藏冷冻库地址（区/县）代码
	 */
	private String storageCounty;
	/**
	 * 冷藏冷冻库地址（区/县）
	 */
	private String storageCountyName;
	/**
	 * 冷藏冷冻库详细地址
	 */
	private String storageAddress;
	/**
	 * 贮存能力（单位：吨）
	 */
	private String storagePowerTon;
	/**
	 * 贮存能力（单位：立方米）
	 */
	private String storagePowerCubicMeter;
	/**
	 * 备案编号
	 */
	private String recNum;
	/**
	 * 备案日期
	 */
	private Date recTime;
	/**
	 * 入库时间
	 */
	private Date entryTime;
	/**
	 * （贮存能力）是否符合食品安全标准
	 */
	private String safetyStandards;
	/**
	 * （贮存能力）贮存面积
	 */
	private String storageArea;
	/**
	 * （贮存能力）贮存容积
	 */
	private String storageCapacity;
	/**
	 * （贮存能力）冷藏冷冻设施、设备名称规格及数量
	 */
	private String equipmentNameSpecification;
	/**
	 * （贮存能力）温度、湿度控制范围
	 */
	private String humidityControlRange;
	/**
	 * （贮存能力）可正确显示内部温度的温度计和外显式温度计数量
	 */
	private String bumberExplicitThermometers;
	/**
	 * （贮存能力）贮存设备、容器和工具是否无毒无害、保持清洁
	 */
	private String keepClean;
	/**
	 * （贮存能力）是否分区分架分类存放食品，是否离地离墙10cm
	 */
	private String isGround;
	/**
	 * 是否有校验消毒清洁维护制度及记录
	 */
	private String isDisinfect;
	/**
	 * 其他非食品类贮存品类别
	 */
	private String otherCategories;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 注销原因
	 */
	private String canclecause;

}
