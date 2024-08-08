package com.example.demo.demos.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.demos.controller.VO.StatisticsVO;
import com.example.demo.demos.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoliu
 * @since 2024-08-08
 */
public interface IOrderService extends IService<Order> {
    @Override
    default boolean updateById(Order entity) {
        return this.updateById(entity);
    }

    Page<Order> search(Integer current, Integer size, Order order);

    boolean saveOrder(Order order);

    boolean fenpai(Integer orderId, String deptId, String deptName);

    List<StatisticsVO> searchOne(String startDate, String endDate);

    List<StatisticsVO> searchTwo(String startDate, String endDate);
}
