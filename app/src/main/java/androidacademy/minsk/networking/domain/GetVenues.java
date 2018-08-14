package androidacademy.minsk.networking.domain;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import androidacademy.minsk.networking.data.NetworkCallback;
import androidacademy.minsk.networking.data.SimpleNetworkCallback;
import androidacademy.minsk.networking.data.VenuePhotosResponse;
import androidacademy.minsk.networking.data.VenuesResponse;
import androidacademy.minsk.networking.data.repository.VenuesRepository;
import androidacademy.minsk.networking.presentation.VenueListViewModel;
import androidacademy.minsk.networking.presentation.model.VenueViewModel;
import java.util.ArrayList;
import java.util.List;

public class GetVenues {

    private VenuesRepository repository = new VenuesRepository();
    private GetVenuePhotos getVenuePhotos = new GetVenuePhotos();
    private VenueListViewModel viewModel = new VenueListViewModel();

    public void execute(final NetworkCallback<VenueListViewModel> callback) {
        repository.getVenues(new NetworkCallback<VenuesResponse>() {
            @Override
            public void onSuccess(VenuesResponse data) {
                final List<VenueViewModel> venuesVM = createVenuesViewModel(data);

                viewModel.setVenues(venuesVM);
                callback.onSuccess(viewModel);

                getVenuePhotos(data, venuesVM);
            }

            private void getVenuePhotos(
                    VenuesResponse data,
                    final List<VenueViewModel> venuesVM
            ) {
                for (VenuesResponse.Group group : data.getGroups()) {
                    for (int i = 0; i < group.getItems().size(); i++) {
                        NetworkCallback<VenuePhotosResponse>
                                venuePhotosCallback = new SimpleNetworkCallback<VenuePhotosResponse>(i) {

                            @Override
                            public void onSuccess(VenuePhotosResponse venuePhotos) {
                                VenueViewModel venueViewModel = venuesVM.get(index);
                                if (venueViewModel == null) {
                                    return;
                                }
                                String imageUrl = venuePhotos.getFirstUrl();
                                if (TextUtils.isEmpty(imageUrl)) {
                                    return;
                                }
                                venueViewModel.setImageUrl(imageUrl);

                                callback.setIndex(index);
                                callback.onSuccess(viewModel);
                            }
                        };

                        getVenuePhotos.execute(venuesVM.get(i), venuePhotosCallback);
                    }
                }
            }

            @Override
            public void onFailure() {
                callback.onFailure();
            }
        });
    }

    @NonNull
    private List<VenueViewModel> createVenuesViewModel(VenuesResponse data) {
        final List<VenueViewModel> venuesVM = new ArrayList<>();

        for (VenuesResponse.Group group : data.getGroups()) {
            for (int i = 0; i < group.getItems().size(); i++) {
                VenuesResponse.Item item = group.getItems().get(i);
                VenueViewModel venueViewModel = new VenueViewModel(item.getVenue().getId(), item.getVenue().getName());
                venuesVM.add(venueViewModel);
            }
        }
        return venuesVM;
    }

}
