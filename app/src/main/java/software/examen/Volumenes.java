package software.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import software.examen.Modelo.Volumen;
import software.examen.WebService.Asynchtask;
import software.examen.WebService.WebService;

import com.mindorks.placeholderview.PlaceHolderView;

public class Volumenes extends AppCompatActivity implements Asynchtask {

    PlaceHolderView phvVolumenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);

        String journal_id = getIntent().getStringExtra("journal_id");

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id=" + journal_id,
                datos, this, this);
        ws.execute("GET");

        this.phvVolumenes = findViewById(R.id.phvVolumenes);
    }

    @Override
    public void processFinish(String result) throws JSONException {
        try {
            JSONArray jsonArray = new JSONArray(result);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                this.phvVolumenes.addView(new Volumen(getApplicationContext(), jsonObject));
            }
        }
        catch (JSONException ex){
            System.out.println(ex.getMessage());
        }
    }
}