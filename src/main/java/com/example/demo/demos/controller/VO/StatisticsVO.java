package com.example.demo.demos.controller.VO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 61分
 * @Date: 2024-08-09 03:07
 * @Description:
 */
@Data
public class StatisticsVO {
    private String deptName;
    private String createTime;
    private Long total;
    private BigDecimal rate;
}
