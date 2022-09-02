package com.ptteng.controller;

import com.ptteng.model.occupation;
import com.ptteng.service.occupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by shun on 2017/6/23.
 */
@Controller
@RequestMapping
public class occupationController {
    @Autowired
    private occupationService occupationService;
    @RequestMapping(value = "/occupation/list", method = RequestMethod.GET)
    public String getList( ModelMap map) {
        List<occupation> occupations = occupationService.getList();
        map.addAttribute("occupations", occupations);
            return "occupationList";
    }
    @RequestMapping(value = "/occupation/list/{v_name}", method = RequestMethod.GET)
    public String getName(@PathVariable("v_name") String v_name, Model model) {
        occupation on = occupationService.getName(v_name);
        model.addAttribute("getName", on);
        return "getName";
    }

}
