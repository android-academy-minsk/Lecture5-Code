package androidacademy.minsk.networking.network;

import androidacademy.minsk.networking.data.VenuePhotosResponse;
import androidacademy.minsk.networking.data.VenuesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoursquareService {

    @GET("venues/explore")
    Call<VenuesResponse> getVenues(@Query("ll") String location);

    @GET("venues/{venueId}/photos")
    Call<VenuePhotosResponse> getVenuePhotos(@Path("venueId") String venueId);
}
