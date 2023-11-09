package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 业务表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:17
 */
@Data
@TableName("nf_busin_history")
public class BusinHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 业务ID
	 */
	@TableId
	private String id;

	private String realid;
	/**
	 * 业务类型： 10：内网备案申报 20：外网备案申报 11：内网备案变更申报 21：外网备案变更申报 12：内网备案注销申报 22：外网备案注销申报
	 */
	private String btype;
	/**
	 * 业务状态 21：未完成  11：受理不通过  21：审核不通过 22：待受理  12：受理通过  22：审核通过
	 */
	private String status;
	/**
	 * 备案ID
	 */
	private String rffsspid;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 最后操作时间
	 */
	private Date lasttime;

}
