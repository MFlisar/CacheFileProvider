### CacheFileProvider [![Release](https://jitpack.io/v/MFlisar/CacheFileProvider.svg)](https://jitpack.io/#MFlisar/CacheFileProvider)

### What is it / What does it do?
This is a minimal library without dependencies that offers a simple cache file provider.
 
### Gradle (via [JitPack.io](https://jitpack.io/))

1. add jitpack to your project's `build.gradle`:

```groovy
repositories {
	maven { url "https://jitpack.io" }
}
```

2. add the compile statement to your module's `build.gradle`:

```groovy
dependencies {
	compile 'com.github.MFlisar:CacheFileProvider:0.1'
}
```

### Usage - General

1) Simply create a file in your apps cache directory

```groovy
File file = new File(getCacheDir() + File.separator + "testfile.txt");
// make sure something is written to this file...
// ....
```

2) Simply create a `Uri` for the file in your cache directory and share it to another app and it will work

```groovy
Uri shareableUri = CachedFileProvider.getCacheFileUri(appContext, file.getName());
```


### Other things

Get the content providers authority:

```groovy
String authority = CachedFileProvider.getAuthority(appContext);
```
