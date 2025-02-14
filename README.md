# Persian Calendar
An Android library built with jetpack compose - Persian calendar component. It's easy to use, quick to implement and can be customized according to your application color and theme.

[![](https://jitpack.io/v/AmirSinaRZ/PersianCalendar.svg)](https://jitpack.io/#AmirSinaRZ/PersianCalendar)

<img width="850" src="art/AddText_02-14-03.38.21.png" alt="Library Image">

# Setup
Add the JitPack repository to settings.gradle file
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...      
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependencies to app-level build.gradle file
```gradle
dependencies {
    ...
    implementation 'com.github.AmirSinaRZ:PersianCalendar:1.0.0'
}
```

# Usage
### simple usage
to show persian calendar whitout any customization:
```kotlin
PersianCalendar { jalaliDate, localDate ->
    //do something with date here
}
```
localDate is java.time.LocalDate & jalaliDate is [JalaliDate.kt](https://github.com/AmirSinaRZ/PersianCalendar/blob/master/persiancalendar/src/main/java/com/amirsinarz/persiancalendar/model/JalaliDate.kt)
### usage with customization:
```kotlin
PersianCalendar(
    modifier: Modifier = Modifier,
    colors: PersianCalendarColors = PersianCalendarDefaults.getPersianCalendarColors(),
    fontFamily: FontFamily = PersianCalendarDefaults.persianCalendarFont(),
    initDate: JalaliDate = JalaliDate(1403, 11, 1), //default is current date
    elevation: Dp = 0.dp,
    contentPadding: Dp = 5.dp,
    cornerRadius: Dp = 8.dp,
    showFullWeekDay: Boolean = false, //true: شنبه, false: ش
    animate: Boolean = true,
    animatePerItem: Boolean = true,
    animationDuration: Int = 200,
    animationDelay: Long = 30L,
) { jalaliDate, localDate ->
    // do something with date here
}
```

## Preview
https://github.com/user-attachments/assets/c7ae8316-9fca-4479-aa62-29ced208dd1e


## Contributing
Contributions are welcome! If you find a bug or would like to create a new feature, please submit a pull request.

## License
This library is licensed under the  Apache-2.0 license. See [LICENSE](https://github.com/AmirSinaRZ/PersianCalendar?tab=Apache-2.0-1-ov-file)

Developed by Amirsina Razghandi
