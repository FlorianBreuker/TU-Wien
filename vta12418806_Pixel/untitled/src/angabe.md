# Informationsblatt zu Test 1

Dieses Informationsblatt enthält Textbausteine, die auch in der Datei `angabe.md` beim 
Test 1 zu finden sein werden. Konkret sind das:

- die Beschreibung der Domäne der Aufgabenstellungen. Die Beschreibung ist in diesem 
  Informationsblatt allgemein gehalten. Beim eigentlichen Test 1 wird die Beschreibung 
  an manchen Stellen konkreter auf die Aufgabenstellung bezogen sein bzw. nicht zutreffende 
  Teile werden nicht mehr aufscheinen. 
- allgemeine Angabetexte und Hinweise, die genau so auch in der Datei `angabe.md` beim
  Test 1 zu finden sein werden.

# EP2 Test 1

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java-Collections-Framework zurückgreifen.
* Verändern Sie keine der vorgegebenen Methodensignaturen.
* Implementieren Sie keine unnötigen Getter-/Setter-Methoden.
* Alle Objektvariablen müssen `private` sein.
* Von Ihnen zusätzlich erstelle Methoden in vorgegebenen Klassen müssen `private` sein.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die
  in einer anderen Klasse, einem Objekt oder einer Methode stehen.
* Auch für teilweise korrekte Lösungen werden Punkte vergeben.

## Information zur Domäne

Ein digitales Bild (`Image`) ist ein rechteckiges 2D-Raster aus Pixeln (`Pixel`). Jede
Position (`Position`) auf dem Raster kann mit einem Koordinatenpaar (x,y) adressiert werden. 'x'
und 'y' sind nicht-negative ganze Zahlen. (0,0) entspricht der linken oberen Ecke und
(`width-1`, `height-1`) der rechten unteren Ecke des Rasters. `width` und `height` entsprechen der
Breite beziehungsweise Höhe des Rasters. Koordinaten außerhalb dieser Bildregion sind nicht
zulässig. 

Die einzelnen Positionen auf dem Raster können
- Zeile für Zeile und in jeder Zeile von links nach rechts (‚row-major order‘, entspricht  
  der Ausgabereihenfolge in der Konsole) oder
- Spalte für Spalte und in jeder Spalte von oben nach unten (‚column-major order‘)

traversiert werden.

Jeder Position auf dem Raster ist eine Graustufe (`GreyLevel`) zugeordnet. Ein Pixel hat demnach
eine Position und eine Graustufe. Wenn nur wenige Positionen eine Graustufe haben,
die sich von der Graustufe 0 unterscheidet, ist es günstig, anstelle des gesamten Rasters nur diese
Positionen samt Graustufe zu speichern. Alle anderen Positionen haben implizit die Graustufe 0.

Auf Bildern können bestimmte Bildoperationen durchgeführt werden, beispielsweise können einzelne 
Pixel gesetzt werden, Linien gezeichnet werden oder Pixeltransformationen durchgeführt werden. 
Pixel, Bilder, Bildoperationen oder andere Bildkomponenten können in geeigneten, geordneten oder 
nicht-geordneten, assoziativen oder nicht-assoziativen Datenstrukturen (Liste, Queue, Stack, 
Suchbaum) verwaltet werden.

Um ein Bild in der Konsole darzustellen, werden manchmal ASCII-Zeichen benutzt, wobei hier nicht
der ASCII-Code des Zeichens der Graustufe entspricht, sondern dessen Füllungsgrad, also der
Prozentsatz der Gesamtfläche der Glyphenbox, der bedruckt ist. Zum Beispiel hat '.' einen
geringen und '@' einen hohen Füllungsgrad. Oft werden zehn Graustufen von 0 bis 9 mit den
Zeichen der vordefinierten Zeichenkette `GREY_SCALE = " .:-=+*#%@"` dargestellt. Das Leerzeichen
mit dem Index 0 in der Zeichenkette entspricht dem kleinsten Grauwert 0 und das Zeichen '@' mit
dem Index 9 in der Zeichenkette entspricht dem höchsten Grauwert 9. Ein weiteres Beispiel für eine
vordefinierte Graustufenskala mit 62 Graustufen ist
``GREY_SCALE = " .`'^:,;Il!i~+_-?1)(tfjrxnuvczYXUJCLZO*aoekhbdpqwqmR0Q$B8&WM#@"``.

Ein Beispiel für ein ASCII-Bild einer Kugel mit 10 Graustufen:
```txt
%%%%%%%%%%%%%%%###########%%%%%%%%%%%%%%
%%%%%%%%%%#####################%%%%%%%%%
%%%%%%%##########%%%%#######****##%%%%%%
%%%%%##*######%%%%%%%%%%#####******#%%%%
%%%%***######%%%%%%%%%%%%####****+++*%%%
%%#*****#####%%%%%%%%%%%####*****++++*%%
%%+******######%%%%%%######*****+++++=*%
%*++++*****#############******+++++====#
%+++++++********************+++++======*
#+===++++++************+++++++=========+
%======++++++++++++++++++++============*
%+==========++++++++++==========------=#
%#==========================----------*%
%%*--------=========-----------------+##
###*=-----------------------------:-+###
##***=-::---------------::::::::::-+****
#***+++=-:::::::::::::::::::::::-=+++***
***+++===--:::::::::::::::::::--===+++**
****+++===---:::::::::::::::---===++++**
```

## Aufgabenstellung

Hier werden Sie eine an den Test angepasste Auflistung aller relevanten Dateien finden:

* `ApplicationTest1.java`
* `MCTest1.java`
* ...

Im Praxisteil des Tests sollen die hier aufgelisteten Dateien bearbeitet werden:

* ...

### Teilaufgabe 1 (maximal 25 Punkte)

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die
Datei `MCTest1.java` und befolgen Sie die Anweisungen aus den Kommentaren in der Datei. Wenn Sie
`MCTest1.java` ausführen, bekommen Sie eine Fehlermeldung, falls inhaltlich relevante Textteile
verändert wurden; ohne Fehler werden Ihre Antworten auf die Fragen aufgelistet.

### Teilaufgabe 2 (maximal 75 Punkte)

Lösen Sie den Praxisteil. Hier werden Sie weitere an den Praxisteil des Tests angepasste
Fragestellungen und Hinweise finden.

English translation: Solve the practical programming part. Here you will find an English 
translation of tasks and hints adapted to the practical part of the specific test.

Vervollständigen Sie die Klassen in den oben aufgelisteten Dateien bitte wie in den Kommentaren
beschrieben an den mit `TODO` gekennzeichneten Stellen. Alle anderen gegebenen Dateien (außer
`MCTest1.java` und `ApplicationTest1.java`) sind bereits vollständig und dürfen nicht verändert
werden.

Die Klasse `ApplicationTest1` enthält Testfälle mit Soll-Ausgaben als Kommentare. Neben diesen
Testfällen müssen auch alle Kommentare in den gefragten Klassen zutreffen. Die Klasse
`ApplicationTest1` fließt nicht in die Beurteilung ein, Sie können diese Datei nach Belieben ändern.

Bei einigen Methoden sind bei den Beschreibungen der Parameter unter `@param` Vorbedingungen
angegeben. Diese Vorbedingungen müssen innerhalb der Methode NICHT überprüft werden, sondern
stellen Zusicherungen dar, auf die sich die Methode verlassen kann.