package io.renren.modules.rffss.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaoxiubin
 * @create 2022-10-31 14:13
 * @desc 业务表实体类
 **/
@Data
@TableName("nf_busin")
public class NfBusinEntity implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 序号
         */
        //IdWorker.getIdStr();
        @TableId(type = IdType.INPUT)
        private String id;
        /**
         * 业务类型：
         * 10：内网备案申报      20：外网备案申报
         * 11：内网备案变更申报   21：外网备案变更申报
         * 12：内网备案注销申报   22：外网备案注销申报
         */
        @NotBlank(message="业务类型不能为空", groups = {AddGroup.class, UpdateGroup.class})
        private String btype;
        /**
         * 业务状态
         * 31：未完成  11：受理不通过  21：审核不通过
         * 32：待受理  12：受理通过  22：审核通过
         */
        @NotBlank(message="业务状态不能为空", groups = {AddGroup.class, UpdateGroup.class})
        private String status;
        /**
         * 冷藏冷冻食品贮存服务提供者id: NfRffsspEntity id
         */
        @NotBlank(message="备案ID不能为空", groups = {AddGroup.class, UpdateGroup.class})
        private String rffsspid;
        /**
         * 最后操作时间
         */
        private Date lasttime;
        /**
         * 创建时间
         */
        private Date createtime;
}
