package io.renren.modules.rffssw.controller;

import io.renren.modules.rffssw.entity.NfUserEntity;
import io.renren.modules.sys.entity.SysUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhaoxiubin
 * @create 2022-10-31 16:00
 * @desc 控制类公共组件
 **/
@Slf4j
public abstract class NfAbstractController {

    protected NfUserEntity getUser() {
        return (NfUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId() {
        return getUser().getId();
    }
}
