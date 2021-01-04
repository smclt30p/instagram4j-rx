package ba.ogalic.instagram4j.rx.impl;

import ba.ogalic.instagram4j.rx.RXIGClient;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.exceptions.IGLoginException;
import io.reactivex.rxjava3.core.Observable;

public class RXIGClientImpl implements RXIGClient {

    @Override
    public Observable<IGClient> login(String username, String password) {
        return Observable.create((emitter -> {
            try {
                IGClient client = IGClient.builder()
                                          .username(username)
                                          .password(password)
                                          .login();
                emitter.onNext(client);
            } catch (IGLoginException e) {
                emitter.onError(e);
            }
        }));
    }

    @Override
    public Observable<IGClient> simulatedLogin(String username, String password) {
        return Observable.create((emitter -> {
            try {
                IGClient client = IGClient.builder()
                                          .username(username)
                                          .password(password)
                                          .simulatedLogin();
                emitter.onNext(client);
            } catch (IGLoginException e) {
                emitter.onError(e);
            }
        }));
    }

}
