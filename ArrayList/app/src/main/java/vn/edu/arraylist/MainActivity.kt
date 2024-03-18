import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] arrstring = new String [] {"Mai","Cuc","Lan","Hong"};
    Integer[] arrInteger = new Integer[] {1,2,1,34,5,78,234};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list = Arrays.asList(arrString);
        List<Integer> integerList = Arrays.asList(arrInteger);
    }

}