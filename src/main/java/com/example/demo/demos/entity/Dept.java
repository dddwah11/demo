package com.example.demo.demos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id（必填）
     */
    @NotBlank(message = "部门id不能为空")
    private String deptId;

    /**
     * 部门名称（必填）
     */
    @NotBlank(message = "部门名称不能为空")
    private String deptName;


}
