package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiMunicipalBureauProductQualityEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiMunicipalBureauProductQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:39
 */
@RestController
@RequestMapping("qy/gymrdipqassimunicipalbureauproductquality")
public class GyMrdipqassiMunicipalBureauProductQualityController {
    @Autowired
    private GyMrdipqassiMunicipalBureauProductQualityService gyMrdipqassiMunicipalBureauProductQualityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMrdipqassiMunicipalBureauProductQualityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMrdipqassiMunicipalBureauProductQualityEntity gyMrdipqassiMunicipalBureauProductQuality = gyMrdipqassiMunicipalBureauProductQualityService.getById(id);

        return R.ok().put("gyMrdipqassiMunicipalBureauProductQuality", gyMrdipqassiMunicipalBureauProductQuality);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMrdipqassiMunicipalBureauProductQualityEntity gyMrdipqassiMunicipalBureauProductQuality){
		gyMrdipqassiMunicipalBureauProductQualityService.save(gyMrdipqassiMunicipalBureauProductQuality);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMrdipqassiMunicipalBureauProductQualityEntity gyMrdipqassiMunicipalBureauProductQuality){
		gyMrdipqassiMunicipalBureauProductQualityService.updateById(gyMrdipqassiMunicipalBureauProductQuality);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMrdipqassiMunicipalBureauProductQualityService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
