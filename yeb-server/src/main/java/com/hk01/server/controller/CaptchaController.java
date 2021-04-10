/**
 * @program: yeb
 * @description:
 * @author nnnNN
 * @date 2021-04-08 23:26:50
 */

package com.hk01.server.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@Slf4j
public class CaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @ApiOperation(value = "验证码")
    @GetMapping(value = "/captcha",produces = "image/jpg")
    public void captcha(HttpServletRequest request, HttpServletResponse response){
        //定义response输出类型为image/jpeg
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        //生成验证码
        String text = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(text);

        request.getSession().setAttribute("captcha",text);

        log.debug("验证码:"+text);
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            //输出流输出图片
            ImageIO.write(image, "jpg", outputStream);
        } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
