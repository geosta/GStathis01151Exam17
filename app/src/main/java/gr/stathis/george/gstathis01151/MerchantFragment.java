package gr.stathis.george.gstathis01151;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MerchantFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MerchantFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 *
 */

    public class MerchantFragment extends Fragment {

        MerchantAdapter merchantAdapter;

        public MerchantFragment() {

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public void onStart() {
            super.onStart();
            fetchMerchants();
        }

        private void fetchMerchants(){
            FetchMerchantsTask fetchMerchantsTask = new FetchMerchantsTask(merchantAdapter);
            fetchMerchantsTask.execute();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            //gsgs View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            View rootView = inflater.inflate(R.layout.fragment_merchant , container, false);
            merchantAdapter = new MerchantAdapter(getActivity(),new ArrayList<Merchant>());
            ListView merchantListView = (ListView)rootView.findViewById(R.id.listview_merchants);
            merchantListView.setAdapter(merchantAdapter);

            return rootView;
        }
    }
