package com.example.list;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import java.util.LinkedList;
import android.database.Cursor;
import com.example.SQL.DbContect;
import com.example.edit.Text;
import com.example.edit.edit;
import com.example.huixingzhen.MainActivity;
import com.example.huixingzhen.R;

import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag_List#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_List extends Fragment  implements MyAdapter.OnButtonClickListener  {







    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button tianjia;
    private double ran;
    private Button diwutianjia;
    private Button duixiangshanchu;
    private Calendar calendar = Calendar.getInstance();
    private Button youbiaoshanchu;
    private Button allshanchu;
    private TextView kong;
    private ListView list_one;
    private MyAdapter mAdapter = null;
    private List<Data> mData = null;
    private Context mContext = null;
    private CheckBox mBox = null;
    private  View contentView;
    private int flag = 1;
    private Data mData_5 = null;   //用来临时放对象的


    private DbContect dbhelper;

    public Frag_List() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_List.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_List newInstance(String param1, String param2) {
        Frag_List fragment = new Frag_List();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
                dbhelper = new DbContect(getActivity());
        dbhelper.getWritableDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       contentView = inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView = contentView.findViewById(R.id.list_one);

        bindViews();
//查询

 //       try (Cursor c = dbhelper.query()) {
            // 在 try-with-resources 语句中调用处理数据的方法
 //           processCursorData(c);
  //      }

        return contentView;
    }
//根据数据库向列表中添加item，对button进行id赋值
    private void processCursorData(Cursor cursor) {
        while (cursor.moveToNext()) {
            // 使用 getColumnIndex() 获取列的索引，而不是 getColumnCount()
            int dateColumnIndex = cursor.getColumnIndex("date");
            // 使用 getColumnIndex() 返回的索引获取列的值
            String dateValue = cursor.getString(dateColumnIndex);
            int id=cursor.getColumnIndex("id");
            // 做一些处理，比如将值添加到列表中
            additem(dateValue, "分类：提取文中的详细信息",id);
        }

        // 关闭游标
        cursor.close();
    }

    private void bindViews(){

        list_one = (ListView) contentView.findViewById(R.id.list_one);
        kong = (TextView) contentView.findViewById(R.id.kong);
        tianjia = (Button) contentView.findViewById(R.id.tianjia);

        mContext = requireContext(); // 或者 getContext()

        mData = new LinkedList<>();
        mAdapter = new MyAdapter((LinkedList<Data>) mData, mContext);

        mAdapter.setOnButtonClickListener(this);
        youbiaoshanchu = (Button) contentView.findViewById(R.id.youbiaoshanchu);
        allshanchu = (Button)contentView. findViewById(R.id.allshanchu);

        kong.setText("暂无数据~");
        list_one.setAdapter(mAdapter);
        list_one.setEmptyView(kong);

        //读取数据库中的数据并添加item
        Cursor cursor=dbhelper.query();
        if(cursor.moveToFirst())
        {
            do{
             //   System.out.println(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
                additem(cursor.getString(cursor.getColumnIndexOrThrow("date")) ,"分类：提取文中的详细信息",cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
            }while (cursor.moveToNext());
        }
        cursor.close();
//表面添加

        tianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                additem(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH) + 1)+"-"+ calendar.get(Calendar.DATE),"分类：提取文中的详细信息",0);

            }
        });
        youbiaoshanchu.setOnClickListener(view -> {
           System.out.println("youbiaoshanchu按钮被点击");
            if (mData != null) {
                for (int i = mData.size() - 1; i >= 0; i--) {
                    if (mData.get(i).isSelected()) {
                     //数据库删除
                        dbhelper.delete(mData.get(i).getid());
                        mData.remove(i);
                    }
                }
                mAdapter.notifyDataSetChanged(); // 通知适配器数据集已更改
            }
        });

        allshanchu.setOnClickListener(view -> {
            System.out.println("allshanchu按钮被点击");

            if (mData != null) {
                dbhelper.deleteAll();
                mData.clear();
                 flag=1;
            }
            mAdapter.notifyDataSetChanged(); // 通知适配器数据集已更改list_one.notifyAll();
        });



    }

private void additem(String time,String data,int id){
    mData_5 =new Data(time,data+flag ,false);

        mData_5.setId(id);

    mAdapter.add(mData_5);
    flag++;
}
//普通添加

    @Override
    public void onButtonClick(int position, int id) {
        // 在这里处理按钮点击事件
        // position 是被点击的按钮在列表中的位置
        handleButtonClick(position,id);
    }

    private void handleButtonClick(int position, int id) {
          System.out.println(id);
          System.out.println(this.mData.get(position).getid());
        // 处理按钮点击事件的逻辑
        // 可以在这里执行从Frag_List到edit页面的跳转等操作
        //取出数据库中与id相对应的数据并显示出来
          System.out.println("Frag_List:handleButtonClick");
        MainActivity mainActivity = (MainActivity) getActivity();
        Fragment editFragment = mainActivity.fragmentList.get(1);
        Text temp=new Text();
        //一致说明已经插入到数据库了，直接取出来就行，然后通过temp设置打开页面的内容

if (id==this.mData.get(position).getid()) {
    Cursor cursor = dbhelper.queryById(id);
    if (cursor.moveToFirst()) {


        temp.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));

        temp.setBrain_remind(cursor.getInt(cursor.getColumnIndexOrThrow("brain_remind")));
        temp.setSpeak_remind(cursor.getInt(cursor.getColumnIndexOrThrow("speak_remind")));
        temp.setRe_think(cursor.getInt(cursor.getColumnIndexOrThrow("re_think")));
        temp.setFansi(cursor.getString(cursor.getColumnIndexOrThrow("fansi")));
        temp.setjianhuaNeirong(cursor.getString(cursor.getColumnIndexOrThrow("jianhua")));
        temp.setjiluNeirong(cursor.getString(cursor.getColumnIndexOrThrow("jilu")));
        temp.setsikaoNeirong(cursor.getString(cursor.getColumnIndexOrThrow("sikao")));
        temp.setlianxiangNeirong(cursor.getString(cursor.getColumnIndexOrThrow("lianxiang")));
        temp.setReviewDay_1(cursor.getInt(cursor.getColumnIndexOrThrow("reviewday_1")));
        temp.setReviewDay_3(cursor.getInt(cursor.getColumnIndexOrThrow("reviewday_3")));
        temp.setReviewDay_7(cursor.getInt(cursor.getColumnIndexOrThrow("reviewday_7")));
        temp.setReviewDay_14(cursor.getInt(cursor.getColumnIndexOrThrow("reviewday_14")));
        temp.setReviewDay_21(cursor.getInt(cursor.getColumnIndexOrThrow("reviewday_21")));
        temp.setReviewDay_30(cursor.getInt(cursor.getColumnIndexOrThrow("reviewday_30")));


    }
    cursor.close();
}else {
    //不一致说明没插入数据库，直接插入数据库
    this.mData.get(position).setId(id);
    System.out.println(id);
    dbhelper.insert(mData.get(position).getid(),mData.get(position).getCurTime(),temp);

}

        ((edit) editFragment).showFragmentContent(temp);
        // 设置 ViewPager2 显示到 edit 页面
        mainActivity.viewPager.setCurrentItem(1, true);
    }
}