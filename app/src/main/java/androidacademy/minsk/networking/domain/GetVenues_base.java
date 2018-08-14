//package androidacademy.minsk.networking.domain;
//
//import androidacademy.minsk.networking.data.NetworkCallback;
//import androidacademy.minsk.networking.data.VenuesResponse;
//import androidacademy.minsk.networking.data.repository.VenuesRepository;
//import androidacademy.minsk.networking.presentation.VenueListViewModel;
//import androidacademy.minsk.networking.presentation.model.VenueViewModel;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GetVenues_base {
//
//    private final VenuesRepository repository = new VenuesRepository();
//
//    public void execute(final NetworkCallback<VenueListViewModel> callback) {
//        repository.getVenues(new NetworkCallback<VenuesResponse>() {
//            @Override
//            public void onSuccess(VenuesResponse data) {
//                callback.onSuccess(createViewModel(data));
//            }
//
//            @Override
//            public void onFailure() {
//            }
//        });
//    }
//
//    private VenueListViewModel createViewModel(VenuesResponse response) {
//        List<VenueViewModel> venueVM = new ArrayList<>();
//
//        for (VenuesResponse.Group group : response.getGroups()) {
//            for (VenuesResponse.Item item : group.getItems()) {
//                VenueViewModel venueViewModel = new VenueViewModel(item.getVenue().getId(), item.getVenue().getName());
//                venueVM.add(venueViewModel);
//            }
//        }
//        return new VenueListViewModel(venueVM);
//    }
//}
