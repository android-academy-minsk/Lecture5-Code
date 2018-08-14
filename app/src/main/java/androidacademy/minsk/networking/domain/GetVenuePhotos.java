package androidacademy.minsk.networking.domain;

import androidacademy.minsk.networking.data.NetworkCallback;
import androidacademy.minsk.networking.data.VenuePhotosResponse;
import androidacademy.minsk.networking.data.repository.VenuePhotosRepository;
import androidacademy.minsk.networking.presentation.model.VenueViewModel;

public class GetVenuePhotos {

    private VenuePhotosRepository repository = new VenuePhotosRepository();

    public void execute(
            VenueViewModel venueViewModel,
            NetworkCallback<VenuePhotosResponse> itemChangedCallback
    ) {
        repository.getVenuePhotos(venueViewModel.getId(), itemChangedCallback);
    }
}
