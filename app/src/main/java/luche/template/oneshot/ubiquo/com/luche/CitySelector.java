package luche.template.oneshot.ubiquo.com.luche;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kogitune.activity_transition.fragment.ExitFragmentTransition;
import com.kogitune.activity_transition.fragment.FragmentTransition;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * A simple {@link Fragment} subclass.
 */
public class CitySelector extends DialogFragment {

    TextView isernia,gapito,cassino,bojano,carpinone,monteroduni,campobasso,venafro,agnone,macchiagodena;

    public CitySelector() {
        // Required empty public constructor
    }

    public static CitySelector newInstance(){
        CitySelector newFrag = new CitySelector();
        return newFrag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_city_selector, container, false);

        isernia = viewGroup.findViewById(R.id.iserniaSelector);
        gapito = viewGroup.findViewById(R.id.stgapitoSelector);
        cassino = viewGroup.findViewById(R.id.cassinoSelector);
        bojano = viewGroup.findViewById(R.id.bojanoSelector);
        carpinone = viewGroup.findViewById(R.id.carpinoneSelector);
        monteroduni = viewGroup.findViewById(R.id.monteroduniSelector);
        campobasso = viewGroup.findViewById(R.id.campobassoSelector);
        venafro = viewGroup.findViewById(R.id.venafroSelector);
        agnone = viewGroup.findViewById(R.id.agnoneSelector);
        macchiagodena = viewGroup.findViewById(R.id.macchiagodenaSelector);


        isernia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PierreList newFrag = PierreList.newInstance("Isernia");
                newFrag.show(getFragmentManager(),"isernia");
            }
        });
        gapito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PierreList newFrag = PierreList.newInstance("Santagapito");
                newFrag.show(getFragmentManager(),"Santagapito");
            }
        });
        cassino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PierreList newFrag = PierreList.newInstance("Cassino");
                newFrag.show(getFragmentManager(),"Cassino");
            }
        });
        bojano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PierreList newFrag = PierreList.newInstance("Bojano");
                newFrag.show(getFragmentManager(),"Bojano");
            }
        });
        carpinone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PierreList newFrag = PierreList.newInstance("Carpinone");
                newFrag.show(getFragmentManager(),"Carpinone");
            }
        });
        monteroduni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PierreList newFrag = PierreList.newInstance("Monteroduni");
                newFrag.show(getFragmentManager(),"Monteroduni");
            }
        });
        campobasso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PierreList newFrag = PierreList.newInstance("Campobasso");
                newFrag.show(getFragmentManager(),"Campobasso");
            }
        });
        venafro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PierreList newFrag = PierreList.newInstance("Venafro");
                newFrag.show(getFragmentManager(),"Venafro");
            }
        });
        agnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PierreList newFrag = PierreList.newInstance("Agnone");
                newFrag.show(getFragmentManager(),"Agnone");
            }
        });
        macchiagodena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PierreList newFrag = PierreList.newInstance("Macchiagodena");
                newFrag.show(getFragmentManager(),"Macchiagodena");
            }
        });


        return viewGroup;
    }


}
