package com.example.universalcinema;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class BinhLuanFrag extends Fragment {
    private View mRootView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final LinkedList<BinhLuan> listCmt = new LinkedList<>();
        listCmt.add(new BinhLuan("Nguoi dung 1", "Phim hay lam do"));
        listCmt.add(new BinhLuan("Nguoi dung 2", "Phim khong te"));
        listCmt.add(new BinhLuan("Nguoi dung 3", "Phim chan lam"));

        final RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerviewcmt);

        Button btn = getView().findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = getView().findViewById(R.id.editcmt);
                String cmt = editText.getText().toString();
                BinhLuan binhLuan = new BinhLuan("Nguoi dung 4", cmt);
                listCmt.addLast(binhLuan);
                ReAdapter reAdapter = new ReAdapter(getContext(), listCmt);
                recyclerView.setAdapter(reAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                editText.setText("");
            }
        });

        ReAdapter reAdapter = new ReAdapter(this.getContext(), listCmt);
        recyclerView.setAdapter(reAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.frag_binhluan,container,false);

        //TextView txtName = (TextView) getView().findViewById(R.id.txtname);
        //TextView txtCmt = (TextView) getView().findViewById(R.id.txtcmt);

        return mRootView;
    }
}
