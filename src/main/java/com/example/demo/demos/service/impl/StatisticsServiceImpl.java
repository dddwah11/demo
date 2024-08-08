package com.example.demo.demos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.demos.controller.VO.StatisticsVO;
import com.example.demo.demos.entity.Order;
import com.example.demo.demos.service.IDeptService;
import com.example.demo.demos.service.IOrderService;
import com.example.demo.demos.service.StatisticsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * @Author: 61分
 * @Date: 2024-08-09 02:57
 * @Description:
 * 超期率=超期工单总量/工单总量
 * 1.查询7月每天的工单总量、超期率(三选二)
 * 2.查询7月每个部门的工单总量、超期率。(三选二)
 * 3.查询7月每个工单类型的工单总量、超期率。(三选二)
 */
@Service
public class StatisticsServiceImpl  implements StatisticsService {
    @Resource
    private IOrderService orderService;

    /**
     *  * 超期率=超期工单总量/工单总量
     * * 1.查询7月每天的工单总量、超期率(三选二)
     * @param date
     * @return
     */
    @Override
    public List<StatisticsVO> searchOne(Integer date) {
        Map<String, String> map = getDay(date);
        return orderService.searchOne(map.get("startDate"),map.get("endDate"));
    }
    @Override
    public List<StatisticsVO> searchTwo(Integer date) {
        Map<String, String> map = getDay(date);
        return orderService.searchTwo(map.get("startDate"),map.get("endDate"));
    }

    private Map<String, String> getDay(Integer date) {
        //月初
        LocalDate intStartDate = LocalDate.of(LocalDate.now().getYear(), date, 1);
        //月末
        LocalDate intEndDate = intStartDate.with(TemporalAdjusters.lastDayOfMonth());
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDate = formatter.format(intStartDate);
        String endDate = formatter.format(intEndDate) + " 23:59:59";
        HashMap<String, String> map = new HashMap<>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        return map;
    }
}
