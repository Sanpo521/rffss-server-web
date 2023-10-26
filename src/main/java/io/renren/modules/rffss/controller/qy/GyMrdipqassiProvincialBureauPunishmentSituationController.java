package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiProvincialBureauPunishmentSituationEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiProvincialBureauPunishmentSituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:40
 */
@RestController
@RequestMapping("qy/gymrdipqassiprovincialbureaupunishmentsituation")
public class GyMrdipqassiProvincialBureauPunishmentSituationController {
    @Autowired
    private GyMrdipqassiProvincialBureauPunishmentSituationService gyMrdipqassiProvincialBureauPunishmentSituationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gyMrdipqassiProvincialBureauPunishmentSituationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		GyMrdipqassiProvincialBureauPunishmentSituationEntity gyMrdipqassiProvincialBureauPunishmentSituation = gyMrdipqassiProvincialBureauPunishmentSituationService.getById(id);

        return R.ok().put("gyMrdipqassiProvincialBureauPunishmentSituation", gyMrdipqassiProvincialBureauPunishmentSituation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GyMrdipqassiProvincialBureauPunishmentSituationEntity gyMrdipqassiProvincialBureauPunishmentSituation){
		gyMrdipqassiProvincialBureauPunishmentSituationService.save(gyMrdipqassiProvincialBureauPunishmentSituation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GyMrdipqassiProvincialBureauPunishmentSituationEntity gyMrdipqassiProvincialBureauPunishmentSituation){
		gyMrdipqassiProvincialBureauPunishmentSituationService.updateById(gyMrdipqassiProvincialBureauPunishmentSituation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		gyMrdipqassiProvincialBureauPunishmentSituationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
