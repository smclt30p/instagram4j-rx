package ba.ogalic.instagram4j.rx.accounts;

import com.github.instagram4j.instagram4j.requests.accounts.AccountsActionRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import com.github.instagram4j.instagram4j.responses.accounts.AccountsUserResponse;
import io.reactivex.rxjava3.core.Observable;

import java.io.File;

public interface AccountActions {

    Observable<AccountsUserResponse> action(AccountsActionRequest.AccountsAction action);

    Observable<AccountsUserResponse> currentUser();

    Observable<IGResponse> setBio(String bio);

    Observable<AccountsUserResponse> setProfilePicture(File file);

    Observable<AccountsUserResponse> setProfilePicture(byte[] photo);

}
