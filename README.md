# AsciiArtView
This library provide to draw [AsciiArt](https://ja.wikipedia.org/wiki/%E3%82%A2%E3%82%B9%E3%82%AD%E3%83%BC%E3%82%A2%E3%83%BC%E3%83%88).

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