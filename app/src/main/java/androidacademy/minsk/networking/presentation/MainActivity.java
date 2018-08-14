package androidacademy.minsk.networking.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import androidacademy.minsk.networking.R;
import androidacademy.minsk.networking.data.SimpleNetworkCallback;
import androidacademy.minsk.networking.domain.GetVenues;

public class MainActivity extends AppCompatActivity {

    private VenueListViewModel viewModel;
    private VenuesAdapter adapter;
    private GetVenues getVenues;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.rv_places);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new VenuesAdapter(null);
        recyclerView.setAdapter(adapter);

        getVenues = new GetVenues();
        final SimpleNetworkCallback<VenueListViewModel> venuesViewModelNetworkCallback
                = new SimpleNetworkCallback<VenueListViewModel>() {

            @Override
            public void onSuccess(VenueListViewModel viewModel) {
                MainActivity.this.viewModel = viewModel;
                if (index >= 0) {
                    adapter.setItem(index, MainActivity.this.viewModel.getVenues());
                } else {
                    adapter.setItems(viewModel.getVenues());
                }
            }
        };

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                getVenues.execute(venuesViewModelNetworkCallback);
            }

            ;
        });
    }
}
