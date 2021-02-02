package reactor_demo.simple_reactor_demo;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Hello world!
 *
 */
public class ReactorBasic 
{
	private static List<String> carModels = Arrays.asList("Era", "Magna", "Sports", "twingo","roadster");
	
    public static void main( String[] args )
    {
        Flux<String> fewWords = Flux.just("Hello", "World");
        Flux<String> manyWords = Flux.fromIterable(carModels);
        Mono<String> singleWord = Mono.just("Single Value");
        
        fewWords.subscribe(item -> System.out.println(item));
        System.out.println("-----------------------------");
        manyWords.subscribe(System.out::println);
        System.out.println("-----------------------------");
        singleWord.subscribe(System.out::println);
        
    }
}
