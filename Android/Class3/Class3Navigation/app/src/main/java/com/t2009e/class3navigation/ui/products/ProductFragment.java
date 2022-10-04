package com.t2009e.class3navigation.ui.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.t2009e.class3navigation.R;
import com.t2009e.class3navigation.databinding.FragmentProductBinding;
import com.t2009e.class3navigation.listview.CustomListAdapter;
import com.t2009e.class3navigation.listview.ListItem;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {

    private FragmentProductBinding binding;
    private ListView listJob;
    private CustomListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProductsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(ProductsViewModel.class);

        binding = FragmentProductBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setVariables( root );

        //final TextView textView = binding.textProducts;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    void setVariables(View v) {
        this.listJob = (ListView) v.findViewById(R.id.list);

        //data
        this.adapter = new CustomListAdapter( this.getActivity(), initJobs() );

        //set data into ListView
        this.listJob.setAdapter( this.adapter );

        this.listJob.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListItem item = (ListItem) listJob.getItemAtPosition(i);
                Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    List<ListItem> initJobs() {
        List<ListItem> list = new ArrayList<>();

        list.add(new ListItem("Haha Dev", "Team leader", "Ha noi"));
        list.add(new ListItem("C# Dev", "Dev leader", "Ha noi"));
        list.add(new ListItem("C++ Dev", "Dev leader", "Ha noi"));
        list.add(new ListItem("Node Dev", "Dev leader", "Ha noi"));
        list.add(new ListItem("PHP Dev", "Dev leader", "Ha noi"));

        return list;
    }
}