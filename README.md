# DateFormatGenerator

DateFormatGenerator is a CLI app that generates date format patterns for [SimpleDateFormat](https://developer.android.com/reference/java/text/SimpleDateFormat.html) that you can use in Android API 17 and below.
It utilizes [DateFormat#getBestDateTimePattern(Locale, String)](https://developer.android.com/reference/android/text/format/DateFormat.html#getBestDateTimePattern%28java.util.Locale%2C%20java.lang.String%29) available in API 18+ to generate format patterns you can pack as resource files and deliver to users in older OS versions.
This generator is designed to run on the Android VM to avoid any differences to the Java VM.

## Requirements

* [ADB](http://developer.android.com/tools/help/adb.html) properly set up
* A device or emulator running with API 21 or newer

## Usage

### Install the apk

First you need to install the APK.

```bash
$ ./gradlew installDebug
```

### Running

This app has no visual interface. You'll need to run it from the CLI like this.

```bash
$ ./run.sh pattern
$ ./run.sh pattern [language_code ...]
```

### Usage samples

Format with abbreviated day of week, month and day in month.

```bash
$ ./run.sh EEEMMMMd en es de pt pt-BR ja
pattern	EEEMMMMd
en	EEE, MMMM d	Wed, May 18
es	EEE, d 'de' MMMM	mié., 18 de mayo
de	EEE, d. MMMM	Mi., 18. Mai
pt	EEE, d 'de' MMMM	qua, 18 de maio
pt_BR	EEE, d 'de' MMMM	qua, 18 de maio
ja	M月d日(EEE)	5月18日(水)
```

To get a list of all available formats, run the command with only a format pattern.

```bash
$ ./run.sh EEEMMMMd
pattern	EEEMMMMd
af	EEE d MMMM	Wo 18 Mei
af_NA	EEE d MMMM	Wo 18 Mei
af_ZA	EEE d MMMM	Wo 18 Mei
agq	EEE d MMMM	tɔm 18 ndzɔ̀ŋèsèe
agq_CM	EEE d MMMM	tɔm 18 ndzɔ̀ŋèsèe
ak	EEE, MMMM d	Wuk, Esusow Aketseaba-Kɔtɔnimba 18
ak_GH	EEE, MMMM d	Wuk, Esusow Aketseaba-Kɔtɔnimba 18
am	EEE, MMMM d	ረቡዕ, ሜይ 18
am_ET	EEE, MMMM d	ረቡዕ, ሜይ 18
ar	EEE، d MMMM	الأربعاء، ١٨ مايو
ar_001	EEE، d MMMM	الأربعاء، ١٨ مايو
ar_AE	EEE، d MMMM	الأربعاء، ١٨ مايو
ar_BH	EEE، d MMMM	الأربعاء، ١٨ مايو
ar_DJ	EEE، d MMMM	الأربعاء، ١٨ مايو
...
```

### Uninstalling

```bash
$ adb uninstall jp.joao.android.dateformatgenerator
```

## License

    Copyright 2016 João Orui

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.