package io.pivotal.literx;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {

//========================================================================================

	// TODO Return an empty Flux
	Flux<String> emptyFlux() {
		return Flux.empty();
	}

//========================================================================================

	// TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
	Flux<String> fooBarFluxFromValues() {
		Mono<String> food= Mono.just("foo");
		Mono<String> bar= Mono.just("bar");
		 return Flux.merge(food,bar) ;
	}

//========================================================================================

	// TODO Create a Flux from a List that contains 2 values "foo" and "bar"
	Flux<String> fooBarFluxFromList() {
		List<String> lista= Arrays.asList("foo","bar");
		return Flux.fromIterable(lista);
	}

//========================================================================================

	// TODO Create a Flux that emits an IllegalStateException
	Flux<String> errorFlux() {
		List<String> lista= Arrays.asList("food","1");
		return Flux.fromIterable(lista).error(new IllegalStateException("error"));
	}

//========================================================================================

		// TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
	Flux<Long> counter() {
		List<Long> count = Arrays.asList(0L,1L,2L,3L,4L,5L,6L,7L,8L,9L);
		return 	Flux.fromIterable(count).delayElements(Duration.ofMillis(100));
	}

}
