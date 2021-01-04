package ba.ogalic.instagram4j.rx.accounts.impl;

import ba.ogalic.instagram4j.rx.accounts.AccountActions;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.requests.accounts.AccountsActionRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import com.github.instagram4j.instagram4j.responses.accounts.AccountsUserResponse;
import io.reactivex.rxjava3.core.Observable;

import java.io.File;

import static ba.ogalic.instagram4j.rx.utils.CompletableUtils.wrapCompletable;

public class AccountActionsImpl implements AccountActions {

    private final IGClient client;

    public AccountActionsImpl(IGClient client) {
        this.client = client;
    }

    @Override
    public Observable<AccountsUserResponse> action(AccountsActionRequest.AccountsAction action) {
        return wrapCompletable(() -> client.actions().account().action(action));

    }

    @Override
    public Observable<AccountsUserResponse> currentUser() {
        return wrapCompletable(() -> client.actions().account().currentUser());
    }

    @Override
    public Observable<IGResponse> setBio(String bio) {
        return wrapCompletable(() -> client.actions().account().setBio(bio));
    }

    @Override
    public Observable<AccountsUserResponse> setProfilePicture(File file) {
        return wrapCompletable(() -> client.actions().account().setProfilePicture(file));
    }

    @Override
    public Observable<AccountsUserResponse> setProfilePicture(byte[] photo) {
        return wrapCompletable(() -> client.actions().account().setProfilePicture(photo));
    }

}
