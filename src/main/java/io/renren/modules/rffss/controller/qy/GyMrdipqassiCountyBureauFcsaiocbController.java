package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiCountyBureauFcsaiocbEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiCountyBureauFcsaiocbService;
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
@RequestMapping("qy/gymrdipqassicountybureaufcsaiocb")
public class GyMrdipqassiCountyBureauFcsaiocbController {
    @Autowired
    private GyMrdipqassiCountyBureauFcsaiocbService gyMrdipqassiCountyBureauFcsaiocbService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMrdipqassiCountyBureauFcsaiocbService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMrdipqassiCountyBureauFcsaiocbEntity gyMrdipqassiCountyBureauFcsaiocb = gyMrdipqassiCountyBureauFcsaiocbService.getById(id);

        return R.ok().put("gyMrdipqassiCountyBureauFcsaiocb", gyMrdipqassiCountyBureauFcsaiocb);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMrdipqassiCountyBureauFcsaiocbEntity gyMrdipqassiCountyBureauFcsaiocb){
		gyMrdipqassiCountyBureauFcsaiocbService.save(gyMrdipqassiCountyBureauFcsaiocb);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMrdipqassiCountyBureauFcsaiocbEntity gyMrdipqassiCountyBureauFcsaiocb){
		gyMrdipqassiCountyBureauFcsaiocbService.updateById(gyMrdipqassiCountyBureauFcsaiocb);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMrdipqassiCountyBureauFcsaiocbService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
