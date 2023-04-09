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

import io.renren.modules.rffss.entity.NfAgentEntity;
import io.renren.modules.rffss.service.NfAgentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 代理人
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
@RestController
@RequestMapping("rffss/nfagent")
public class NfAgentController {
    @Autowired
    private NfAgentService nfAgentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nfAgentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
		NfAgentEntity nfAgent = nfAgentService.getById(id);

        return R.ok().put("nfAgent", nfAgent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NfAgentEntity nfAgent){
		nfAgentService.save(nfAgent);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NfAgentEntity nfAgent){
		nfAgentService.updateById(nfAgent);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] ids){
		nfAgentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
