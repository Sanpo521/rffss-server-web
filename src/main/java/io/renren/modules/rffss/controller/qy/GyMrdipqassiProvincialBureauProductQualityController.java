package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiProvincialBureauProductQualityEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiProvincialBureauProductQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:40
 */
@RestController
@RequestMapping("qy/gymrdipqassiprovincialbureauproductquality")
public class GyMrdipqassiProvincialBureauProductQualityController {
    @Autowired
    private GyMrdipqassiProvincialBureauProductQualityService gyMrdipqassiProvincialBureauProductQualityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMrdipqassiProvincialBureauProductQualityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMrdipqassiProvincialBureauProductQualityEntity gyMrdipqassiProvincialBureauProductQuality = gyMrdipqassiProvincialBureauProductQualityService.getById(id);

        return R.ok().put("gyMrdipqassiProvincialBureauProductQuality", gyMrdipqassiProvincialBureauProductQuality);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMrdipqassiProvincialBureauProductQualityEntity gyMrdipqassiProvincialBureauProductQuality){
		gyMrdipqassiProvincialBureauProductQualityService.save(gyMrdipqassiProvincialBureauProductQuality);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMrdipqassiProvincialBureauProductQualityEntity gyMrdipqassiProvincialBureauProductQuality){
		gyMrdipqassiProvincialBureauProductQualityService.updateById(gyMrdipqassiProvincialBureauProductQuality);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMrdipqassiProvincialBureauProductQualityService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
