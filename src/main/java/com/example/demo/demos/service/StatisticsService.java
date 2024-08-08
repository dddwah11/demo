package com.example.demo.demos.service;

import com.example.demo.demos.controller.VO.StatisticsVO;
import com.example.demo.demos.entity.Order;

import java.util.List;

public interface StatisticsService {

    List<StatisticsVO> searchTwo(Integer date);

    List<StatisticsVO> searchOne(Integer date);
}
