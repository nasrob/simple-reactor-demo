package reactor_demo.simple_reactor_demo;

import java.util.stream.Stream;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

public class ReactorCustomSubscriber {
	
	public static void main(String[] args) {
	
		Flux<String> fewUsers = Flux.fromStream(Stream.of("Leo", "John", "Thierry", "Richard", "Zizou"));
		
		CustomSubscriber cs = new CustomSubscriber();
		
		fewUsers.subscribe(cs);
	}
		

	static class CustomSubscriber extends BaseSubscriber<String>{
	
		@Override
		protected void hookOnSubscribe(Subscription subscription) {
			System.out.println("Fetching the values ...!!");
			// subscription.request(10);
			
			for (int i = 0; i < 6; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				subscription.request(1);
			}
		}
		
		@Override
		protected void hookOnNext(String value) {
			System.out.println("Fetching next value in hooknext() ==> " + value);
		}
		
		@Override
		protected void hookOnComplete() {
			System.out.println("Congratulation, Everything is completed successfully ..!!");
		}
		
		@Override
		protected void hookOnError(Throwable throwable) {
			System.out.println("Opps, Somthing went wrong ..!! " + throwable.getMessage());
		}
		
		@Override
		protected void hookOnCancel() {
			System.out.println("Operation has been cancelled ..!!");
		}
		
		@Override
		protected void hookFinally(SignalType type) {
			System.out.println("Shutting down the operation, Bye ..!! " + type.name());
		}
	}
	
}
