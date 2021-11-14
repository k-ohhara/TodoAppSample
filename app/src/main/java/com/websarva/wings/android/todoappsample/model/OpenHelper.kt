package com.websarva.wings.android.todoappsample.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class OpenHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Todo.db"
        private const val SQL_CREATE_ENTRIES = ("CREATE TABLE todo" +
                " (" +
                "taskId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "taskName TEXT NOT NULL,"
                + "status INTEGER NOT NULL)")
        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS todo"
    }
}
