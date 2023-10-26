package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMarketRegulatedInformationEntity;
import io.renren.modules.rffss.service.qy.GyMarketRegulatedInformationService;
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
@RequestMapping("qy/gymarketregulatedinformation")
public class GyMarketRegulatedInformationController {
    @Autowired
    private GyMarketRegulatedInformationService gyMarketRegulatedInformationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMarketRegulatedInformationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMarketRegulatedInformationEntity gyMarketRegulatedInformation = gyMarketRegulatedInformationService.getById(id);

        return R.ok().put("gyMarketRegulatedInformation", gyMarketRegulatedInformation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMarketRegulatedInformationEntity gyMarketRegulatedInformation){
		gyMarketRegulatedInformationService.save(gyMarketRegulatedInformation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMarketRegulatedInformationEntity gyMarketRegulatedInformation){
		gyMarketRegulatedInformationService.updateById(gyMarketRegulatedInformation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMarketRegulatedInformationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
