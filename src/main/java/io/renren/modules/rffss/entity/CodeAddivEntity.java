package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaoxiubin
 * create-time 2023-04-05 11:49
 * description 代码集--行政区划实体类
 **/
@Data
@TableName("code_addiv")
public class CodeAddivEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 行政区划
     */
    @TableId
    private String code;
    /**
     * 行政名称
     */
    private String name;
    /**
     * 父级行政区划
     */
    private String parent;
    /**
     * 行政级别：1为省，2为市，3为区县，4为乡镇、社区、街道
     */
    private String level;
    /**
     * 是否可用 1可用，0不可用
     */
    private Integer enabled;

    @TableField(exist = false)
    private Object subAddivs;
}
