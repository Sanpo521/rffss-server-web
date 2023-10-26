package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyEqmsaiiWeekEntity;
import io.renren.modules.rffss.service.qy.GyEqmsaiiWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:41
 */
@RestController
@RequestMapping("qy/gyeqmsaiiweek")
public class GyEqmsaiiWeekController {
    @Autowired
    private GyEqmsaiiWeekService gyEqmsaiiWeekService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyEqmsaiiWeekService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyEqmsaiiWeekEntity gyEqmsaiiWeek = gyEqmsaiiWeekService.getById(id);

        return R.ok().put("gyEqmsaiiWeek", gyEqmsaiiWeek);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyEqmsaiiWeekEntity gyEqmsaiiWeek){
		gyEqmsaiiWeekService.save(gyEqmsaiiWeek);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyEqmsaiiWeekEntity gyEqmsaiiWeek){
		gyEqmsaiiWeekService.updateById(gyEqmsaiiWeek);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyEqmsaiiWeekService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
