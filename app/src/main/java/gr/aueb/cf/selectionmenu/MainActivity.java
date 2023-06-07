package gr.aueb.cf.selectionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import gr.aueb.cf.selectionmenu.adapters.MyArrayAdapter;

/***
 * MainActivity represents the main screen of the application.
 * It displays a list of items and handles item click events.
 * When an item is clicked, the user is redirected to another page, SecondActivity,
 * with the selected item's title and image.
 *
 * @author Kountouris Panagiotis
 */
public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        String[] titles = {"Java", "SQL", "C Sharp", "Javascript", "python", "Typescript", "HTML", "CSS"};

        String[] description = {
                "Java is a popular general-purpose programming language known for its versatility and platform independence",
                "SQL (Structured Query Language) is a programming language used for managing and manipulating relational databases",
                "C# is a modern, object-oriented programming language developed by Microsoft, commonly used for building Windows applications and web services",
                "JavaScript is a high-level, interpreted programming language that adds interactivity and dynamic behavior to websites",
                "Python is a versatile and easy-to-learn programming language known for its simplicity and readability, widely used in various domains including web development, data analysis, and artificial intelligence",
                "TypeScript is a typed superset of JavaScript that compiles to plain JavaScript, providing static typing and enhanced tooling for large-scale applications",
                "HTML (Hypertext Markup Language) is the standard markup language for creating web pages, defining their structure and content",
                "CSS (Cascading Style Sheets) is a stylesheet language used to describe the presentation and layout of HTML documents, enabling styling and visual enhancements",
        };

        Integer [] images = {
                R.drawable.ic_java,
                R.drawable.ic_sql,
                R.drawable.ic_csharp,
                R.drawable.ic_javascript,
                R.drawable.ic_python,
                R.drawable.ic_typescript,
                R.drawable.ic_html,
                R.drawable.ic_css
        };

        // We create our own adapter
        MyArrayAdapter myArrayAdapter = new MyArrayAdapter(
                this,
                titles,
                description,
                images
        );

        listView.setAdapter(myArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItemTitle = titles[position]; // Get the selected item's title
                int selectedItemImage = images[position];

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("title", selectedItemTitle);
                intent.putExtra("image", selectedItemImage);

                startActivity(intent);
            }
        });
    }
}