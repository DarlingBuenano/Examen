package software.examen.Modelo;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import software.examen.R;

@NonReusable
@Layout(R.layout.revistas)
public class Revista {
    @View(R.id.imgPortada)
    ImageView imgPortada;

    @View(R.id.txtNombre)
    TextView txtNombre;

    @View(R.id.txtDescripcion)
    TextView txtDescripcion;

    private Context mContext;
    private String url;

    public Revista(Context context, String url){
        mContext = context;
        this.url = url;
    }

    @Resolve
    protected void onResolved(){
        //Esto para cargar una url en la imagen
        //Glide.with(this.mContext).load(this.url).into(this.imgPortada);

        //Esto para establecer datos en las vistas
        this.txtNombre.setText("asfaf");
    }
}
