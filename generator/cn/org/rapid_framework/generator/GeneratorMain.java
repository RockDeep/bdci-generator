package cn.org.rapid_framework.generator;

/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		GeneratorFacade g = new GeneratorFacade();
		// g.printAllTableNames(); //打印数据库中的表名称

		g.deleteOutRootDir(); // 删除生成器的输出目录
		//g.generateByTable("dianjin_experience_money_voucher", "bdci"); // 通过数据库表生成文件,template为模板的根目录
		//g.generateByAllTable("bdci"); //自动搜索数据库中的所有表并生成文件,template为模板的根目录
		g.processTableByPrefixes(new String[]{"tongdun_"},"bdci");//根据表格前缀生成代码
		// g.generateByClass(Blog.class,"template_clazz");

		// g.deleteByTable("table_name", "template"); //删除生成的文件
		// 打开文件夹
		String run = GeneratorProperties.getRequiredProperty("outRoot");
		Runtime.getRuntime().exec("cmd.exe /c start " + run);
	}
}
