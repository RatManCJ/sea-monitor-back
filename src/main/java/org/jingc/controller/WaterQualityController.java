package org.jingc.controller;

import org.jingc.service.WaterQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: WaterQuality
 * @Author jingc
 * @Package org.jingc.controller
 * @Date 2025/3/2 16:11
 * @description:
 */

@RestController
@CrossOrigin
@RequestMapping("water")
public class WaterQualityController {

    @Autowired
    private WaterQualityService waterQualityService;

}
