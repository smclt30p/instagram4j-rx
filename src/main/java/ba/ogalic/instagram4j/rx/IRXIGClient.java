package ba.ogalic.instagram4j.rx;


import com.github.instagram4j.instagram4j.actions.feed.CursorIterator;
import com.github.instagram4j.instagram4j.requests.IGRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;

import ba.ogalic.instagram4j.rx.accounts.AccountActions;
import ba.ogalic.instagram4j.rx.igtv.IGTVActions;
import ba.ogalic.instagram4j.rx.search.SearchActions;
import ba.ogalic.instagram4j.rx.simulate.SimulateActions;
import ba.ogalic.instagram4j.rx.status.StatusActions;
import ba.ogalic.instagram4j.rx.story.StoryActions;
import ba.ogalic.instagram4j.rx.timeline.TimelineActions;
import ba.ogalic.instagram4j.rx.upload.UploadActions;
import ba.ogalic.instagram4j.rx.users.UsersActions;
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

    /**
     * This performs a HTTP request as a observable
     *
     * @param request the request to perform
     * @param <T> the response object type
     * @return the observable for that request
     */
    <T extends IGResponse> Observable<T> request(IGRequest<T> request);

    /**
     * This fetches all the elements a iterator has to offer. To limit the output of
     * request, use the utilities RxJava provides. (take(), limit(), map() etc.)
     *
     * @param iterator the iterator to use
     * @param <R> the type of the response data
     * @param <T> the type of the request data
     * @return a observable that iterates over all the elements
     */
    <R extends IGResponse, T extends IGRequest<R>> Observable<R> request(CursorIterator<T, R> iterator);
}
