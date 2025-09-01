# 海洋水质监测系统

本项目为基于 Spring Boot 的海洋水质监测系统，支持水质数据的导入、查询与管理。

## 项目结构

- `src/main/java/org/jingc/`  
  - `SeaMonitorApplication.java`：Spring Boot 启动类  
  - `service/WaterQualityService.java`：水质数据服务层，包含 Excel 导入等功能  
- `src/main/resources/mapper/WaterQualityMapper.xml`  
  MyBatis 映射文件，包含水质数据的增删查操作
- `src/main/doc/water_quality.sql`  
  数据库表结构及初始化 SQL
- `src/main/resources/water_quality_report_by_year.xlsx`  
  水质数据 Excel 模板或样例

## 快速开始

1. **环境准备**
   - JDK 8+
   - Maven 3.6+
   - PostgreSQL 数据库

2. **数据库初始化**
   - 执行 [src/main/doc/water_quality.sql](src/main/doc/water_quality.sql) 创建表结构

3. **配置数据库连接**
   - 修改 `src/main/resources/application.yml`，配置数据库连接信息

4. **运行项目**
   ```sh
   mvn spring-boot:run
   ```

5. **数据导入**
   - 将水质数据 Excel 文件放入 `src/main/resources/` 目录
   - 调用 [`WaterQualityService.importData`](Users/15817/Desktop/sea-monitor-back/src/main/java/org/jingc/service/WaterQualityService.java) 方法导入数据

## 主要功能

- 支持 Excel 批量导入水质数据
- 提供多种条件查询接口（按时间、站点、城市等）
- 数据库表结构详见 [water_quality.sql](src/main/doc/water_quality.sql)

## 相关文件

- [SeaMonitorApplication.java](src/main/java/org/jingc/SeaMonitorApplication.java)
- [WaterQualityService.java](Users/15817/Desktop/sea-monitor-back/src/main/java/org/jingc/service/WaterQualityService.java)
- [WaterQualityMapper.xml](src/main/resources/mapper/WaterQualityMapper.xml)
- [water_quality.sql](src/main/doc/water_quality.sql)

## 联系方式

如有问题请联