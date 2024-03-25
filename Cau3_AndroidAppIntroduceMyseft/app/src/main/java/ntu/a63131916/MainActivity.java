package ntu.a63131916;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView logoImageView;
    private TextView introduceTextView;
    private Button watchTrailerButton;
    private TextView projectDateTextView;
    private ImageView facebookIconImageView, instagramIconImageView, twitterIconImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        logoImageView = findViewById(R.id.logoImageView);
        introduceTextView = findViewById(R.id.introduceTextView);
        watchTrailerButton = findViewById(R.id.watchTrailerButton);
        projectDateTextView = findViewById(R.id.projectDateTextView);
        facebookIconImageView = findViewById(R.id.facebookIconImageView);
        instagramIconImageView = findViewById(R.id.instagramIconImageView);
        twitterIconImageView = findViewById(R.id.twitterIconImageView);
    }
}
