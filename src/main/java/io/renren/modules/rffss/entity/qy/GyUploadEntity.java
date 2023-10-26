package io.renren.modules.rffss.entity.qy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:43
 */
@Data
@TableName("gy_upload")
public class GyUploadEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**ASSIGN_ID
	 *
	 */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
	/**
	 * 文件内容
	 */
	private String content;
	/**
	 * 0未使用1已使用
	 */
	private String type;
	/**
	 * 文件名称
	 */
	private String fileName;
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
