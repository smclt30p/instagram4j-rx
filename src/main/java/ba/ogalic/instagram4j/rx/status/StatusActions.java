package ba.ogalic.instagram4j.rx.status;

import com.github.instagram4j.instagram4j.responses.IGResponse;
import io.reactivex.rxjava3.core.Observable;

public interface StatusActions {

    Observable<IGResponse> setStatus(String text, String emoji, long expiresAt, boolean shouldNotify, String statusType);

    Observable<IGResponse> setStatus(String text, String emoji, long expiresAt);

}
