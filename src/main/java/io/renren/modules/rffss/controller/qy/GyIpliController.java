package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyIpliEntity;
import io.renren.modules.rffss.service.qy.GyIpliService;
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
@RequestMapping("qy/gyipli")
public class GyIpliController {
    @Autowired
    private GyIpliService gyIpliService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyIpliService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyIpliEntity gyIpli = gyIpliService.getById(id);

        return R.ok().put("gyIpli", gyIpli);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyIpliEntity gyIpli){
		gyIpliService.save(gyIpli);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyIpliEntity gyIpli){
		gyIpliService.updateById(gyIpli);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyIpliService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
