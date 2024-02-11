package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectMaritalStatusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectMaritalStatusFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_RESPONSE = "response";

    // TODO: Rename and change types of parameters
    private Response mRes;
    public MaritalStatusFragmentListener mListener;

    public SelectMaritalStatusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SelectMaritalStatusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectMaritalStatusFragment newInstance(Response param1) {
        SelectMaritalStatusFragment fragment = new SelectMaritalStatusFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_RESPONSE, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRes = (Response)getArguments().getSerializable(ARG_RESPONSE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_marital_status, container, false);

        view.findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
                RadioButton selectedButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                if(selectedButton == null) {
                    Toast.makeText(getContext(), "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    String radioText = selectedButton.getText().toString();
                    mListener.MaritalStatusFragmentListener(radioText);
                }
            }
        });

        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (MaritalStatusFragmentListener) context;
    }

    public interface MaritalStatusFragmentListener {
        void MaritalStatusFragmentListener(String maritalStatus);
    }
}