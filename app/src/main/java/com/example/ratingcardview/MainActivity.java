package com.example.ratingcardview;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClick {
    private RecyclerView rvEmoji;
    private Adapter adapter;
    private List<Model> modelList = new ArrayList<>();
    private TextView tvFeedback;
    private TextView btnSubmit;
    private String feedback = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvEmoji = findViewById(R.id.rvEmoji);
        tvFeedback = findViewById(R.id.tvFeedback);
        btnSubmit = findViewById(R.id.btnSubmit);
        rvEmoji.setHasFixedSize(true);
        rvEmoji.setLayoutManager(new GridLayoutManager(this, 5));
        modelList.add(new Model(R.drawable.very_bad));
        modelList.add(new Model(R.drawable.bad));
        modelList.add(new Model(R.drawable.average));
        modelList.add(new Model(R.drawable.good));
        modelList.add(new Model(R.drawable.perfact));

        adapter = new Adapter(this, modelList, this);
        rvEmoji.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "" + feedback, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void itemCLick(int position) {
        btnSubmit.setEnabled(true);
        if (position == 0) {
            feedback = "Very Bad";
            tvFeedback.setText(feedback);
        } else if (position == 1) {
            feedback = "Bad";
            tvFeedback.setText(feedback);
        } else if (position == 2) {
            feedback = "Average";
            tvFeedback.setText(feedback);
        } else if (position == 3) {
            feedback = "Good";
            tvFeedback.setText(feedback);
        } else if (position == 4) {
            feedback = "Perfect";
            tvFeedback.setText(feedback);
        }
       // Toast.makeText(this, "" + feedback, Toast.LENGTH_SHORT).show();
    }
}