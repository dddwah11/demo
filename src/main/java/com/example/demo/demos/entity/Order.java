package com.example.demo.demos.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaoliu
 * @since 2024-08-08
 */
@Getter
@Setter
@TableName("`order`")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 工单编号（必填）
     */
    @NotBlank(message = "工单编号不能为空")
    private String orderNo;

    /**
     * 工单状态 0 交办 1 直接答复 3无效工单（必填）
     */
    @NotNull(message = "工单状态不能为空")
    private Integer orderType;

    /**
     * 标题（必填）
     */
    @NotBlank(message = "工单标题不能为空")
    private String title;

    /**
     * 内容（必填）
     */
    @NotBlank(message = "工单内容不能为空")
    private String content;

    /**
     * 处理部门
     */
    private String handleDeptId;

    /**
     * 创建时间（必填）
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 分派时间
     */
    private Date fenpaiTime;

    /**
     * 是否超期 0否 1是
     */
    private Byte isOverdue;


}
