package androidacademy.minsk.networking.presentation;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidacademy.minsk.networking.R;
import androidacademy.minsk.networking.network.utils.ImageDownloader;
import androidacademy.minsk.networking.presentation.model.VenueViewModel;

class VenueViewHolder extends RecyclerView.ViewHolder {

    private final ImageView imageView;
    private final TextView textView;

    VenueViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);
    }

    public void bindViewHolder(VenueViewModel venue) {
        textView.setText(venue.getName());

        if (!TextUtils.isEmpty(venue.getImageUrl())) {
            ImageDownloader.download(venue.getImageUrl(), imageView);
        }
    }
}
