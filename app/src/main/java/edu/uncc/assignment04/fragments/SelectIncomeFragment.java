package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectIncomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectIncomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_RESPONSE = "response";

    // TODO: Rename and change types of parameters
    private Response mRes;
    public IncomeFragmentListener mListener;

    public SelectIncomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SelectIncomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectIncomeFragment newInstance(Response param1) {
        SelectIncomeFragment fragment = new SelectIncomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_select_income, container, false);
        ((SeekBar)view.findViewById(R.id.seekBar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;

                if(progressChangedValue == 0){
                    ((TextView)view.findViewById(R.id.textViewHouseHoldIncome)).setText("<$25k");
                }
                else if (progressChangedValue == 1){
                    ((TextView)view.findViewById(R.id.textViewHouseHoldIncome)).setText("$25k-<$50k");
                }
                else if (progressChangedValue == 2) {
                    ((TextView)view.findViewById(R.id.textViewHouseHoldIncome)).setText("$50k-<$100k");
                }
                else if (progressChangedValue == 3) {
                    ((TextView)view.findViewById(R.id.textViewHouseHoldIncome)).setText("$100k-<$200k");
                }
                else {
                    ((TextView)view.findViewById(R.id.textViewHouseHoldIncome)).setText(">$200k");
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        view.findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onIncomeFragmentInteraction(((TextView)view.findViewById(R.id.textViewHouseHoldIncome)).getText().toString());
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

    public interface IncomeFragmentListener {
        void onIncomeFragmentInteraction(String income);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectIncomeFragment.IncomeFragmentListener) context;
    }
}