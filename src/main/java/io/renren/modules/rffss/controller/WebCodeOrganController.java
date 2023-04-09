package io.renren.modules.rffss.controller;

import com.alibaba.fastjson.JSONArray;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.CodeOrganEntity;
import io.renren.modules.rffss.service.CodeOrganService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 登记机关代码表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2021-11-08 14:31:41
 */
@RestController
@RequestMapping("wcodeorgan")
public class WebCodeOrganController {
    @Autowired
    private CodeOrganService codeOrganService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        if (params.containsKey("key")){

        }
        PageUtils page = codeOrganService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/tree")
    public R tree(@RequestParam Map<String, Object> params){
        String parentCode = "230000";
        JSONArray tree = codeOrganService.queryTreeEx(parentCode);

        return R.ok().put("page", tree);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{code}")
    public R info(@PathVariable("code") String code){
		CodeOrganEntity codeOrgan = codeOrganService.getById(code);

        return R.ok().put("codeOrgan", codeOrgan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rffss:codeorgan:save")
    public R save(@RequestBody CodeOrganEntity codeOrgan){
		codeOrganService.save(codeOrgan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rffss:codeorgan:update")
    public R update(@RequestBody CodeOrganEntity codeOrgan){
		codeOrganService.updateById(codeOrgan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rffss:codeorgan:delete")
    public R delete(@RequestBody Long[] codes){
		codeOrganService.removeByIds(Arrays.asList(codes));

        return R.ok();
    }

}
