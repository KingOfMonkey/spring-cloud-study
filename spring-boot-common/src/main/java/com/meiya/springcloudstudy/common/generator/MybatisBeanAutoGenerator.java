package com.meiya.springcloudstudy.common.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * mybatis-plus bean
 * 代码生成器
 */
public class MybatisBeanAutoGenerator {

    private static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + ";");
        System.out.println(help.toString());
        if(scanner.hasNext()){
            String ipt = scanner.next();
            if(StringUtils.isNotBlank(ipt));
            return ipt;
        }
        throw new IllegalArgumentException("请输入正确的" + tip + "!");
    }

    public static void main(String[] args) {
        generate();
    }

    public static void generate(){
        AutoGenerator generator = new AutoGenerator();

        GlobalConfig config = new GlobalConfig();
        config.setAuthor("bai bing");
        String projectPath = System.getProperty("user.dir");
        config.setOutputDir(projectPath + "/src/main/java");
        config.setBaseResultMap(true);
        config.setDateType(DateType.ONLY_DATE);
        config.setOpen(false);
        generator.setGlobalConfig(config);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://47.108.202.112:3306/aly_database?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        generator.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.meiya.springcloudstudy");
        pc.setController("controller");
        pc.setEntity("bean");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setXml("mapper.xml");
        generator.setPackageInfo(pc);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(scanner("表名, 多个用英文逗号分隔").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        generator.setStrategy(strategy);

        generator.execute();
    }

}
