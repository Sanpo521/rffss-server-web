package io.renren.modules.rffss.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.NfRffsspUserEntity;
import io.renren.modules.rffss.service.NfRffsspUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 外网用户与主体关联表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
@RestController
@RequestMapping("rffss/nfrffsspuser")
public class NfRffsspUserController {
    @Autowired
    private NfRffsspUserService nfRffsspUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nfRffsspUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		NfRffsspUserEntity nfRffsspUser = nfRffsspUserService.getById(id);

        return R.ok().put("nfRffsspUser", nfRffsspUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NfRffsspUserEntity nfRffsspUser){
		nfRffsspUserService.save(nfRffsspUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NfRffsspUserEntity nfRffsspUser){
		nfRffsspUserService.updateById(nfRffsspUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		nfRffsspUserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
