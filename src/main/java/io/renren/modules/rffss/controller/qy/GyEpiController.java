package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyEpiEntity;
import io.renren.modules.rffss.service.qy.GyEpiService;
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
@RequestMapping("qy/gyepi")
public class GyEpiController {
    @Autowired
    private GyEpiService gyEpiService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyEpiService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyEpiEntity gyEpi = gyEpiService.getById(id);

        return R.ok().put("gyEpi", gyEpi);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyEpiEntity gyEpi){
		gyEpiService.save(gyEpi);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyEpiEntity gyEpi){
		gyEpiService.updateById(gyEpi);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyEpiService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
