package com.infogramtelemedia.foodlist.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.infogramtelemedia.foodlist.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InstructionsFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstructionsFragments extends Fragment {

    TextView tvInstructions;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InstructionsFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InstructionsFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static InstructionsFragments newInstance(String param1, String param2) {
        InstructionsFragments fragment = new InstructionsFragments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    String instuctions;
    public void initDataInstructions(String instuctions){
        this.instuctions = instuctions;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_instructions_fragments, container, false);
        tvInstructions = view.findViewById(R.id.tvInsructions);
        tvInstructions.setText(instuctions);
        return view;
    }
}
