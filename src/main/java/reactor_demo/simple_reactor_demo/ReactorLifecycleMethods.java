package reactor_demo.simple_reactor_demo;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;

public class ReactorLifecycleMethods {

	public static void main(String[] args) {
		List<String> designationList = Arrays.asList("Jr Consultant", "Associate", "Sr Consultant", "Principal Consultant");
		
		Flux<String> designationFlux = Flux.fromIterable(designationList);
		
		designationFlux.doOnComplete(() -> System.out.println("Operation completed ..!!"))
						.doOnNext(value -> System.out.println("value in onNext() => " + value))
						.doOnSubscribe(subscription -> {
							System.out.println("Fetching Values ...!!");
							for (int i = 0; i < 6; i++) {
								try {
									Thread.sleep(1000);
								} catch (InterruptedException ex) {
									ex.printStackTrace();
								}
								subscription.request(1);
							}
						})
						.doOnError(throwable -> System.out.println("Oups, Something went Wrong ...!! " + throwable.getMessage()))
						.doFinally(signalType -> System.out.println("Shutting down the operation, Bye ...!! " + signalType.name()))
						.subscribe();
	}
	
	
	
}
