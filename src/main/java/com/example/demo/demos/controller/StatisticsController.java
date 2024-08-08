package com.example.demo.demos.controller;

import com.example.demo.demos.common.R;
import com.example.demo.demos.controller.VO.StatisticsVO;
import com.example.demo.demos.entity.Order;
import com.example.demo.demos.service.IDeptService;
import com.example.demo.demos.service.IOrderService;
import com.example.demo.demos.service.StatisticsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: 61分
 * @Date: 2024-08-09 02:51
 * @Description:
 * 超期率=超期工单总量/工单总量
 * 4.查询7月每天的工单总量、超期率(三选二)
 * 5.查询7月每个部门的工单总量、超期率。(三选二)
 * 6.查询7月每个工单类型的工单总量、超期率。(三选二)
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Resource
    private StatisticsService service;

    @GetMapping("/1")
    public R searchOne(@RequestParam(value = "date") @NotNull(message = "日期不能为空") Integer date) {
        return R.ok(service.searchOne(date));
    }

    @GetMapping("/2")
    public R searchTwo(@RequestParam(value = "date") @NotNull(message = "日期不能为空") Integer date) {
        return R.ok(service.searchTwo(date));
    }
}
