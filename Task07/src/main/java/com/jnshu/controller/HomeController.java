package com.jnshu.controller;

import com.jnshu.Utils.SendCloudAPIV2_44;
import com.jnshu.Utils.SendMSG;
import com.ksyun.ks3.dto.Bucket;
import com.ksyun.ks3.dto.CannedAccessControlList;
import com.ksyun.ks3.http.HttpClientConfig;
import com.ksyun.ks3.service.Ks3;
import com.ksyun.ks3.service.Ks3Client;
import com.ksyun.ks3.service.Ks3ClientConfig;
import com.ksyun.ks3.service.request.PutObjectRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.File;
import java.util.List;

/**
 * Created by Tom on 2017/5/13.
 */
@Controller
public class HomeController {
    Logger log =Logger.getLogger(HomeController.class);

    @Autowired
    SendMSG sendMsg;

    @RequestMapping("/sendMsg")
    public String home(String tel, String pwd, Model model, HttpServletResponse response,HttpServletRequest request){

        log.info("发送验证码的方法被调用==tel："+tel+",pwd:"+pwd);
        Logger log= Logger.getLogger(HomeController.class);
        log.info("====================mobel="+tel);
        String mobelNum = tel;
        String code="321654";
//        sendMsg.send(mobelNum,"654321");
        model.addAttribute("tel",tel);
        model.addAttribute("pwd",pwd);
        HttpSession httpSession=request.getSession();
        httpSession.setAttribute("code",code);
        httpSession.setMaxInactiveInterval(60);
        return "login";

    }
    @RequestMapping("/login")
    public String login(){
        log.info("login====");
        return "login";
    }
    @RequestMapping("/loginer")
    public String loginer(String tel,String pwd){
        log.info("loginer方法被调用，参数tel："+tel+",参数pwd："+pwd);
        return "loginsuccess";
    }
    @RequestMapping("/home")
    public String home(){
        log.info("home方法被调用");

        return "home";
    }

//    public static void main(String  args []) throws Exception {
//        String number="13007299384";
//        String code="0661";

//        SendCloudAPIV2_44.send_common();

//        SendMSG sendMSG=new SendMSG("8aaf07085bf11ee1015bf6a509d00293","84bf387996074348bcafc403cc0590bd","8aaf07085bf11ee1015bf6a50bab029a");

//        sendMSG.send(number,code);


//    }






}
