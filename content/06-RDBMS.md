# Relationales Datenbankmanagementsystem



### ER-Diagramm

![alt text](content/images/er-diagram.svg)



### ER-Diagramm - Kardinalitäten in n:m-notation

![ER-Diagramm in n:m-Notation](content/images/er-diagram_n-m-notation.svg)

* Ein Studierender besucht **genau ein** Repetitorium
* Ein Repetitorium wird von **n** Studierenden besucht

Mögliche Kombinationen: **1 – 1 / 1 – n / n – m**



### ER-Diagramm - Kardinalitäten in min:max-notation

![ER-Diagramm in min:max-Notation](content/images/er-diagram_min-max-notation.svg)

* Ein Studierender besucht **null bis beliebig viele** Repetitorien
* Ein Repetitorium wird von **einem bis beliebig vielen** Studierenden besucht

Mögliche Kombinationen: **(1, 1) – (1, 1) / (x, \*) – (1, 1) / (x, \*) – (x, x)**

**x** steht hier (im Gegensatz zu n:m) für eine echte beliebige Zahl



### ER-Diagramm - Kardinalitäten in uml-notation

![ER-Diagramm in UML-Notation](content/images/er-diagram_uml-notation.svg)

* Ein Studierender besucht **beliebig viele** Repetitorien
* Ein Repetitorium wird von **einem bis beliebig vielen** Studierenden besucht

Mögliche Kombinationen: **1 – 1 / x..\* – 1 / 0..\* – \***

**x** steht hierbei (im gegensatz zu n:m) für eine echte beliebige Zahl



### EER-Diagramme - Beziehungen mit Attributen

![EER-Diagramm mit Attributen an Beziehungen](content/images/eer-diagram-attribute-an-beziehungen.svg)



### Übung

Da Du inzwischen etwas Erfahrung im Programmieren hast, möchtest Du mit deiner besten Freundin/deinem besten Freund eine kleine Firma eröffnen. 
Damit ihr bei der Fülle an Aufträgen noch den Überblick behalten könnt, wollt ihr euch zunächst eine kleine Software schreiben, die euch hilft alles zu organisieren.

**Eure Problemstellung lautet:**

Ihr habt Kunden mit einer Anschrift und einem Namen. 
Im Auftrag dieser Kunden arbeitet ihr an verschiedenen Projekten, wobei jedes Projekt genau einem Kunden zugeordnet werden kann.
Aufträge sind entweder komplette Neu-Entwicklungen oder Folgeaufträge wie Bugfixes oder neue Funktionen.
Aufträge haben eine Nummer und laufen immer über einen bestimmten Zeitraum.
Außerdem ist jeder Auftrag einem Team zugeordnet.
Jedes Teams bestehen meistens aus mehreren Mitarbeitern.
Von jedem Mitarbeiter braucht ihr den Name, die Anschrift und die Kontodaten für die Verwaltung.



### Lösung

![ER-Übung Lösung](content/images/er-uebung-loesung.svg)



# Relationale Algebra



Wikipedia:
>*In der Theorie der Datenbanken versteht man unter einer Relationenalgebra oder einer relationalen Algebra eine _**formale Sprache**_, mit der sich Abfragen über einem relationalen Schema formulieren lassen.<br/><br/> Sie erlaubt es, Relationen miteinander zu verknüpfen oder zu reduzieren und komplexere Informationen daraus herzuleiten.*



## Operationen
Bei allen Operationen handelt es sich immer um Mengenoperationen.

Hierzu zählen beispielsweise:
* Vereinigung
* Schnitt
* Differenz
* Kreuzprodukt
* Projektion
* Selektion
* Join



## Vereinigung
![Union](content/images/Union.svg)

Note: alles von allem



## Schnitt
![Intersect](content/images/Intersect.svg)

Note: nur gleiches



## Differenz
![Relative_complement](content/images/Relative_complement.svg)

Note: nur verschiedenes; nur vom ersten



## Kreuzprodukt
![Cross_product](content/images/Cross_product.svg)

Note: alle zeilen von R mit der ersten Zeile von S, dann mit der zweiten Zeile, usw.



![Projection](content/images/Projection.svg)

Note: ohne doppelte werte



![Selection](content/images/Selection.svg)

Note: nach bestimmtem Wert ausgewählt



![Join](content/images/Join.svg)

Note: Kreuzprodukt + Zeilen auswählen anhand der Bedingung



![Equi-Join](content/images/Equi-Join.svg)

Note: Kreuzprodukt + Zeilen auswählen anhand von Werten die gleich sein sollen



![Natural Join](content/images/Natural_Join.svg)

Note: Überschneidung finden und die Zeilen dann zusammenführen



![Semi Join](content/images/Semi_Join.svg)

Note: Überschneidung finden und die Zeilen vom ersten nehmen 



![Outer Join](content/images/Outer_Join.svg)

Note: Zeilen mit Überschneidung aneinander fügen, ohne mit NULL auffüllen



![Rename](content/images/Rename.svg)

Note: namen ändern



Ein Beispiel:

* Zwei Alternativen
  1. &pi;<sub style="font-size:20px;">KdNr, KdName</sub> (&sigma;<sub style="font-size:20px;">KdStadt = 'Ulm'</sub> Kunden)
  2. &sigma;<sub style="font-size:20px;">KdStadt = 'Ulm'</sub> (&pi;<sub style="font-size:20px;">KdNr, KdName</sub> Kunden)
* Eine der beiden Alternativen führt nicht zum gewünschten Ergebnis

* Welche?

* Warum?
Note: Ergebnis unten



Ein Beispiel:

* Zwei Alternativen
  1. &pi;<sub style="font-size:20px;">{KdNr, KdName}</sub> (&sigma;<sub style="font-size:20px;">{KdStadt = 'Ulm'}</sub> Kunden)
  2. &sigma;<sub style="font-size:20px;">{KdStadt = 'Ulm'}</sub> (&pi;<sub style="font-size:20px;">{KdNr, KdName}</sub> Kunden)
* Eine der beiden Alternativen führt nicht zum gewünschten Ergebnis

* Welche? Nr 2

* Warum? Weil die Kundenstadt beim Auswerten der Selektion nicht mehr existiert.



## Aufgabe
Gegeben seien die folgenden Relationenschemata:

![MensaTables](content/images/relAlgebra_exampleTables_Mensa.svg)<!-- .element height="50%" width="50%" -->

--------

Gib die Algebra-Ausdrücke für die folgenden Anfragen an:
1. Gib die Namen und Preise aller Gerichte aus
4. Gib die Preise der Gerichte aus, die in der Mensa mit 530 Sitzplätzen angeboten werden.
3. Gib die Sitzplätze aller Mensen aus, die mit Fisch kochen
2. Gib alle Zutaten aus, die für das Gericht *Gut & Günstig* bestellt werden müssen, aber nicht für das Gericht *Lecker & Fein*



## Lösungsvorschlag

![MensaTables](content/images/relAlgebra_exampleTables_Mensa.svg)<!-- .element height="50%" width="50%" -->

--------

1. &pi;<sub style="font-size:20px;">{Name,Preis}</sub>Gericht
2. &pi;<sub style="font-size:20px;">{Preis}</sub>Gericht &#10781;<sub style="font-size:20px;">{Gericht.GerichtID = Mensa.GerichtID}</sub>(&sigma;<sub style="font-size:20px;">{Sitzplätze = 530}</sub>Mensa)
3. &pi;<sub style="font-size:20px;">{Sitzplätze}</sub>Mensa &#10781;<sub style="font-size:20px;">{Mensa.GerichtID = Gericht.GerichtID}</sub> (Gericht &#10781;<sub style="font-size:20px;">{Gericht.GerichtID = Zutaten.GerichtID}</sub> (&sigma;<sub style="font-size:20px;">{Zutaten.Name = 'Fisch'}</sub>Zutaten))
4. &pi;<sub style="font-size:20px;">{Name}</sub>Zutaten &#10781;<sub style="font-size:20px;">{Zutaten.GerichtID = Gericht.GerichtID}</sub> (&sigma;<sub style="font-size:20px;">{Gericht.Name = 'Gut & Günstig'}</sub>Gericht) - &pi;<sub style="font-size:20px;">{Name}</sub>Zutaten &#10781;<sub style="font-size:20px;">{Zutaten.GerichtID = Gericht.GerichtID}</sub> (&sigma;<sub style="font-size:20px;">{Gericht.Name = 'Lecker & Fein'}</sub>Gericht)



## Aufgabe
Gegeben seien die folgenden Relationenschemata:

![TeileTables](content/images/relAlgebra_exampleTables_Teile.svg)<!-- .element height="50%" width="50%" -->

--------

Gib die Algebra-Ausdrücke für die folgenden Anfragen an:
1. Gib alle Namen der Teile aus, deren Bestand kleiner gleich 5 ist.
2. Gib alle Städte aus, in denen ein Kunde wohnt oder ein Lieferant seinen Firmensitz hat.
3. Gib alle Namen der Kunden aus, die nicht gleichzeitig auch Lieferanten sind.
4. Gib den Namen und die Stadt aller Lieferanten aus, bei denen keine Bestellungen vorliegen.
5. Gib alle Namen von Teilen, die von einem Kunden aus Ulm beim Lieferanten ’Rapp’ bestellt wurden.
6. Gib die Namen aller Teile, bei denen der Kunde und Lieferant in der gleichen Stadt sind.



## Lösungsvorschlag

![TeileTables](content/images/relAlgebra_exampleTables_Teile.svg)<!-- .element height="50%" width="50%" -->

--------

1. &pi;<sub style="font-size:20px;">{Name}</sub>(&sigma;<sub style="font-size:20px;">{Bestand<=5}</sub>Teile)
2. &pi;<sub style="font-size:20px;">{LiefStadt}</sub>Lieferant &#x222a; &pi;<sub style="font-size:20px;">{KdStadt}</sub>(Bestellung &#10781;<sub style="font-size:20px;">{Bestellung.KdNr = Kunde.KdNr}</sub> Kunde)
3. &pi;<sub style="font-size:20px;">{Name:KdName}</sub>Kunde − &pi;<sub style="font-size:20px;">{Name:LiefName}</sub>Lieferant
4. &pi;<sub style="font-size:20px;">{LiefName, LiefStadt}</sub>Lieferant − &pi;<sub style="font-size:20px;">{LiefName, LiefStadt}</sub>(Lieferant &#10781;<sub style="font-size:20px;">{Lieferant.LiefNr = Bestellung.LiefNr}</sub> Bestellung)
5. &pi;<sub style="font-size:20px;">{Name}</sub>(Teile &#10781;<sub style="font-size:20px;">{Teile.TNR = Bestellung.TNR}</sub> (&sigma;<sub style="font-size:20px;">{KdStadt = 'Ulm' ^ LiefName = 'Rapp'}</sub>
((Bestellung &#10781;<sub style="font-size:20px;">{Bestellung.LiefNr = Lieferant.LiefNr}</sub> Lieferant) &#10781;<sub style="font-size:20px;">{Bestellung.KdNr = Kunde.KdNr}</sub> Kunde)))
6. &pi;<sub style="font-size:20px;">{Name}</sub>(Teile &#10781;<sub style="font-size:20px;">{Teile.TNR = Bestellung.TNR}</sub> (Bestellung &#10781;<sub style="font-size:20px;">{Bestellung.LiefNr = Lieferant.LiefNr ^ Bestellung.KdNr = Kunde.KdNr}</sub>
(Lieferant &#10781;<sub style="font-size:20px;">{LiefStadt = KdStadt}</sub> Kunde)))



## Funktionale abhängigkeiten
Eine Relation wird durch Attribute definiert. Bestimmen einige dieser Attribute eindeutig die Werte anderer Attribute, so spricht man von funktionaler Abhängigkeit. 



## Funktionale Abhängigkeiten
Man könnte sich etwa eine Kundendatenbank vorstellen, in der die Anschrift und die Telefonnummer eines Kunden eindeutig durch seinen Namen zusammen mit seinem Geburtsdatum bestimmt sind. Hier wären also Anschrift und Telefonnummer funktional abhängig von Name und Geburtsdatum. 

```
Name, Geburtsdatum -> Anschrift
Name, Geburtsdatum -> Telefonnummer
```



## Formale Definition
Sei r(R) eine Relation mit dem Relationenschema R und seien α und β Teilmengen von Attributen von R. Sei t ∈ r ein Tupel aus r. Dann ist t[α] die Einschränkung von t auf die Attribute aus α. 

Die funktionale Abhängigkeit α → β (β ist funktional abhängig von α) gilt auf R, wenn für jede zulässige Relation r(R) gilt: 

![Definition formale Abhängigkeit](content/images/funk_abhaengigkeit.png)<!-- .element height="35%" width="35%" --> 
 
Das heißt, für alle Tupel t1, t2 ∈ r mit gleichen α-Attributen (t1[α] = t2[α]) gilt auch, dass ihre β-Attribute gleich sind (t1[β] = t2[β]). Die Werte der Attribute aus der Attributmenge α bestimmen also eindeutig die Werte der Attribute aus der Attributmenge β



## Aufgabe
Bestimme die Schlüsselkandidaten der folgenden funktionalen Abhängigkeiten:
```
A → B
BC → E
ED → A
```



## Lösung
Bestimme die Schlüsselkandidaten der folgenden funktionalen Abhängigkeiten:
```
A → B
BC → E
ED → A
```
> ACD, BCD, ECD



## Aufgabe
Welche funktionalen Abhängigkeiten können für das folgende Relationenschema vorliegen?

| A   | B   | C     | D        |
| --- | --- | ----- | -------- |
| 1   | 1   | Katze | Montag   |
| 1   | 2   | Hund  | Dienstag |
| 1   | 3   | Katze | Montag   |
| 2   | 1   | Katze | Mittwoch |



## Lösung
Welche funktionalen Abhängigkeiten können für das folgende Relationenschema vorliegen?

| A   | B   | C     | D        |
| --- | --- | ----- | -------- |
| 1   | 1   | Katze | Montag   |
| 1   | 2   | Hund  | Dienstag |
| 1   | 3   | Katze | Montag   |
| 2   | 1   | Katze | Mittwoch |

> B → C, D → A, D → C
> 
> AB → C, AB → D, AB → CD, AC → D, AD → C, BD → A, BD → C, CD → A
> 
> ABC → D, ABD → C




# Normalformen & Anomalien
Die Normalisierung eines relationalen Datenbankschemas soll Redundanzen verringern und Anomalien verhindert.
Außerdem sollen die Aktualisierung einer Datenbank vereinfacht und die Konsistenz der Daten gewährleistet werden.

Dazu gibt es die Normalformen, die durch die Einhaltung von Normalisierungs-Regeln erreicht werden



## Vorgehen
![Normalisierung](content/images/Vorgehen_3NF.png)



## Beispiel

Primärschlüssel ist CD_ID

<div style="font-size:20px;">

| *CD_ID* | Album                                  | Gründungsjahr | Titel                                                  |
|     --- | ---                                    |           --- | ---                                                    |
|       1 | Michael Jackson - Thriller             |          1982 | {1. Baby Be Mine, 2. The Girl Is Mine, 3. Thriller }   |
|       2 | AC/DC - Back in Black                  |          1980 | {1. Hells Bells, 2. Shoot to Thrill, 3. Back in Black} |
|       3 | Pink Floyd - The Dark Side of the Moon |          1973 | {1. Speak to Me, 2. On the Run}                        |

### 1. NF verletzt! Die Spalten Album und Titel sind nicht atomar!



### 1. Normalform 

Primärschlüssel ist jetzt CD_ID **und** Track, da auf einer CD nicht zwei mal Track 1 sein kann.

<div style="font-size:20px;">

| *CD_ID* | Album                     | Interpret       | Gründungsjahr | *Track* | Titel            |
|     --- | ---                       | ---             |           --- |     --- | ---              |
|       1 | Thriller                  | Michael Jackson |          1982 |       1 | Baby Be Mine     |
|       1 | Thriller                  | Michael Jackson |          1982 |       2 | The Girl Is Mine |
|       1 | Thriller                  | Michael Jackson |          1982 |       3 | Thriller         |
|       2 | Back in Black             | AC/DC           |          1980 |       1 | Hells Bells      |
|       2 | Back in Black             | AC/DC           |          1980 |       2 | Shoot to Thrill  |
|       2 | Back in Black             | AC/DC           |          1980 |       3 | Back in Black    |
|       3 | The Dark Side of the Moon | Pink Floyd      |          1973 |       1 | Speak to Me      |
|       3 | The Dark Side of the Moon | Pink Floyd      |          1973 |       2 | On the Run, Time |

Note: Zusammengesetzter Primärschlüssel



### 1. Normalform 

<div style="font-size:20px;">

| *CD_ID* | Album                     | Interpret           | Gründungsjahr | *Track* | Titel            |
|     --- | ---                       | ---                 |           --- |     --- | ---              |
|       1 | **Thriller**              | **Michael Jackson** |      **1982** |       1 | Baby Be Mine     |
|       1 | **Thriller**              | **Michael Jackson** |      **1982** |       2 | The Girl Is Mine |
|       1 | **Thriller**              | **Michael Jackson** |      **1982** |       3 | Thriller         |
|       2 | Back in Black             | AC/DC               |          1980 |       1 | Hells Bells      |
|       2 | Back in Black             | AC/DC               |          1980 |       2 | Shoot to Thrill  |
|       2 | Back in Black             | AC/DC               |          1980 |       3 | Back in Black    |
|       3 | The Dark Side of the Moon | Pink Floyd          |          1973 |       1 | Speak to Me      |
|       3 | The Dark Side of the Moon | Pink Floyd          |          1973 |       2 | On the Run, Time |

### 2. NF verletzt! Album, Interpret und Gründungsjahr hängen von CD_ID ab, aber nicht von Track! Die Nicht-Schlüssel-Attribute dürfen nicht nur von einem Teil des Schlüssels abhängen!

Note: Abhängigkeiten von Schlüsseln betrachten!



### 2. Normalform

<div style="font-size:20px;">

| *CD_ID* | Album                     | Interpret       | Gründungsjahr |
|     --- | ---                       | ---             |           --- |
|       1 | Thriller                  | Michael Jackson |          1982 |
|       2 | Back in Black             | AC/DC           |          1980 |
|       3 | The Dark Side of the Moon | Pink Floyd      |          1973 |
|       4 | Highway to Hell           | AC/DC           |          1980 |

| *CD_ID* | *Track* | Titel            |
|     --- |     --- | ---              |
|       1 |       1 | Baby Be Mine     |
|       1 |       2 | The Girl Is Mine |
|       1 |       3 | Thriller         |
|       2 |       1 | Hells Bells      |
|       2 |       2 | Shoot to Thrill  |
|       2 |       3 | Back in Black    |
|       3 |       1 | Speak to Me      |
|       3 |       2 | On the Run, Time |



### 2. Normalform

<div style="font-size:20px;">

| *CD_ID* | Album                     | Interpret       | Gründungsjahr |
|     --- | ---                       | ---             | ---           |
|       1 | Thriller                  | Michael Jackson | 1982          |
|       2 | Back in Black             | **AC/DC**       | **1980**      |
|       3 | The Dark Side of the Moon | Pink Floyd      | 1973          |
|       4 | Highway to Hell           | **AC/DC**       | **1980**      |

| *CD_ID* | *Track* | Titel            |
|     --- |     --- | ---              |
|       1 |       1 | Baby Be Mine     |
|       1 |       2 | The Girl Is Mine |
|       1 |       3 | Thriller         |
|       2 |       1 | Hells Bells      |
|       2 |       2 | Shoot to Thrill  |
|       2 |       3 | Back in Black    |
|       3 |       1 | Speak to Me      |
|       3 |       2 | On the Run, Time |

### 3. NF verletzt! Der Interpret einer CD lässt sich über CD_ID bestimmen. Das Gründungsjahr der Band hängt aber vom Interpreten ab. Beides sind keine Schlüssel. Das Problem ist Redundanz!

Note: Redundante Infos in Nicht-Schlüsseln suchen



### 3. Normalform

Titel Tabelle wie oben.

<div style="font-size:20px;">

| *CD_ID* | Album                     | Interpret_ID |
|     --- | ---                       |          --- |
|       1 | Thriller                  |            1 |
|       2 | Back in Black             |            2 |
|       3 | The Dark Side of the Moon |            3 |
|       4 | Highway to Hell           |            2 |

| Interpret_ID | Interpret       | Gründungsjahr |
|          --- | ---             |           --- |
|            1 | Michael Jackson |          1982 |
|            2 | AC/DC           |          1980 |
|            3 | Pink Floyd      |          1973 |



## Anomalien



### Insertion Anomalie
Beim Einfügen von Daten in eine Datenbank spricht man von einer Einfüge-Anomalie, wenn ein neues Tupel in die Relation nicht oder nur schwierig eingetragen werden kann, weil nicht zu allen Attributen des Primärschlüssels Werte vorliegen.



### Beispiel
|*Kennzeichen*|Hersteller|Vorname|*Nachname*|
|---|---|---|---|
|K-KJ 321|VW|Peter|Schmidt|
|H-CH 333|Audi|Fritz|Schneider|
|B-MD 321|BMW|Max|Maier|
|B-MD 321|BMW|Tom|Lehmann|
|A-BC 123|Škoda| ?| ?|
|A-BC 123|Škoda| ?| ?|

In dieser Tabelle wird für Fahrzeuge der jeweilige Fahrer angegeben. Die Attribute Kennzeichen und Nachname seien Identifikationsschlüssel. Hier treten Einfügeanomalien auf, wenn ein neues Fahrzeug eingefügt werden soll, aber noch kein Fahrer bestimmt wurde.



### Update Anomalie
Beim Ändern von Daten in einer Datenbank spricht man von einer Änderungs-Anomalie, wenn nicht alle (redundanten) Vorkommen eines Attributwert zugleich geändert werden. Dieses führt zu inkonsistenten Daten.



### Beispiel
|*Kennzeichen*|Hersteller|Farbe|Vorname|*Nachname*|
|---|---|---|---|
|K-KJ 321|VW|Blau|Peter|Schmidt|
|H-CH 333|Opel|Rot|Fritz|Schneider|
|B-MD 321|BMW|Schwarz|Max|Maier|
|B-MM 473|Peugeot|Grün|Max|Maier|

Wir gehen davon aus, dass beide "Max Meier" die selbe Person sind. Ändern wir nun seinen Namen in "Maier", muss dieses an zwei Stellen geschehen. Falls nicht, spricht man von einer Update-Anomalie.



### Delete Anomalie
Eine Lösch-Anomalie entsteht, wenn durch das Löschen eines Datensatzes mehr Informationen als erwünscht verloren gehen. Sie entsteht, wenn ein Datensatz mehrere unabhängige Informationen enthält. Durch das Löschen der einen Information wird dann auch die andere gelöscht, obwohl diese noch benötigt wird.



### Beispiel
|*Kennzeichen*|Hersteller|Farbe|Vorname|*Nachname*|
|---|---|---|---|
|K-KJ 321|VW|Blau|Peter|Schmidt|
|H-CH 333|Opel|Rot|Fritz|Schneider|
|B-MD 321|BMW|Schwarz|Max|Maier|

Hier kann das Fahrzeug B-MD 321 nicht gelöscht werden, ohne den Fahrer ebenfalls zu löschen.



Alle Anomalien können beseitigt werden, wenn die Datenbank in der 3. Normalform vorliegt.
