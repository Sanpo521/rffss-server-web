package io.renren.modules.rffss.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.NfMaterialEntity;
import io.renren.modules.rffss.service.NfMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 材料表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
@RestController
@RequestMapping("rffss/nfmaterial")
public class NfMaterialController {
    @Autowired
    private NfMaterialService nfMaterialService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nfMaterialService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
		NfMaterialEntity nfMaterial = nfMaterialService.getById(id);

        return R.ok().put("nfMaterial", nfMaterial);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NfMaterialEntity nfMaterial){
		nfMaterialService.save(nfMaterial);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NfMaterialEntity nfMaterial){
		nfMaterialService.updateById(nfMaterial);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] ids){
		nfMaterialService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
