package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiCountyBureauAoapfpqatclEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiCountyBureauAoapfpqatclService;
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
@RequestMapping("qy/gymrdipqassicountybureauaoapfpqatcl")
public class GyMrdipqassiCountyBureauAoapfpqatclController {
    @Autowired
    private GyMrdipqassiCountyBureauAoapfpqatclService gyMrdipqassiCountyBureauAoapfpqatclService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMrdipqassiCountyBureauAoapfpqatclService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMrdipqassiCountyBureauAoapfpqatclEntity gyMrdipqassiCountyBureauAoapfpqatcl = gyMrdipqassiCountyBureauAoapfpqatclService.getById(id);

        return R.ok().put("gyMrdipqassiCountyBureauAoapfpqatcl", gyMrdipqassiCountyBureauAoapfpqatcl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMrdipqassiCountyBureauAoapfpqatclEntity gyMrdipqassiCountyBureauAoapfpqatcl){
		gyMrdipqassiCountyBureauAoapfpqatclService.save(gyMrdipqassiCountyBureauAoapfpqatcl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMrdipqassiCountyBureauAoapfpqatclEntity gyMrdipqassiCountyBureauAoapfpqatcl){
		gyMrdipqassiCountyBureauAoapfpqatclService.updateById(gyMrdipqassiCountyBureauAoapfpqatcl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMrdipqassiCountyBureauAoapfpqatclService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
