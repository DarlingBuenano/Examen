package software.examen;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.View;


@NonReusable
@Layout(R.layout.revistas)

public class PlaceHolderView {
    @View(R.id.imgPortada)
    ImageView imgPortada;

    @View(R.id.txtNombre)
    TextView txtNombre;

    @View(R.id.txtDescripcion)
    TextView txtDescripcion;

    private Context mContext;
}
