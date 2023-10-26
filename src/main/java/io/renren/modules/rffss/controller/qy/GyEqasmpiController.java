package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyEqasmpiEntity;
import io.renren.modules.rffss.service.qy.GyEqasmpiService;
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
@RequestMapping("qy/gyeqasmpi")
public class GyEqasmpiController {
    @Autowired
    private GyEqasmpiService gyEqasmpiService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyEqasmpiService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyEqasmpiEntity gyEqasmpi = gyEqasmpiService.getById(id);

        return R.ok().put("gyEqasmpi", gyEqasmpi);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyEqasmpiEntity gyEqasmpi){
		gyEqasmpiService.save(gyEqasmpi);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyEqasmpiEntity gyEqasmpi){
		gyEqasmpiService.updateById(gyEqasmpi);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyEqasmpiService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
