package io.renren.modules.rffssw.controller;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.renren.common.utils.R;
import io.renren.modules.rffssw.entity.NfUserEntity;
import io.renren.modules.rffssw.service.NfUserService;
import io.renren.modules.rffssw.service.NfUserTokenService;
import io.renren.modules.rffssw.service.NfCaptchaService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.form.SysLoginForm;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @author zhaoxiubin
 * @create 2022-10-31 16:06
 * @desc 外网用户登录相关
 **/

@RestController
public class NfLoginController extends NfAbstractController {
    @Autowired
    private NfUserService nfUserService;
    @Autowired
    private NfUserTokenService nfUserTokenService;
    @Autowired
    private NfCaptchaService nfCaptchaService;

    /**
     * 验证码
     */
    @GetMapping("wcaptcha.jpg")
    public void captcha(HttpServletResponse response, String uuid)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = nfCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     */
    @PostMapping("wlogin")
    public Map<String, Object> login(@RequestBody SysLoginForm form)throws IOException {
        boolean captcha = nfCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if(!captcha){
            return R.error("验证码不正确");
        }

        //用户信息
        NfUserEntity user = nfUserService.queryByUserName(form.getUsername());

        //账号不存在、密码错误
        if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return R.error("账号或密码不正确");
        }


        //账号锁定
        if(user.getStatus() == 2){
            return R.error("账号已被锁定,请联系管理员");
        }
        if(user.getStatus() == 0){
            return R.error("账号不存在");
        }

        //生成token，并保存到数据库
        R r = nfUserTokenService.createToken(user.getId());
        return r;
    }


    /**
     * 退出
     */
    @PostMapping("/wlogout")
    public R logout() {
        nfUserTokenService.logout(getUserId());
        return R.ok();
    }
}
