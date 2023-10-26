package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiStratificationMarketInstituteEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiStratificationMarketInstituteService;
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
@RequestMapping("qy/gymrdipqassistratificationmarketinstitute")
public class GyMrdipqassiStratificationMarketInstituteController {
    @Autowired
    private GyMrdipqassiStratificationMarketInstituteService gyMrdipqassiStratificationMarketInstituteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMrdipqassiStratificationMarketInstituteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMrdipqassiStratificationMarketInstituteEntity gyMrdipqassiStratificationMarketInstitute = gyMrdipqassiStratificationMarketInstituteService.getById(id);

        return R.ok().put("gyMrdipqassiStratificationMarketInstitute", gyMrdipqassiStratificationMarketInstitute);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMrdipqassiStratificationMarketInstituteEntity gyMrdipqassiStratificationMarketInstitute){
		gyMrdipqassiStratificationMarketInstituteService.save(gyMrdipqassiStratificationMarketInstitute);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMrdipqassiStratificationMarketInstituteEntity gyMrdipqassiStratificationMarketInstitute){
		gyMrdipqassiStratificationMarketInstituteService.updateById(gyMrdipqassiStratificationMarketInstitute);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMrdipqassiStratificationMarketInstituteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
