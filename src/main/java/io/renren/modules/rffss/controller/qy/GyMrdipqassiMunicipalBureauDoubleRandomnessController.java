package io.renren.modules.rffss.controller.qy;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiMunicipalBureauDoubleRandomnessEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiMunicipalBureauDoubleRandomnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;




/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-24 09:44:37
 */
@RestController
@RequestMapping("qy/gymrdipqassimunicipalbureaudoublerandomness")
public class GyMrdipqassiMunicipalBureauDoubleRandomnessController {
    @Autowired
    private GyMrdipqassiMunicipalBureauDoubleRandomnessService gyMrdipqassiMunicipalBureauDoubleRandomnessService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMrdipqassiMunicipalBureauDoubleRandomnessService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMrdipqassiMunicipalBureauDoubleRandomnessEntity gyMrdipqassiMunicipalBureauDoubleRandomness = gyMrdipqassiMunicipalBureauDoubleRandomnessService.getById(id);

        return R.ok().put("gyMrdipqassiMunicipalBureauDoubleRandomness", gyMrdipqassiMunicipalBureauDoubleRandomness);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMrdipqassiMunicipalBureauDoubleRandomnessEntity gyMrdipqassiMunicipalBureauDoubleRandomness){
		gyMrdipqassiMunicipalBureauDoubleRandomnessService.save(gyMrdipqassiMunicipalBureauDoubleRandomness);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMrdipqassiMunicipalBureauDoubleRandomnessEntity gyMrdipqassiMunicipalBureauDoubleRandomness){
		gyMrdipqassiMunicipalBureauDoubleRandomnessService.updateById(gyMrdipqassiMunicipalBureauDoubleRandomness);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMrdipqassiMunicipalBureauDoubleRandomnessService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
