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

import io.renren.modules.rffss.entity.NfBusinEntity;
import io.renren.modules.rffss.service.NfBusinService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 业务表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
@RestController
@RequestMapping("rffss/nfbusin")
public class NfBusinController {
    @Autowired
    private NfBusinService nfBusinService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nfBusinService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
		NfBusinEntity nfBusin = nfBusinService.getById(id);

        return R.ok().put("nfBusin", nfBusin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NfBusinEntity nfBusin){
		nfBusinService.save(nfBusin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NfBusinEntity nfBusin){
		nfBusinService.updateById(nfBusin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] ids){
		nfBusinService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
