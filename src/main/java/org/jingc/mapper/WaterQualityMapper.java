package org.jingc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jingc.entity.WaterQuality;

import java.util.Date;
import java.util.List;

/**
 * @Title: WaterQualityMapper
 * @Author jingc
 * @Package org.jingc.mapper
 * @Date 2025/3/9 14:20
 * @description: 数据库表操作接口
 */

@Mapper
public interface WaterQualityMapper {

    void batchInsertData(List<WaterQuality> waterQualityList);

    void insertData(WaterQuality waterQuality);

    List<WaterQuality> getWaterData();

    List<WaterQuality> getDataByTime(Date time);

    List<WaterQuality> getDataBySiteInfo(String site);

    List<WaterQuality> getByCityAndYear(String city, Date time, String waterQualityClassification);

    List<String> getAllCityByTime(Date time, String waterQualityClassification);
}
