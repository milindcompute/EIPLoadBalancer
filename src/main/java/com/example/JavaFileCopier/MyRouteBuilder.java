package com.example.JavaFileCopier;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start")
		 .loadBalance().roundRobin()
		 .to("direct:a").to("direct:b");
		
		from("direct:a")
		 .process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				System.out.println("A received: "+exchange.getIn().getBody().toString());
				
			}
		});
		from("direct:b")
		 .process(new Processor() {
				
				public void process(Exchange exchange) throws Exception {
					System.out.println("B received: "+exchange.getIn().getBody().toString());
					
				}
			});
	}
}
