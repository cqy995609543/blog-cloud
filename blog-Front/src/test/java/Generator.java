import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;
import java.util.List;

/**
 * @author yu
 * @date 2021/12/4 - 10:54
 * @Content:
 */
public class Generator {

	static final String URL = "jdbc:mysql://localhost:3306/m_manage?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=true";
	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");//获取项目路径
		FastAutoGenerator.create(URL, "root", "125803")
				//全局配置
				.globalConfig(builder -> {
					builder.author("whc")
							.outputDir(projectPath + "/src/main/java")//输出路径
							.enableSwagger()//开启swagger3
							.fileOverride()//覆盖文件
							.disableOpenDir();//不打开文件夹
				})
				//包名配置
				.packageConfig(builder -> {
					builder.parent("com.wang")
							.moduleName("blog")
							.service("service")
							.serviceImpl("service.impl")
							.controller("controller")
							.entity("pojo")
							.mapper("mapper")
							//自定义输出路径，mapper.xml生成到resources目录下
							.pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "/src/main/resources/mapper"));
				})
				//策略配置
				.strategyConfig(builder -> {
					builder.addInclude("student")
							.addTablePrefix("t_")//表前缀
							.serviceBuilder().formatServiceFileName("%sService")//去掉Service的 "I" 前缀
							.controllerBuilder().enableRestStyle()//restful开启
							.enableHyphenStyle()//url改变 例如：index_id_1
							.entityBuilder().enableLombok();//开启lombok
				})
				//执行
				.execute();
	}




}
