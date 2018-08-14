package androidacademy.minsk.networking.network;

import static androidacademy.minsk.networking.AcademyApplication.getApp;

import android.support.annotation.NonNull;
import androidacademy.minsk.networking.data.NetworkCallback;
import androidacademy.minsk.networking.data.VenuePhotosResponse;
import androidacademy.minsk.networking.data.VenuesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppNetworkClient {

    public void getVenues(final NetworkCallback<VenuesResponse> callback) {
        final String location = "32.070080,34.794145";
        final Call<VenuesResponse> call = getApp().api.getVenues(location);

        call.enqueue(new Callback<VenuesResponse>() {
            @Override
            public void onResponse(
                    @NonNull Call<VenuesResponse> call,
                    @NonNull Response<VenuesResponse> response
            ) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(
                    @NonNull Call<VenuesResponse> call,
                    Throwable t
            ) {
                callback.onFailure();
            }
        });
    }

    public void getVenuePhotos(
            String venueId,
            final NetworkCallback<VenuePhotosResponse> callback
    ) {
        final Call<VenuePhotosResponse> call = getApp().api.getVenuePhotos(venueId);

        call.enqueue(new Callback<VenuePhotosResponse>() {
            @Override
            public void onResponse(
                    @NonNull Call<VenuePhotosResponse> call,
                    @NonNull Response<VenuePhotosResponse> response
            ) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(
                    @NonNull Call<VenuePhotosResponse> call,
                    @NonNull Throwable t
            ) {
                callback.onFailure();
            }
        });
    }
}
