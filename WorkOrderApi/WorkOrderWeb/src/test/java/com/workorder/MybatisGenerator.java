package com.workorder;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = WorkOrderWebApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MybatisGenerator {


    @Test
    public void generatorHelper(){
        //1、全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                .setActiveRecord(false)
                .setEnableCache(false)
                //这个位置的位置是自己项目的路径到java文件夹下
                .setOutputDir("C:\\Users\\Lenovo\\Desktop\\WorkOrderApi\\WorkOrderWeb\\src\\main\\java")
                .setFileOverride(true)//覆盖生成的文件
                .setIdType(IdType.INPUT)
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                //这个参数是生成人(如：张三、李四)
                .setAuthor("liuguofeng")
                .setOpen(false);
        //2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        /*//这套配置是Oracle的配置
        dataSourceConfig.setUrl("jdbc:oracle:thin:@ip:端口:库名")
                .setDriverName("oracle.jdbc.driver.OracleDriver")
                //数据库登录名
                .setUsername("xxx")
                //数据库密码
                .setPassword("xxx")
                .setDbType(DbType.ORACLE);*/

        //这套配置是MySql的配置
        //这个是做的SSH的连接（useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false）
        dataSourceConfig.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=WorkOrderDB")
                .setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                //数据库登录名
                .setUsername("sa")
                //数据库密码
                .setPassword("lbf123")
                .setDbType(DbType.SQL_SERVER);
        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setNaming(NamingStrategy.underline_to_camel)
//                TODO
                //需要导入的表的名称
                .setInclude("WosUser")
                //需要导入表删除前缀（如：xxx_xx,删除完前缀是xx,只剩下表名）
                .setTablePrefix("");

        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        //这个需要改成自己项目的位置
        packageConfig.setParent("com.workorder")
                //Dao层的文件
                .setMapper("dao")
                //service层的文件
                .setService("service")
                //controller层的文件
                .setController("controller")
                //实体类的文件
                .setEntity("entity")
                //xml的文件
                .setXml("dao");

        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        //6、执行
        autoGenerator.execute();
    }

}