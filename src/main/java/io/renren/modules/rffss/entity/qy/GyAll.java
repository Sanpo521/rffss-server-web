package io.renren.modules.rffss.entity.qy;

import lombok.Data;

import java.util.List;

/**
 * @Author zzb
 * @Date 2023/10/24 9:14
 * @Version 1.0
 */
@Data
public class GyAll {
    /**
     *企业注册登记基本信息/企业产品质量安全管理基本信息
     */
    private GyBioerEntity gyBioer;
    /**
     *企业产品质量安全管理基本信息 -企业质量安全管理人员信息质量安全员
     */
    private List<GyBioepqasmEntity> gyBioepqasm;

    /**
     *企业产品质量安全管理基本信息-企业产品信息
     */
    private List<GyEpiEntity> gyEpi;
    /**
     *企业产品质量安全管理基本信息 -企业质量安全管理人员信息质量安全总监
     */
    private List<GyEqasmpiEntity> gyEqasmpi;
    /**
     *企业质量管理制度及执行信息(日)
     */
    private List<GyEqmsaiiEntity> gyEqmsaii;
    /**
     *企业质量管理制度及执行信息(月)
     */
    private List<GyEqmsaiiMonthEntity> gyEqmsaiiMonth;
    /**
     *企业质量管理制度及执行信息(周)
     */
    private List<GyEqmsaiiWeekEntity> gyEqmsaiiWeek;
    /**
     * 工业产品许可证信息
     */
    private List<GyIpliEntity> gyIpli;
    /**
     *市场所监管信息
     */
    private List<GyMarketRegulatedInformationEntity> gyMarketRegulatedInformation;
    /**
     *市场监管部门工业产品质量安全监管信息(县（区）局全覆盖监督检查情况 - 接受县（区）级产品质量行政处罚情况)
     */
    private List<GyMrdipqassiCountyBureauAoapfpqatclEntity> gyMrdipqassiCountyBureauAoapfpqatcl;
    /**
     * 市场监管部门工业产品质量安全监管信息(县（区）局全覆盖监督检查情况 - 县（区）级产品质量监督抽查情况)
     */
    private List<GyMrdipqassiCountyBureauClpqsascEntity> gyMrdipqassiCountyBureauClpqsasc;
    /**
     * 市场监管部门工业产品质量安全监管信息(县（区）局全覆盖监督检查情况 - 县（区）局全覆盖监督检查情况)
     */
    private List<GyMrdipqassiCountyBureauFcsaiocbEntity> gyMrdipqassiCountyBureauFcsaiocb;
    /**
     *市场监管部门工业产品质量安全监管信息(市局监管信息 - 市级产品质量监督抽查情况)
     */
    private List<GyMrdipqassiMunicipalBureauProductQualityEntity> gyMrdipqassiMunicipalBureauProductQualityEntity;
    /**
     *市场监管部门工业产品质量安全监管信息(市局监管信息 - 接受市级产品质量行政处罚情况)
     */
    private List<GyMrdipqassiMunicipalBureauPunishmentSituationEntity> gyMrdipqassiMunicipalBureauPunishmentSituation;
    /**
     * 市场监管部门工业产品质量安全监管信息(省局监管信息 - 省局双随机监督检查情况)
     */
    private List<GyMrdipqassiProvincialBureauDoubleRandomnessEntity> gyMrdipqassiProvincialBureauDoubleRandomness;
    /**
     *市场监管部门工业产品质量安全监管信息(省局监管信息 - 省级产品质量监督抽查情况)
     */
    private List<GyMrdipqassiProvincialBureauProductQualityEntity> gyMrdipqassiProvincialBureauProductQuality;
    /**
     * 市场监管部门工业产品质量安全监管信息(省局监管信息 - 接受省级产品质量行政处罚情况)
     */
    private List<GyMrdipqassiProvincialBureauPunishmentSituationEntity> gyMrdipqassiProvincialBureauPunishmentSituation;
    /**
     *市场监管部门工业产品质量安全监管信息(分层 - 县(区))
     */
    private List<GyMrdipqassiStratificationCountyEntity> gyMrdipqassiStratificationCounty;
    /**
     *市场监管部门工业产品质量安全监管信息(分层 - 市场)
     */
    private List<GyMrdipqassiStratificationMarketInstituteEntity> gyMrdipqassiStratificationMarketInstitute;
    /**
     *市场监管部门工业产品质量安全监管信息(分层 - 省)
     */
    private List<GyMrdipqassiStratificationProvinceEntity> gyMrdipqassiStratificationProvince;
    /**
     *企业被投诉举报和产品召回信息  召回信息
     */
    private List<GyProductRecallInformationEntity> gyProductRecallInformation;
    /**
     *企业被投诉举报和产品召回信息  举报信息
     */
    private List<GyReportingInformationEntity> gyReportingInformation;
    /**
     *市场监管部门工业产品质量安全监管信息(市局监管信息 - 市局双随机监督检查情况)
     */
    private List<GyMrdipqassiMunicipalBureauDoubleRandomnessEntity> gyMrdipqassiMunicipalBureauDoubleRandomness;


}
