package com.michaelflisar.cachefileprovider;


import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CacheFileProviderUtil {

    public static File copyFile(Context context, File fileToCopy, String cacheFileName) {
        File cacheFile = new File(context.getCacheDir(), cacheFileName);
        if (cacheFile.exists()) {
            cacheFile.delete();
        }

        if (fileToCopy == null) {
            try {
                cacheFile.createNewFile();
            } catch (IOException e) {

            }
        } else {
            copy(fileToCopy, cacheFile);
        }

        return cacheFile;
    }

    public static Uri copyFile(Context context, Uri fileToCopy, String cacheFileName, boolean checkIfFileIsInCache) {

        // 1) check if file is already in cache
        if (checkIfFileIsInCache && isFileInCache(context, fileToCopy)) {
            return fileToCopy;
        }

        // 2) else copy the file to the cache directory
        File cacheFile = new File(context.getCacheDir(), cacheFileName);
        if (cacheFile.exists()) {
            cacheFile.delete();
        }

        if (fileToCopy == null) {
            try {
                cacheFile.createNewFile();
            } catch (IOException e) {

            }
        } else {
            copy(context, fileToCopy, cacheFile);
        }

        return Uri.fromFile(cacheFile);
    }

    private static boolean isFileInCache(Context context, Uri fileUri) {
        try {
            File file = new File(fileUri.getPath());
            return file.getParentFile().getAbsolutePath().equals(context.getCacheDir().getAbsolutePath());
        } catch (Exception e) {
            return false;
        }

    }

    private static boolean copy(File src, File dst) {
        try {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst);
            return copy(in, out);
        } catch (IOException e) {
            return false;
        }
    }

    private static boolean copy(Context context, Uri src, File dst) {
        try {
            ContentResolver content = context.getContentResolver();
            InputStream in = content.openInputStream(src);
            OutputStream out = new FileOutputStream(dst);
            return copy(in, out);
        } catch (IOException e) {
            return false;
        }
    }

    private static boolean copy(InputStream in, OutputStream out) {
        boolean success = false;
        try {
            // Transfer bytes from in to out
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            success = true;
        } catch (IOException e) {

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }

        return success;
    }
}
