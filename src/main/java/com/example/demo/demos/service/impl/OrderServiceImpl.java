package com.example.demo.demos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.demos.controller.VO.StatisticsVO;
import com.example.demo.demos.entity.Dept;
import com.example.demo.demos.entity.Order;
import com.example.demo.demos.mapper.OrderMapper;
import com.example.demo.demos.service.IDeptService;
import com.example.demo.demos.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoliu
 * @since 2024-08-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Resource
    private IDeptService deptService;

    @Resource
    private OrderMapper orderMapper;

    /**
     * 重写save方法,避免重复编号
     * @param entity 实体对象
     * @return
     */
    @Override
    public boolean saveOrder(Order entity) {
        Order order = getOne(new LambdaQueryWrapper<Order>().eq(!StringUtils.isBlank(entity.getOrderNo()), Order::getOrderNo, entity.getOrderNo()));
        if (Objects.nonNull(order)) throw new RuntimeException("工单编号重复，请重新添加");
        return super.save(entity);
    }

    @Override
    public boolean fenpai(Integer orderId, String deptId, String deptName) {
        Dept dept = deptService.getOne(new LambdaQueryWrapper<Dept>().eq(!StringUtils.isBlank(deptId), Dept::getDeptId, deptId));
        if (Objects.isNull(dept)) throw new RuntimeException("无效部门id");
        Order order = getById(orderId);
        if (Objects.isNull(order)) throw new RuntimeException("无效工单id");
        if (StringUtils.isNotBlank(order.getHandleDeptId())) throw new RuntimeException("该工单已分配");
        order.setHandleDeptId(deptId);
        order.setFenpaiTime(new Date());
        return update(order, null);
    }

    @Override
    public List<StatisticsVO> searchOne(String startDate, String endDate) {
        return orderMapper.searchOne(startDate, endDate);
    }

    @Override
    public List<StatisticsVO> searchTwo(String startDate, String endDate) {
        return orderMapper.searchTwo(startDate, endDate);

    }

    @Override
    public boolean updateById(Order entity) {
        Order order = getOne(new LambdaQueryWrapper<Order>().eq(!StringUtils.isBlank(entity.getOrderNo()), Order::getOrderNo, entity.getOrderNo()));
        if (Objects.nonNull(order)) throw new RuntimeException("工单编号不能重复,请重新填写");
        return super.updateById(entity);
    }

    /**
     *
     * @param current
     * @param size
     * @param order
     * @return
     */
    @Override
    public Page<Order> search(Integer current, Integer size, Order order) {
        /**
         * 根据编号与工单状态进行模糊查询
         */
        Page<Order> page = new Page<>(current, size);
        Page<Order> orderPage = page(page, new LambdaQueryWrapper<Order>()
                .like(!StringUtils.isBlank(order.getOrderNo()), Order::getOrderNo, order.getOrderNo())
                .eq(order.getOrderType()!=null,Order::getOrderType,order.getOrderType()));
        return orderPage;
    }



}
