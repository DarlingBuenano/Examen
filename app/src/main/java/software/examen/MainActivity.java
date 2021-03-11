package software.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import software.examen.Modelo.Revista;
import software.examen.WebService.Asynchtask;
import software.examen.WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, this, this);
        ws.execute("GET");

        PlaceHolderView phvRevistas = findViewById(R.id.phvRevistas);
        phvRevistas.addView(new Revista(getApplicationContext(), "Mi url 1"));
        phvRevistas.addView(new Revista(getApplicationContext(), "Mi url 2"));
    }

    @Override
    public void processFinish(String result) throws JSONException {

    }
}