package org.jichuang.hope6537.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * @描述：Hibernate框架初始化
 * @作者：赵鹏
 * @变量： 
 * @开发时间：2013-10-26下午08:54:37
 * @版本：
 */
public class CreateDatabase {
	
	public static void CreateDB(){
		
		Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
		
		SchemaExport export = new SchemaExport(cfg);
		
		export.create(true, true);
	}
	
	public static void main(String[] args) {
		CreateDB();
	}


}
