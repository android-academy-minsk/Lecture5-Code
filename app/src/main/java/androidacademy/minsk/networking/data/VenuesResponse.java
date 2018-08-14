package androidacademy.minsk.networking.data;

import androidacademy.minsk.networking.data.model.Venue;
import java.util.List;

public class VenuesResponse {

    List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public static class Group {

        List<Item> items;

        public List<Item> getItems() {
            return items;
        }
    }

    public static class Item {

        Venue venue;

        public Venue getVenue() {
            return venue;
        }
    }
}
