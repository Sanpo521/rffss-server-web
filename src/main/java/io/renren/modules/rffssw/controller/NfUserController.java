package io.renren.modules.rffssw.controller;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.rffssw.entity.NfUserEntity;
import io.renren.modules.rffssw.service.NfUserService;
import io.renren.modules.sys.form.PasswordForm;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaoxiubin
 * @create 2022-10-31 15:11
 * @desc 外网用户控制类
 **/

@RestController
@RequestMapping("/user")
public class NfUserController extends NfAbstractController {
    @Autowired
    private NfUserService nfUserService;

    /**
     * 获取登录的用户信息
     */
    @GetMapping("/info")
    public R info(){
        return R.ok().put("user", getUser());
    }

    /**
     * 修改登录用户密码
     */
    @SysLog("修改密码")
    @PostMapping("/password")
    public R password(@RequestBody PasswordForm form){
        Assert.isBlank(form.getNewPassword(), "新密码不为能空");

        //sha256加密
        String password = new Sha256Hash(form.getPassword(), getUser().getSalt()).toHex();
        //sha256加密
        String newPassword = new Sha256Hash(form.getNewPassword(), getUser().getSalt()).toHex();

        //更新密码
        boolean flag = nfUserService.updatePassword(getUserId(), password, newPassword);
        if(!flag){
            return R.error("原密码不正确");
        }

        return R.ok();
    }

    /**
     * 保存用户
     */
    @PostMapping("/save")
    public R save(@RequestBody NfUserEntity user){
        ValidatorUtils.validateEntity(user, AddGroup.class);
//用户信息
//        NfUserEntity userTemp = nfUserService.queryByUserName(user.getUsername());
//        if (null == userTemp){
            nfUserService.saveUser(user);
//            return R.ok();
//        }
        return R.ok();
    }

    /**
     * 修改用户
     */
    @PostMapping("/update")
    public R update(@RequestBody NfUserEntity user){
        ValidatorUtils.validateEntity(user, UpdateGroup.class);
        nfUserService.update(user);
        return R.ok();
    }

    /**
     * 删除用户
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long id){
        nfUserService.delete(id);
        return R.ok();
    }
}
