package com.tworoot2.sqlitedatabase.databaseClass

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.pupupunk.Model.ItemActivity
import com.example.pupupunk.Model.Model

class Domain(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    val model = Model()

    override fun onCreate(db: SQLiteDatabase) {

       val query = ("CREATE TABLE " + TABLE_ACTIVITIES + " ("
               + ID_ACT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
               LOCATION_NAME_COL + " TEXT, " +
               USERNAME_COL + " TEXT, " +
               PHOTO_COL + " TEXT, " +
               DESCRIPTION_COL + " TEXT, " +
               PLACE_COL + " TEXT, " +
               DATE_COL + " TEXT, " +
               TIME_COL + " TEXT" + ");")

        db.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ACTIVITIES;")
        onCreate(db)
    }

    fun insertActivity(locationName: String, userName: String, photo: String, description: String, place: String, date: String, time: String) {
        val db: SQLiteDatabase = this.writableDatabase
        val newActivity = ItemActivity(-1, userName, photo, description, place, date, time)
        if (!model.checkDataAndTimeCorrect(date, time)) {throw Exception("Follow hints to enter data and time")}
        if (model.checkTimeOut(newActivity)){ throw Exception("Cannot schedule an activity for more than 7 days in advance") }
        val contentValues = ContentValues().apply {
            put(LOCATION_NAME_COL, locationName)
            put(USERNAME_COL, userName)
            put(PHOTO_COL, photo)
            put(DESCRIPTION_COL, description)
            put(PLACE_COL, place)
            put(DATE_COL, date)
            put(TIME_COL, time)
        }
        val c = db.insert(TABLE_ACTIVITIES, null, contentValues)
        Log.d("INSERT__DATA", c.toString())
        db.close()
    }

    @SuppressLint("Range", "Recycle")
    fun getData(locationName: String): ArrayList<ItemActivity> {
        val db = this.readableDatabase
        var cursor: Cursor? = null
        var itemsArray = ArrayList<ItemActivity>()
        try{
            cursor = db.rawQuery("SELECT * FROM $TABLE_ACTIVITIES WHERE $LOCATION_NAME_COL = '$locationName'", null)
        }catch(e: SQLiteException) {
            Log.d("GET_ERROR", e.message.toString())
            return ArrayList()
        }
        if (cursor.moveToFirst()) {
                do {
                    val id = cursor.getInt(cursor.getColumnIndex(ID_ACT))
                    val userName = cursor.getString(cursor.getColumnIndex(USERNAME_COL))
                    val userPhoto = cursor.getString(cursor.getColumnIndex(PHOTO_COL))
                    val description = cursor.getString(cursor.getColumnIndex(DESCRIPTION_COL))
                    val place = cursor.getString(cursor.getColumnIndex(PLACE_COL))
                    val date = cursor.getString(cursor.getColumnIndex(DATE_COL))
                    val time = cursor.getString(cursor.getColumnIndex(TIME_COL))
                    itemsArray.add(
                        ItemActivity(
                            id,
                            userName,
                            userPhoto,
                            description,
                            place,
                            date,
                            time
                        )
                    )
                } while (cursor.moveToNext())
            }
        db.close()
        return itemsArray

    }

    fun deleteActivity(activity: ItemActivity):Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ID_ACT, activity.id)
        val success = db.delete(TABLE_ACTIVITIES,"activityId="+activity.id,null)
        db.close()
        return success
    }



    @SuppressLint("Range")
    fun clearAllDeadlines(){
        val db = this.writableDatabase
        var cursor = db.rawQuery("SELECT * FROM $TABLE_ACTIVITIES", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(ID_ACT))
                val userName = cursor.getString(cursor.getColumnIndex(USERNAME_COL))
                val userPhoto = cursor.getString(cursor.getColumnIndex(PHOTO_COL))
                val description = cursor.getString(cursor.getColumnIndex(DESCRIPTION_COL))
                val place = cursor.getString(cursor.getColumnIndex(PLACE_COL))
                val date = cursor.getString(cursor.getColumnIndex(DATE_COL))
                val time = cursor.getString(cursor.getColumnIndex(TIME_COL))
                val activity = ItemActivity(id, userName, userPhoto, description, place, date, time)
                if (model.checkTimeOut(activity)){
                    Log.d("DELETE_ACTIVITY", id.toString() + description)
                    deleteActivity(activity) }
            } while (cursor.moveToNext())
        }
        db.close()
    }


    // initialize here database name and database version
    companion object {
        private val DATABASE_NAME = "mydatabase.db"
        private val DATABASE_VERSION = 1

        val TABLE_ACTIVITIES = "activities"
        val ID_ACT = "activityId"
        val LOCATION_NAME_COL = "location_name"
        val USERNAME_COL = "userName"
        val PHOTO_COL = "photo"
        val DESCRIPTION_COL = "description"
        val PLACE_COL = "place"
        val DATE_COL = "date"
        val TIME_COL = "time"

    }


}