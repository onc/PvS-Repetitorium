# (E)ER-Diagramme



### ER-Diagramm

![alt text](content/images/er-diagram.svg)



### ER-Diagramm - Kardinalitäten in n:m-notation

![ER-Diagrammm in n:m-Notation](content/images/er-diagram_n-m-notation.svg)

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
