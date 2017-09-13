package luche.template.oneshot.ubiquo.com.luche;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFrag extends Fragment {


    public ContactFrag() {
        // Required empty public constructor
    }

    public static ContactFrag newFrag (){
        ContactFrag newFrag = new ContactFrag();
        return newFrag;
    }

    protected Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_contact, container, false);
        button = viewGroup.findViewById(R.id.fragPhone);


        return viewGroup;
    }

}
