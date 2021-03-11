package software.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import software.examen.Modelo.Revista;
import software.examen.WebService.Asynchtask;
import software.examen.WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    PlaceHolderView phvRevistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, this, this);
        ws.execute("GET");

        this.phvRevistas = findViewById(R.id.phvRevistas);
    }

    @Override
    public void processFinish(String result) throws JSONException {

        try {
            JSONArray jsonArray = new JSONArray(result);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                this.phvRevistas.addView(new Revista(getApplicationContext(), jsonObject));
            }
        }
        catch (JSONException ex){
            System.out.println(ex.getMessage());
        }
    }
}