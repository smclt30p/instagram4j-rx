package ba.ogalic.instagram4j.rx.igtv;

import com.github.instagram4j.instagram4j.actions.feed.FeedIterable;
import com.github.instagram4j.instagram4j.requests.igtv.IgtvBrowseFeedRequest;
import com.github.instagram4j.instagram4j.responses.igtv.IgtvBrowseFeedResponse;
import com.github.instagram4j.instagram4j.responses.igtv.IgtvChannelResponse;
import com.github.instagram4j.instagram4j.responses.igtv.IgtvSearchResponse;
import com.github.instagram4j.instagram4j.responses.igtv.IgtvSeriesResponse;
import com.github.instagram4j.instagram4j.responses.media.MediaResponse;
import io.reactivex.rxjava3.core.Observable;

import java.io.File;

public interface IGTVActions {

    Observable<MediaResponse.MediaConfigureToIgtvResponse> upload(byte[] data, byte[] cover,
                                                                  String title, String caption,
                                                                  boolean postToFeed);

    Observable<MediaResponse.MediaConfigureToIgtvResponse> upload(File video, File cover,
                                                                  String title, String caption,
                                                                  boolean postToFeed);


    Observable<IgtvSeriesResponse> createSeries(String title, String description);

    Observable<IgtvSeriesResponse> addEpisode(String seriesId, long pk);

    Observable<IgtvChannelResponse> getChannel(long pk);

    Observable<IgtvChannelResponse> getChannel(String userId);

    Observable<IgtvSearchResponse> search(String query);

    FeedIterable<IgtvBrowseFeedRequest, IgtvBrowseFeedResponse> feed();

}
