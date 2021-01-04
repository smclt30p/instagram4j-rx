package ba.ogalic.instagram4j.rx.utils;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class CompletableUtils {

    /**
     * This method wraps the completable future into a RxJava observable
     */
    public static <T> Observable<T> wrapCompletable(Callable<CompletableFuture<T>> callable) {
        return Observable.create((emitter -> {
            try {
                CompletableFuture<T> ret = callable.call();
                emitter.onNext(ret.get());
            } catch (Exception e) {
                emitter.onError(e);
            }
        }));
    }

}
