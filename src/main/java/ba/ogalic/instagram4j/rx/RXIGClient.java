package ba.ogalic.instagram4j.rx;

import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.actions.feed.CursorIterator;
import com.github.instagram4j.instagram4j.exceptions.IGLoginException;
import com.github.instagram4j.instagram4j.requests.IGRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;

import java.util.concurrent.atomic.AtomicBoolean;

import ba.ogalic.instagram4j.rx.accounts.AccountActions;
import ba.ogalic.instagram4j.rx.accounts.impl.AccountActionsImpl;
import ba.ogalic.instagram4j.rx.igtv.IGTVActions;
import ba.ogalic.instagram4j.rx.igtv.impl.IGTVActionsImpl;
import ba.ogalic.instagram4j.rx.search.SearchActions;
import ba.ogalic.instagram4j.rx.search.impl.SearchActionsImpl;
import ba.ogalic.instagram4j.rx.simulate.SimulateActions;
import ba.ogalic.instagram4j.rx.simulate.impl.SimulateActionsImpl;
import ba.ogalic.instagram4j.rx.status.StatusActions;
import ba.ogalic.instagram4j.rx.status.impl.StatusActionsImpl;
import ba.ogalic.instagram4j.rx.story.StoryActions;
import ba.ogalic.instagram4j.rx.story.impl.StoryActionsImpl;
import ba.ogalic.instagram4j.rx.timeline.TimelineActions;
import ba.ogalic.instagram4j.rx.timeline.impl.TimelineActionsImpl;
import ba.ogalic.instagram4j.rx.upload.UploadActions;
import ba.ogalic.instagram4j.rx.upload.impl.UploadActionsImpl;
import ba.ogalic.instagram4j.rx.users.UsersActions;
import ba.ogalic.instagram4j.rx.users.impl.UserActionsImpl;
import io.reactivex.rxjava3.core.Observable;

public class RXIGClient implements IRXIGClient {

    private final IGClient client;

    private RXIGClient(IGClient client) {
        this.client = client;
    }

    public static IRXIGClient build(IGClient client) {
        if (!client.isLoggedIn())
            throw new RuntimeException("Restored IGClient object that is not logged in!");
        return new RXIGClient(client);
    }

    public static Observable<IRXIGClient> login(String username, String password) {
        return Observable.create((emitter -> {
            try {
                IGClient client = IGClient.builder()
                                          .username(username)
                                          .password(password)
                                          .login();
                emitter.onNext(new RXIGClient(client));
                emitter.onComplete();
            } catch (IGLoginException e) {
                emitter.onError(e);
            }
        }));
    }

    public <T extends IGResponse> Observable<T> request(IGRequest<T> request) {
        return Observable.create((subscriber) -> {
            try {
                subscriber.onNext(client.sendRequest(request).get());
                subscriber.onComplete();
            } catch (Throwable t) {
                subscriber.onError(t);
            }
        });
    }

    @Override
    public <R extends IGResponse, T extends IGRequest<R>> Observable<R> request(CursorIterator<T, R> iterator) {
        return Observable.create((emitter) -> {
            AtomicBoolean run = new AtomicBoolean(true);
            emitter.setCancellable(() -> run.set(false));
            try {
                while (iterator.hasNext() && run.get())
                    emitter.onNext(iterator.next());
                emitter.onComplete();
            } catch (Throwable t) {
                emitter.onError(t);
            }
        });
    }

    public static Observable<IRXIGClient> simulatedLogin(String username, String password) {
        return Observable.create((emitter -> {
            try {
                IGClient client = IGClient.builder()
                                          .username(username)
                                          .password(password)
                                          .simulatedLogin();
                emitter.onNext(new RXIGClient(client));
                emitter.onComplete();
            } catch (IGLoginException e) {
                emitter.onError(e);
            }
        }));
    }

    @Override
    public AccountActions accountActions() {
        return new AccountActionsImpl(client);
    }

    @Override
    public UploadActions uploadActions() {
        return new UploadActionsImpl(client);
    }

    @Override
    public TimelineActions timelineActions() {
        return new TimelineActionsImpl(client);
    }

    @Override
    public StoryActions storyActions() {
        return new StoryActionsImpl(client);
    }

    @Override
    public UsersActions usersActions() {
        return new UserActionsImpl(client);
    }

    @Override
    public SimulateActions simulateActions() {
        return new SimulateActionsImpl(client);
    }

    @Override
    public IGTVActions IgtvActions() {
        return new IGTVActionsImpl(client);
    }

    @Override
    public SearchActions searchActions() {
        return new SearchActionsImpl(client);
    }

    @Override
    public StatusActions statusActions() {
        return new StatusActionsImpl(client);
    }

    public IGClient getClient() {
        return client;
    }

}
