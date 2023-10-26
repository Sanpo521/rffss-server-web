package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiProvincialBureauDoubleRandomnessEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiProvincialBureauDoubleRandomnessService;
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
@RequestMapping("qy/gymrdipqassiprovincialbureaudoublerandomness")
public class GyMrdipqassiProvincialBureauDoubleRandomnessController {
    @Autowired
    private GyMrdipqassiProvincialBureauDoubleRandomnessService gyMrdipqassiProvincialBureauDoubleRandomnessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMrdipqassiProvincialBureauDoubleRandomnessService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMrdipqassiProvincialBureauDoubleRandomnessEntity gyMrdipqassiProvincialBureauDoubleRandomness = gyMrdipqassiProvincialBureauDoubleRandomnessService.getById(id);

        return R.ok().put("gyMrdipqassiProvincialBureauDoubleRandomness", gyMrdipqassiProvincialBureauDoubleRandomness);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMrdipqassiProvincialBureauDoubleRandomnessEntity gyMrdipqassiProvincialBureauDoubleRandomness){
		gyMrdipqassiProvincialBureauDoubleRandomnessService.save(gyMrdipqassiProvincialBureauDoubleRandomness);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMrdipqassiProvincialBureauDoubleRandomnessEntity gyMrdipqassiProvincialBureauDoubleRandomness){
		gyMrdipqassiProvincialBureauDoubleRandomnessService.updateById(gyMrdipqassiProvincialBureauDoubleRandomness);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMrdipqassiProvincialBureauDoubleRandomnessService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
