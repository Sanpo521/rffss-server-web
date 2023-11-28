/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.sys.oauth2;

import com.google.gson.Gson;
import io.renren.common.utils.HttpContextUtils;
import io.renren.common.utils.R;
import io.renren.modules.rffss.controller.qy.GyUploadController;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * oauth2过滤器
 *
 * @author Mark sunlightcs@gmail.com
 */
public class OAuth2Filter extends AuthenticatingFilter {

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token
        String token = getRequestToken((HttpServletRequest) request);

        if(StringUtils.isBlank(token)){
            return null;
        }

        return new OAuth2Token(token);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        WebApplicationContext ctx = RequestContextUtils.findWebApplicationContext(httpServletRequest);
//        RequestMappingHandlerMapping mapping = ctx.getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
//        HandlerExecutionChain handler = null;
//        try {
//            handler = mapping.getHandler(httpServletRequest);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        HandlerMethod handlerClass = (HandlerMethod)handler.getHandler();
//        Class<?> nowClass = handlerClass.getBeanType();
//        Method method = handlerClass.getMethod();
//        ShiroIgnoreAuth anonymousAccess = AnnotationUtils.getAnnotation(nowClass, ShiroIgnoreAuth.class);
//        if (anonymousAccess != null) {
//            return true;
//        }
//        anonymousAccess = AnnotationUtils.getAnnotation(method,ShiroIgnoreAuth.class);
//        //如果方法上有 @ShiroIgnoreAuth 注解，则不进行权限校验
//        if (anonymousAccess != null) {
//            return true;
//        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();

        ///临时token处理方法
        if(StringUtils.contains(requestURI,"qy/gyupload/info")
                || StringUtils.contains(requestURI,"statistics/listExcel")
                || StringUtils.contains(requestURI,"statisticsex/listExcel")
                || StringUtils.contains(requestURI,"statisticsex/excel")
        ){
            return true;
        }

        GyUploadController example = new GyUploadController();

        Class<?> clazz = example.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ShiroIgnoreAuth.class)) {
                ShiroIgnoreAuth annotation = method.getAnnotation(ShiroIgnoreAuth.class);
                System.out.println(1);
            }
        }

        if(((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())){
            return true;
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token，如果token不存在，直接返回401
        String token = getRequestToken((HttpServletRequest) request);
        if(StringUtils.isBlank(token)){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());

            String json = new Gson().toJson(R.error(HttpStatus.SC_UNAUTHORIZED, "invalid token"));

            httpResponse.getWriter().print(json);

            return false;
        }

        return executeLogin(request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
        try {
            //处理登录失败的异常
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            R r = R.error(HttpStatus.SC_UNAUTHORIZED, throwable.getMessage());

            String json = new Gson().toJson(r);
            httpResponse.getWriter().print(json);
        } catch (IOException e1) {

        }

        return false;
    }

    /**
     * 获取请求的token
     */
    private String getRequestToken(HttpServletRequest httpRequest){
        //从header中获取token
        String token = httpRequest.getHeader("token");

        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = httpRequest.getParameter("token");
        }

        return token;
    }


}
