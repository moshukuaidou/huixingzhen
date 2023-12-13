package com.example.list;
import android.database.Cursor;
import android.os.Build;
import android.widget.Button;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.SQL.DbContect;
import  com.example.edit.Text;
import com.example.huixingzhen.R;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.UUID;
import java.util.Random;
public class MyAdapter extends BaseAdapter {


    public interface OnButtonClickListener {
        void onButtonClick(int position, int id);
    }

    private OnButtonClickListener buttonClickListener;

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        this.buttonClickListener = listener;
    }





    private Context mContext;
    private LinkedList<Data> mData;
    private Calendar calendar = Calendar.getInstance();
    private Text txt;

    private Context context;
    DbContect dbHelper ;
    public MyAdapter() {

    }

    public MyAdapter(LinkedList<Data> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
        System.out.println(mContext);

        txt=new Text();

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //定义一个接口，触发该函数即跳转到MainActivity中




    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
            holder = new ViewHolder();
            holder.xuanze = convertView.findViewById(R.id.checkBox_day_1);
            holder.neirong = convertView.findViewById(R.id.List_view_neirong);
            holder.shijian = convertView.findViewById(R.id.List_view_shijian);
            holder.button=convertView.findViewById(R.id.List_view_button);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Data data = mData.get(position);
        holder.neirong.setText(data.getContent());
        holder.shijian.setText(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH) + 1)+"-"+ calendar.get(Calendar.DATE));
        holder.xuanze.setChecked(data.isSelected());
        dbHelper= new DbContect(mContext);
        dbHelper.getWritableDatabase();
        holder.xuanze.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                mData.get(position).setSelected(isChecked);
            }
        });
//点击详细信息按钮时,向数据库添加一条只有id的条目
        holder.button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                //首先从Data中获取id
                int uniqueId=  mData.get(position).getid();
                System.out.println(uniqueId);
                //id为0说明没插入
                if(uniqueId==0) {
                    //给按钮生成随机的唯一ID，并给按钮设置id，不给Data设置id，方便后面判断插入数据库

                    uniqueId=generateRandomInt();
                   // mData.get(position).setId(uniqueId);
                    holder.button.setId(uniqueId);
                    System.out.println(holder.button.getId());
                }else{
                    //id不为0说明Data有数据，是从数据库里面来的，就要将id和按钮绑定。或者已经创建了，
                    holder.button.setId(uniqueId);
                    System.out.println(holder.button.getId());
                }

                System.out.println(uniqueId);

                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClick(position,uniqueId);
                }


            }
        });
        return convertView;
    }

    public void add(Data data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }


    public void remove(Data data) {
        if(mData != null) {
            mData.remove(data);
            data.setSelected(false);
        }
        notifyDataSetChanged();
    }



    public void clear() {
        if(mData != null) {
            mData.clear();
        }
        notifyDataSetChanged();
    }





    private class ViewHolder {
        TextView neirong;
        TextView shijian;
        CheckBox xuanze;
        Button button;

    }

    public static int generateRandomInt() {
        long timestamp = System.currentTimeMillis();
        Random random = new Random(timestamp);
        return random.nextInt(899999999)+100000000;  // 范围可以根据需要调整
    }
}
