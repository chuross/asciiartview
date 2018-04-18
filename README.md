[![](https://jitpack.io/v/chuross/asciiartview.svg)](https://jitpack.io/#chuross/asciiartview)

# AsciiArtView
This library provide to draw [AsciiArt](https://ja.wikipedia.org/wiki/%E3%82%A2%E3%82%B9%E3%82%AD%E3%83%BC%E3%82%A2%E3%83%BC%E3%83%88).

<img src="https://user-images.githubusercontent.com/1422031/38908780-d4c9268a-42fc-11e8-8c72-da5caa4fe9ba.png" width="400">

## Download
### Gradle
1. add JitPack repository to your project root `build.gradle`.
```groovy
repositories {
    maven { url "https://jitpack.io" }
}
```

2. add the dependency
[![](https://jitpack.io/v/chuross/asciiartview.svg)](https://jitpack.io/#chuross/asciiartview)

```groovy
dependencies {
    compile 'com.github.chuross:asciiartview:x.x.x
}
```

## Usage
### `monafont` into assets directory
This library depends `monafont`.

http://monafont.sourceforge.net/

### Layout XML
```xml
<com.github.chuross.asciiartview.AsciiArtView
    android:id="@+id/asciiart"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

### Code
```kotlin
val yourAsciiArtData: String = ... // from assets or network or...

val asciiArtView: AsciiArtView = findViewById(R.id.asciiart)
asciiArtView.setAsciiArt(yourAsciiArtData)
asciiArtView.setTypeface(Typeface.createFromAsset(assets, "mona.ttf"))
```

## XML Attributes
|name|type|description|etc|
|:---|:---|:---|:---|
|aav_color|color|||
|aav_typeface|string|||

## License
```
Copyright 2018 chuross

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```