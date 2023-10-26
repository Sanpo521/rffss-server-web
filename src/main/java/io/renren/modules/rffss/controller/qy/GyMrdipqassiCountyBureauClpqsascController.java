package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiCountyBureauClpqsascEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiCountyBureauClpqsascService;
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
@RequestMapping("qy/gymrdipqassicountybureauclpqsasc")
public class GyMrdipqassiCountyBureauClpqsascController {
    @Autowired
    private GyMrdipqassiCountyBureauClpqsascService gyMrdipqassiCountyBureauClpqsascService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMrdipqassiCountyBureauClpqsascService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMrdipqassiCountyBureauClpqsascEntity gyMrdipqassiCountyBureauClpqsasc = gyMrdipqassiCountyBureauClpqsascService.getById(id);

        return R.ok().put("gyMrdipqassiCountyBureauClpqsasc", gyMrdipqassiCountyBureauClpqsasc);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMrdipqassiCountyBureauClpqsascEntity gyMrdipqassiCountyBureauClpqsasc){
		gyMrdipqassiCountyBureauClpqsascService.save(gyMrdipqassiCountyBureauClpqsasc);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMrdipqassiCountyBureauClpqsascEntity gyMrdipqassiCountyBureauClpqsasc){
		gyMrdipqassiCountyBureauClpqsascService.updateById(gyMrdipqassiCountyBureauClpqsasc);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMrdipqassiCountyBureauClpqsascService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
