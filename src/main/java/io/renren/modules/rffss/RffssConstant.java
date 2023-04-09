package io.renren.modules.rffss;

/**
 * @author zhaoxiubin
 * @create 2022-11-05 14:59
 * @desc 常量类
 **/
public class RffssConstant {
    /**
     * id前缀： IN：内网
     */
    public final static String ID_PREFIX_IN = "IN";
    /**
     * id前缀： OUT：外网
     */
    public final static String ID_PREFIX_OUT = "OUT";

    /**
     * 业务类型： 10：内网备案申报
     */
    public final static String BUSIN_TYPE_APPLY_IN = "10";
    /**
     * 业务类型： 11：内网备案变更申报
     */
    public final static String BUSIN_TYPE_CHANGE_IN = "11";
    /**
     * 业务类型： 12：内网备案注销申报
     */
    public final static String BUSIN_TYPE_CANCEL_IN = "12";
    /**
     * 业务类型： 20：外网备案申报
     */
    public final static String BUSIN_TYPE_APPLY_OUT = "20";
    /**
     * 业务类型： 21：外网备案变更申报
     */
    public final static String BUSIN_TYPE_CHANGE_OUT = "21";
    /**
     * 业务类型： 22：外网备案注销申报
     */
    public final static String BUSIN_TYPE_CANCEL_OUT = "22";

    /**
     * 业务状态： 31：未提交
     */
    public final static String BUSIN_STATUS_ING = "31";
    /**
     * 业务状态： 32：已提交
     */
    public final static String BUSIN_STATUS_SUMBIT = "32";
    /**
     * 业务类型： 11：受理不通过
     */
    public final static String BUSIN_STATUS_ACCEPT_NO = "11";
    /**
     * 业务类型： 12：受理通过
     */
    public final static String BUSIN_STATUS_ACCEPT = "12";
    /**
     * 业务类型： 21：审核不通过
     */
    public final static String BUSIN_STATUS_CHECK_NO = "21";
    /**
     * 业务类型： 22：审核通过
     */
    public final static String BUSIN_STATUS_CHECK = "22";


    /**
     * 备案状态  1 录入
     */
    public final static String RFFSSP_STATUS_ING = "1";
    /**
     * 备案状态  2 提交
     */
    public final static String RFFSSP_STATUS_SUMBIT = "2";
    /**
     * 备案状态  3 业务完成
     */
    public final static String RFFSSP_STATUS_OVER = "3";


    /**
     * 材料类型： 10 冷藏冷冻贮存场所布局图
     */
    public final static String MATERIAL_TYPE_LAYOUT = "10";
    /**
     * 材料类型： 20 法定代表人或者负责人身份证明复印件人像面
     */
    public final static String MATERIAL_TYPE_IDCARDHEAD = "20";
    /**
     * 材料类型： 21 法定代表人或者负责人身份证明复印件国徽面
     */
    public final static String MATERIAL_TYPE_IDCARDNE = "21";
    /**
     * 材料类型： 30 所提交资料真实性承诺书
     */
    public final static String MATERIAL_TYPE_LETTERCOMMIT = "30";


    /**
     * 受理审核类型: 1 为受理
     */
    public final static String CHECKED_TYPE_ACCEPT = "1";
    /**
     * 受理审核类型: 2  为审核
     */
    public final static String CHECKED_TYPE_CHECKED = "2";


    /**
     * 受理审核结果： 1 为不通过
     */
    public final static String CHECKED_RESULT_NO = "1";
    /**
     * 受理审核结果： 2  为通过
     */
    public final static String CHECKED_RESULT_YES = "2";
}
