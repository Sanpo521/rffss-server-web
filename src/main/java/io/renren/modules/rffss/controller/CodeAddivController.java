package io.renren.modules.rffss.controller;

import com.alibaba.fastjson.JSONArray;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.CodeAddivEntity;
import io.renren.modules.rffss.service.CodeAddivService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @author zhaoxiubin
 * create-time 2023-04-05 11:47
 * description 代码集--行政区划
 **/
@RestController
@RequestMapping("codeaddiv")
public class CodeAddivController {
    @Autowired
    private CodeAddivService codeAddivService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        if (params.containsKey("key")){

        }
        PageUtils page = codeAddivService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/tree")
    public R tree(@RequestParam Map<String, Object> params){
        String parentCode = "230000";
        JSONArray tree = codeAddivService.queryTreeEx(parentCode);

        return R.ok().put("page", tree);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{code}")
    public R info(@PathVariable("code") String code){
        CodeAddivEntity codeAddiv = codeAddivService.getById(code);

        return R.ok().put("codeAddiv", codeAddiv);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rffss:codeAddiv:save")
    public R save(@RequestBody CodeAddivEntity codeAddiv){
        codeAddivService.save(codeAddiv);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rffss:codeAddiv:update")
    public R update(@RequestBody CodeAddivEntity codeAddiv){
        codeAddivService.updateById(codeAddiv);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rffss:codeAddiv:delete")
    public R delete(@RequestBody Long[] codes){
        codeAddivService.removeByIds(Arrays.asList(codes));

        return R.ok();
    }
}
