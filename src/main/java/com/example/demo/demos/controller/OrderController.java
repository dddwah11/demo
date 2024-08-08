package com.example.demo.demos.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.demos.common.R;
import com.example.demo.demos.entity.Order;
import com.example.demo.demos.service.IOrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaoliu
 * @since 2024-08-08
 */
@RestController
@RequestMapping("/post/order")
public class OrderController {
    @Resource
    private IOrderService orderService;

    @PostMapping("/save")
    public R save(@RequestBody @Validated  Order order) {
        boolean flag = orderService.saveOrder(order);
        return flag ? R.ok("添加成功") : R.fail("添加失败");
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable("id") Integer id) {
        boolean flag = orderService.removeById(id);
        return flag ? R.ok("删除成功") : R.fail("删除失败");
    }

    @PutMapping("/update")
    public R update(@RequestBody @Validated  Order order) {
        boolean flag = orderService.updateById(order);
        return flag ? R.ok("修改成功") : R.fail("修改失败");
    }

    @GetMapping("/search")
    public R search(@RequestParam(defaultValue = "1") Integer current,
                    @RequestParam(defaultValue = "6") Integer size,
                    @RequestBody Order order) {
        Page<Order> pageData =  orderService.search(current,size,order);
        return R.ok(pageData);
    }

    @PutMapping("/fenpai")
    public R fenpai(@RequestParam(name = "orderId") Integer orderId,
                    @RequestParam(name = "deptId") String deptId,
                    @RequestParam(name = "deptName") String deptName) {
       boolean flag = orderService.fenpai(orderId, deptId, deptName);
        return flag ? R.ok() : R.fail();
    }
}

