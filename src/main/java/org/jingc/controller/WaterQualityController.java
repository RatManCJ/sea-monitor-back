package org.jingc.controller;

import lombok.extern.slf4j.Slf4j;
import org.jingc.entity.WaterQuality;
import org.jingc.entity.WaterQualityOut;
import org.jingc.service.WaterQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Title: WaterQuality
 * @Author jingc
 * @Package org.jingc.controller
 * @Date 2025/3/2 16:11
 * @description:
 */

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("water")
public class WaterQualityController {


    @Autowired
    private WaterQualityService waterQualityService;

    @GetMapping("import")
    public String importData() {
        waterQualityService.importData();
        return "success";
    }

    @GetMapping("/get-data-by-time")
    public List<WaterQuality> getDataByTime(@RequestParam String time) throws ParseException {
        int size = 0;
        try {
            log.info("时间为 :{}", time);
            // 将时间字符串解析为 Date 对象
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedTime = dateFormat.parse(time);
            // 调用服务层方法
            List<WaterQuality> waterQualityList = waterQualityService.getDataByTime(parsedTime);
            size = waterQualityList.size();
            log.info("获取到的数据条数 size:{}", size);
            return waterQualityList;
        } catch (Exception e) {
            log.error("org.jingc.controller.WaterQualityController.getDataByTime ERROR:", e);
            throw new RuntimeException("获取数据失败");
        }
    }


    @GetMapping("get-data-by-site-info")
    public List<WaterQualityOut> getDataBySiteInfo(@RequestParam String site) {
        try {
            log.info("site:{}", site);
            List<WaterQualityOut> waterQualityList = waterQualityService.getDataBySiteInfo(site);
            log.info("获取到的数据条数 size:{}", waterQualityList.size());
            return waterQualityList;
        } catch (Exception e) {
            log.error("org.jingc.controller.WaterQualityController.getDataBySiteInfo ERROR:", e);
            throw new RuntimeException("获取数据失败");
        }
    }

    @GetMapping("get-data-by-year-city")
    public List<WaterQualityOut> getDataByCityAndYear(@RequestParam String city,
                                                      @RequestParam String time,
                                                      @RequestParam String waterQualityClassification

    ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedTime = dateFormat.parse(time);
        return waterQualityService.getByCityAndYear(city, parsedTime, waterQualityClassification);
    }

    @GetMapping("get-all-city-by-time")
    public List<String> getAllCityByTime(
            @RequestParam String time,
            @RequestParam String waterQualityClassification

    ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedTime = dateFormat.parse(time);
        return waterQualityService.getAllCityByTime(parsedTime, waterQualityClassification);
    }

}
