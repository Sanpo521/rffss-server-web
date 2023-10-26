package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyEqmsaiiEntity;
import io.renren.modules.rffss.service.qy.GyEqmsaiiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:42
 */
@RestController
@RequestMapping("qy/gyeqmsaii")
public class GyEqmsaiiController {
    @Autowired
    private GyEqmsaiiService gyEqmsaiiService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyEqmsaiiService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyEqmsaiiEntity gyEqmsaii = gyEqmsaiiService.getById(id);

        return R.ok().put("gyEqmsaii", gyEqmsaii);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyEqmsaiiEntity gyEqmsaii){
		gyEqmsaiiService.save(gyEqmsaii);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyEqmsaiiEntity gyEqmsaii){
		gyEqmsaiiService.updateById(gyEqmsaii);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyEqmsaiiService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
