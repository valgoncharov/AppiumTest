# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/user/Library/Android/sdk/tools/proguard/proguard-android.txt

# Appium
-keep class io.appium.** { *; }
-keep class org.openqa.selenium.** { *; }

# JUnit
-keep class org.junit.** { *; }