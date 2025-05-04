package org.jingc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Title: WaterQualityOut
 * @Author jingc
 * @Package org.jingc.entity
 * @Date 2025/5/3 2:35
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WaterQualityOut {

    // 主键id
    private String id;

    // 海区
    private String sea;

    // 省份
    private String province;

    // 地市
    private String city;

    // 点位编码
    private String site;

    // 实测经度
    private String longitude;

    // 实测纬度
    private String latitude;

    // 监测时间
    private String monitorMonth;

    // ph
    private String ph;

    // 溶解氧
    private String dissolvedOxygen;

    // 化学需氧量
    private String chemicalOxygenDemand;

    // 无机氮
    private String inorganicNitrogen;

    // 活性磷酸盐
    private String activePhosphate;

    // 石油类
    private String petroleum;

    // 水质类别
    private String waterQualityClassification;

}
