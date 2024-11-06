---
icon: material/keyboard
---

#### Basic Usage

```kotlin
// create a file that can be shared with external apps
val cacheFile = CachedFileProvider.copyFileToCache(context, file)
val cacheFile = CachedFileProvider.copyFileToCache(context, uri)

// get the shareable uri for this file
val uri = CachedFileProvider.getCacheFileUri(context, cacheFile.name)

// now you can share the uri with external apps
// ATTENTION: if you share the file via an intent,
// also use Intent.FLAG_GRANT_READ_URI_PERMISSION
// ...
```

!!! tip

    If you want to share the cached file with an email app, then check out [FeedbackManager](https://mflisar.github.io/FeedbackManager){:target="_blank"} - its an utility based on `CacheFileProvider` that does exactly that. It also takes care of the above mentioned `Intent.FLAG_GRANT_READ_URI_PERMISSION`.