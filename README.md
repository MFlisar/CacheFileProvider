[![Maven](https://img.shields.io/maven-central/v/io.github.mflisar.cachefileprovider/library?style=for-the-badge&color=blue)](https://central.sonatype.com/namespace/io.github.mflisar.cachefileprovider)
[![API](https://img.shields.io/badge/api-21%2B-brightgreen.svg?style=for-the-badge)](https://android-arsenal.com/api?level=21)
[![Kotlin](https://img.shields.io/github/languages/top/mflisar/cachefileprovider.svg?style=for-the-badge&color=blueviolet)](https://kotlinlang.org/)
[![License](https://img.shields.io/github/license/MFlisar/CacheFileProvider?style=for-the-badge)](LICENSE)

<h1 align="center">CacheFileProvider</h1>

This is a minimal library with a **few lines of code** and without dependencies that offers a simple file provider (simple read only access for sharing files with other apps).

## :heavy_check_mark: Features

* offers functions to copy a file to the underlying FileProvider folder
* allows to simply share a file without any setup from user side
* minimal size - contains only **8 functions** inside **2 classes**

## :link: Dependencies

This library does not have any custom dependencies!

## :elephant: Gradle

This library is distributed via [maven central](https://central.sonatype.com/).

*build.gradle.kts*

```kts
val cachefileprovider = "<LATEST-VERSION>"

implementation("io.github.mflisar.cachefileprovider:library:$cachefileprovider")
```

## </> Basic Usage

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

## :bulb: Tipp

If you want to share the cached file with an email app, then check out [FeedbackManager](https://github.com/MFlisar/FeedbackManager) - its an utility based on `CacheFileProvider` that does exactly that. It also takes care of the above mentioned `Intent.FLAG_GRANT_READ_URI_PERMISSION`.