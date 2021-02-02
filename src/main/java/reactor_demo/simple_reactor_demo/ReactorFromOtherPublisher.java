package reactor_demo.simple_reactor_demo;

import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class ReactorFromOtherPublisher {

	public static void main(String[] args) {
		Flux<String> fewWords = Flux.just("One", "Second");
		
		Flux<Integer> intFlux = Flux.fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		
		Flux<String> strFlux = Flux.fromStream(Stream.of("Ten", "Hundred", "Thousand", "Ten Thousands", "Bitcoin", "Ether"));
		
		Flux<String> fromOtherPublisherFlux = Flux.from(fewWords);
		
		intFlux.subscribe(System.out::println);
		strFlux.subscribe(System.out::println);
		fromOtherPublisherFlux.subscribe(System.out::println);
		
	}
}
