# Notizen zu Hackathon

Prioritäten 1-3 (1 = must have, 4 future)

* Digitales Unfallprotokoll
* 1 Einfache Bedienung und grosse Übersicht (nach Unfall ist man verwirrt und nervös) -> usability
* 1 Fotos werden direkt aus der Applikation heraus mit der Handykamera erstellt
* 3 Universell und nicht Versicherungsspezifisch
* 1 Am Schluss signieren wie bei der Papierform beide Parteien das Protokoll
* 1 (3 mit Bilder) App schick ausgefüllte Daten an Server
* 2 Versicherungen könnnen via REST-Call und einer ID die Daten des Unfalls beziehen und in ihre Applikationen einbauen
* 1 Hat der Kunde die Aufnahme eines Schadens abgeschlossen (mit Unterschriften beider Parteien) kann er via eine Funktion ein Mail mit den Daten an seine GA der Mobi auslösen http://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application
* 1 Daten auch als PDF exportierbar
* 2 Mobiliar-Like Skizze -> manuelles Zeichnen
* 3 Digital-Wallet mit gescannten Fahrzeupapieren (nur mir Icon andeuten)
* 2 Wenn Gegenpartei das App ebenfalls besitzt könnten die Daten (Bluetooth, Server,..) ausgetauscht werden, was nochmal zu einer drastischen Beschleundigung des Prozesses führen würde (ohne Vertragsdaten, Wiederverwendung von Daten, keine Redundanz)
* 2 Zeugenadressen können erfasst werden
* 2 Polizeirapport anhängen
* 3 Location-API (z.b. Foursquare) ermöglicht finden von Garage in der Nähe
* 4 Mobi-App Anbindung (Möglichkeiten aufzeigen)

## Folgende Vorteile bietet die App gegenüber der Papierform
* Sprachunabhängig -> brauche nicht ein Protokoll in jeder Sprache
* Handy hat man immer bei sich -> Protokoll evtl nicht, Anerkennungsprozess
* Schnelleres Aufnehmen eines Schadens (Persönliche Daten wie Adresse,Fahrzeug,Versicherung können hinterlegt werden -> Digital Wallet mit Fahrzeugpapieren?)
* Mail an Bezugsperson bei der Versicherung (Mehrmaliges umkopieren/abtippen der gleichen Daten fällt weg)
* Daten zur Auswertung für Unfallstatistiken


## Fantastic UI libs
* https://design.google.com/icons/#ic_assignment_ind -> icons for menu
* https://github.com/wasabeef/awesome-android-ui
* https://github.com/tekinarslan/AndroidMaterialDesignToolbar
* https://github.com/PaNaVTEC/DrawableView -> for signing



# Release Notes
# bluemoon App

[![Build Status](https://travis-ci.org/AndroidBootstrap/org-mobi-bluemoon.svg?branch=master)](https://travis-ci.org/AndroidBootstrap/org-mobi-bluemoon)

This repository contains the source code for the [bluemoon](http://www.androidbootstrap.com/)
Android app available from [Google Play](https://play.google.com/store/apps/details?id=org.mobi.bluemoon).

Please see the [issues](https://github.org.mobi.bluemoon/org-mobi-bluemoon/issues) section
to report any bugs or feature requests and to see the list of known issues.

Have a questions about bluemoon? Ask away on the [org-mobi-bluemoon discussion forum](https://groups.google.com/forum/#!forum/org-mobi-bluemoon).


## HOW TO
Learn how to develop with IntelliJ and Gradle.

## Authentication
Log into this demo app with the following credentials:

user: demo@androidbootstrap.com

password: android

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


## Building

The build requires [Gradle](http://www.gradle.org/downloads)
v1.10+ and the [Android SDK](http://developer.android.com/sdk/index.html)
to be installed in your development environment. In addition you'll need to set
the `ANDROID_HOME` environment variable to the location of your SDK:

    export ANDROID_HOME=/path/to/your/android-sdk


## Contributing

Please fork this repository and contribute back using

Any contributions, large or small, major features, bug fixes, additional
language translations, unit/integration tests are welcomed and appreciated
but will be thoroughly reviewed and discussed.

I hope this helps you in building your next android app.
