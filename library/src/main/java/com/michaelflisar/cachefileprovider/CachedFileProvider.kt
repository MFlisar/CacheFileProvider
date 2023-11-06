package com.michaelflisar.cachefileprovider

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException

class CachedFileProvider : FileProvider() {

    companion object {

        fun getAuthority(context: Context): String {
            return context.packageName + ".CachedFileProvider"
        }

        fun getCacheFileUri(context: Context, fileName: String): Uri {
            val folder = getCacheFileDirectory(context)
            val cacheFile = File(folder, fileName)
            return FileProvider.getUriForFile(context, getAuthority(context), cacheFile)
        }

        fun getCacheFileDirectory(context: Context): File {
            return File(context.filesDir, "shared-files")
        }

        fun copyFileToCache(
            context: Context,
            fileToCopy: File,
            cacheFileName: String? = null
        ): File {
            val fileName = cacheFileName ?: fileToCopy.name
            val folder = getCacheFileDirectory(context)
            val cacheFile = File(folder, fileName)
            if (cacheFile.exists()) {
                cacheFile.delete()
            }
            try {
                cacheFile.mkdirs()
                cacheFile.createNewFile()
            } catch (e: IOException) {
                Log.e("CacheFileProvider", "Error copying file!", e)
            }
            CacheFileProviderUtil.copy(fileToCopy, cacheFile)
            return cacheFile
        }

        fun copyFileToCache(
            context: Context,
            uriToCopy: Uri,
            cacheFileName: String? = null
        ): File {
            val fileName = cacheFileName ?: uriToCopy.lastPathSegment ?: "file"
            val folder = getCacheFileDirectory(context)
            val cacheFile = File(folder, fileName)
            if (cacheFile.exists()) {
                cacheFile.delete()
            }
            try {
                folder.mkdirs()
                cacheFile.createNewFile()
                CacheFileProviderUtil.copy(context, uriToCopy, cacheFile)
            } catch (e: IOException) {
                Log.e("CacheFileProvider", "Error copying file!", e)
            }
            return cacheFile
        }
    }
}