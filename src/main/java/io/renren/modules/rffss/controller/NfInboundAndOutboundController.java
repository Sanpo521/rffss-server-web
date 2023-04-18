package io.renren.modules.rffss.controller;


import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.rffss.entity.NfInboundAndOutboundEntity;
import io.renren.modules.rffss.service.NfInboundAndOutboundService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-04-18 09:58:55
 */
@RestController
@RequestMapping("nfinboundandoutbound")
public class NfInboundAndOutboundController {
    @Autowired
    private NfInboundAndOutboundService nfInboundAndOutboundService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(   @RequestParam(value = "page") Long page,
                     @RequestParam(value = "limit") Long limit,
                     @RequestParam(value = "type",required = false) Long type,
                     @RequestParam(value = "rffsspId",required = false) Long rffsspId
                     ){
        Page<NfInboundAndOutboundEntity> pageParam = new Page<>(page, limit);
        return R.ok().put("page", nfInboundAndOutboundService.queryPage(pageParam,type,rffsspId));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		NfInboundAndOutboundEntity nfInboundAndOutbound = nfInboundAndOutboundService.getById(id);

        return R.ok().put("nfInboundAndOutbound", nfInboundAndOutbound);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody NfInboundAndOutboundEntity nfInboundAndOutbound){
		nfInboundAndOutboundService.save(nfInboundAndOutbound);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody NfInboundAndOutboundEntity nfInboundAndOutbound){
		nfInboundAndOutboundService.updateById(nfInboundAndOutbound);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		nfInboundAndOutboundService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
