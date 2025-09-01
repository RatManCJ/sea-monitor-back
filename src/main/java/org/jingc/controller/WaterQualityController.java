package org.jingc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
import java.util.Map;

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

    @GetMapping("demo")
    public String demo(@RequestParam Map<String, Object> params) {

        // 创建ObjectMapper实例
        ObjectMapper objectMapper = new ObjectMapper();
        String id = params.get("id").toString();

        String o = (String)params.get("name");

        System.out.println("o = " + o);

//        // 将 demo 字段的 map 转换为 Demo 对象
//        Map<String, Object> demoMap = (Map<String, Object>) params.get("demo");
//        Demo demo = objectMapper.convertValue(demoMap, Demo.class);
//
//        System.out.println("id:" + id);
//        System.out.println("demo.toString() = " + demo.toString());

        return "demo";
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Demo {
    private Long id;

    private String name;
}