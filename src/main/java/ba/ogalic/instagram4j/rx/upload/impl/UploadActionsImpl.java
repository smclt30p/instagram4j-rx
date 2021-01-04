package ba.ogalic.instagram4j.rx.upload.impl;

import ba.ogalic.instagram4j.rx.upload.UploadActions;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.actions.upload.UploadAction;
import com.github.instagram4j.instagram4j.models.media.UploadParameters;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import com.github.instagram4j.instagram4j.responses.media.RuploadPhotoResponse;
import io.reactivex.rxjava3.core.Observable;

import static ba.ogalic.instagram4j.rx.utils.CompletableUtils.wrapCompletable;

public class UploadActionsImpl implements UploadActions {

    private final IGClient client;

    public UploadActionsImpl(IGClient client) {
        this.client = client;
    }

    @Override
    public Observable<RuploadPhotoResponse> photo(byte[] data, String uploadId, boolean isSidecar) {
        return wrapCompletable(() -> client.actions().upload().photo(data, uploadId, isSidecar));
    }

    @Override
    public Observable<RuploadPhotoResponse> photo(byte[] data, String uploadId) {
        return photo(data, uploadId, false);
    }

    @Override
    public Observable<? extends IGResponse> videoWithCover(byte[] data, byte[] cover, UploadParameters uploadParameters) {
        return wrapCompletable(() -> client.actions().upload().videoWithCover(data, cover, uploadParameters));
    }

    @Override
    public Observable<? extends IGResponse> chunkedVideoWithCover(byte[] data, byte[] cover, int chunkSize, String uploadId) {
        return wrapCompletable(() -> client.actions().upload().chunkedVideoWithCover(data, cover, chunkSize, uploadId));
    }

    @Override
    public Observable<IGResponse> finish(String uploadId) {
        return wrapCompletable(() -> client.actions().upload().finish(uploadId));
    }

    @Override
    public Observable<IGResponse> segments(String uploadId, byte[][] segments, int totalLength) {
        return wrapCompletable(() -> client.actions().upload().segments(uploadId, segments, totalLength));
    }

    @Override
    public byte[][] toSegments(byte[] data, int segmentSize) {
        return UploadAction.toSegments(data, segmentSize);
    }

}
