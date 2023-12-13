package com.example.edit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import java.util.Random;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.SQL.DbContect;
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
    private RadioGroup Radio_feiman;
    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private CheckBox checkbox3;
    private CheckBox review_day_1;
    private CheckBox review_day_3;
    private CheckBox review_day_7;
    private CheckBox review_day_14;
    private CheckBox review_day_21;
    private CheckBox review_day_30;

    private DbContect dbhelper;

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
        dbhelper= new DbContect(getActivity());
        dbhelper.getWritableDatabase();
        checkbox1 = contentView.findViewById(R.id.radioButton25);
        checkbox2 =contentView. findViewById(R.id.radioButton26);
        checkbox3 = contentView.findViewById(R.id.radioButton27);

        review_day_1 = contentView.findViewById(R.id.checkBox_day_1 );
        review_day_3 =contentView. findViewById(R.id.checkBox_day_3);
        review_day_7 = contentView.findViewById(R.id.checkBox_day_7 );
        review_day_14 = contentView.findViewById(R.id.checkBox_day_14 );
        review_day_21 =contentView. findViewById(R.id.checkBox_day_21 );
        review_day_30 = contentView.findViewById(R.id.checkBox_day_30 );

        fansi_EditText = contentView.findViewById(R.id.fansi_neirong);
        jianhuaNeirong_EditText = contentView.findViewById(R.id.jianhua_neirong);
        sikaoNeirong_EditText = contentView.findViewById(R.id.sikao_neirong);
        jiluNeirong_EditText = contentView.findViewById(R.id.jilu_neirong);
        lianxiangNeirong_EditText = contentView.findViewById(R.id.lianxiang_neirong);

        // 初始化Text对象
        text_text = new Text();
//存储复选按钮
        saveCheckbox(text_text);
        saveUserInputText();


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

        checkbox1.setChecked( txt.getBrain_remind()!=0);
        checkbox2.setChecked( txt.getSpeak_remind()!=0);
        checkbox3.setChecked( txt.getRe_think()!=0);
        fansi_EditText.setText(txt.getFansi());
        jianhuaNeirong_EditText .setText(txt.getjianhuaNeirong());
        sikaoNeirong_EditText .setText(txt.getsikaoNeirong());
        jiluNeirong_EditText .setText(txt.getjiluNeirong());
        lianxiangNeirong_EditText .setText(txt.getlianxiangNeirong());
        review_day_1.setChecked( txt.getReviewDay_1()!=0);
        review_day_3.setChecked( txt.getReviewDay_3()!=0);
        review_day_7.setChecked( txt.getReviewDay_7()!=0);
        review_day_14.setChecked( txt.getReviewDay_14()!=0);
        review_day_21.setChecked( txt.getReviewDay_21()!=0);
        review_day_30.setChecked( txt.getReviewDay_30()!=0);

        contentView.setVisibility(View.VISIBLE);
        //}
    }


    @Override
    public void onPause() {
        super.onPause();
        // 在Fragment暂停时更新数据模型
        dbhelper=new DbContect(getActivity());
        dbhelper.update(text_text,text_text.getId());
        dbhelper.close();
    }


    // 添加一个方法，在需要时显示Fragment内容（例如，点击按钮时调用）
    public void showFragmentContent(Text txt) {

       text_text=txt;
        showContent(txt);
    }
    public void setText_text(Text txt){
        text_text=txt;
    }

    public void saveCheckbox(Text txt){
        checkbox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (isChecked) {
            //选中
            text_text.setBrain_remind(1);
        }else {//没有选中
            text_text.setBrain_remind(0);
        }

    });
        checkbox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (isChecked) {
            text_text.setSpeak_remind(1);
        }else {//没有选中
            text_text.setSpeak_remind(0);
        }
    });
        checkbox3.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (isChecked) {
            text_text.setSpeak_remind(1);
        }else {//没有选中
            text_text.setSpeak_remind(0);
        }
    });
        review_day_1.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (isChecked) {
            text_text.setReviewDay_1(1);
        }else {//没有选中
            text_text.setReviewDay_1(0);
        }
    });
        review_day_3.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (isChecked) {
            text_text.setReviewDay_3(1);
        }else {//没有选中
            text_text.setReviewDay_3(0);
        }
    });
        review_day_7.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (isChecked) {
            text_text.setReviewDay_7(1);
        }else {//没有选中
            text_text.setReviewDay_7(0);
        }
    });
        review_day_14.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (isChecked) {
            text_text.setReviewDay_14(1);
        }else {//没有选中
            text_text.setReviewDay_14(0);
        }
    });
        review_day_21.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (isChecked) {
            text_text.setReviewDay_21(1);
        }else {//没有选中
            text_text.setReviewDay_21(0);
        }
    });
        review_day_30.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (isChecked) {
            text_text.setReviewDay_30(1);
        }else {//没有选中
            text_text.setReviewDay_30(0);
        }
    });
    }


    private void saveUserInputText( ) {
        // Implement the logic to save user input (e.g., to SharedPreferences, file, or database)


// 创建独立的TextWatcher
        TextWatcher fansiWatcher = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             
            }

            @Override
            public void afterTextChanged(Editable s) {
                fansi_afterTextChanged(s);
            }
        };

         TextWatcher jianhuaNeirongWatcher = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
        
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
 
            }

            @Override
            public void afterTextChanged(Editable s) {
                jianhuaNeirong_afterTextChanged(s);
            }
        };

         TextWatcher sikaoNeirongWatcher = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
   
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
           
            }

            @Override
            public void afterTextChanged(Editable s) {
                sikaoNeirong_afterTextChanged(s);
            }
        };

         TextWatcher jiluNeirongWatcher = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
    
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      
            }

            @Override
            public void afterTextChanged(Editable s) {
                jiluNeirong_afterTextChanged(s);
            }
        };

         TextWatcher lianxiangNeirongWatcher = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               
            }

            @Override
            public void afterTextChanged(Editable s) {
                lianxiangNeirong_afterTextChanged(s);
            }
        };

// 在适当的地方为每个EditText设置对应的TextWatcher
        fansi_EditText.addTextChangedListener(fansiWatcher);
        jianhuaNeirong_EditText.addTextChangedListener(jianhuaNeirongWatcher);
        sikaoNeirong_EditText.addTextChangedListener(sikaoNeirongWatcher);
        jiluNeirong_EditText.addTextChangedListener(jiluNeirongWatcher);
        lianxiangNeirong_EditText.addTextChangedListener(lianxiangNeirongWatcher);






}

    private void lianxiangNeirong_afterTextChanged(Editable s) {
        String userInput = s.toString();
        text_text.setlianxiangNeirong(userInput);
    }

    private void jiluNeirong_afterTextChanged(Editable s) {
        String userInput = s.toString();
        text_text.setjiluNeirong(userInput);
    }

    private void sikaoNeirong_afterTextChanged(Editable s) {
        String userInput = s.toString();
        text_text.setsikaoNeirong(userInput);
    }

    private void jianhuaNeirong_afterTextChanged(Editable s) {
        String userInput = s.toString();
        text_text.setjianhuaNeirong(userInput);
    }

    private void fansi_afterTextChanged(Editable s) {
        String userInput = s.toString();
        text_text.setFansi(userInput);
    }








}