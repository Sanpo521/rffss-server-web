package io.renren.modules.rffss.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.dao.CodeOrganDao;
import io.renren.modules.rffss.entity.CodeOrganEntity;
import io.renren.modules.rffss.service.CodeOrganService;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("codeOrganService")
//@DataSource("oracle")
public class CodeOrganServiceImpl extends ServiceImpl<CodeOrganDao, CodeOrganEntity> implements CodeOrganService {
    private static final Logger LOG = LoggerFactory.getLogger(CodeOrganServiceImpl.class);

    @Autowired
    private CodeOrganDao codeOrganDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<CodeOrganEntity> queryWrapper = new QueryWrapper<CodeOrganEntity>().eq("enabled", 1);
        String orgcode = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getOrgcode();
        queryWrapper.and(wq->wq.eq("code", orgcode).or().eq("parentcode", orgcode));
        List<CodeOrganEntity> codeOrganEntityList = this.baseMapper.selectList(queryWrapper);
        return new PageUtils(codeOrganEntityList, codeOrganEntityList.size(), 1, 1);
    }


    @Override
    public List<CodeOrganEntity> queryListByCode(String orgcode){
        QueryWrapper<CodeOrganEntity> queryWrapper = new QueryWrapper<CodeOrganEntity>().eq("enabled", 1);
        queryWrapper.and(wq->wq.eq("code", orgcode).or().eq("parentcode", orgcode));
        queryWrapper.orderByAsc("code");
        List<CodeOrganEntity> codeOrganEntityList = this.baseMapper.selectList(queryWrapper);
        return codeOrganEntityList;
    }

    @Override
    public JSONArray queryTree(String parentcode){
        JSONArray ja =  new JSONArray();
        List<CodeOrganEntity> codeOrgans = getByParentcode(parentcode);
        if (null != codeOrgans && codeOrgans.size()>0){
            for (CodeOrganEntity codeOrgan: codeOrgans){
                JSONArray jaa = queryTree(codeOrgan.getCode());
                if (null==jaa){
                    codeOrgan.setSubOrgans("");
                    ja.add(codeOrgan);
                }else{
                    codeOrgan.setSubOrgans(jaa);
                    ja.add(codeOrgan);
                }
            }
        }else{
            return null;
        }
        return ja;
    }

    @Override
    public JSONArray queryTreeEx(String code){
        JSONArray ja =  new JSONArray();
        CodeOrganEntity codeOrganCur = getByCode(code);
        JSONArray jaa = queryTree(code);
        if (null==jaa){
            codeOrganCur.setSubOrgans("");
            ja.add(codeOrganCur);
        }else{
            codeOrganCur.setSubOrgans(jaa);
            ja.add(codeOrganCur);
        }
        return ja;
    }

    @Override
    public CodeOrganEntity getByCode(String code) {
        CodeOrganEntity codeOrgan = codeOrganDao.selectOne(new QueryWrapper<CodeOrganEntity>().eq("code", code));
        return codeOrgan;
    }

    @Override
    public CodeOrganEntity getByName(String name) {
        CodeOrganEntity codeOrgan = codeOrganDao.selectOne(new QueryWrapper<CodeOrganEntity>().eq("name", name));
        return codeOrgan;
    }

    @Override
    public List<CodeOrganEntity> getByParentcode(String parentcode){
        List<CodeOrganEntity> codeOrgans = codeOrganDao.selectList(new QueryWrapper<CodeOrganEntity>().eq("parentcode", parentcode));
        return codeOrgans;
    }
}
