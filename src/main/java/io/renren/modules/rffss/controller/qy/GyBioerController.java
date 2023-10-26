package io.renren.modules.rffss.controller.qy;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.*;
import io.renren.modules.rffss.service.qy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:43
 */
@RestController
@RequestMapping("qy/gybioer")
public class GyBioerController {
    @Autowired
    private GyBioerService gyBioerService;
    @Autowired
    private GyBioepqasmService gyBioepqasmService;
    @Autowired
    private GyEpiService gyEpiService;
    @Autowired
    private GyEqasmpiService gyEqasmpiService;
    @Autowired
    private GyEqmsaiiMonthService gyEqmsaiiMonthService;
    @Autowired
    private GyEqmsaiiService gyEqmsaiiService;
    @Autowired
    private GyEqmsaiiWeekService gyEqmsaiiWeekService;
    @Autowired
    private GyIpliService gyIpliService;
    @Autowired
    private GyMarketRegulatedInformationService gyMarketRegulatedInformationService;
    @Autowired
    private GyMrdipqassiCountyBureauAoapfpqatclService gyMrdipqassiCountyBureauAoapfpqatclService;
    @Autowired
    private GyMrdipqassiCountyBureauClpqsascService gyMrdipqassiCountyBureauClpqsascService;
    @Autowired
    private GyMrdipqassiCountyBureauFcsaiocbService gyMrdipqassiCountyBureauFcsaiocbService;
    @Autowired
    private GyMrdipqassiMunicipalBureauDoubleRandomnessService gyMrdipqassiMunicipalBureauDoubleRandomnessService;
    @Autowired
    private GyMrdipqassiMunicipalBureauProductQualityService gyMrdipqassiMunicipalBureauProductQualityService;
    @Autowired
    private GyMrdipqassiMunicipalBureauPunishmentSituationService gyMrdipqassiMunicipalBureauPunishmentSituationService;
    @Autowired
    private GyMrdipqassiProvincialBureauDoubleRandomnessService gyMrdipqassiProvincialBureauDoubleRandomnessService;
    @Autowired
    private GyMrdipqassiProvincialBureauProductQualityService gyMrdipqassiProvincialBureauProductQualityService;
    @Autowired
    private GyMrdipqassiProvincialBureauPunishmentSituationService gyMrdipqassiProvincialBureauPunishmentSituationService;
    @Autowired
    private GyMrdipqassiStratificationCountyService gyMrdipqassiStratificationCountyService;
    @Autowired
    private GyMrdipqassiStratificationMarketInstituteService gyMrdipqassiStratificationMarketInstituteService;
    @Autowired
    private GyMrdipqassiStratificationProvinceService gyMrdipqassiStratificationProvinceService;
    @Autowired
    private GyProductRecallInformationService gyProductRecallInformationService;
    @Autowired
    private GyReportingInformationService gyReportingInformationService;
    @Autowired
    private GyUploadService gyUploadService;
    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyBioerService.queryPage(params);

        return R.ok().put("page", page);
    }
    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody GyAll gyAll){
        GyBioerEntity gyBioer = gyAll.getGyBioer();
        gyBioerService.save(gyBioer);
        long entid=gyBioer.getId();
        List<GyBioepqasmEntity> gyBioepqasm = gyAll.getGyBioepqasm();
        if(CollectionUtils.isNotEmpty(gyBioepqasm)){
            gyBioepqasm.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyBioepqasmService.save(map);
            });
        }
        List<GyEpiEntity> gyEpi=gyAll.getGyEpi();
        if(CollectionUtils.isNotEmpty(gyEpi)){
            gyEpi.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyEpiService.save(map);
            });
        }
        List<GyEqasmpiEntity> gyEqasmpi=gyAll.getGyEqasmpi();
        if(CollectionUtils.isNotEmpty(gyEqasmpi)){
            gyEqasmpi.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyEqasmpiService.save(map);
            });
        }
        List<GyEqmsaiiEntity> gyEqmsaii=gyAll.getGyEqmsaii();
        if(CollectionUtils.isNotEmpty(gyEqmsaii)){
            gyEqmsaii.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyEqmsaiiService.save(map);
                gyUploadService.updateUploadType(map.getJroqasd());
                gyUploadService.updateUploadType(map.getCocfaqso());
                gyUploadService.updateUploadType(map.getEpqascl());
                gyUploadService.updateUploadType(map.getDcopqas());
            });
        }
        List<GyEqmsaiiMonthEntity> gyEqmsaiiMonth=gyAll.getGyEqmsaiiMonth();
        if(CollectionUtils.isNotEmpty(gyEqmsaiiMonth)){
            gyEqmsaiiMonth.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyEqmsaiiMonthService.save(map);
                gyUploadService.updateUploadType(map.getJroqasd());
                gyUploadService.updateUploadType(map.getCocfaqso());
                gyUploadService.updateUploadType(map.getEpqascl());
                gyUploadService.updateUploadType(map.getDcopqas());
            });
        }
        List<GyEqmsaiiWeekEntity> gyEqmsaiiWeek=gyAll.getGyEqmsaiiWeek();
        if(CollectionUtils.isNotEmpty(gyEqmsaiiWeek)){
            gyEqmsaiiWeek.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyEqmsaiiWeekService.save(map);
                gyUploadService.updateUploadType(map.getJroqasd());
                gyUploadService.updateUploadType(map.getCocfaqso());
                gyUploadService.updateUploadType(map.getEpqascl());
                gyUploadService.updateUploadType(map.getDcopqas());
            });
        }
        List<GyIpliEntity> gyIpli=gyAll.getGyIpli();
        if(CollectionUtils.isNotEmpty(gyIpli)){
            gyIpli.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyIpliService.save(map);
            });
        }
        List<GyMarketRegulatedInformationEntity> gyMarketRegulatedInformation=gyAll.getGyMarketRegulatedInformation();
        if(CollectionUtils.isNotEmpty(gyMarketRegulatedInformation)){
            gyMarketRegulatedInformation.forEach(map->{
                map.setEntId(entid);
                gyMarketRegulatedInformationService.save(map);
                gyUploadService.updateUploadType(map.getMarketCoverageUpid());
                gyUploadService.updateUploadType(map.getProductQualityMarketUpid());
            });
        }
        List<GyMrdipqassiCountyBureauAoapfpqatclEntity> gyMrdipqassiCountyBureauAoapfpqatcl=gyAll.getGyMrdipqassiCountyBureauAoapfpqatcl();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiCountyBureauAoapfpqatcl)){
            gyMrdipqassiCountyBureauAoapfpqatcl.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiCountyBureauAoapfpqatclService.save(map);
                gyUploadService.updateUploadType(map.getAoapfpqatcl());
            });
        }
        List<GyMrdipqassiCountyBureauClpqsascEntity> gyMrdipqassiCountyBureauClpqsasc=gyAll.getGyMrdipqassiCountyBureauClpqsasc();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiCountyBureauClpqsasc)){
            gyMrdipqassiCountyBureauClpqsasc.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiCountyBureauClpqsascService.save(map);
                gyUploadService.updateUploadType(map.getClpqsasc());
            });
        }
        List<GyMrdipqassiCountyBureauFcsaiocbEntity> gyMrdipqassiCountyBureauFcsaiocb=gyAll.getGyMrdipqassiCountyBureauFcsaiocb();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiCountyBureauFcsaiocb)){
            gyMrdipqassiCountyBureauFcsaiocb.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiCountyBureauFcsaiocbService.save(map);
                gyUploadService.updateUploadType(map.getFcsaiocb());
            });
        }
        List<GyMrdipqassiMunicipalBureauProductQualityEntity> gyMrdipqassiMunicipalBureauProductQualityEntity=gyAll.getGyMrdipqassiMunicipalBureauProductQualityEntity();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiMunicipalBureauProductQualityEntity)){
            gyMrdipqassiMunicipalBureauProductQualityEntity.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiMunicipalBureauProductQualityService.save(map);
                gyUploadService.updateUploadType(map.getMlpqsasc());

            });
        }
        List<GyMrdipqassiMunicipalBureauPunishmentSituationEntity> gyMrdipqassiMunicipalBureauPunishmentSituation=gyAll.getGyMrdipqassiMunicipalBureauPunishmentSituation();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiMunicipalBureauPunishmentSituation)){
            gyMrdipqassiMunicipalBureauPunishmentSituation.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiMunicipalBureauPunishmentSituationService.save(map);
                gyUploadService.updateUploadType(map.getAoapfpqatml());
            });
        }
        List<GyMrdipqassiProvincialBureauDoubleRandomnessEntity> gyMrdipqassiProvincialBureauDoubleRandomness=gyAll.getGyMrdipqassiProvincialBureauDoubleRandomness();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiProvincialBureauDoubleRandomness)){
            gyMrdipqassiProvincialBureauDoubleRandomness.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiProvincialBureauDoubleRandomnessService.save(map);
                gyUploadService.updateUploadType(map.getDrsaibtpb());

            });
        }
        List<GyMrdipqassiProvincialBureauProductQualityEntity> gyMrdipqassiProvincialBureauProductQuality=gyAll.getGyMrdipqassiProvincialBureauProductQuality();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiProvincialBureauProductQuality)){
            gyMrdipqassiProvincialBureauProductQuality.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiProvincialBureauProductQualityService.save(map);
                gyUploadService.updateUploadType(map.getPpqsasc());

            });
        }
        List<GyMrdipqassiProvincialBureauPunishmentSituationEntity> gyMrdipqassiProvincialBureauPunishmentSituation=gyAll.getGyMrdipqassiProvincialBureauPunishmentSituation();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiProvincialBureauPunishmentSituation)){
            gyMrdipqassiProvincialBureauPunishmentSituation.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiProvincialBureauPunishmentSituationService.save(map);
                gyUploadService.updateUploadType(map.getAoplapfpq());
            });
        }
        List<GyMrdipqassiStratificationCountyEntity> gyMrdipqassiStratificationCounty=gyAll.getGyMrdipqassiStratificationCounty();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiStratificationCounty)){
            gyMrdipqassiStratificationCounty.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiStratificationCountyService.save(map);
            });
        }
        List<GyMrdipqassiStratificationMarketInstituteEntity> gyMrdipqassiStratificationMarketInstitute=gyAll.getGyMrdipqassiStratificationMarketInstitute();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiStratificationMarketInstitute)){
            gyMrdipqassiStratificationMarketInstitute.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiStratificationMarketInstituteService.save(map);
            });
        }
        List<GyMrdipqassiStratificationProvinceEntity> gyMrdipqassiStratificationProvince=gyAll.getGyMrdipqassiStratificationProvince();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiStratificationProvince)){
            gyMrdipqassiStratificationProvince.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiStratificationProvinceService.save(map);
            });
        }
        List<GyProductRecallInformationEntity> gyProductRecallInformation=gyAll.getGyProductRecallInformation();
        if(CollectionUtils.isNotEmpty(gyProductRecallInformation)){
            gyProductRecallInformation.forEach(map->{
                map.setEntId(entid);
                gyProductRecallInformationService.save(map);
            });
        }
        List<GyReportingInformationEntity> gyReportingInformation=gyAll.getGyReportingInformation();
        if(CollectionUtils.isNotEmpty(gyReportingInformation)){
            gyReportingInformation.forEach(map->{
                map.setEntId(entid);
                gyReportingInformationService.save(map);
            });
        }
        List<GyMrdipqassiMunicipalBureauDoubleRandomnessEntity> gyMrdipqassiMunicipalBureauDoubleRandomness=gyAll.getGyMrdipqassiMunicipalBureauDoubleRandomness();
        if(CollectionUtils.isNotEmpty(gyMrdipqassiMunicipalBureauDoubleRandomness)){
            gyMrdipqassiMunicipalBureauDoubleRandomness.forEach(map->{
                map.setEntId(String.valueOf(entid));
                gyMrdipqassiMunicipalBureauDoubleRandomnessService.save(map);
                gyUploadService.updateUploadType(map.getDrsaibtmb());
            });
        }
        return R.ok();
    }


    /**
     * 查询单个工业
     * @param id
     * @return
     */
    @GetMapping("/selectOne")
    public R list(@RequestParam Long id){
        GyAll gyAll=new GyAll();
        GyBioerEntity gyBioer = gyBioerService.getById(id);
        gyAll.setGyBioer(gyBioer);
        Map<String, Object> columnMap=new HashMap<>();
        columnMap.put("ent_id",id);
        gyAll.setGyBioepqasm(gyBioepqasmService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyEpi(gyEpiService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyEqasmpi(gyEqasmpiService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyEqmsaii(gyEqmsaiiService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyEqmsaiiMonth(gyEqmsaiiMonthService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyEqmsaiiWeek(gyEqmsaiiWeekService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyIpli(gyIpliService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMarketRegulatedInformation(gyMarketRegulatedInformationService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiCountyBureauAoapfpqatcl(gyMrdipqassiCountyBureauAoapfpqatclService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiCountyBureauClpqsasc(gyMrdipqassiCountyBureauClpqsascService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiCountyBureauFcsaiocb(gyMrdipqassiCountyBureauFcsaiocbService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiMunicipalBureauProductQualityEntity(gyMrdipqassiMunicipalBureauProductQualityService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiMunicipalBureauPunishmentSituation(gyMrdipqassiMunicipalBureauPunishmentSituationService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiProvincialBureauDoubleRandomness(gyMrdipqassiProvincialBureauDoubleRandomnessService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiProvincialBureauProductQuality(gyMrdipqassiProvincialBureauProductQualityService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiProvincialBureauPunishmentSituation(gyMrdipqassiProvincialBureauPunishmentSituationService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiStratificationCounty(gyMrdipqassiStratificationCountyService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiStratificationMarketInstitute(gyMrdipqassiStratificationMarketInstituteService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiStratificationProvince(gyMrdipqassiStratificationProvinceService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyProductRecallInformation(gyProductRecallInformationService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyReportingInformation(gyReportingInformationService.getBaseMapper().selectByMap(columnMap));
        gyAll.setGyMrdipqassiMunicipalBureauDoubleRandomness(gyMrdipqassiMunicipalBureauDoubleRandomnessService.getBaseMapper().selectByMap(columnMap));
        return R.ok().put("data", gyAll);
    }
}
