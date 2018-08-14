package androidacademy.minsk.networking.presentation;

import androidacademy.minsk.networking.presentation.model.VenueViewModel;
import java.util.ArrayList;
import java.util.List;

public class VenueListViewModel {

    private List<VenueViewModel> venues;

    public VenueListViewModel(List<VenueViewModel> venues) {
        this.venues = venues;
    }

    public VenueListViewModel() {
        this(new ArrayList<VenueViewModel>());
    }

    public int getVenuesCount() {
        return venues == null ? 0 : venues.size();
    }

    public VenueViewModel getVenue(int position) {
        return venues.get(position);
    }

    public List<VenueViewModel> getVenues() {
        return venues;
    }

    public void setVenues(List<VenueViewModel> venues) {
        this.venues = venues;
    }
}
