package reactor_demo.simple_reactor_demo;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.SignalType;

public class CustomSubscriber extends BaseSubscriber<String>{

	@Override
	protected void hookOnSubscribe(Subscription subscription) {
		System.out.println("Fetching the values ...!!");
		subscription.request(10);
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
