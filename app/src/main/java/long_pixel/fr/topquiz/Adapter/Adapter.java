package long_pixel.fr.topquiz.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import long_pixel.fr.topquiz.R;

/**
 * Created by romain on 22/11/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<String> listePseudo = new ArrayList<>();
    ArrayList<Integer> listScore = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_listview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {

            super(itemView);


        }
    }
}
