package io.renren.modules.rffss.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.rffss.entity.NfCheckedEntity;
import io.renren.modules.rffss.service.NfCheckedService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 操作记录
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
@RestController
@RequestMapping("rffss/nfchecked")
public class NfCheckedController {
    @Autowired
    private NfCheckedService nfCheckedService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("rffss:nfchecked:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nfCheckedService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("rffss:nfchecked:info")
    public R info(@PathVariable("id") Long id){
		NfCheckedEntity nfChecked = nfCheckedService.getById(id);

        return R.ok().put("nfChecked", nfChecked);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rffss:nfchecked:save")
    public R save(@RequestBody NfCheckedEntity nfChecked){
		nfCheckedService.save(nfChecked);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rffss:nfchecked:update")
    public R update(@RequestBody NfCheckedEntity nfChecked){
		nfCheckedService.updateById(nfChecked);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rffss:nfchecked:delete")
    public R delete(@RequestBody Long[] ids){
		nfCheckedService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
