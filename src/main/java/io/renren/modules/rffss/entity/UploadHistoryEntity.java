package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:16
 */
@Data
@TableName("nf_upload_history")
public class UploadHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *  id
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;


	private Long realid;
	/**
	 *  业务id
	 */
	private String businessId;

	/**
	 *  文件内容
	 */
	private String content;

	/**
	 *  业务类型
	 */
	private String business;

	/**
	 *  创建时间
	 */
	private Date createtime;

	/**
	 *  最后操作时间
	 */
	private Date lasttime;

}
