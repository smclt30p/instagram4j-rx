package ba.ogalic.instagram4j.rx;


import com.github.instagram4j.instagram4j.IGClient;
import io.reactivex.rxjava3.core.Observable;

public interface RXIGClient {

    Observable<IGClient> login(String username, String password);

    Observable<IGClient> simulatedLogin(String username, String password);
}
