package com.briup.environment.test;

import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import com.briup.environment.bean.Environment;
import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.server.Server;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.Log;


public class EnvironmentTest {
	private Log log;
	private Configuration configuration;
	/*
	 * 一个JUnit4的单元测试用例执行顺序为:
	 * @BeforeClass -> @Before -> @Test -> @After -> @AfterClass; 
	 * 每一个测试方法的调用顺序为:
	 * @Before -> @Test -> @After;
	 */
	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void clientTest() {
		
	}
	@Test
	public void serverTest() {
		
	}
}
