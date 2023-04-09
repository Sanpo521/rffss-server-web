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

import io.renren.modules.rffss.entity.NfOptEntity;
import io.renren.modules.rffss.service.NfOptService;
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
@RequestMapping("rffss/nfopt")
public class NfOptController {
    @Autowired
    private NfOptService nfOptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nfOptService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		NfOptEntity nfOpt = nfOptService.getById(id);

        return R.ok().put("nfOpt", nfOpt);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NfOptEntity nfOpt){
		nfOptService.save(nfOpt);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NfOptEntity nfOpt){
		nfOptService.updateById(nfOpt);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		nfOptService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
