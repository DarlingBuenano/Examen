package software.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;
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

    }
}