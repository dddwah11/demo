package com.example.demo.demos.mapper;

import com.example.demo.demos.controller.VO.StatisticsVO;
import com.example.demo.demos.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaoliu
 * @since 2024-08-08
 */
public interface OrderMapper extends BaseMapper<Order> {

    List<StatisticsVO> searchOne(@Param("startDate") String startDate,@Param("endDate") String endDate);

    List<StatisticsVO> searchTwo(@Param("startDate") String startDate,@Param("endDate") String endDate);
}
