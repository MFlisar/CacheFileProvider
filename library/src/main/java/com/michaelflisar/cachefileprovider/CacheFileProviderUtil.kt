package com.michaelflisar.cachefileprovider

import android.content.Context
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

internal object CacheFileProviderUtil {

    fun copy(src: File, dst: File): Boolean {
        return try {
            val inputStream = FileInputStream(src)
            val outputStream = FileOutputStream(dst)
            copy(inputStream, outputStream)
        } catch (e: IOException) {
            Log.e("CacheFileProvider", "Error copying file!", e)
            false
        }
    }

    fun copy(context: Context, src: Uri, dst: File): Boolean {
        return try {
            val content = context.contentResolver
            val inputStream = content.openInputStream(src)
            val outputStream = FileOutputStream(dst)
            copy(inputStream, outputStream)
        } catch (e: IOException) {
            Log.e("CacheFileProvider", "Error copying file ($src => $dst)!", e)
            false
        }
    }

   private fun copy(inputStream: InputStream?, outputStream: OutputStream): Boolean {
        if (inputStream == null)
            return false
        var success = false
        try {
            // Transfer bytes from in to out
            val buf = ByteArray(1024)
            var len: Int
            while (inputStream.read(buf).also { len = it } > 0) {
                outputStream.write(buf, 0, len)
            }
            success = true
        } catch (e: IOException) {
            Log.e("CacheFileProvider", "Error copying file!", e)
        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {
                Log.e("CacheFileProvider", "Error copying file!", e)
            }
            try {
                outputStream.close()
            } catch (e: IOException) {
                Log.e("CacheFileProvider", "Error copying file!", e)
            }
        }
        return success
    }
}