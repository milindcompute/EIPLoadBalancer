package com.example.JavaFileCopier;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MyApp {

	public static void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new MyRouteBuilder());
		camelContext.start();
		ProducerTemplate template = camelContext.createProducerTemplate();
		template.sendBody("direct:start","This is a LB Test");
		Thread.sleep(1000);
		template.sendBody("direct:start","This is a LB Test2");
		Thread.sleep(1000);
		template.sendBody("direct:start","This is a LB Test3");
		Thread.sleep(1000);
		template.sendBody("direct:start","This is a LB Test4");
		Thread.sleep(10000);
	
	}

}
