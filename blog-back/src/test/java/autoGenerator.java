import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yu
 * @date 2021/12/4 - 11:14
 * @Content:
 */
public class autoGenerator {


	static final String URL = "jdbc:mysql://localhost:3306/blogs?serverTimezone=GMT%2B8&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=true";

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");//获取项目路径
		FastAutoGenerator.create(URL, "root", "root")
				//全局配置
				.globalConfig((scanner, builder) -> {
					builder.author(scanner.apply("请输入作者名？"))
							.outputDir(projectPath + "/blog-back/src/main/java")//输出路径
							.enableSwagger()//开启swagger3
							.fileOverride()//覆盖文件
							.disableOpenDir();//不打开文件夹
				})
				//包名配置
				.packageConfig((scanner, builder) -> {
					builder.parent(scanner.apply("请输入包名？"))
							.moduleName("")
							.service("service")
							.serviceImpl("service.impl")
							.controller("controller")
							.entity("entity")
							.mapper("mapper")
							//自定义输出路径，mapper.xml生成到resources目录下
							.pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "/blog-back/src/main/resources/mapper"));
				})
				//策略配置
				.strategyConfig((scanner, builder) -> {
					builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
							.addTablePrefix("blogs_")//表前缀
							.serviceBuilder().formatServiceFileName("%sService")//去掉Service的 "I" 前缀
							.controllerBuilder().enableRestStyle()//restful开启
							.enableHyphenStyle()//url改变 例如：index_id_1
							.entityBuilder().enableLombok();//开启lombok
				})
				//执行
				.execute();
	}

	// 处理 all 情况
	protected static List<String> getTables(String tables) {
		return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
	}


}
