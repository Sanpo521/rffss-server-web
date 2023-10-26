package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyProductRecallInformationEntity;
import io.renren.modules.rffss.service.qy.GyProductRecallInformationService;
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
@RequestMapping("qy/gyproductrecallinformation")
public class GyProductRecallInformationController {
    @Autowired
    private GyProductRecallInformationService gyProductRecallInformationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyProductRecallInformationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyProductRecallInformationEntity gyProductRecallInformation = gyProductRecallInformationService.getById(id);

        return R.ok().put("gyProductRecallInformation", gyProductRecallInformation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyProductRecallInformationEntity gyProductRecallInformation){
		gyProductRecallInformationService.save(gyProductRecallInformation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyProductRecallInformationEntity gyProductRecallInformation){
		gyProductRecallInformationService.updateById(gyProductRecallInformation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyProductRecallInformationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
