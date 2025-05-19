package org.jingc.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import lombok.extern.slf4j.Slf4j;
import org.jingc.entity.GeoJsonData;
import org.jingc.entity.WaterQuality;
import org.jingc.entity.WaterQualityIn;
import org.jingc.entity.WaterQualityOut;
import org.jingc.mapper.WaterQualityMapper;
import org.jingc.utils.ExcelImportListener;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title: WaterQualityService
 * @Author jingc
 * @Package org.jingc.service
 * @Date 2025/3/2 16:25
 * @description: 服务层
 */

@Slf4j
@Service
public class WaterQualityService {
    private final WaterQualityMapper waterQualityMapper;

    public WaterQualityService(WaterQualityMapper waterQualityMapper) {
        this.waterQualityMapper = waterQualityMapper;
    }

    public void importData() {
        ExcelImportListener<WaterQualityIn> importListener = new ExcelImportListener<>();
        // 获取文件名
        String file = "src/main/resources/water_quality_report_by_year.xlsx";
        ExcelReader excelReader = EasyExcelFactory.read(file, WaterQualityIn.class, importListener).build();
        // 读取所有 sheet
        List<ReadSheet> readSheetList = EasyExcel.read(file).build().excelExecutor().sheetList();
        for (ReadSheet readSheet : readSheetList) {
            excelReader.read(readSheet);
        }
        List<WaterQualityIn> datas = importListener.getDatas();
        for (WaterQualityIn data : datas) {
            String monitorMonth = data.getMonitorMonth();
            YearMonth yearMonth = YearMonth.parse(monitorMonth);
        }
        excelReader.finish();
    }

    public List<WaterQuality> getAllDate() {
        return waterQualityMapper.getWaterData();
    }

    public List<WaterQuality> getDataByTime(Date time) {
        return waterQualityMapper.getDataByTime(time);
    }

    public List<WaterQualityOut> getDataBySiteInfo(String site) {
        List<WaterQuality> dataBySiteInfo = waterQualityMapper.getDataBySiteInfo(site);
        List<WaterQualityOut> waterQualityOuts = new ArrayList<>();

        // 创建一个SimpleDateFormat对象用于解析原始日期字符串
        SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        // 创建一个新的SimpleDateFormat对象用于格式化日期为"yy-MM"格式
        SimpleDateFormat newFormat = new SimpleDateFormat("yy-MM");
        for (WaterQuality waterQuality : dataBySiteInfo) {
            WaterQualityOut build = WaterQualityOut.builder().id(waterQuality.getId()).sea(waterQuality.getSea()).province(waterQuality.getProvince()).city(waterQuality.getCity()).site(waterQuality.getSite()).longitude(waterQuality.getLongitude()).latitude(waterQuality.getLatitude()).monitorMonth(newFormat.format(waterQuality.getMonitorMonth())).ph(waterQuality.getPh()).dissolvedOxygen(waterQuality.getDissolvedOxygen()).chemicalOxygenDemand(waterQuality.getChemicalOxygenDemand()).inorganicNitrogen(waterQuality.getInorganicNitrogen()).activePhosphate(waterQuality.getActivePhosphate()).petroleum(waterQuality.getPetroleum()).waterQualityClassification(waterQuality.getWaterQualityClassification()).build();
            waterQualityOuts.add(build);
        }

        return waterQualityOuts;
    }

    public List<WaterQualityOut> getByCityAndYear(String city, Date parsedTime, String waterQualityClassification) {
        List<WaterQuality> byCityAndYear = waterQualityMapper.getByCityAndYear(city, parsedTime, waterQualityClassification);
        List<WaterQualityOut> waterQualityOuts = new ArrayList<>();

        // 创建一个SimpleDateFormat对象用于解析原始日期字符串
        SimpleDateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        // 创建一个新的SimpleDateFormat对象用于格式化日期为"yy-MM"格式
        SimpleDateFormat newFormat = new SimpleDateFormat("yy-MM");

        for (WaterQuality waterQuality : byCityAndYear) {
            WaterQualityOut build = WaterQualityOut.builder().id(waterQuality.getId()).sea(waterQuality.getSea()).province(waterQuality.getProvince()).city(waterQuality.getCity()).site(waterQuality.getSite()).longitude(waterQuality.getLongitude()).latitude(waterQuality.getLatitude()).monitorMonth(newFormat.format(waterQuality.getMonitorMonth())).ph(waterQuality.getPh()).dissolvedOxygen(waterQuality.getDissolvedOxygen()).chemicalOxygenDemand(waterQuality.getChemicalOxygenDemand()).inorganicNitrogen(waterQuality.getInorganicNitrogen()).activePhosphate(waterQuality.getActivePhosphate()).petroleum(waterQuality.getPetroleum()).waterQualityClassification(waterQuality.getWaterQualityClassification()).build();
            waterQualityOuts.add(build);
        }

        return waterQualityOuts;
    }

    public List<String> getAllCityByTime(Date parsedTime, String waterQualityClassification) {
        return waterQualityMapper.getAllCityByTime(parsedTime, waterQualityClassification);
    }
}
