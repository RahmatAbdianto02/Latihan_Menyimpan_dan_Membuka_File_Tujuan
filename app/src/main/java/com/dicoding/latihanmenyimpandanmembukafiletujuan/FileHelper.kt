package com.dicoding.latihanmenyimpandanmembukafiletujuan

import android.content.Context

internal object FileHelper {

    fun writeToFile(fileModel: FileModel,context: Context){
        context.openFileOutput(fileModel.filename,Context.MODE_PRIVATE).use {
            it.write(fileModel.data?.toByteArray())
        }
    }

    fun readFromFile(context: Context,filname:String): FileModel{
        val fileModel = FileModel()
        fileModel.filename = filname
        fileModel.data = context.openFileInput(filname).bufferedReader().useLines { lines ->
            lines.fold(""){ some,text ->
                "$some$text\n"
            }
        }
        return fileModel
    }
}