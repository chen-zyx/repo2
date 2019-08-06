package com.chen.test_project_day01.controller;

import com.chen.test_project_day01.entity.Place;
import com.chen.test_project_day01.service.IPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private IPlaceService iPlaceService;

    @RequestMapping("/toPlace")
    public String toPlace(){
        return "addr/index";
    }

    @RequestMapping("/getPlace")
    @ResponseBody
    public List<Place> getPlace(){
        return  iPlaceService.findAllPlace();
    }




}
