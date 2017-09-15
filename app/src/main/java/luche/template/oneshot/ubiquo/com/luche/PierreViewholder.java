package luche.template.oneshot.ubiquo.com.luche;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by akain on 14/09/2017.
 */

public class PierreViewholder extends RecyclerView.ViewHolder {
    View item;
    TextView name, number;
    CircularImageView img;

    public PierreViewholder(View itemView) {
        super(itemView);
        item=itemView;

        name = itemView.findViewById(R.id.p_name);
        number = itemView.findViewById(R.id.p_phone);
        img = itemView.findViewById(R.id.p_img);
    }

    public void setname (String pName){
        String[] parts = pName.split(" ");
        name.setText(parts[0]+"\n"+parts[1]);
    }

    public void setNumber(String num){
        String completeNumber = "+39 "+num;
        number.setText(completeNumber);
    }

    public void setImage(Activity ctx, String imgPath){
        Glide.with(ctx).load(imgPath).into(img);
    }
}
