package org.jingc.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Title: WaterQuality
 * @Author jingc
 * @Package org.jingc.entity
 * @Date 2025/3/2 16:02
 * @description: 近海水质实体类
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@ColumnWidth(25)
public class WaterQuality {

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

    @ExcelProperty(value = "lon", index = 5)
    private String lon;

    @ExcelProperty(value = "lat", index = 6)
    private String lat;

    @ExcelProperty(value = "minitor_month", index = 7)
    private String monitorMonth;

    @ExcelProperty(value = "pH", index = 8)
    private String pH;

    @ExcelProperty(value = "rjy", index = 9)
    private String rjy;

    @ExcelProperty(value = "hxxyl", index = 10)
    private String hxxyl;

    @ExcelProperty(value = "wjd", index = 11)
    private String wjd;

    @ExcelProperty(value = "hxlxy", index = 12)
    private String hxlxy;

    @ExcelProperty(value = "syl", index = 13)
    private String syl;

    @ExcelProperty(value = "szlb", index = 14)
    private String szlb;

}
