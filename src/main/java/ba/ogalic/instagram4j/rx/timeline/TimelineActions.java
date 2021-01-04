package ba.ogalic.instagram4j.rx.timeline;

import com.github.instagram4j.instagram4j.actions.feed.FeedIterable;
import com.github.instagram4j.instagram4j.actions.timeline.TimelineAction;
import com.github.instagram4j.instagram4j.requests.feed.FeedTimelineRequest;
import com.github.instagram4j.instagram4j.requests.media.MediaConfigureSidecarRequest;
import com.github.instagram4j.instagram4j.requests.media.MediaConfigureTimelineRequest;
import com.github.instagram4j.instagram4j.responses.feed.FeedTimelineResponse;
import com.github.instagram4j.instagram4j.responses.media.MediaResponse;
import io.reactivex.rxjava3.core.Observable;

import java.io.File;
import java.util.List;

public interface TimelineActions {

    FeedIterable<FeedTimelineRequest, FeedTimelineResponse> feed();

    Observable<MediaResponse.MediaConfigureTimelineResponse> uploadPhoto(byte[] data, MediaConfigureTimelineRequest.MediaConfigurePayload payload);

    Observable<MediaResponse.MediaConfigureTimelineResponse> uploadPhoto(byte[] data, String caption);

    Observable<MediaResponse.MediaConfigureTimelineResponse> uploadPhoto(File file, String caption);

    Observable<MediaResponse.MediaConfigureTimelineResponse> uploadPhoto(File file, MediaConfigureTimelineRequest.MediaConfigurePayload payload);

    Observable<MediaResponse.MediaConfigureTimelineResponse> uploadVideo(byte[] videoData, byte[] coverData, MediaConfigureTimelineRequest.MediaConfigurePayload payload);

    Observable<MediaResponse.MediaConfigureTimelineResponse> uploadVideo(File video, File cover, String caption);

    Observable<MediaResponse.MediaConfigureTimelineResponse> uploadVideo(File video, File cover, MediaConfigureTimelineRequest.MediaConfigurePayload payload);

    Observable<MediaResponse.MediaConfigureTimelineResponse> uploadVideo(byte[] videoData, byte[] coverData, String caption);

    Observable<MediaResponse.MediaConfigureSidecarResponse> uploadAlbum(List<TimelineAction.SidecarInfo> infos, MediaConfigureSidecarRequest.MediaConfigureSidecarPayload payload);

    Observable<MediaResponse.MediaConfigureSidecarResponse> uploadAlbum(List<TimelineAction.SidecarInfo> infos, String caption);

}
