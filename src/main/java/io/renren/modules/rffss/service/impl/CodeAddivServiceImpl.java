package io.renren.modules.rffss.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.dao.CodeAddivDao;
import io.renren.modules.rffss.entity.CodeAddivEntity;
import io.renren.modules.rffss.service.CodeAddivService;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhaoxiubin
 * create-time 2023-04-05 11:54
 * description 代码集--行政区划实现类
 **/
@Service("codeAddivService")
public class CodeAddivServiceImpl extends ServiceImpl<CodeAddivDao, CodeAddivEntity> implements CodeAddivService {
    private static final Logger LOG = LoggerFactory.getLogger(CodeAddivServiceImpl.class);

    @Autowired
    private CodeAddivDao codeAddivDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<CodeAddivEntity> queryWrapper = new QueryWrapper<CodeAddivEntity>().eq("enabled", 1);
        String orgcode = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getOrgcode();
        queryWrapper.and(wq->wq.eq("code", orgcode).or().eq("parent", orgcode));
        List<CodeAddivEntity> codeAddivEntityList = this.baseMapper.selectList(queryWrapper);
        return new PageUtils(codeAddivEntityList, codeAddivEntityList.size(), 1, 1);
    }


    @Override
    public List<CodeAddivEntity> queryListByCode(String orgcode){
        QueryWrapper<CodeAddivEntity> queryWrapper = new QueryWrapper<CodeAddivEntity>().eq("enabled", 1);
        queryWrapper.and(wq->wq.eq("code", orgcode).or().eq("parent", orgcode));
        queryWrapper.orderByAsc("code");
        List<CodeAddivEntity> codeAddivEntityList = this.baseMapper.selectList(queryWrapper);
        return codeAddivEntityList;
    }

    @Override
    public JSONArray queryTree(String parentcode){
        JSONArray ja =  new JSONArray();
        List<CodeAddivEntity> codeAddivs = getByParentcode(parentcode);
        if (null != codeAddivs && codeAddivs.size()>0){
            for (CodeAddivEntity codeAddiv: codeAddivs){
                JSONArray jaa = queryTree(codeAddiv.getCode());
                if (null==jaa){
                    codeAddiv.setSubAddivs("");
                    ja.add(codeAddiv);
                }else{
                    codeAddiv.setSubAddivs(jaa);
                    ja.add(codeAddiv);
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
        CodeAddivEntity codeAddivCur = getByCode(code);
        JSONArray jaa = queryTree(code);
        if (null==jaa){
            codeAddivCur.setSubAddivs("");
            ja.add(codeAddivCur);
        }else{
            codeAddivCur.setSubAddivs(jaa);
            ja.add(codeAddivCur);
        }
        return ja;
    }

    @Override
    public CodeAddivEntity getByCode(String code) {
        CodeAddivEntity codeAddiv = codeAddivDao.selectOne(new QueryWrapper<CodeAddivEntity>().eq("code", code));
        return codeAddiv;
    }

    @Override
    public CodeAddivEntity getByName(String name) {
        CodeAddivEntity codeAddiv = codeAddivDao.selectOne(new QueryWrapper<CodeAddivEntity>().eq("name", name));
        return codeAddiv;
    }

    @Override
    public List<CodeAddivEntity> getByParentcode(String parentcode){
        List<CodeAddivEntity> codeAddivs = codeAddivDao.selectList(new QueryWrapper<CodeAddivEntity>().eq("parent", parentcode));
        return codeAddivs;
    }
}
