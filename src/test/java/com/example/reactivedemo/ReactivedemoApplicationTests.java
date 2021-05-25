package com.example.reactivedemo;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootTest
class ReactivedemoApplicationTests {




	@Test
	void contextLoads() {
	}

	@Test
	public void flux(){
		Flux<String> flux =Flux.just("A","B","C");

		StepVerifier
				.create(flux)
				.expectNext("A","B","C")
				.verifyComplete();

	}


	@Test
	public void flux_error(){
		Flux<String> flux =Flux.just("A","B","C").log();
				//.concatWith(new RuntimeException("something went wrong"));

		StepVerifier
				.create(flux)
				.expectNext("A","B","C")
				.verifyComplete();

	}


	@Test
	public final void fluxTestUsingParallelScheudler(){
		//Flux<String> flux =Flux.just("A","B","C").log();
		//.concatWith(new RuntimeException("something went wrong"));
       Flux<String> flux = Flux.fromIterable(Arrays.asList("1","2","3","4"))
			   .window(2)
			   .flatMap(identifiers -> identifiers.flatMap(
					   new Function() {
						   public Object apply(Object var1) {
							   return this.apply((String)var1);
						   }

						   public final Publisher apply(String id) {
							   ReactivedemoApplicationTests var10000 = ReactivedemoApplicationTests.this;
							   return (Publisher)ReactivedemoApplicationTests.getEmployeeid(id);
						   }
					   }
			   ))
			   .log();

		StepVerifier
				.create(flux)
				.expectNext("sam","jam","jay","san")
				.verifyComplete();

	}



	private static Mono getEmployeeid(String id) {
		Map<String,String> map= new HashMap();
 		map.put("1","sam");
		map.put("2","jam");
		map.put("3","jay");
		map.put("4","san");
		return Mono.just(map.getOrDefault(id,"Not Found"));

	}



}




