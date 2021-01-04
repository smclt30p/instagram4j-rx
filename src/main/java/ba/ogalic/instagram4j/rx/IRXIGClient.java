package ba.ogalic.instagram4j.rx;


import ba.ogalic.instagram4j.rx.accounts.AccountActions;
import ba.ogalic.instagram4j.rx.igtv.IGTVActions;
import ba.ogalic.instagram4j.rx.search.SearchActions;
import ba.ogalic.instagram4j.rx.simulate.SimulateActions;
import ba.ogalic.instagram4j.rx.status.StatusActions;
import ba.ogalic.instagram4j.rx.story.StoryActions;
import ba.ogalic.instagram4j.rx.timeline.TimelineActions;
import ba.ogalic.instagram4j.rx.upload.UploadActions;
import ba.ogalic.instagram4j.rx.users.UsersActions;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.requests.accounts.AccountsActionRequest;
import com.github.instagram4j.instagram4j.responses.accounts.AccountsUserResponse;
import io.reactivex.rxjava3.core.Observable;

public interface IRXIGClient {

    UploadActions uploadActions();
    TimelineActions timelineActions();
    StoryActions storyActions();
    UsersActions usersActions();
    SimulateActions simulateActions();
    IGTVActions IgtvActions();
    AccountActions accountActions();
    SearchActions searchActions();
    StatusActions statusActions();

}
