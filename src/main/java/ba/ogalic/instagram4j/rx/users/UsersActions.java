package ba.ogalic.instagram4j.rx.users;

import com.github.instagram4j.instagram4j.actions.users.UserAction;
import com.github.instagram4j.instagram4j.models.user.User;
import com.github.instagram4j.instagram4j.responses.users.UsersSearchResponse;
import io.reactivex.rxjava3.core.Observable;

public interface UsersActions {

     Observable<UserAction> findByUsername(String username);

     Observable<User> info(long pk);

     Observable<UsersSearchResponse> search(String query);

}
