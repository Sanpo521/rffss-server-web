package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 登记机关代码表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2021-11-26 18:23:52
 */
@Data
@TableName("code_organ")
public class CodeOrganEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 代码
	 */
	@TableId
	private String code;
	/**
	 * 机构名称
	 */
	private String name;
	/**
	 * 行政区划
	 */
	private String areacode;
	/**
	 * 电子印章编号
	 */
	private String sealid;
	/**
	 * 机构代码
	 */
	private String uniscid;
	/**
	 * 是否可用 1可用，0不可用
	 */
	private Integer enabled;
	/**
	 * 数据来源代码
	 */
	private String datasource;

	/**
	 * 父级代码
	 */
	private String parentcode;

	@TableField(exist = false)
	private Object subOrgans;
}
