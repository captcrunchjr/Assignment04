package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.uncc.assignment04.Response;
import edu.uncc.assignment04.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IdentificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IdentificationFragment extends Fragment {
    final String TAG = "IdentificationFragment";
    public IdentificationFragmentListener mIdListener;

    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "ARG_NAME";
    private static final String ARG_EMAIL = "ARG_EMAIL";
    private static final String ARG_ROLE = "ARG_ROLE";

    // TODO: Rename and change types of parameters
    private String name;
    private String email;
    private String role;

    public IdentificationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name Parameter 1.
     * @param email Parameter 2.
     * @param role Parameter 3.
     * @return A new instance of fragment IdentificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IdentificationFragment newInstance(String name, String email, String role) {
        IdentificationFragment fragment = new IdentificationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_EMAIL, email);
        args.putString(ARG_ROLE, role);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.name = getArguments().getString(ARG_NAME);
            this.email = getArguments().getString(ARG_EMAIL);
            this.role = getArguments().getString(ARG_ROLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_identification, container, false);
        Button buttonNext = view.findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton selectedButton = view.findViewById(((RadioGroup)view.findViewById(R.id.radioGroup)).getCheckedRadioButtonId());
                String name = ((EditText)view.findViewById(R.id.editTextName)).getText().toString();
                String email = ((EditText)view.findViewById(R.id.editTextEmail)).getText().toString();
                if( selectedButton == null || name.isEmpty() || email.isEmpty()){
                    Toast toast = Toast.makeText(getContext(), "Please enter a name, email, and select a role", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    String selectedButtonText = selectedButton.getText().toString();
                    Response response = new Response(name, email, selectedButtonText);
                    Bundle savedInstanceState = new Bundle();
                    savedInstanceState.putSerializable("response", response);
                    Fragment demographicFragment = new DemographicFragment();
                    demographicFragment.setArguments(savedInstanceState);
                    mIdListener.IdentificationFragmentListener(response);
                    //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, demographicFragment).addToBackStack(null).commit();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mIdListener = (IdentificationFragmentListener) context;
    }

    public interface IdentificationFragmentListener {
        void IdentificationFragmentListener(Response res);
    }
}