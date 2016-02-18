# React image pan and zoom for Android

## Include in your App


Installation
------------

Install the npm package [`react-native-image-cache`](https://www.npmjs.com/package/react-native-image-cache). Inside your React Native project, run ([example](https://github.com/Anthonyzou/react-native-image-cache/tree/master/example)):
```bash
npm install --save react-native-image-cache
```

In `android/settings.gradle`, remove the line `include ':app'` and add the following lines
```
include :react-native-image-cache'
project(':react-native-image-cache').projectDir = file('../node_modules/react-native-image-cache/android')
```
**NOTE** : If you have included other libraries in your project, the `include` line will contain the other dependencies too.

In `android/app/build.gradle`, add a dependency to `':react-native-image-cache'`
```
dependencies {
    compile project(':react-native-image-cache')
}
```

Next, you need to change the `MainActivity` of your app to register `ReactNativeDialogsPackage` :
```java
import com.image.cache.ReactImageCache; // add this import

public class MainActivity extends ReactActivity {
    //...

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new ReactImageCache() // add this manager
      );
    }
```
