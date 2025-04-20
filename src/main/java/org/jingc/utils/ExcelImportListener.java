package org.jingc.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: ExcelListener
 * @Author jingc
 * @Package org.jingc.utils
 * @Date 2025/3/28 22:36
 * @description: excel监听处理
 */
public class ExcelImportListener<T> extends AnalysisEventListener<T> {

    private List<T> datas = new ArrayList<>();

    @Override
    public void invoke(T o, AnalysisContext analysisContext) {
        if (o != null) {
            datas.add(o);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 暂时不使用
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

}
