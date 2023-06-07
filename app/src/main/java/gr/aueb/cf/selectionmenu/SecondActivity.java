package gr.aueb.cf.selectionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * SecondActivity represents the second screen of the application.
 * It displays the selected item's title and image.
 */
public class SecondActivity extends AppCompatActivity {

    private TextView welcomeTV;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeTV = findViewById(R.id.welcomeTV);
        ImageView imageView = findViewById(R.id.imageView);

        final String welcome = "You Selected ";
        String stringToDisplay = "";

        Intent intent = getIntent();
        String selectedTitle = intent.getStringExtra("title");
        int selectedImage = intent.getIntExtra("image", 0);

        stringToDisplay = welcome.concat(selectedTitle);
        welcomeTV.setText(stringToDisplay);
        imageView.setImageResource(selectedImage);
    }
}