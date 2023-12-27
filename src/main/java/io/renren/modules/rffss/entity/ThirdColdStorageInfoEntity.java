package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * oracle保存
 * @author zzb
 */
@Data
@TableName("infoshar_1458931363")
public class ThirdColdStorageInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 从事对温度、湿度等有特殊要求食品贮存业务的非食品生产经营者备案信息主键
	 */
	@TableId
	private String thirdcoldstorageinfoid;
	/**
	 * 办理备案日期 YYYYMMDD
	 */
	private Date applytime;
	/**
	 * 申请人姓名
	 */
	private String applyname;
	/**
	 * 申请人联系方式
	 */
	private String applycontactinfo;
	/**
	 * 代理人姓名
	 */
	private String proxyname;
	/**
	 * 代理人联系方式
	 */
	private String proxycontactinfo;
	/**
	 * 统一社会信用代码,要与营业执照的统一社会信用代码保持一致
	 */
	private String uniscid;
	/**
	 * 从事冷藏冷冻食品贮存业务的非食品生产经营者名称,要与营业执照的市场主体名称保持一致
	 */
	private String storageentname;
	/**
	 * 法定代表人（负责人）,要与营业执照的法定代表人保持一致
	 */
	private String lerep;
	/**
	 * 联系电话
	 */
	private String contractname;
	/**
	 * $column.comments
	 */
	private String contracttel;
	/**
	 * 冷藏冷冻库名称
	 */
	private String storagename;
	/**
	 * 冷藏冷冻库地址（省）代码
	 */
	private String storageprovince;
	/**
	 * 冷藏冷冻库地址（省）
	 */
	private String storageprovname;
	/**
	 * 冷藏冷冻库地址（市）代码
	 */
	private String storagecity;
	/**
	 * 冷藏冷冻库地址（市）
	 */
	private String storagecityname;
	/**
	 * 冷藏冷冻库地址（区/县）代码
	 */
	private String storagecounty;
	/**
	 * 冷藏冷冻库地址（区/县）
	 */
	private String storagecountyname;
	/**
	 * 冷藏冷冻库详细地址
	 */
	private String storageaddress;
	/**
	 * 贮存能力（单位：吨）
	 */
	private Double storagepowerton;
	/**
	 * 贮存能力（单位：立方米）
	 */
	private Double storagepowercubicmeter;
	/**
	 * 备案编号,按照冷藏冷冻库编号，一库一号
	 */
	private String recnum;
	/**
	 * 备案日期  YYYYMMDD
	 */
	private Date rectime;
	/**
	 * 市场监管部门代码  C9
	 */
	private String handleunitcode;
	/**
	 * 市场监管部门名称
	 */
	private String handleunit;
	/**
	 * 受理人
	 */
	private String receiver;
	/**
	 * 入库时间,YYYYMMDDhhmmss,默认系统生成当前时间
	 */
	private Date entrytime;

}
