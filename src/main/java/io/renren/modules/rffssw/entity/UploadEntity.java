package io.renren.modules.rffssw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author zzb
 * @date Sun Oct 08 10:39:26 CST 2023
 * @Description: groovy script auto generate
 */
@Data
@TableName("nf_upload")
public class UploadEntity {

    /**
     *  id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

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
