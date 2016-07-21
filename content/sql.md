# Structured Query Language (SQL)



SQL ist der Relationalen Algebra in den Grundzügen sehr Ähnlich

Alle Mengenoperationen, welche wir bei der Relationalen Algebra gesehen haben gibt es auch in SQL

* Vereinigung
* Schnitt
* Differenz
* Kreuzprodukt
* Projektion
* Selektion
* Join
* ...



SQL ist die am weitesten verbreitete Datenbanksprache (manchmal auch Programmiersprache, obwohl nur teilweise richtig) der Welt.



##SQL - From
Gibt an aus welcher Tabelle ausgewählt wird



##SQL - Select
Wählt angegebene spalten aus einer Tabelle aus

Entspricht in Relationaler Algebra dem Pi &pi;



##Beispiel
Tebelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
SELECT * FROM Student
```
oder
```sql
SELECT Name FROM Student
```



Wichtig:

SQL ist nicht case sensitiv

SELECT * FROM student

ist also das gleiche wie

select * from student

Der Übersichtlichkeit halber schreiben wir hier aber sie Schlüsselwörter groß



##SQL - Where
Gibt Bedingungen an, welche Zeilen ausgewählt werden.

Entspricht in Relationaler Algebra dem Sigma &sigma;



##Beispiel
Tebelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
SELECT * FROM student WHERE MartrNr > 26000
```



|Saison|Fahrerweltmeister|KonstrukteursWM|WM_Punkte|Team_Punkte|
|---|---|---|---|---|
|1995|Michael Schumacher|Benetton-Renault|102|137|
|1996|Damon Hill|Williams-Renault|97|175|
|1997|Jaques Villeneuve|Williams-Renault|81|123|
|1998|Mika Häkinnen|McLaren-Mercedes|100|156|
|1999|Mika Häkinnen|Ferrari|76|128|
|2000|Michael Schumacher|Ferrari|108|170|
|2001|Michael Schumacher|Ferrari|123|179|
|2002|Michael Schumacher|Ferrari|144|221|



##Aufgabe 1
Gibt aus:
1. Alle Zeilen in denen Michael Schumacher Fahrerweltmeister wurde.
2. Alle Zeilen in denen die Team Punkte über 150 liegen.
3. Das Jahr mit der Höchsten WM-Punktzahl
4. Die Namen aller Fahrer die Weltmeister wurden (eindeutig)
5. Die Jahre aufsteigend sortiert nach Team Punkten
