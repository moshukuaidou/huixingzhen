package com.example.edit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.huixingzhen.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link edit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class edit extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  View contentView;

    private EditText jianhuaNeirong_EditText;

    private EditText sikaoNeirong_EditText;
    private EditText fansi_EditText;

    private EditText jiluNeirong_EditText;

    private EditText lianxiangNeirong_EditText;
    private Text text_text;
    public edit() {


        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment edit.
     */
    // TODO: Rename and change types and number of parameters
    public static edit newInstance(String param1, String param2) {
        edit fragment = new edit();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 填充布局文件
        contentView = inflater.inflate(R.layout.fragment_edit, container, false);
        // 初始化视图组件
        initializeViews();
        // 隐藏内容
        hideContent();
        return contentView;
    }

    private void initializeViews() {
        // 查找并初始化各个EditText组件
        fansi_EditText = contentView.findViewById(R.id.fansi_neirong);
        jianhuaNeirong_EditText = contentView.findViewById(R.id.jianhua_neirong);
        sikaoNeirong_EditText = contentView.findViewById(R.id.sikao_neirong);
        jiluNeirong_EditText = contentView.findViewById(R.id.jilu_neirong);
        lianxiangNeirong_EditText = contentView.findViewById(R.id.lianxiang_neirong);

        // 初始化Text对象
        text_text = new Text();
    }

    private void hideContent() {
        // 初始时隐藏内容
      //  if (contentView != null) {
            contentView.setVisibility(View.INVISIBLE);
       // }
    }

    private void showContent(Text txt) {
        // 当需要时显示内容
       // if (contentView != null) {

        fansi_EditText.setText(txt.getFansi());
        jianhuaNeirong_EditText .setText(txt.getjianhuaNeirong());
        sikaoNeirong_EditText .setText(txt.getsikaoNeirong());
        jiluNeirong_EditText .setText(txt.getjiluNeirong());
        lianxiangNeirong_EditText .setText(txt.getlianxiangNeirong());



        contentView.setVisibility(View.VISIBLE);
        //}
    }
    private void editView() {
        // 根据用户输入更新Text对象的属性
        text_text.setFansi(fansi_EditText.getText().toString());
        text_text.setjianhuaNeirong(jianhuaNeirong_EditText.getText().toString());
        text_text.setsikaoNeirong(sikaoNeirong_EditText.getText().toString());
        text_text.setjiluNeirong(jiluNeirong_EditText.getText().toString());
        text_text.setlianxiangNeirong(lianxiangNeirong_EditText.getText().toString());
    }

    @Override
    public void onPause() {
        super.onPause();
        // 在Fragment暂停时更新数据模型
        updateNoteModel();
    }

    private void updateNoteModel() {
        // 更新数据模型
        editView();
        // 根据用户输入执行其他逻辑或操作
    }

    // 添加一个方法，在需要时显示Fragment内容（例如，点击按钮时调用）
    public void showFragmentContent(Text txt) {


        showContent(txt);
    }
    public void setText_text(Text txt){
        text_text=txt;
    }
}