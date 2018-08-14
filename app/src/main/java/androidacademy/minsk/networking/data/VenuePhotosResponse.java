package androidacademy.minsk.networking.data;

import java.util.List;

public class VenuePhotosResponse {

    PhotosResponse photos;

    public String getFirstUrl() {
        return (photos == null) ? null : photos.getFirstUrl();
    }

    public class PhotosResponse {

        List<Item> items;

        public List<Item> getItems() {
            return items;
        }

        String getFirstUrl() {
            return (items == null) || items.size() < 1 ? null : items.get(0).getUrl();
        }
    }

    public class Item {

        String id;
        String prefix;
        String suffix;

        public String getUrl() {
            return String.format("%s%s%s", prefix, "original", suffix);
        }
    }
}
