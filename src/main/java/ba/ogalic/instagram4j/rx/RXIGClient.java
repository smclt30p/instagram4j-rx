package ba.ogalic.instagram4j.rx;

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
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.exceptions.IGLoginException;
import com.github.instagram4j.instagram4j.requests.accounts.AccountsActionRequest;
import com.github.instagram4j.instagram4j.responses.accounts.AccountsUserResponse;
import io.reactivex.rxjava3.core.Observable;

import static ba.ogalic.instagram4j.rx.utils.CompletableUtils.wrapCompletable;

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

    public Observable<IRXIGClient> simulatedLogin(String username, String password) {
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

}
