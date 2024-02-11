package edu.uncc.assignment04.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_RESPONSE = "response";

    // TODO: Rename and change types of parameters
    private Response mRes;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(Response param1) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ((TextView)view.findViewById(R.id.textViewName)).setText(mRes.getName());
        ((TextView)view.findViewById(R.id.textViewEmail)).setText(mRes.getEmail());
        ((TextView)view.findViewById(R.id.textViewEdu)).setText(mRes.getEducationLevel());
        ((TextView)view.findViewById(R.id.textViewMaritalStatus)).setText(mRes.getMaritalStatus());
        ((TextView)view.findViewById(R.id.textViewLivingStatus)).setText(mRes.getLivingStatus());
        ((TextView)view.findViewById(R.id.textViewIncomeValue)).setText(mRes.getIncome());

        return view;
    }
}