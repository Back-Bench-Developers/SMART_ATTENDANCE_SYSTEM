package com.example.attendanceproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendanceproject.ui.EcedeptAdapter;

public class tableadapter extends  RecyclerView.Adapter<tableadapter.tableviewHolder>{
    Context context;
    Attendancedata2 attendancedata2;
    public tableadapter(Context context,Attendancedata2 attendancedata2)
    {
        this.context=context;
        this.attendancedata2=attendancedata2;
    }
    @NonNull
    @Override
    public tableviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.tablelist,null);
        tableadapter.tableviewHolder userViewHolderEce=new tableadapter.tableviewHolder(view);
        return userViewHolderEce;
    }

    @Override
    public void onBindViewHolder(@NonNull tableviewHolder holder, int position) {
        holder.tabledate.setText(attendancedata2.getAttens().get(position).getIndia_date());
        String s=getdata(attendancedata2.getAttens().get(position).getFirst_period());
        holder.fst.setText(s);
        s=getdata(attendancedata2.getAttens().get(position).getSec_period());
        holder.sst.setText(s);
        s=getdata(attendancedata2.getAttens().get(position).getThird_period());
        holder.tst.setText(s);
        s=getdata(attendancedata2.getAttens().get(position).getFourt_period());
        holder.fth.setText(s);
        s=getdata(attendancedata2.getAttens().get(position).getFifth_period());
        holder.ffth.setText(s);
        s=getdata(attendancedata2.getAttens().get(position).getSix_period());
        holder.ssth.setText(s);
        s=getdata(attendancedata2.getAttens().get(position).getSeven_period());
        holder.seth.setText(s);
        s=getdata(attendancedata2.getAttens().get(position).getEight_period());
        holder.eth.setText(s);
    }

    private String getdata(String first_period) {

        if (first_period.equals("3"))
        {
            first_period="     ";
        }
        if (first_period.equals("1"))
        {
            first_period="p   ";
        }
        if (first_period.equals("0"))
        {
            first_period="a   ";
        }
        return first_period;
    }

    @Override
    public int getItemCount() {
        return attendancedata2.getAttens().size();
    }

    public class tableviewHolder extends RecyclerView.ViewHolder
    {
        TextView tabledate,fst,sst,tst,fth,ffth,ssth,seth,eth;
        public tableviewHolder(@NonNull View itemView) {
            super(itemView);
            tabledate=(TextView)itemView.findViewById(R.id.tabledate);
            fst=(TextView)itemView.findViewById(R.id.fst);
            tst=(TextView)itemView.findViewById(R.id.tst);
            sst=(TextView)itemView.findViewById(R.id.sst);
            fth=(TextView)itemView.findViewById(R.id.fth);
            ffth=(TextView)itemView.findViewById(R.id.ffth);
            ssth=(TextView)itemView.findViewById(R.id.ssth);
            seth=(TextView)itemView.findViewById(R.id.seth);
            eth=(TextView)itemView.findViewById(R.id.eth);
        }
    }
}
