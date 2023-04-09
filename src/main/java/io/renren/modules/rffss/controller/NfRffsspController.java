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

import io.renren.modules.rffss.entity.NfRffsspEntity;
import io.renren.modules.rffss.service.NfRffsspService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 冷藏冷冻食品贮存服务提供者
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
@RestController
@RequestMapping("rffss/nfrffssp")
public class NfRffsspController {
    @Autowired
    private NfRffsspService nfRffsspService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nfRffsspService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
		NfRffsspEntity nfRffssp = nfRffsspService.getById(id);

        return R.ok().put("nfRffssp", nfRffssp);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NfRffsspEntity nfRffssp){
		nfRffsspService.save(nfRffssp);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NfRffsspEntity nfRffssp){
		nfRffsspService.updateById(nfRffssp);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] ids){
		nfRffsspService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
