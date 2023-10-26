package io.renren.modules.rffss.entity.qy;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-24 09:44:37
 */
@Data
@TableName("gy_mrdipqassi_municipal_bureau_double_randomness")
public class GyMrdipqassiMunicipalBureauDoubleRandomnessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 检查时间
	 */
	private Date inspectionTime;
	/**
	 * 是否发现问题(0否 1是)
	 */
	private String discoverProblems;
	/**
	 * 市局双随机监督检查情况
	 */
	private Long drsaibtmb;
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
