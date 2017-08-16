package com.example.francisco.w3d2weekday;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by FRANCISCO on 10/08/2017.
 */

public class RandomListAdapter extends RecyclerView.Adapter<RandomListAdapter.ViewHolder> {

    private static final String TAG = "RandomListAdapter";
    ArrayList<RandomObjects> randomList = new ArrayList<>();
    Context context;

    public RandomListAdapter(ArrayList<RandomObjects> randomList) {
        this.randomList = randomList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvrandom1,tvrandom2,tvrandom3;
        ImageView tvrandom4;

        public ViewHolder(View itemView) {
            super(itemView);

            tvrandom1 = (TextView) itemView.findViewById(R.id.tvrandom1);
            tvrandom2 = (TextView) itemView.findViewById(R.id.tvrandom2);
            tvrandom3 = (TextView) itemView.findViewById(R.id.tvrandom3);
            tvrandom4 = (ImageView) itemView.findViewById(R.id.tvrandom4);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.randomlist_item, parent, false);
        return new ViewHolder(view);
    }

    private int lastPosition = -1;
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(position > lastPosition){
            //Animation animation = AnimationUtils
        }

        Log.d(TAG, "onBindViewHolder: ");
        final RandomObjects randoms = randomList.get(position);
        holder.tvrandom1.setText(""+randoms.getRandom1());
        holder.tvrandom2.setText(""+randoms.getRandom2());
        holder.tvrandom3.setText(""+randoms.getRandom3());
        holder.tvrandom4.setImageResource(randoms.getRandom4());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(context, AlarmService.class);
                myIntent.putExtra("element",randoms.getRandom1()+" "+randoms.getRandom2());
                PendingIntent pendingIntent = PendingIntent.getService(context, 0, myIntent, 0);
                AlarmManager alarmManager = (AlarmManager)context.getSystemService(ALARM_SERVICE);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.SECOND, 1);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                //Toast.makeText(context, "Start Alarm", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        //Log.d(TAG, "getItemCount: "+randomList.size());
        return randomList.size();
    }
}
