package ba.ogalic.instagram4j.rx.igtv.impl;

import ba.ogalic.instagram4j.rx.igtv.IGTVActions;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.actions.feed.FeedIterable;
import com.github.instagram4j.instagram4j.requests.igtv.IgtvBrowseFeedRequest;
import com.github.instagram4j.instagram4j.responses.igtv.IgtvBrowseFeedResponse;
import com.github.instagram4j.instagram4j.responses.igtv.IgtvChannelResponse;
import com.github.instagram4j.instagram4j.responses.igtv.IgtvSearchResponse;
import com.github.instagram4j.instagram4j.responses.igtv.IgtvSeriesResponse;
import com.github.instagram4j.instagram4j.responses.media.MediaResponse;
import io.reactivex.rxjava3.core.Observable;

import java.io.File;

import static ba.ogalic.instagram4j.rx.utils.CompletableUtils.wrapCompletable;

public class IGTVActionsImpl implements IGTVActions {

    private final IGClient client;

    public IGTVActionsImpl(IGClient client) {
        this.client = client;
    }

    @Override
    public Observable<MediaResponse.MediaConfigureToIgtvResponse> upload(byte[] data, byte[] cover, String title, String caption, boolean postToFeed) {
        return wrapCompletable(() -> client.actions().igtv().upload(data, cover, title, caption, postToFeed));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureToIgtvResponse> upload(File video, File cover, String title, String caption, boolean postToFeed) {
        return wrapCompletable(() -> client.actions().igtv().upload(video, cover, title, caption, postToFeed));
    }

    @Override
    public Observable<IgtvSeriesResponse> createSeries(String title, String description) {
        return wrapCompletable(() -> client.actions().igtv().createSeries(title, description));
    }

    @Override
    public Observable<IgtvSeriesResponse> addEpisode(String seriesId, long pk) {
        return wrapCompletable(() -> client.actions().igtv().addEpisode(seriesId, pk));
    }

    @Override
    public Observable<IgtvChannelResponse> getChannel(long pk) {
        return wrapCompletable(() -> client.actions().igtv().getChannel(pk));
    }

    @Override
    public Observable<IgtvChannelResponse> getChannel(String userId) {
        return wrapCompletable(() -> client.actions().igtv().getChannel(userId));
    }

    @Override
    public Observable<IgtvSearchResponse> search(String query) {
        return wrapCompletable(() -> client.actions().igtv().search(query));
    }

    @Override
    public FeedIterable<IgtvBrowseFeedRequest, IgtvBrowseFeedResponse> feed() {
        return client.actions().igtv().feed();
    }

}
