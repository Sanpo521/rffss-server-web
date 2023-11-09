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
 * @date 2023-11-09 12:38:16
 */
@Data
@TableName("nf_opt_history")
public class OptHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 操作记录ID
	 */
	@TableId
	private Long id;

	private Long realid;
	/**
	 * 业务id: NfBusinEntity id
	 */
	private String businid;
	/**
	 * 操作模块名称
	 */
	private String module;
	/**
	 * 操作人员
	 */
	private Long ouser;
	/**
	 * IP地址
	 */
	private String ip;
	/**
	 * 执行时长(毫秒)
	 */
	private Long duration;
	/**
	 * 操作时间
	 */
	private Date otime;

}
