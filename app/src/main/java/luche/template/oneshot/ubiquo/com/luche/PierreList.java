package luche.template.oneshot.ubiquo.com.luche;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Range;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.ChangeText;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionSet;

import java.awt.font.NumericShaper;
import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;


/**
 * A simple {@link Fragment} subclass.
 */
public class PierreList extends DialogFragment {

    private static String targetCity;
    protected RecyclerView recyclerView;
    protected FirebaseRecyclerAdapter<Pierre,PierreViewholder> pierreAdapter;
    protected DatabaseReference myRef;
    protected TextView cityTextView;

    public PierreList() {
        // Required empty public constructor
    }

    public static PierreList newInstance(String city){
        targetCity = city;
        PierreList newFrag = new PierreList();
        return newFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myRef = FirebaseDatabase.getInstance().getReference().child("Pierre").child(targetCity);
        Query alphabetic = myRef.orderByChild("nome");
        myRef.keepSynced(true);

        pierreAdapter = new FirebaseRecyclerAdapter<Pierre, PierreViewholder>(
                Pierre.class,
                R.layout.pierre_card,
                PierreViewholder.class,
                alphabetic
        ) {
            @Override
            protected void populateViewHolder(PierreViewholder viewHolder, final Pierre model, int position) {
                viewHolder.setImage(getActivity(),model.getImg());
                viewHolder.setname(model.getNome());
                viewHolder.setNumber(model.getPhone());
                viewHolder.actionCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + model.getPhone()));
                        startActivity(call);
                    }
                });

                Animation anim = new ScaleAnimation(0f,1f,Animation.RELATIVE_TO_SELF,Animation.RELATIVE_TO_SELF);
                anim.setDuration(400);
                anim.setStartOffset(offSetSwitcher(position));
                viewHolder.itemView.startAnimation(anim);
            }


        };
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_pierre_list, container, false);
        recyclerView = viewGroup.findViewById(R.id.recyclerPr);
        cityTextView = viewGroup.findViewById(R.id.current_city);
        cityTextView.setText(targetCity.toLowerCase());



        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new SlideInLeftAnimator(new OvershootInterpolator(1f)));



        SlideInBottomAnimationAdapter alphaAdapter = new SlideInBottomAnimationAdapter(pierreAdapter);
        alphaAdapter.setDuration(1000);
        alphaAdapter.setFirstOnly(false);
        alphaAdapter.setInterpolator(new OvershootInterpolator());

        recyclerView.setAdapter(alphaAdapter);



        return viewGroup;
    }



   protected Long offSetSwitcher(Integer position){
       if(position>=0 && position<=4){
           return position*100L;
       }

       if(position>=5 && position<=9){
           return position*20L;
       }

       if(position>=10 && position<=14){
           return position*10L;
       }

       if(position>=15 && position<=19){
           return position*10L;
       }

       return position*100L;
   }
}
