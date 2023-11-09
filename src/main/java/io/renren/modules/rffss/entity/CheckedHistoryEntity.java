package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作记录
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:17
 */
@Data
@TableName("nf_checked_history")
public class CheckedHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 受理审核ID
	 */
	@TableId
	private String id;

	private String realid;
	/**
	 * 业务id: NfBusinEntity id
	 */
	private String businid;
	/**
	 * 受理审核人员
	 */
	private String name;
	/**
	 * 受理审核结果： 1 为不通过  2  为通过
	 */
	private String cresult;
	/**
	 * 受理审核意见
	 */
	private String opinions;
	/**
	 * 受理审核时间
	 */
	private Date ctime;
	/**
	 * 受理审核类型: 1 为受理    2  为审核
	 */
	private String ctype;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 最后操作时间
	 */
	private Date lasttime;

}
