package ba.ogalic.instagram4j.rx.status.impl;

import ba.ogalic.instagram4j.rx.status.StatusActions;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import io.reactivex.rxjava3.core.Observable;

import static ba.ogalic.instagram4j.rx.utils.CompletableUtils.wrapCompletable;

public class StatusActionsImpl implements StatusActions {

    private final IGClient client;

    public StatusActionsImpl(IGClient client) {
        this.client = client;
    }

    @Override
    public Observable<IGResponse> setStatus(String text, String emoji, long expiresAt, boolean shouldNotify, String statusType) {
        return wrapCompletable(() -> client.actions().status().setStatus(text, emoji, expiresAt, shouldNotify, statusType));
    }

    @Override
    public Observable<IGResponse> setStatus(String text, String emoji, long expiresAt) {
        return wrapCompletable(() -> client.actions().status().setStatus(text, emoji, expiresAt));
    }

}
