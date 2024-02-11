package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DemographicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemographicFragment extends Fragment {
    final String TAG = "DemographicFragment";
    private Response res;

    goToEducationListener mEduListener;
    goToMaritalListener mMaritalListener;
    goToLivingListener mLivingListener;
    goToIncomeListener mIncomeListener;
    goToProfileListener mProfileListener;
    private String educationLevel;
    private String livingStatus;
    private String income;
    private String maritalStatus;

    public DemographicFragment() {
        // Required empty public constructor
    }

    public static DemographicFragment newInstance(Response param1) {
        DemographicFragment fragment = new DemographicFragment();
        Bundle args = new Bundle();
        args.putSerializable("response", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            res = (Response)getArguments().getSerializable("response");
        }
        if(!res.getEducationLevel().isEmpty()){
            educationLevel = res.getEducationLevel();
        }
        if(!res.getLivingStatus().isEmpty()){
            livingStatus = res.getLivingStatus();
        }
        if(!res.getIncome().isEmpty()){
            income = res.getIncome();
        }
        if(!res.getMaritalStatus().isEmpty()){
            maritalStatus = res.getMaritalStatus();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demographic, container, false);
        ((TextView)view.findViewById(R.id.textViewEducation)).setText(educationLevel);
        ((TextView)view.findViewById(R.id.textViewLivingStatus)).setText(livingStatus);
        ((TextView)view.findViewById(R.id.textViewIncomeStatus)).setText(income);
        ((TextView)view.findViewById(R.id.textViewMaritalStatus)).setText(maritalStatus);

        view.findViewById(R.id.buttonSelectEducation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + res.toString());
                mEduListener.goToEducationListener(res);
            }
        });

        view.findViewById(R.id.buttonSelectMarital).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaritalListener.goToMaritalListener(res);
            }
        });

        view.findViewById(R.id.buttonSelectLiving).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLivingListener.goToLivingListener(res);
            }
        });

        view.findViewById(R.id.buttonSelectIncome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIncomeListener.goToIncomeListener(res);
            }
        });

        view.findViewById(R.id.buttonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(res.getLivingStatus().isEmpty() || res.getMaritalStatus().isEmpty() || res.getEducationLevel().isEmpty() || res.getIncome().isEmpty()){
                    Toast toast = Toast.makeText(getContext(), "Please fill out all fields", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    mProfileListener.goToProfileListener(res);
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mEduListener = (goToEducationListener) context;
        mMaritalListener = (goToMaritalListener) context;
        mLivingListener = (goToLivingListener) context;
        mIncomeListener = (goToIncomeListener) context;
        mProfileListener = (goToProfileListener) context;

    }

    public interface goToEducationListener {
        void goToEducationListener(Response res);
    }

    public interface goToMaritalListener {
        void goToMaritalListener(Response res);
    }

    public interface goToLivingListener {
        void goToLivingListener(Response res);
    }

    public interface goToIncomeListener {
        void goToIncomeListener(Response res);
    }

    public interface goToProfileListener {
        void goToProfileListener(Response res);
    }
}