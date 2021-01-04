package ba.ogalic.instagram4j.rx.upload;

import com.github.instagram4j.instagram4j.models.media.UploadParameters;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import com.github.instagram4j.instagram4j.responses.media.RuploadPhotoResponse;
import io.reactivex.rxjava3.core.Observable;

public interface UploadActions {

    Observable<RuploadPhotoResponse> photo(byte[] data, String uploadId, boolean isSidecar);

    Observable<RuploadPhotoResponse> photo(byte[] data, String uploadId);

    Observable<? extends IGResponse> videoWithCover(byte[] data, byte[] cover, UploadParameters uploadParameters);

    Observable<? extends IGResponse> chunkedVideoWithCover(byte[] data, byte[] cover, int chunkSize, String uploadId);

    Observable<IGResponse> finish(String uploadId);

    Observable<IGResponse> segments(String uploadId, byte[][] segments, int totalLength);

    byte[][] toSegments(byte[] data, int segmentSize);

}
