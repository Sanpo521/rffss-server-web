package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 材料表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:16
 */
@Data
@TableName("nf_material_history")
public class MaterialHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 材料ID
	 */
	@TableId
	private String id;

	private String realid;
	/**
	 * 材料类型：10 冷藏冷冻贮存场所布局图 20 法定代表人或者负责人身份证明复印件人像面 21 法定代表人或者负责人身份证明复印件国徽面 30 所提交资料真实性承诺书
	 */
	private String mtype;
	/**
	 * 同材料类型的顺序号
	 */
	private Integer morder;
	/**
	 * 材料地址
	 */
	private String mpath;
	/**
	 * 业务id: NfBusinEntity id
	 */
	private String businid;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 最后操作时间
	 */
	private Date lasttime;

}
