package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyBioepqasmEntity;
import io.renren.modules.rffss.service.qy.GyBioepqasmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:43
 */
@RestController
@RequestMapping("qy/gybioepqasm")
public class GyBioepqasmController {
    @Autowired
    private GyBioepqasmService gyBioepqasmService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyBioepqasmService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyBioepqasmEntity gyBioepqasm = gyBioepqasmService.getById(id);

        return R.ok().put("gyBioepqasm", gyBioepqasm);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyBioepqasmEntity gyBioepqasm){
		gyBioepqasmService.save(gyBioepqasm);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyBioepqasmEntity gyBioepqasm){
		gyBioepqasmService.updateById(gyBioepqasm);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyBioepqasmService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
