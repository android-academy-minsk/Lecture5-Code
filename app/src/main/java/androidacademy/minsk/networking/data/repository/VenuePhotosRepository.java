package androidacademy.minsk.networking.data.repository;

import androidacademy.minsk.networking.data.NetworkCallback;
import androidacademy.minsk.networking.data.VenuePhotosResponse;
import androidacademy.minsk.networking.network.AppNetworkClient;

public class VenuePhotosRepository {

    private AppNetworkClient client = new AppNetworkClient();

    public void getVenuePhotos(
            final String venueId,
            final NetworkCallback<VenuePhotosResponse> callback
    ) {
        client.getVenuePhotos(venueId, callback);
    }
}
