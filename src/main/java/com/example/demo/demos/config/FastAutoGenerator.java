package com.example.demo.demos.config;

import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;


public class FastAutoGenerator {
    public static void main(String[] args) {
        com.baomidou.mybatisplus.generator
                .FastAutoGenerator.create("jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=UTC&characterEncoding=utf8", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("xiaoliu") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\BaiduNetdiskDownload\\demo\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.demo.demos") // 设置父包名
//                            .moduleName() // /设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\BaiduNetdiskDownload\\demo\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder
                            .addInclude("order") // 设置需要生成的表名
                            .addTablePrefix("") // 设置过滤表前缀
                            .controllerBuilder().
                            enableRestStyle();
                    builder.entityBuilder()
                            .enableLombok();
                })
                .execute();
    }
}
