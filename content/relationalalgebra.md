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



![Union](content/images/Union.svg)



![Intersect](content/images/Intersect.svg)



![Relative_complement](content/images/Relative_complement.svg)



![Cross_product](content/images/Cross_product.svg)



![Projection](content/images/Projection.svg)



![Selection](content/images/Selection.svg)



![Join](content/images/Join.svg)



![Equi-Join](content/images/Equi-Join.svg)



![Natural Join](content/images/Natural_Join.svg)



![Semi Join](content/images/Semi_Join.svg)



![Outer Join](content/images/Outer_Join.svg)



![Rename](content/images/Rename.svg)



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
  1. &pi;<sub style="font-size:20px;">KdNr, KdName</sub> (&sigma;<sub style="font-size:20px;">KdStadt = 'Ulm'</sub> Kunden)
  2. &sigma;<sub style="font-size:20px;">KdStadt = 'Ulm'</sub> (&pi;<sub style="font-size:20px;">KdNr, KdName</sub> Kunden)
* Eine der beiden Alternativen führt nicht zum gewünschten Ergebnis

* Welche? Nr 2

* Warum? Weil die Kundenstadt beim Auswerten der Selektion nicht mehr existiert.



##Aufgabe
Gegeben seien die folgenden Relationenschemata:

|Mensa|||
|---|---|---|
|MensaID|GerichtID|Sitzplätze|

|Gericht||||
|---|---|---|---|
|GerichtID|Name|Preis|Menge|

|Zutaten|||
|---|---|---|
|ZutatID|GerichtID|Name|

--------

Gib die Algebra-Ausdrücke für die folgenden Anfragen an:
1. Gib alle Namen und Preise aller Gerichte aus
4. Gib die Preise der Gerichte aus, die in der Mensa mit 530 Sitzplätzen angeboten werden.
3. Gib die Sitzplätze aller Mensen aus, die mit Fisch kochen
2. Gib alle Zutaten aus, die für das Gericht *Gut & Günstig* bestellt werden müssen, aber nicht für das Gericht *Lecker & Fein*


##Lösungsvorschlag
1. &pi;<sub style="font-size:20px;">{Name,Preis}</sub>Gericht
2. &pi;<sub style="font-size:20px;">{Preis}</sub>Gericht &#10781;<sub style="font-size:20px;">{GerichtID}</sub>(&sigma;<sub style="font-size:20px;">{Sitzplätze = 530}</sub>Mensa)
3. &pi;<sub style="font-size:20px;">{Sitzplätze}</sub>Mensa &#10781;<sub style="font-size:20px;">{GerichtID}</sub> (Gericht &#10781;<sub style="font-size:20px;">{ZutatID}</sub> (&sigma;<sub style="font-size:20px;">{Zutaten.Name = Fisch}</sub>Zutaten))
4. &pi;<sub style="font-size:20px;">{Name}</sub>Zutaten &#10781;<sub style="font-size:20px;">{GerichtID}</sub> (&sigma;<sub style="font-size:20px;">{Gericht.Name = Gut & Günstig}</sub>Gericht) - &pi;<sub style="font-size:20px;">{Name}</sub>Zutaten &#10781;<sub style="font-size:20px;">{GerichtID}</sub> (&sigma;<sub style="font-size:20px;">{Gericht.Name = Lecker & Fein}</sub>Gericht)



##Aufgabe
Gegeben seien die folgenden Relationenschemata:

|Teile||||
|---|---|---|---|
|TNR|Name|Preis|Bestand|

|Lieferant|||
|---|---|---|
|LiefNr|LiefName|LiefStadt|

|Bestellung|||
|---|---|---|
|TNR|LiefNr|KdNr|

|Kunde|||
|---|---|---|
|KdNR|KdName|KdStadt|

--------

Gib die Algebra-Ausdrücke für die folgenden Anfragen an:
1. Gib alle Namen der Teile aus, deren Bestand kleiner gleich 5 ist.
2. Gib alle Städte aus, in denen ein Kunde wohnt oder ein Lieferant seinen Firmensitz hat.
3. Gib alle Namen der Kunden aus, die nicht gleichzeitig auch Lieferanten sind.
4. Gib den Namen und die Stadt aller Lieferanten aus, bei denen keine Bestellungen vorliegen.
5. Gib alle Namen von Teilen, die von einem Kunden aus Ulm beim Lieferanten ’Rapp’ bestellt wurden.
6. Gib die Namen aller Teile, bei denen der Kunde und Lieferant in der gleichen Stadt sind.


##Lösungsvorschlag
1. &pi;<sub style="font-size:20px;">{Name}</sub>(&sigma;<sub style="font-size:20px;">{Bestand<=5}</sub>Teile)
2. &pi;<sub style="font-size:20px;">{LiefStadt}</sub>Lieferant &#x222a; &pi;<sub style="font-size:20px;">{KdStadt}</sub>(Bestellung &#10781;<sub style="font-size:20px;">{Bestellung.KdNr = Kunde.KdNr}</sub> Kunde)
3. &pi;<sub style="font-size:20px;">{KdName}</sub>Kunde − &pi;<sub style="font-size:20px;">{LiefName}</sub>Lieferant
4. &pi;<sub style="font-size:20px;">{LiefName, LiefStadt}</sub>Lieferant − &pi;<sub style="font-size:20px;">{LiefName, LiefStadt}</sub>(Lieferant &#10781;<sub style="font-size:20px;">{Lieferant.LiefNr = Bestellung.LiefNr}</sub> Bestellung)
5. &pi;<sub style="font-size:20px;">{Name}</sub>(Teile &#10781;<sub style="font-size:20px;">{Teile.TNR = Bestellung.TNR}</sub> (&sigma;<sub style="font-size:20px;">{KdStadt = ’Ulm’ ^ LiefName = ’Rapp’}</sub>
((Bestellung &#10781;<sub style="font-size:20px;">{Bestellung.LiefNr = Lieferant.LiefNr}</sub> Lieferant) &#10781;<sub style="font-size:20px;">{Bestellung.KdNr = Kunde.KdNr}</sub> Kunde)))
6. &pi;<sub style="font-size:20px;">{Name}</sub>(Teile &#10781;<sub style="font-size:20px;">{Teile.TNR = Bestellung.TNR}</sub> (Bestellung &#10781;<sub style="font-size:20px;">{Bestellung.LiefNr = Lieferant.LiefNr ^ Bestellung.KdNr = Kunde.KdNr}</sub>
(Lieferant &#10781;<sub style="font-size:20px;">{LiefStadt = KdStadt}</sub> Kunde)))



# Normalformen & Anomalien
Die Normalisierung eines relationalen Datenbankschemas hat den Zweck, Redundanzen zu verringern und dadurch verursachte Anomalien zu verhindern, um so die Aktualisierung einer Datenbank zu vereinfachen sowie die Konsistenz der Daten zu gewährleisten.



Zu diesem Zweck gibt es die Normalformen, welche erreicht werden, wenn bestimmte Normalisierungsregeln eingehalten werden.



##Vorgehen
![Normalisierung](content/images/Vorgehen_3NF.png)



##Beispiel
<div style="font-size:20px;">

|MatNr|Name|Studiengang|Semester|Vorlesung|Uhrzeit|
|---|---|---|---|---|
|42817|Mustermann, Julius|Medizin|14|Molekular Medizin, Anatomie 2, Einführung in die Informatik|18, 14, 10|
|96514|Hansen, Stephanie|Informatik|1|Einführung in die Informatik, Lineare Algebra|10, 12|
|79551|Fauler, Johanna|Wirtschaftsmathematik|4|Lineare DGLs 2, Einführung in die Informatik|14, 10|
|83838|Lahmann, Tobias|Medieninformatik|5|Programmierung von Systemen|10|

</div>
Diese Relation ist nicht in der ersten Normalform aus folgenden Gründen:
* Name besteht aus Vor- und Nachname
* Vorlesung besteht aus einer Menge an Vorlesungen
* Uhrzeit besteht aus einer Menge von Uhrzeiten



Um in die erste Normalform zu gelangen müssen die nicht atomaren Attribute umgewandelt werden. Dies kann durch Einfügen zusätzlicher Zeilen, Spalten oder neuer Relationen erfolgen.



##Beispiel
<div style="font-size:20px;">

|MatNr|Name|Vorname|Studiengang|Semester|Vorlesung|Uhrzeit|
|---|---|---|---|---|---|
|42817|Mustermann|Julius|Medizin|14|Molekular Medizin|18|
|42817|Mustermann|Julius|Medizin|14|Anatomie 2|14|
|42817|Mustermann|Julius|Medizin|14|Einführung in die Informatik|10|
|96514|Hansen|Stephanie|Informatik|1|Einführung in die Informatik|10|
|96514|Hansen|Stephanie|Informatik|1|Lineare Algebra|10|
|79551|Fauler|Johanna|Wirtschaftsmathematik|4|Lineare DGLs 2|14|
|79551|Fauler|Johanna|Wirtschaftsmathematik|4|Einführung in die Informatik|14|
|83838|Lahmann|Tobias|Medieninformatik|5|Programmierung von Systemen|10|

</div>
Diese Relation ist jetzt in der ersten jedoch nicht in der zweiten Normalform aus folgenden Gründen:
* Name besteht aus Vor- und Nachname
* Vorlesung besteht aus einer Menge an Vorlesungen
* Uhrzeit besteht aus einer Menge von Uhrzeiten
