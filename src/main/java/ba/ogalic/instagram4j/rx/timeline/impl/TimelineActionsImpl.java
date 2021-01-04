package ba.ogalic.instagram4j.rx.timeline.impl;

import ba.ogalic.instagram4j.rx.timeline.TimelineActions;
import com.github.instagram4j.instagram4j.IGClient;
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

import static ba.ogalic.instagram4j.rx.utils.CompletableUtils.wrapCompletable;

public class TimelineActionsImpl implements TimelineActions {

    private final IGClient client;

    public TimelineActionsImpl(IGClient client) {
        this.client = client;
    }

    @Override
    public FeedIterable<FeedTimelineRequest, FeedTimelineResponse> feed() {
        return client.actions().timeline().feed();
    }

    @Override
    public Observable<MediaResponse.MediaConfigureTimelineResponse> uploadPhoto(byte[] data, MediaConfigureTimelineRequest.MediaConfigurePayload payload) {
        return wrapCompletable(() -> client.actions().timeline().uploadPhoto(data, payload));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureTimelineResponse> uploadPhoto(byte[] data, String caption) {
        return wrapCompletable(() -> client.actions().timeline().uploadPhoto(data, caption));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureTimelineResponse> uploadPhoto(File file, String caption) {
        return wrapCompletable(() -> client.actions().timeline().uploadPhoto(file, caption));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureTimelineResponse> uploadPhoto(File file, MediaConfigureTimelineRequest.MediaConfigurePayload payload) {
        return wrapCompletable(() -> client.actions().timeline().uploadPhoto(file, payload));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureTimelineResponse> uploadVideo(byte[] videoData, byte[] coverData, MediaConfigureTimelineRequest.MediaConfigurePayload payload) {
        return wrapCompletable(() -> client.actions().timeline().uploadVideo(videoData, coverData, payload));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureTimelineResponse> uploadVideo(File video, File cover, String caption) {
        return wrapCompletable(() -> client.actions().timeline().uploadVideo(video, cover, caption));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureTimelineResponse> uploadVideo(File video, File cover, MediaConfigureTimelineRequest.MediaConfigurePayload payload) {
        return wrapCompletable(() -> client.actions().timeline().uploadVideo(video, cover, payload));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureTimelineResponse> uploadVideo(byte[] videoData, byte[] coverData, String caption) {
        return wrapCompletable(() -> client.actions().timeline().uploadVideo(videoData, coverData, caption));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureSidecarResponse> uploadAlbum(List<TimelineAction.SidecarInfo> infos, MediaConfigureSidecarRequest.MediaConfigureSidecarPayload payload) {
        return wrapCompletable(() -> client.actions().timeline().uploadAlbum(infos, payload));
    }

    @Override
    public Observable<MediaResponse.MediaConfigureSidecarResponse> uploadAlbum(List<TimelineAction.SidecarInfo> infos, String caption) {
        return wrapCompletable(() -> client.actions().timeline().uploadAlbum(infos, caption));
    }

}
