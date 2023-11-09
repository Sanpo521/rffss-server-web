package io.renren.modules.rffss.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.renren.common.utils.ExcelUtil;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.config.RffssConfig;
import io.renren.modules.rffss.RffssConstant;
import io.renren.modules.rffss.entity.*;
import io.renren.modules.rffss.service.*;
import io.renren.modules.rffssw.entity.UploadEntity;
import io.renren.modules.rffssw.service.UploadService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaoxiubin
 * @create 2022-11-05 12:20
 * @desc 备案所有信息控制类
 **/
@RestController
@RequestMapping("nfrecord")
public class NfRecordController {
    @Autowired
    private RffssConfig rffssConfig;
    @Autowired
    private NfBusinService businService;
    @Autowired
    private BusinHistoryService businHistoryService;
    @Autowired
    private NfRffsspService rffsspService;
    @Autowired
    private RffsspHistoryService rffsspHistoryService;
    @Autowired
    private NfAgentService agentService;
    @Autowired
    private AgentHistoryService agentHistoryService;
    @Autowired
    private NfMaterialService materialService;
    @Autowired
    private MaterialHistoryService materialHistoryService;
    @Autowired
    private NfCheckedService checkedService;
    @Autowired
    private NfRffsspUserService rffsspUserService;
    @Autowired
    private CodeOrganService codeOrganService;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private UploadHistoryService uploadHistoryService;
    @Autowired
    private ThirdColdStorageInfoService thirdColdStorageInfoService;

    @RequestMapping("/apply/list")
    @RequiresPermissions("nfrecord:apply:list")
    public R applyList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_IN);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ING);
        return list(params);
    }

    @RequestMapping("/change/list")
    @RequiresPermissions("nfrecord:change:list")
    public R changeList(@RequestParam Map<String, Object> params){

        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_IN);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ING);
        return listEx(params);
    }

    @RequestMapping("/cancel/list")
    @RequiresPermissions("nfrecord:cancel:list")
    public R cancelList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CANCEL_IN);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ING);
        return listEx(params);
    }

    @RequestMapping("/applya/list")
    @RequiresPermissions("nfrecord:applya:list")
    public R applyaList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_SUMBIT);
        return list(params);
    }

    @RequestMapping("/changea/list")
    @RequiresPermissions("nfrecord:changea:list")
    public R changeaList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_SUMBIT);
        return list(params);
    }

    @RequestMapping("/cancela/list")
    @RequiresPermissions("nfrecord:cancela:list")
    public R cancelaList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CANCEL_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_CANCEL_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_SUMBIT);
        return list(params);
    }

    @RequestMapping("/applyc/list")
    @RequiresPermissions("nfrecord:applyc:list")
    public R applycList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ACCEPT);
        return list(params);
    }

    @RequestMapping("/changec/list")
    @RequiresPermissions("nfrecord:changec:list")
    public R changecList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ACCEPT);
        return list(params);
    }

    @RequestMapping("/cancelc/list")
    @RequiresPermissions("nfrecord:cancelc:list")
    public R cancelcList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CANCEL_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_CANCEL_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ACCEPT);
        return list(params);
    }

    /**
     * 审核完成列表
     * @param params
     * @return
     */
    @RequestMapping("/check/list")
    @RequiresPermissions("nfrecord:check:list")
    public R checkList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_OUT);
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_CHECK);
        return list(params);
    }

    /**
     * 根据行政机关查询备案申请
     * @param params
     * @return
     */
    @RequestMapping("/statistics/list")
    @RequiresPermissions("nfrecord:statistics:list")
    public R statisticsList(@RequestParam Map<String, Object> params){
        if (params.containsKey("btype")){
            String[] b=params.get("btype").toString().split(",");
            if(b!=null && b.length>0){
                List<String> btypes =  Arrays.asList(b);
                params.put("btype", btypes);
            }
        }
        params.put("status", RffssConstant.BUSIN_STATUS_CHECK);
        return list(params);
    }


    @RequestMapping({"/statistics/listExcel"})
    public void listExcel(@RequestParam(required = false) String btype, @RequestParam(required = false) String issueorg, @RequestParam(required = false) String createTime, HttpServletResponse response) {
        Map<String, Object> params = new HashMap();
        if (StringUtils.isNotEmpty(btype)) {
            params.put("btype", btype);
        }

        if (StringUtils.isNotEmpty(issueorg)) {
            params.put("issueorg", issueorg);
        }

        if (StringUtils.isNotEmpty(createTime)) {
            params.put("createTime", createTime);
        }

        if (params.containsKey("btype")) {
            String[] b = params.get("btype").toString().split(",");
            if (b != null && b.length > 0) {
                List<String> btypes = Arrays.asList(b);
                params.put("btype", btypes);
            }
        }

        params.put("status", "22");
        List<Map<String, Object>> mapList = this.businService.listExcel(params);
        if (CollectionUtils.isNotEmpty(mapList)) {
            List<String> columnList = new ArrayList();
            columnList.add("县（市、区）");
            columnList.add("备案号");
            columnList.add("提供者名称");
            columnList.add("冷库数");
            columnList.add("备注");
            List<List<String>> collect = (List)mapList.stream().map((item) -> {
                List<String> str = new ArrayList();
                String sheng = item.get("sheng") != null ? item.get("sheng").toString() : "";
                String shi = item.get("shi") != null ? item.get("shi").toString() : "";
                String xian = item.get("xian") != null ? item.get("xian").toString() : "";
                str.add(sheng + shi + xian);
                str.add(item.get("rec_num") != null ? item.get("rec_num").toString() : "");
                str.add(item.get("apply_name") != null ? item.get("apply_name").toString() : "");
                str.add(item.get("equipment_name_specification") != null ? item.get("equipment_name_specification").toString() : "");
                str.add(item.get("remarks") != null ? item.get("remarks").toString() : "");
                return str;
            }).collect(Collectors.toList());
            ExcelUtil.uploadExcelAboutUser(response, "统计.xls", columnList, collect);
        }

    }
    /**
     * 各地市入库数量统计
     * @param typesOf
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/inbound/list")
    @RequiresPermissions("nfrecord:inbound:list")
    public R inboundList(@RequestParam(value = "typesOf",required = false) String  typesOf,
                         @RequestParam(value = "type",required = false) String  type,
                         @RequestParam(value = "startDate",required = false) String  startDate,
                         @RequestParam(value = "endDate",required = false) String  endDate){

        return R.ok().put("list", businService.getAddressCodeInbound(typesOf,startDate,endDate,type));
    }

    /**
     * 查询每月没有出库和入库的备案
     * @param page
     * @param limit
     * @param date
     * @return
     */
    @RequestMapping("/warn/list")
    @RequiresPermissions("nfrecord:warn:list")
    public R warnList(@RequestParam(value = "page") Long  page,
                         @RequestParam(value = "limit") Long  limit,
                         @RequestParam(value = "date") String  date){

        return R.ok().put("page", businService.queryWarnInbound(page,limit,date));
    }

    private R listEx( Map<String, Object> params){
        PageUtils businPage = businService.queryPageEx(params);
        return listOptEx(params, businPage);
    }

    private R listOptEx( Map<String, Object> params, PageUtils businPage){
        List<NfBusinEntity> businList = (List<NfBusinEntity>) businPage.getList();
        List<NfRecordEntity> recordList = new ArrayList<NfRecordEntity>(5);
        for (NfBusinEntity busin: businList){
            NfRecordEntity record = new NfRecordEntity();
            record.setBusin(busin);
            NfRffsspEntity rffssp = rffsspService.getById(busin.getRffsspid());
            record.setRffssp(rffssp);
            NfAgentEntity agent = agentService.getByBusinid(busin.getId());
            record.setAgent(agent);
            List<NfMaterialEntity> layouts = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LAYOUT);
            record.setLayout(layouts);
            List<NfMaterialEntity> idCardHead = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDHEAD);
            record.setIdCardHead(idCardHead);
            List<NfMaterialEntity> idCardNe = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDNE);
            record.setIdCardNe(idCardNe);
            List<NfMaterialEntity> letterCommits = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LETTERCOMMIT);
            record.setLetterCommit(letterCommits);
            recordList.add(record);
        }
        businPage.setList(recordList);
        return R.ok().put("page", businPage);
    }

    private R list( Map<String, Object> params){
        PageUtils businPage = businService.queryPage(params);
        return listOpt(params, businPage);
    }

    private R listOpt( Map<String, Object> params, PageUtils businPage){
        List<NfBusinEntity> businList = (List<NfBusinEntity>) businPage.getList();
        List<NfRecordEntity> recordList = new ArrayList<NfRecordEntity>(5);
        for (NfBusinEntity busin: businList){
            NfRecordEntity record = new NfRecordEntity();
            record.setBusin(busin);
            NfRffsspEntity rffssp = rffsspService.getById(busin.getRffsspid());
            record.setRffssp(rffssp);
            NfAgentEntity agent = agentService.getByBusinid(busin.getId());
            record.setAgent(agent);
            List<NfMaterialEntity> layouts = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LAYOUT);
            record.setLayout(layouts);
            List<NfMaterialEntity> idCardHead = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDHEAD);
            record.setIdCardHead(idCardHead);
            List<NfMaterialEntity> idCardNe = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDNE);
            record.setIdCardNe(idCardNe);
            List<NfMaterialEntity> letterCommits = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LETTERCOMMIT);
            record.setLetterCommit(letterCommits);
            NfCheckedEntity accept = checkedService.getByBusinid(busin.getId(), RffssConstant.CHECKED_TYPE_ACCEPT);
            record.setAccept(accept);
            NfCheckedEntity checked = checkedService.getByBusinid(busin.getId(), RffssConstant.CHECKED_TYPE_CHECKED);
            record.setChecked(checked);
            recordList.add(record);
        }
        businPage.setList(recordList);
        return R.ok().put("page", businPage);
    }

    /**
     * 信息
     */
    @RequestMapping("/apply/info/{id}")
    @RequiresPermissions("nfrecord:apply:info")
    public R applyInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/change/info/{id}")
    @RequiresPermissions("nfrecord:change:info")
    public R changeInfo(@PathVariable("id") String id){
        return infoEx(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/cancel/info/{id}")
    @RequiresPermissions("nfrecord:cancel:info")
    public R cancelInfo(@PathVariable("id") String id){
        return infoEx(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/applya/info/{id}")
    @RequiresPermissions("nfrecord:applya:info")
    public R applyaInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/changea/info/{id}")
    @RequiresPermissions("nfrecord:changea:info")
    public R changeaInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/cancela/info/{id}")
    @RequiresPermissions("nfrecord:cancela:info")
    public R cancelaInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/applyc/info/{id}")
    @RequiresPermissions("nfrecord:applyc:info")
    public R applycInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/changec/info/{id}")
    @RequiresPermissions("nfrecord:changec:info")
    public R changecInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/cancelc/info/{id}")
    @RequiresPermissions("nfrecord:cancelc:info")
    public R cancelcInfo(@PathVariable("id") String id){
        return info(id);
    }

    private R infoEx(String id){
        NfBusinEntity busin = businService.getById(id);
        NfRecordEntity record = new NfRecordEntity();
        record.setBusin(new NfBusinEntity());
        NfRffsspEntity rffssp = rffsspService.getById(busin.getRffsspid());
        if (null != rffssp.getIssueorg()){
            CodeOrganEntity codeOrgan = codeOrganService.getByCode(rffssp.getIssueorg());
            rffssp.setOrgname(codeOrgan.getName());
        }
        record.setRffssp(rffssp);
        NfAgentEntity agent = agentService.getByBusinid(busin.getId());
        record.setAgent(agent);
        List<NfMaterialEntity> layouts = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LAYOUT);
        record.setLayout(layouts);
        List<NfMaterialEntity> idCardHead = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDHEAD);
        record.setIdCardHead(idCardHead);
        List<NfMaterialEntity> idCardNe = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDNE);
        record.setIdCardNe(idCardNe);
        List<NfMaterialEntity> letterCommits = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LETTERCOMMIT);
        record.setLetterCommit(letterCommits);
        List<UploadEntity> uploadEntities=uploadService.getUpload(busin.getId(),busin.getBtype());
        record.setUploadEntities(uploadEntities);
        return R.ok().put("record", record);
    }

    private R info(String id){
        NfBusinEntity busin = businService.getById(id);
        NfRecordEntity record = new NfRecordEntity();
        record.setBusin(busin);
        NfRffsspEntity rffssp = rffsspService.getById(busin.getRffsspid());
        if (null != rffssp.getIssueorg()){
            CodeOrganEntity codeOrgan = codeOrganService.getByCode(rffssp.getIssueorg());
            rffssp.setOrgname(codeOrgan.getName());
        }
        record.setRffssp(rffssp);
        NfAgentEntity agent = agentService.getByBusinid(busin.getId());
        record.setAgent(agent);
        List<NfMaterialEntity> layouts = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LAYOUT);
        record.setLayout(layouts);
        List<NfMaterialEntity> idCardHead = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDHEAD);
        record.setIdCardHead(idCardHead);
        List<NfMaterialEntity> idCardNe = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDNE);
        record.setIdCardNe(idCardNe);
        List<NfMaterialEntity> letterCommits = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LETTERCOMMIT);
        record.setLetterCommit(letterCommits);
        NfCheckedEntity accept = checkedService.getByBusinid(busin.getId(), RffssConstant.CHECKED_TYPE_ACCEPT);
        record.setAccept(accept);
        NfCheckedEntity checked = checkedService.getByBusinid(busin.getId(), RffssConstant.CHECKED_TYPE_CHECKED);
        record.setChecked(checked);
        List<UploadEntity> uploadEntities=uploadService.getUpload(busin.getId(),busin.getBtype());
        record.setUploadEntities(uploadEntities);
        return R.ok().put("record", record);
    }

    @RequestMapping("/apply/save")
    @RequiresPermissions("nfrecord:apply:save")
    public R applySave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, RffssConstant.BUSIN_TYPE_APPLY_IN, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/change/save")
    @RequiresPermissions("nfrecord:change:save")
    public R changeSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, RffssConstant.BUSIN_TYPE_CHANGE_IN, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/cancel/save")
    @RequiresPermissions("nfrecord:cancel:save")
    public R cancelSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, RffssConstant.BUSIN_TYPE_CANCEL_IN, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/applya/save")
    @RequiresPermissions("nfrecord:applya:save")
    public R applyaSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/changea/save")
    @RequiresPermissions("nfrecord:changea:save")
    public R changeaSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/cancela/save")
    @RequiresPermissions("nfrecord:cancela:save")
    public R cancelaSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }
    @Value("${saveoracle}")
    private String saveoracle;


    @RequestMapping("/applyc/save")
    @RequiresPermissions("nfrecord:applyc:save")
    public R applycSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);

        if(StringUtils.equals(saveoracle,"1")){
//            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
//            SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
            ThirdColdStorageInfoEntity t=new ThirdColdStorageInfoEntity();
            NfRffsspEntity rffssp = record.getRffssp();
            if(rffssp!=null){
                t.setThirdcoldstorageinfoid(rffssp.getId());
                if(rffssp.getCreatetime()!=null){
                    t.setApplytime(rffssp.getCreatetime());
                }
                t.setApplyname(rffssp.getApplyName());
                t.setApplycontactinfo(rffssp.getApplyContactInfo());
                t.setStorageentname(rffssp.getStorageEntName());
                t.setLerep(rffssp.getLeRep());
                t.setContractname(rffssp.getContractName());
                t.setContracttel(rffssp.getContractTel());
                t.setStoragename(rffssp.getStorageName());
                t.setStorageprovince(rffssp.getStorageProvince());
                t.setStorageprovname(rffssp.getStorageProvName());
                t.setStoragecity(rffssp.getStorageCity());
                t.setStoragecityname(rffssp.getStorageCityName());
                t.setStoragecounty(rffssp.getStorageCounty());
                t.setStoragecountyname(rffssp.getStorageCountyName());
                t.setStorageaddress(rffssp.getStorageAddress());
                String storagePowerTon = rffssp.getStoragePowerTon();
                if(StringUtils.isNotEmpty(storagePowerTon)){
                    t.setStoragepowerton(Integer.parseInt(storagePowerTon));
                }
                String storagePowerCubicMeter = rffssp.getStoragePowerCubicMeter();
                if(StringUtils.isNotEmpty(storagePowerCubicMeter)){
                    t.setStoragepowercubicmeter(Integer.parseInt(storagePowerCubicMeter));
                }
                t.setUniscid(rffssp.getUniscId());
                t.setRecnum(rffssp.getRecNum());
                if(rffssp.getRecTime()!=null){
                    t.setRectime(rffssp.getRecTime());
                }
                if(rffssp.getEntryTime()!=null){
                    t.setEntrytime(rffssp.getEntryTime());
                }
                if(rffssp.getIssueorg()!=null){
                    t.setHandleunitcode(rffssp.getIssueorg());
                    CodeOrganEntity codeOrgan = codeOrganService.getById(rffssp.getIssueorg());
                    if(codeOrgan!=null){
                        t.setHandleunit(codeOrgan.getName());
                    }
                }
            }
            NfAgentEntity agent = record.getAgent();
            if(agent!=null){
                t.setProxyname(agent.getName());
                t.setProxycontactinfo(agent.getMobile());
            }
            NfCheckedEntity accept = record.getAccept();
            if(accept!=null){
                t.setReceiver(accept.getName());
            }

            thirdColdStorageInfoService.saveData(t);

        }


        return R.ok();
    }

    @RequestMapping("/changec/save")
    @RequiresPermissions("nfrecord:changec:save")
    public R changecSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/cancelc/save")
    @RequiresPermissions("nfrecord:cancelc:save")
    public R cancelcSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    private void backupRecord (NfRecordEntity record, String businType){
        NfRffsspEntity rffssp = record.getRffssp();
        if (null != businType && null != rffssp && StringUtils.isNotEmpty(rffssp.getId())){
            MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
            mapperFactory.classMap(RffsspHistoryEntity.class, NfRffsspEntity.class)
                    .byDefault().register();
            MapperFacade mapper = mapperFactory.getMapperFacade();
            NfRffsspEntity rffsspOld = rffsspService.getById(rffssp.getId());
            RffsspHistoryEntity rffsspHistoryEntity = mapper.map(rffsspOld, RffsspHistoryEntity.class);
            rffsspHistoryEntity.setId(IdWorker.getIdStr());
            rffsspHistoryEntity.setRealid(rffsspOld.getId());
            rffsspHistoryService.saveOrUpdate(rffsspHistoryEntity);

            NfBusinEntity busin = businService.queryByRffsspid(rffssp.getId());
            if (null != busin){
                /***************NfAgentEntity*******************/
                MapperFactory mapperFactoryA = new DefaultMapperFactory.Builder().build();
                mapperFactoryA.classMap(AgentHistoryEntity.class, NfAgentEntity.class)
                        .byDefault().register();
                MapperFacade mapperA = mapperFactoryA.getMapperFacade();
                NfAgentEntity agentOld = agentService.getByBusinid(busin.getId());
                AgentHistoryEntity agentHistoryEntity = mapperA.map(agentOld, AgentHistoryEntity.class);
                agentHistoryEntity.setId(IdWorker.getIdStr());
                agentHistoryEntity.setRealid(agentOld.getId());
                agentHistoryService.saveOrUpdate(agentHistoryEntity);

                /***************List<NfMaterialEntity>*******************/
                MapperFactory mapperFactoryB = new DefaultMapperFactory.Builder().build();
                mapperFactoryB.classMap(MaterialHistoryEntity.class, NfMaterialEntity.class)
                        .byDefault().register();
                MapperFacade mapperB = mapperFactoryB.getMapperFacade();
                List<NfMaterialEntity> nfMaterialEntities = materialService.getsByBusinid(busin.getId());
                if(CollectionUtils.isNotEmpty(nfMaterialEntities)) {
                    for (NfMaterialEntity nf : nfMaterialEntities) {
                        MaterialHistoryEntity materialHistoryEntity = mapperB.map(nf, MaterialHistoryEntity.class);
                        materialHistoryEntity.setId(IdWorker.getIdStr());
                        materialHistoryEntity.setRealid(nf.getId());
                        materialHistoryService.saveOrUpdate(materialHistoryEntity);
                    }
                }
                /***************List<UploadEntity>*******************/
                MapperFactory mapperFactoryC = new DefaultMapperFactory.Builder().build();
                mapperFactoryC.classMap(UploadHistoryEntity.class, UploadEntity.class)
                        .byDefault().register();
                MapperFacade mapperC = mapperFactoryC.getMapperFacade();
                List<UploadEntity> uploadEntities = uploadService.getUpload(busin.getId());
                if(CollectionUtils.isNotEmpty(uploadEntities)) {
                    for (UploadEntity ul : uploadEntities) {
                        UploadHistoryEntity uploadHistory = mapperC.map(ul, UploadHistoryEntity.class);
                        uploadHistory.setId(IdWorker.getId());
                        uploadHistory.setRealid(ul.getId());
                        uploadHistoryService.saveOrUpdate(uploadHistory);
                    }
                }

                /***************NfAgentEntity*******************/
                MapperFactory mapperFactoryD = new DefaultMapperFactory.Builder().build();
                mapperFactoryD.classMap(BusinHistoryEntity.class, NfBusinEntity.class)
                        .byDefault().register();
                MapperFacade mapperD = mapperFactoryD.getMapperFacade();
                BusinHistoryEntity businHistoryEntity = mapperD.map(busin, BusinHistoryEntity.class);
                businHistoryEntity.setId(IdWorker.getIdStr());
                businHistoryEntity.setRealid(busin.getId());
                businHistoryService.saveOrUpdate(businHistoryEntity);
                businService.removeById(busin.getId());
            }
        }
    }

    private void save (NfRecordEntity record, String rffssStatus, String businType, String businStatus){
        backupRecord(record, businType);
        NfRffsspEntity rffssp = record.getRffssp();
        if (null != rffssp){
            if (!StringUtils.isNotEmpty(rffssp.getId())){
                rffssp.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
            }
            if (null == rffssp.getCreatetime()){
                rffssp.setCreatetime(new Date());
            }
            rffssp.setLasttime(new Date());
            rffssp.setStatus(rffssStatus);
            rffssp.setValid(1);
            rffsspService.saveOrUpdate(rffssp);
        }
        NfBusinEntity busin = record.getBusin();
        if (null != busin){
            if (!StringUtils.isNotEmpty(busin.getId())){
                busin.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
            }
            busin.setRffsspid(rffssp.getId());
            if (null == busin.getCreatetime()){
                busin.setCreatetime(new Date());
            }
            busin.setBtype(null==businType?busin.getBtype():businType);
            busin.setLasttime(new Date());
            busin.setStatus(businStatus);
            businService.saveOrUpdate(busin);
            List<UploadEntity> uploadEntities = record.getUploadEntities();
            if(CollectionUtils.isNotEmpty(uploadEntities)){
                for (UploadEntity upload:uploadEntities){
                    upload.setBusiness(busin.getBtype());
                    upload.setBusinessId(busin.getId());
                    upload.setLasttime(new Date());
                    upload.setCreatetime(new Date());
                    uploadService.saveOrUpdate(upload);
                }
            }
        }
        NfAgentEntity agent = record.getAgent();
        if (null != busin){
            if (!StringUtils.isNotEmpty(agent.getId())){
                agent.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
            }
            agent.setBusinid(busin.getId());
            if (null == agent.getCreatetime()){
                agent.setCreatetime(new Date());
            }
            agent.setLasttime(new Date());
            agentService.saveOrUpdate(agent);
        }
        List<NfMaterialEntity> layouts = record.getLayout();
        if (null != layouts && layouts.size()>0){
            int i = 1;
            for (NfMaterialEntity material: layouts){
                if (!StringUtils.isNotEmpty(material.getId())){
                    material.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
                }
                material.setMtype(RffssConstant.MATERIAL_TYPE_LAYOUT);
                material.setName(i++);
                material.setBusinid(busin.getId());
                if (null == material.getCreatetime()){
                    material.setCreatetime(new Date());
                }
                material.setLasttime(new Date());
                materialService.saveOrUpdate(material);
            }
        }
        List<NfMaterialEntity> idCardHead = record.getIdCardHead();
        if (null != idCardHead && idCardHead.size()>0){
            int i = 1;
            for (NfMaterialEntity material: idCardHead){
                if (!StringUtils.isNotEmpty(material.getId())){
                    material.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
                }
                material.setMtype(RffssConstant.MATERIAL_TYPE_IDCARDHEAD);
                material.setName(i++);
                material.setBusinid(busin.getId());
                if (null == material.getCreatetime()){
                    material.setCreatetime(new Date());
                }
                material.setLasttime(new Date());
                materialService.saveOrUpdate(material);
            }
        }
        List<NfMaterialEntity> idCardNe = record.getIdCardNe();
        if (null != idCardNe && idCardNe.size()>0){
            int i = 1;
            for (NfMaterialEntity material: idCardNe){
                if (!StringUtils.isNotEmpty(material.getId())){
                    material.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
                }
                material.setMtype(RffssConstant.MATERIAL_TYPE_IDCARDNE);
                material.setName(i++);
                material.setBusinid(busin.getId());
                if (null == material.getCreatetime()){
                    material.setCreatetime(new Date());
                }
                material.setLasttime(new Date());
                materialService.saveOrUpdate(material);
            }
        }
        List<NfMaterialEntity> letterCommits = record.getLetterCommit();
        if (null != letterCommits && letterCommits.size()>0){
            int i = 1;
            for (NfMaterialEntity material: letterCommits){
                if (!StringUtils.isNotEmpty(material.getId())){
                    material.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
                }
                material.setMtype(RffssConstant.MATERIAL_TYPE_LETTERCOMMIT);
                material.setName(i++);
                material.setBusinid(busin.getId());
                if (null == material.getCreatetime()){
                    material.setCreatetime(new Date());
                }
                material.setLasttime(new Date());
                materialService.saveOrUpdate(material);
            }
        }

        NfCheckedEntity accept = record.getAccept();
        if (null != accept && StringUtils.isNotEmpty(accept.getName())){
//            accept.setId(accept.getId()==0L?null:accept.getId());
            if (!StringUtils.isNotEmpty(accept.getId())){
                accept.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
            }
            accept.setCtype(RffssConstant.CHECKED_TYPE_ACCEPT);
            accept.setBusinid(busin.getId());
            if (null == accept.getCreatetime()){
                accept.setCreatetime(new Date());
            }
            accept.setLasttime(new Date());
            if (StringUtils.equals(accept.getCresult(),(RffssConstant.CHECKED_RESULT_NO))){
                rffssp.setStatus(RffssConstant.RFFSSP_STATUS_OVER);
            }
            busin.setStatus(accept.getCtype() + accept.getCresult());
            checkedService.saveOrUpdate(accept);
        }

        NfCheckedEntity checked = record.getChecked();
        if (null != checked && StringUtils.isNotEmpty(checked.getName())){
//            checked.setId(checked.getId()==0L?null:checked.getId());
            if (!StringUtils.isNotEmpty(checked.getId())){
                checked.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
            }
            checked.setCtype(RffssConstant.CHECKED_TYPE_CHECKED);
            checked.setBusinid(busin.getId());
            if (null == checked.getCreatetime()){
                checked.setCreatetime(new Date());
            }
            checked.setLasttime(new Date());
            rffssp.setStatus(RffssConstant.RFFSSP_STATUS_OVER);
            busin.setStatus(checked.getCtype() + checked.getCresult());
            checkedService.saveOrUpdate(checked);
        }
        rffsspService.saveOrUpdate(rffssp);
        businService.saveOrUpdate(busin);
    }

}
