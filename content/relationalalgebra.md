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
