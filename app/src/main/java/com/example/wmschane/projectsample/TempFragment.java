package com.example.wmschane.projectsample;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TempFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TempFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TempFragment extends Fragment implements OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters


    private double DegreeValue;
    Button TempUP;
    Button TempDown;
    EditText Degree;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TempFragment() {


        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TempFragment.
     *
     */
    // TODO: Rename and change types and number of parameters





    public static TempFragment newInstance(String param1, String param2) {
        TempFragment fragment = new TempFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        super.onCreate(savedInstanceState);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        TempUP = (Button) view.findViewById(R.id.TempPlus);
        TempDown = (Button) view.findViewById(R.id.TempMinus);
        Degree = (EditText) view.findViewById(R.id.TempDegree);


        TempUP.setOnClickListener(this);
        TempDown.setOnClickListener(this);

        return view;

    }




    @Override
    public void onClick(View v){


        


        switch (v.getId()){
            case R.id.TempPlus:
                DegreeValue = Float.parseFloat(Degree.getText().toString());
                if(DegreeValue > 90){
                    DegreeValue = 75;
                }
                if(DegreeValue < 60){
                    DegreeValue = 75;
                }
                DegreeValue = DegreeValue + 1.0f;
                Degree.setText(Double.toString(DegreeValue));
                break;
            case R.id.TempMinus:
                DegreeValue = Float.parseFloat(Degree.getText().toString());
                if(DegreeValue > 112){
                    DegreeValue = 75;
                }
                if(DegreeValue < 30){
                    DegreeValue = 75;
                }
                DegreeValue = DegreeValue - 1.0f;
                Degree.setText(Double.toString(DegreeValue));
                break;
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
