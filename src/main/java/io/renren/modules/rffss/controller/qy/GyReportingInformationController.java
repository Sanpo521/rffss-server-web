package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyReportingInformationEntity;
import io.renren.modules.rffss.service.qy.GyReportingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:43
 */
@RestController
@RequestMapping("qy/gyreportinginformation")
public class GyReportingInformationController {
    @Autowired
    private GyReportingInformationService gyReportingInformationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyReportingInformationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyReportingInformationEntity gyReportingInformation = gyReportingInformationService.getById(id);

        return R.ok().put("gyReportingInformation", gyReportingInformation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyReportingInformationEntity gyReportingInformation){
		gyReportingInformationService.save(gyReportingInformation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyReportingInformationEntity gyReportingInformation){
		gyReportingInformationService.updateById(gyReportingInformation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyReportingInformationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
