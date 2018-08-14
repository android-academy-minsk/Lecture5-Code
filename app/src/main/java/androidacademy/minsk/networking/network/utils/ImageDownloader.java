package androidacademy.minsk.networking.network.utils;

import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class ImageDownloader {

    public static void download(
            String url,
            ImageView view
    ) {
        Picasso.get().load(url).into(view);
    }
}
