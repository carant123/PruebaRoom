package com.proyecto.qr.retrofitrxjava;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Carlos on 16/02/2018.
 */

public class AdapterRetrofit extends RecyclerView.Adapter<AdapterRetrofit.AdapterViewHolder> {

    private MultipleResource data;
    private Context context;

    public AdapterRetrofit(MultipleResource data, Context context) {
        this.data = data;
        this.context = context;
    }

/*    public void setStrings(MultipleResource data) {
        this.data = data;
        notifyDataSetChanged();
    }*/


    @Override
    public AdapterRetrofit.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyvleview_item_layout,parent,false);
        return new AdapterRetrofit.AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterRetrofit.AdapterViewHolder holder, int position) {
        holder.binHolder(data);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void clearItem () {
        data = null;
        notifyDataSetChanged();
    }



    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        TextView datavalue;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            datavalue = itemView.findViewById(R.id.textViewData);
        }

        public void binHolder(MultipleResource data) {
            datavalue.setText("TotalPages: " + data.totalPages);
        }
    }
}
