package androidacademy.minsk.networking.data.repository;

import androidacademy.minsk.networking.data.NetworkCallback;
import androidacademy.minsk.networking.data.VenuesResponse;
import androidacademy.minsk.networking.network.AppNetworkClient;

public class VenuesRepository {

    private AppNetworkClient client = new AppNetworkClient();

    public void getVenues(final NetworkCallback<VenuesResponse> callback) {
        client.getVenues(callback);
    }
}
