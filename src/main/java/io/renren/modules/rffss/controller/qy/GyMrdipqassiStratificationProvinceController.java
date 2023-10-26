package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiStratificationProvinceEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiStratificationProvinceService;
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
@RequestMapping("qy/gymrdipqassistratificationprovince")
public class GyMrdipqassiStratificationProvinceController {
    @Autowired
    private GyMrdipqassiStratificationProvinceService gyMrdipqassiStratificationProvinceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMrdipqassiStratificationProvinceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMrdipqassiStratificationProvinceEntity gyMrdipqassiStratificationProvince = gyMrdipqassiStratificationProvinceService.getById(id);

        return R.ok().put("gyMrdipqassiStratificationProvince", gyMrdipqassiStratificationProvince);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMrdipqassiStratificationProvinceEntity gyMrdipqassiStratificationProvince){
		gyMrdipqassiStratificationProvinceService.save(gyMrdipqassiStratificationProvince);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMrdipqassiStratificationProvinceEntity gyMrdipqassiStratificationProvince){
		gyMrdipqassiStratificationProvinceService.updateById(gyMrdipqassiStratificationProvince);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMrdipqassiStratificationProvinceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
