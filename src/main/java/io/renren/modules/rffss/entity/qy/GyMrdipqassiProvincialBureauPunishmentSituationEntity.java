package io.renren.modules.rffss.entity.qy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:40
 */
@Data
@TableName("gy_mrdipqassi_provincial_bureau_punishment_situation")
public class GyMrdipqassiProvincialBureauPunishmentSituationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
	/**
	 * 处罚时间
	 */
	private Date penaltyTime;
	/**
	 * 接受省级产品质量行政处罚情况
	 */
	private Long aoplapfpq;
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
