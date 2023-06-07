package gr.aueb.cf.selectionmenu.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import gr.aueb.cf.selectionmenu.R;

/**
 * MyArrayAdapter is a custom ArrayAdapter used to populate the ListView in MainActivity.
 * It binds the data (titles, descriptions, and images) to the item_view layout.
 */
public class MyArrayAdapter extends ArrayAdapter<String> {
    private Activity context;
    private String[] myTitles;
    private String[] myDescriptions;
    private Integer[] myImages;

    /**
     * Constructs a new instance of MyArrayAdapter.
     *
     * @param context       The activity context.
     * @param myTitles      The array of item titles.
     * @param myDescriptions The array of item descriptions.
     * @param myImages      The array of item images.
     */
    public MyArrayAdapter(Activity context, String[] myTitles, String[] myDescriptions, Integer[] myImages){
        super(context, R.layout.item_view, myTitles);
        this.context = context;
        this.myTitles = myTitles;
        this.myDescriptions = myDescriptions;
        this.myImages = myImages;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Layout Inflater
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);

        // We make the connections
        TextView titleText = view.findViewById(R.id.titleTV);
        TextView descriptionText = view.findViewById(R.id.descriptionTV);
        ImageView imageView = view.findViewById(R.id.myIV);

        titleText.setText(myTitles[position]);
        descriptionText.setText(myDescriptions[position]);
        imageView.setImageResource(myImages[position]);

        return view;
    }
}
