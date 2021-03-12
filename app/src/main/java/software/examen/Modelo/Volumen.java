package software.examen.Modelo;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONException;
import org.json.JSONObject;

import software.examen.R;

public class Volumen {

    @View(R.id.imgCover)
    ImageView imgCover;

    @View(R.id.txtTitle)
    TextView txtTitle;

    @View(R.id.txtDataPublished)
    TextView txtDataPublished;

    @View(R.id.txtDoi)
    TextView txtDoi;

    @View(R.id.txtVolume)
    TextView txtVolume;

    @View(R.id.txtYear)
    TextView txtYear;

    @View(R.id.txtNumber)
    TextView txtNumber;

    @View(R.id.txtIssue_id)
    TextView txtIssue_id;

    private Context context;
    private JSONObject jsonVolumen;

    public Volumen(Context context, JSONObject jsonVolumen){
        this.context = context;
        this.jsonVolumen = jsonVolumen;
    }

    @Resolve
    protected void onResolved(){
        try {
            Glide.with(this.context).load(jsonVolumen.getString("cover")).into(this.imgCover);
            txtTitle.setText(jsonVolumen.getString("title"));
            txtDataPublished.setText(jsonVolumen.getString("date_published"));
            txtDoi.setText(jsonVolumen.getString("doi"));
            txtVolume.setText(jsonVolumen.getString("volume"));
            txtYear.setText(jsonVolumen.getString("year"));
            txtNumber.setText(jsonVolumen.getString("number"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
