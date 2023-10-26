package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiMunicipalBureauPunishmentSituationDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiMunicipalBureauPunishmentSituationEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiMunicipalBureauPunishmentSituationService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiMunicipalBureauPunishmentSituationService")
public class GyMrdipqassiMunicipalBureauPunishmentSituationServiceImpl extends ServiceImpl<GyMrdipqassiMunicipalBureauPunishmentSituationDao, GyMrdipqassiMunicipalBureauPunishmentSituationEntity> implements GyMrdipqassiMunicipalBureauPunishmentSituationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiMunicipalBureauPunishmentSituationEntity> page = this.page(
                new Query<GyMrdipqassiMunicipalBureauPunishmentSituationEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiMunicipalBureauPunishmentSituationEntity>()
        );

        return new PageUtils(page);
    }

}
