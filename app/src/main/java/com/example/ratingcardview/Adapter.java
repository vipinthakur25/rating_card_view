package com.example.ratingcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    private Context context;
    private List<Model> modelList;
    OnItemClick click;
    int row_index;
    // if checkedPosition = -1, there is no default selection
    // if checkedPosition = 0, 1st item is selected by default
    private int checkedPosition = 0;

    public Adapter(Context context, List<Model> modelList, OnItemClick click) {
        this.context = context;
        this.modelList = modelList;
        this.click = click;
    }

    @NonNull
    @Override
    public Adapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);

        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterViewHolder holder, int position) {
        holder.bindView(modelList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.itemCLick(position);
                row_index = position;
                notifyDataSetChanged();
            }
        });
        if (row_index == position) {
            holder.viewBackground.setBackgroundResource(R.drawable.item_selected_bg);
            holder.ivSelect.setVisibility(View.VISIBLE);
        } else {
            holder.viewBackground.setBackgroundResource(R.drawable.item_background_unselected);
            holder.ivSelect.setVisibility(View.GONE);
        }
    }

    public interface OnItemClick {
        void itemCLick(int position);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        private View viewBackground;
        private ImageView ivEmoji;
        private ImageView ivSelect;
        private ConstraintLayout cardView;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            viewBackground = itemView.findViewById(R.id.viewBackground);
            ivEmoji = itemView.findViewById(R.id.ivEmoji);
            ivSelect = itemView.findViewById(R.id.ivSelect);
            cardView = itemView.findViewById(R.id.cardView);

        }

        private void bindView(Model model) {
            ivEmoji.setImageResource(model.getImage());
//            if (model.status) {
//                viewBackground.setBackgroundResource(R.drawable.item_selected_bg);
//                ivSelect.setVisibility(View.VISIBLE);
//            } else {
//                viewBackground.setBackgroundResource(R.drawable.item_background_unselected);
//                ivSelect.setVisibility(View.GONE);
//            }
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (model.status) {
//                        viewBackground.setBackgroundResource(R.drawable.item_background_unselected);
//                        ivSelect.setVisibility(View.GONE);
//                        model.status = false;
//                    } else {
//                        viewBackground.setBackgroundResource(R.drawable.item_selected_bg);
//                        ivSelect.setVisibility(View.VISIBLE);
//                        model.status = true;
//                    }
//                }
//            });
        }
    }
}
