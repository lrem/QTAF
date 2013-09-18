package cn.baiweigang.qtaf.toolkit.util;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import cn.baiweigang.qtaf.toolkit.TkConf;

/**
 * 自定义日志
 *
 */
public class LogUtil {
	private Logger log ;
	private LogUtil(String name) {
		configLogProperties();
		log = Logger.getLogger(name);
	}
	private LogUtil(Class<?> clazz){
		configLogProperties();
		log = Logger.getLogger(clazz);
	}
	
	public static LogUtil getLogger(String name){
		return new LogUtil(name);
	}
	public static LogUtil getLogger(Class<?> clazz){
		return new LogUtil(clazz);
	}
	
	public void error(Object message){
		log.error(message);
	}
	public void info(Object message){
		log.info(message);
	}
	public void debug(Object message){
		log.debug(message);
	}
	public void warn(Object message){
		log.error(message);
	}
	
	/**
	 * 读取日志配置文件
	 */
	private  void configLogProperties(){
		try {
			if (!new File(TkConf.Log4jConf).exists()) {//配置文件不存在时，写入
				TkConf.writeConf();//写配置文件
			}
			
			PropertyConfigurator.configure(TkConf.Log4jConf);
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
	
	
}