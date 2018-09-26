package test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Test
	public void test(){
		List<String> warnings = new ArrayList<String>();
		
		boolean overwrite = true;
		//读取配置文件
		File configFile = new File("src/main/resources/generator.xml");
		 
		//格式解析
		ConfigurationParser configParser = new ConfigurationParser(warnings);
		
		System.out.println(configParser);
	
		try {
		
			Configuration config = configParser.parseConfiguration(configFile);
			System.out.println(config);
			
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			System.out.println(callback);
		
			MyBatisGenerator myBatisGenerator;
			try {
				myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
				
				try {
					myBatisGenerator.generate(null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("逆向工程！");
			
			} catch (InvalidConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	
	}

}
