package org.jingc.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import lombok.extern.slf4j.Slf4j;
import org.jingc.entity.WaterQuality;
import org.jingc.entity.WaterQualityIn;
import org.jingc.mapper.WaterQualityMapper;
import org.jingc.utils.ExcelImportListener;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
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

    public List<WaterQuality> getDataBySiteInfo(String site) {
        return waterQualityMapper.getDataBySiteInfo(site);
    }
}
