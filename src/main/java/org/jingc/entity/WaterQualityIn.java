package org.jingc.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import javafx.scene.chart.PieChart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title: WaterQualityIn
 * @Author jingc
 * @Package org.jingc.entity
 * @Date 2025/3/8 23:14
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ColumnWidth(25)
public class WaterQualityIn {

    @ExcelProperty(value = "id", index = 0)
    private String id;

    @ExcelProperty(value = "sea", index = 1)
    private String sea;

    @ExcelProperty(value = "province", index = 2)
    private String province;

    @ExcelProperty(value = "city", index = 3)
    private String city;

    @ExcelProperty(value = "site", index = 4)
    private String site;

    @ExcelProperty(value = "longitude", index = 5)
    private String lon;

    @ExcelProperty(value = "latitude", index = 6)
    private String lat;

    @ExcelProperty(value = "monitor_month", index = 7)
    private String monitorMonth;

    @ExcelProperty(value = "PH", index = 8)
    private String PH;

    @ExcelProperty(value = "dissolved_oxygen", index = 9)
    private String dissolvedOxygen;

    @ExcelProperty(value = "chemical_oxygen_demand", index = 10)
    private String hxxyl;

    @ExcelProperty(value = "inorganic_nitrogen", index = 11)
    private String wjd;

    @ExcelProperty(value = "active_phosphate", index = 12)
    private String hxlxy;

    @ExcelProperty(value = "petroleum", index = 13)
    private String syl;

    @ExcelProperty(value = "water_quality_classification", index = 14)
    private String szlb;

}
