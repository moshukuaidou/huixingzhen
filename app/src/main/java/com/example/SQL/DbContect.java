package com.example.SQL;
import com.example.edit.Text;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbContect extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "Users.db";
    private static final String TABLE_NAME = "text";  // 修改为与原代码中一致的表名
    private static final String TAG = "DbContect";
    private Context mContext;

    public DbContect(Context context) {
        super(context, DB_NAME, null, VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建表的 SQL 语句
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                " (_id INTEGER PRIMARY KEY ," +
                " brain_remind int(1) ,speak_remind int(1) , re_think int(1) ,  date VARCHAR(200),fansi VARCHAR(200), jianhua VARCHAR(200), jilu VARCHAR(200)," +
                " sikao VARCHAR(200), lianxiang VARCHAR(200), reviewday_1 int(1) , reviewday_3 int(1) ,reviewday_7 int(1), reviewday_14 int(1), reviewday_21 int(1), reviewday_30 int(1) )";
        // 执行 SQL 语句创建表
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 升级数据库时，删除旧表并重新创建新表

    }
//插入
    public void insert(int id,String TIME,Text user) {

        if (mContext == null) {
            Log.e(TAG, "Context is null. Unable to perform database operation.");
            return;
        }
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", id);
        values.put("brain_remind", user.getBrain_remind());
        values.put("speak_remind", user.getSpeak_remind());
        values.put("re_think", user.getRe_think());
        values.put("date", TIME);
        values.put("fansi", user.getFansi());
        values.put("jianhua", user.getjianhuaNeirong());
        values.put("jilu", user.getjiluNeirong());
        values.put("sikao", user.getsikaoNeirong());
        values.put("lianxiang", user.getlianxiangNeirong());
        values.put("reviewday_1", user.getReviewDay_1());
        values.put("reviewday_3", user.getReviewDay_3());
        values.put("reviewday_7", user.getReviewDay_7());
        values.put("reviewday_14", user.getReviewDay_14());
        values.put("reviewday_21", user.getReviewDay_21());
        values.put("reviewday_30", user.getReviewDay_30());

       db.insert(TABLE_NAME, null, values);
        db.close();

    }
//更新,返回行数
    public void update(Text user, int userId) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "_id = ?";
        String[] whereArgs = {String.valueOf(userId)};

        ContentValues values = new ContentValues();
        values.put("_id", userId);
        values.put("brain_remind", user.getBrain_remind());
        values.put("speak_remind", user.getSpeak_remind());
        values.put("re_think", user.getRe_think());
        values.put("date", user.getTime());
        values.put("fansi", user.getFansi());
        values.put("jianhua", user.getjianhuaNeirong());
        values.put("jilu", user.getjiluNeirong());
        values.put("sikao", user.getsikaoNeirong());
        values.put("lianxiang", user.getlianxiangNeirong());
        values.put("reviewday_1", user.getReviewDay_1());
        values.put("reviewday_3", user.getReviewDay_3());
        values.put("reviewday_7", user.getReviewDay_7());
        values.put("reviewday_14", user.getReviewDay_14());
        values.put("reviewday_21", user.getReviewDay_21());
        values.put("reviewday_30", user.getReviewDay_30());
        int rowsAffected = db.update(TABLE_NAME, values, whereClause, whereArgs);

        // 检查更新是否成功
        if (rowsAffected > 0) {
            Log.d(TAG, "update: 更新成功, 受影响的行数：" + rowsAffected);
        } else {
            Log.e(TAG, "update: 更新失败, 没有受影响的行");
        }

        db.close();
    }


    public Cursor query() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
    public Cursor queryById(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE _id = ?";
        return db.rawQuery(query, new String[]{String.valueOf(id)});
    }
    public void delete(int id){
        SQLiteDatabase db = getWritableDatabase();
        String sql="delete from text where _id= ?";
        db.execSQL(sql,new String[]{String.valueOf(id)});
        //关闭db通道
        db.close();
        Log.d("DbContect", "delete: 删除"+id);
    }


    public void deleteAll(){
        SQLiteDatabase db = getWritableDatabase();
        String sql="delete from text";
        db.execSQL(sql);
        //关闭db通道
        db.close();
        Log.d("hc", "deleteAll: 清空");
    }



}
