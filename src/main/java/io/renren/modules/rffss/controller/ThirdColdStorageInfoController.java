package io.renren.modules.rffss.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.ThirdColdStorageInfoEntity;
import io.renren.modules.rffss.service.ThirdColdStorageInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * oracle保存
 * @author zzb
 */
@RestController
@RequestMapping("integration/thirdcoldstorageinfo")
public class ThirdColdStorageInfoController {
    @Autowired
    private ThirdColdStorageInfoService thirdColdStorageInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("integration:thirdcoldstorageinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = thirdColdStorageInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{thirdcoldstorageinfoid}")
    @RequiresPermissions("integration:thirdcoldstorageinfo:info")
    public R info(@PathVariable("thirdcoldstorageinfoid") String thirdcoldstorageinfoid){
		ThirdColdStorageInfoEntity thirdColdStorageInfo = thirdColdStorageInfoService.getById(thirdcoldstorageinfoid);

        return R.ok().put("thirdColdStorageInfo", thirdColdStorageInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("integration:thirdcoldstorageinfo:save")
    public R save(@RequestBody ThirdColdStorageInfoEntity thirdColdStorageInfo){
		thirdColdStorageInfoService.save(thirdColdStorageInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("integration:thirdcoldstorageinfo:update")
    public R update(@RequestBody ThirdColdStorageInfoEntity thirdColdStorageInfo){
		thirdColdStorageInfoService.updateById(thirdColdStorageInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("integration:thirdcoldstorageinfo:delete")
    public R delete(@RequestBody String[] thirdcoldstorageinfoids){
		thirdColdStorageInfoService.removeByIds(Arrays.asList(thirdcoldstorageinfoids));

        return R.ok();
    }

}
