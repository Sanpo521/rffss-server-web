package io.renren.modules.rffss.entity;

import lombok.Data;

import java.util.List;

/**
 * @author zhaoxiubin
 * @create 2022-11-05 12:09
 * @desc 备案所有信息实体类
 **/
@Data
public class NfRecordEntity {
    /**
     * 业务信息
     */
    NfBusinEntity busin;
    /**
     * 冷藏冷冻食品贮存服务提供者实体类
     */
    NfRffsspEntity rffssp;
    /**
     * 代理人实体类
     */
    NfAgentEntity agent;
    /**
     * 冷藏冷冻贮存场所布局图
     */
    List<NfMaterialEntity> layout;
    /**
     * 法定代表人或者负责人身份证明复印件人像面
     */
    List<NfMaterialEntity> idCardHead;
    /**
     * 法定代表人或者负责人身份证明复印件国徽面
     */
    List<NfMaterialEntity> idCardNe;
    /**
     * 资料真实性承诺书
     */
    List<NfMaterialEntity> letterCommit;
    /**
     * 受理审核信息
     */
    NfCheckedEntity accept;
    /**
     * 审核信息
     */
    NfCheckedEntity checked;
}
