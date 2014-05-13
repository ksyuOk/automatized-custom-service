package com.example.android_client.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 13.05.14
 */
public class DatabaseCreater extends SQLiteOpenHelper {

    private Context context;

    private static String LOG_TAG = DatabaseCreater.class.getSimpleName();

    public static final String DATABASE_NAME = "customserviceDB";
    public static final int DATABASE_VERSION = 0;

    // ALL TABLES IN DATABASE
    public static final String TABLE_CATEGORY_MENU = "CategoryMenu";
    public static final String TABLE_DISH = "Dish";
    public static final String TABLE_CLIENT = "Client";
    public static final String TABLE_ORDER = "Order";
    public static final String TABLE_ORDER_ITEM = "OrderItem";

    // columns in CategoryMenu table
    public static final String TABLE_CATEGORYMENU_NAME = "CategoryName";
    public static final String TABLE_CATEGORYMENU_IMAGE = "CategoryImage";

    // columns in Dish table
    public static final String TABLE_DISH_IDCATEGORY = "IdCategory";
    public static final String TABLE_DISH_NAME = "DishName";
    public static final String TABLE_DISH_DESCRIPTION = "DishDescription";
    public static final String TABLE_DISH_TIMECOOK = "DishTimeCook";
    public static final String TABLE_DISH_PRICE = "DishPrice";
    public static final String TABLE_DISH_IMAGE = "DishImage";
    public static final String TABLE_DISH_LARGE_IMAGE = "DishLargeImage";

    // columns in Client table
    public static final String TABLE_CLIENT_NAME = "ClientName";
    public static final String TABLE_CLIENT_EMAIL = "ClientEmail";

    // columns in Order table
    public static final String TABLE_ORDER_IDCLIENT = "IdClient";
    public static final String TABLE_ORDER_TABLE_NUMBER = "TableNumber";
    public static final String TABLE_ORDER_PRICE = "OrderPrice";
    public static final String TABLE_ORDER_TIME_COOK = "OrderTimeCook";
    public static final String TABLE_ORDER_CREATED = "OrderCreated";
    public static final String TABLE_ORDER_RATE = "OrderRate";
    public static final String TABLE_ORDER_RESPONSE_DESCRIPTION = "OrderResponseDescription";
    public static final String TABLE_ORDER_STATUS = "OrderStatus";

    // columns in OrderItem table
    public static final String TABLE_ORDER_ITEM_IDORDER = "IdOrder";
    public static final String TABLE_ORDER_ITEM_IDDISH = "IdDish";
    public static final String TABLE_ORDER_ITEM_COUNT = "OrderItemCount";
    public static final String TABLE_ORDER_ITEM_PRICE = "OrderItemPrice";

    public static final String CREATE_TABLE_CATEGORY_MENU =
            "create table " + TABLE_CATEGORY_MENU +
                    " (" + BaseColumns._ID + " integer primary key autoincrement, " +
                    TABLE_CATEGORYMENU_NAME + " text, " +
                    TABLE_CATEGORYMENU_IMAGE + " blob);";

    public static final String CREATE_TABLE_DISH =
            "create table " + TABLE_DISH +
                    " (" + BaseColumns._ID + " integer primary key autoincrement, " +
                    TABLE_DISH_IDCATEGORY + " integer, " +
                    TABLE_DISH_NAME + " text, " +
                    TABLE_DISH_DESCRIPTION + " text, " +
                    TABLE_DISH_TIMECOOK + " long default 0, " +
                    TABLE_DISH_PRICE + " integer, " +
                    TABLE_DISH_IMAGE + " blob, " +
                    TABLE_DISH_LARGE_IMAGE + " blob, " +
                    "FOREIGN KEY(" + TABLE_DISH_IDCATEGORY + ") REFERENCES " +
                    TABLE_CATEGORY_MENU + "(" + BaseColumns._ID + "));";

    public static final String CREATE_TABLE_CLIENT =
            "create table " + TABLE_CLIENT +
                    " (" + BaseColumns._ID + " integer primary key autoincrement, " +
                    TABLE_CLIENT_NAME + " text, " +
                    TABLE_CLIENT_EMAIL + " text);";

    public static final String CREATE_TABLE_ORDER =
            "create table " + TABLE_ORDER +
                    " (" + BaseColumns._ID + " integer primary key autoincrement, " +
                    TABLE_ORDER_IDCLIENT + " integer, " +
                    TABLE_ORDER_TABLE_NUMBER + " integer, " +
                    TABLE_ORDER_PRICE + " integer, " +
                    TABLE_ORDER_TIME_COOK + " integer default 0, " +
                    TABLE_ORDER_CREATED + " long default 0, " +
                    TABLE_ORDER_RATE + " integer, " +
                    TABLE_ORDER_RESPONSE_DESCRIPTION + " text," +
                    TABLE_ORDER_STATUS + " text, " +
                    "FOREIGN KEY(" + TABLE_ORDER_IDCLIENT + ") REFERENCES " +
                    TABLE_CLIENT + "(" + BaseColumns._ID + "));";;


    public static final String CREATE_TABLE_ORDER_ITEM =
            "create table " + TABLE_ORDER_ITEM +
                    " (" + BaseColumns._ID + " integer primary key autoincrement, " +
                    TABLE_ORDER_ITEM_IDORDER + " integer, " +
                    TABLE_ORDER_ITEM_IDDISH + " integer, " +
                    TABLE_ORDER_ITEM_COUNT + " integer, " +
                    TABLE_ORDER_ITEM_PRICE + " long, " +
                    "FOREIGN KEY(" + TABLE_ORDER_ITEM_IDORDER + ") REFERENCES " +
                    TABLE_ORDER + "(" + BaseColumns._ID + ")" +
                    "FOREIGN KEY(" + TABLE_ORDER_ITEM_IDDISH + ") REFERENCES " +
                    TABLE_DISH + "(" + BaseColumns._ID + "));";



    public DatabaseCreater(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.beginTransaction();
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE_CATEGORY_MENU);
            sqLiteDatabase.execSQL(CREATE_TABLE_CLIENT);
            sqLiteDatabase.execSQL(CREATE_TABLE_DISH);
            sqLiteDatabase.execSQL(CREATE_TABLE_ORDER);
            sqLiteDatabase.execSQL(CREATE_TABLE_ORDER_ITEM);
            sqLiteDatabase.execSQL("PRAGMA case_sensitive_like = 0");
            sqLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            Log.d(LOG_TAG, "Can't create database ", e);
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.beginTransaction();
        try {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CATEGORY_MENU);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CLIENT);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_DISH);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ORDER);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ORDER_ITEM);
            sqLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            Log.d(LOG_TAG, "Can't delete database ", e);
        } finally {
            sqLiteDatabase.endTransaction();
        }
        onCreate(sqLiteDatabase);
    }
}
