package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiProvincialBureauPunishmentSituationDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiProvincialBureauPunishmentSituationEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiProvincialBureauPunishmentSituationService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiProvincialBureauPunishmentSituationService")
public class GyMrdipqassiProvincialBureauPunishmentSituationServiceImpl extends ServiceImpl<GyMrdipqassiProvincialBureauPunishmentSituationDao, GyMrdipqassiProvincialBureauPunishmentSituationEntity> implements GyMrdipqassiProvincialBureauPunishmentSituationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiProvincialBureauPunishmentSituationEntity> page = this.page(
                new Query<GyMrdipqassiProvincialBureauPunishmentSituationEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiProvincialBureauPunishmentSituationEntity>()
        );

        return new PageUtils(page);
    }

}
