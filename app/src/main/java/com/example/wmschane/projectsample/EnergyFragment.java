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
import android.widget.Button;


public class EnergyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

//    public EnergyFragment() {
//        // Required empty public constructor
//    }

//    // TODO: Rename and change types and number of parameters
//    public static EnergyFragment newInstance(String param1, String param2) {
//        EnergyFragment fragment = new EnergyFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energy,container, false);

        // Inflate the layout for this fragment
        Button manageLights = (Button) view.findViewById(R.id.manage_lights_button);

        manageLights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, new LightsFragment());
                transaction.commit();
            }
        });


        Button tempBtn = (Button)view.findViewById(R.id.set_temperature_button);

        tempBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, new TempFragment());
                transaction.commit();

            }
        });



        Button appliancesBtn = (Button)view.findViewById(R.id.manage_appliances_button);
        appliancesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction;
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, new ApplianceFragment());
                transaction.commit();
            }
        });




        return  view;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

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
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
