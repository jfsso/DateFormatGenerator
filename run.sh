#!/bin/bash
pkg=jp.joao.android.dateformatgenerator
cls=Generator
apk=$(adb shell pm path $pkg | tr -d '\r' | awk -F: '{print $2}')
adb shell "export CLASSPATH=$apk; exec app_process /system/bin $pkg.$cls" $@

