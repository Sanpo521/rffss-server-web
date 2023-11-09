package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 代理人
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:17
 */
@Data
@TableName("nf_agent_history")
public class AgentHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 代理人ID
	 */
	@TableId
	private String id;

	/**
	 * 代理人ID
	 */
	private String realid;
	/**
	 * 代理人姓名
	 */
	private String name;
	/**
	 * 代理人联系方式
	 */
	private String mobile;
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
