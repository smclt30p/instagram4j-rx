package ba.ogalic.instagram4j.rx.users.impl;

import ba.ogalic.instagram4j.rx.users.UsersActions;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.actions.users.UserAction;
import com.github.instagram4j.instagram4j.models.user.User;
import com.github.instagram4j.instagram4j.responses.users.UsersSearchResponse;
import io.reactivex.rxjava3.core.Observable;

import static ba.ogalic.instagram4j.rx.utils.CompletableUtils.wrapCompletable;

public class UserActionsImpl implements UsersActions {

    private final IGClient client;

    public UserActionsImpl(IGClient client) {
        this.client = client;
    }

    @Override
    public Observable<UserAction> findByUsername(String username) {
        return wrapCompletable(() -> client.actions().users().findByUsername(username));
    }

    @Override
    public Observable<User> info(long pk) {
        return wrapCompletable(() -> client.actions().users().info(pk));
    }

    @Override
    public Observable<UsersSearchResponse> search(String query) {
        return wrapCompletable(() -> client.actions().users().search(query));
    }

}
