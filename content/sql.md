# Structured Query Language (SQL)



**SQL ist der Relationalen Algebra in den Grundzügen sehr Ähnlich**

Die Mengenoperationen, die wir bei der Relationalen Algebra gesehen haben gibt es auch in SQL

* Vereinigung
* Schnitt
* Differenz
* Kreuzprodukt
* Projektion
* Selektion
* Join
* ...



SQL ist die am weitesten verbreitete Datenbanksprache der Welt.



## SQL - From
Gibt an aus welcher Tabelle ausgewählt wird



## SQL - Select
Wählt die angegebenen Spalten aus einer Tabelle aus

Entspricht in Relationaler Algebra dem Pi &pi;



### Beispiel
Tabelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
SELECT * 
FROM Student
```

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|



## Wichtig:

SQL ist nicht case sensitiv

**SELECT * FROM student**

ist also das Gleiche wie

**select * from student**

Der Übersichtlichkeit halber schreiben wir hier aber sie Schlüsselwörter groß



## SQL - Where
Gibt Bedingungen an, welche Zeilen ausgewählt werden.

Entspricht in Relationaler Algebra dem Sigma &sigma;



### Beispiel
Tabelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
SELECT * 
FROM Student 
WHERE MartrNr > 26000
```

|MatrNr|Name|
|---|---|
|26120|Fichte|
|27103|Fauler|



## SQL - Like
LIKE filtert in der WHERE Klausel nach dem Inhalt der Zelle, wobei der Inhalt auch nur Teilweise erfüllt sein muss.



### Beispiel
Tabelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
SELECT * 
FROM Student 
WHERE Name LIKE 'F%'
```

|MatrNr|Name|
|---|---|
|26120|Fichte|
|27103|Fauler|



## SQL - AND
AND verbindet mehrere boolesche Ausdrücke einer WHERE Klausel miteinander.



### Beispiel
Tabelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
SELECT * 
FROM Student 
WHERE Name LIKE 'F%' AND MatrNr > 25000
```

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|



## Achtung!

Innerhalb einer where Klausel müssen immer vollständige boolesche Ausdrücke stehen
```sql
SELECT * 
FROM Student 
WHERE MatrNr > 26000 AND < 27000
```
funktioniert also nicht!



## SQL - Between
BETWEEN gibt einen Wertebereich an zwischen dem ein Ausdruck ausgewählt wird. Die Randbereiche werden dabei mit ausgewählt.



### Beispiel
Tabelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
SELECT * 
FROM Student 
WHERE MatrNr BETWEEN 26000 AND 27000
```

|MatrNr|Name|
|---|---|
|26120|Fichte|



## SQL - Order By
ORDER BY gibt an nach welcher Spalte sortiert werden soll



### Beispiel
Tabelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
SELECT * 
FROM Student 
ORDER BY Name
```

|MatrNr|Name|
|---|---|
|25403|Jonas|
|26120|Fichte|
|27103|Fauler|



## SQL - Join
Verknüpfungen von Tabellen. Es werden mehrere Tabellen auf einer Bedingung zusammengefasst.



### Beispiel

|Student|MatrNr|Name|
|---|---|---|
||26120|Fichte|
||25403|Jonas|
||27103|Fauler|

|Studiert|MatrNr|Fach|
|---|---|---|
||26120|Informatik|
||25403|Informatik|
||27103|Medieninformatik|

```sql
SELECT Student.Name, Studiert.Fach
FROM Student JOIN Studiert
  ON Student.MatrNr = Studiert.MatrNr
```

|Name|Fach|
|---|---|
|Fichte|Informatik|
|Jonas|Informatik|
|Fauler|Medieninformatik|



## SQL - Insert Into
INSERT INTO fügt Werte in eine Tabelle ein.



### Beispiel
Tabelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
INSERT INTO Student 
VALUES (30000, Hansen)
```
```sql
INSERT INTO Student (MatrNr)
VALUES (30001)
```

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|
|30000|Hansen|
|30001||



## SQL - Update
UPDATE aktualisiert werte einer Tabelle.



### Beispiel
Tabelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
UPDATE Student 
SET Name = 'Faula' 
WHERE MatrNr = 27103
```

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Faula|



## SQL - Aggregatfunktionen
Aggregatfunktionen sind Funktionen in SQL mit denen mit Werten gerechnet werden kann.
* AVG() - Gibt den Durchschnitt zurück
* COUNT() - Gibt die Anzahl der Zeilen zurück
* FIRST() - Gibt die erste Zeile zurück
* LAST() - Gibt die letzte Zeile zurück
* MAX() - Gibt das Maximum zurück
* MIN() - Gibt das Minimum zurück
* SUM() - Gibt die Summe zurück



### Beispiel
Tabelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
SELECT MIN(MatrNr)
FROM Student 
```

|MIN(MatrNr)|
|---|
|25403|



## SQL - GROUP BY
GROUP BY geht mit den Aggregatfunktionen einher. Für das Gruppieren von Werten werden zwangsläufig Aggregatfunktionen benötigt



### Beispiel
Tabelle Student

|MatrNr|Name|Semester|
|---|---|---|
|26120|Fichte|2|
|25403|Jonas|3|
|27103|Fauler|3|

```sql
SELECT MIN(MatrNr)
FROM Student 
GROUP BY Semester
```

|MIN(MatrNr)
|---|
|26120|
|25403|

Gibt die kleinste Matrikelnummer **pro Semester** zurück.



## Aufgabe
Tabelle **Formel1**
<div style="font-size:20px;">

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

</div>
Gibt aus:
1. Alle Zeilen in denen Michael Schumacher Fahrerweltmeister wurde.
2. Alle Zeilen in denen die Team Punkte über 150 liegen.
3. Das Jahr mit der Höchsten WM-Punktzahl
4. Die Namen aller Fahrer die Weltmeister wurden (eindeutig)
5. Die Jahre aufsteigend sortiert nach Team Punkten



## Lösungsvorschlag

Gibt aus:

1. Alle Zeilen in denen Michael Schumacher Fahrerweltmeister wurde.
```sql
SELECT * FROM Formel1 WHERE Fahrerweltmeister = 'Michael Schumacher'
```
2. Alle Zeilen in denen die Team Punkte über 150 liegen.
```sql
SELECT * FROM Formel1 WHERE Team_Punkte > 150
```
3. Das Jahr mit der Höchsten WM-Punktzahl
```sql
SELECT Saison, MAX(WM_Punkte) FROM Formel1
```
4. Die Namen aller Fahrer die Weltmeister wurden (eindeutig)
```sql
SELECT DISTINCT Fahrerweltmeister FROM Formel1
```
5. Die Jahre aufsteigend sortiert nach Team Punkten
```sql
SELECT Saison FROM Formel1 ORDER BY Team_Punkte
```



## Aufgabe
<div style="font-size:20px;">

|Missionen|MissionID|Name|Datum|
|---|---|---|---|
||1968-089A|Apollo 7|11. Oktober 1968|
||1969-059A|Apollo 11|16. Juli 1969|
||1970-029A|Apollo 13|11. April 1970|
||1973-032A|Skylab 2|25. Mai 1973|

|Besatzung|MissionID|Kommandant|Pilot|ErsterOffizier|
|---|---|---|
||1968-089A|Donn Eisele|Walter Schirra|Walter Cunningham|
||1969-059A|Neil Armstrong|Edwin „Buzz“ Aldrin|Michael Collins|
||1970-029A|Jim Lovell|John Swigert|Fred Haise|
||1973-032A|Joseph Kerwin|Charles Conrad|Paul Weitz|

</div>
Wähle aus:
1. Die Mission die nach Apollo benannt wurden
2. Die Missionen die nach 1969 aber vor 1973 stattgefunden haben.
3. Alle Daten der Mission in der Jim Lovell Kommandant war.
4. Die MissionID in der 2 Walters mitgeflogen sind.



## Lösungsvorschlag

Wähle aus:
1. Die Mission die nach Apollo benannt wurden
```sql
SELECT * FROM Missionen WHERE Name LIKE 'Apollo%'
```
2. Die Missionen die nach 1969 aber vor 1973 stattgefunden haben.
```sql
SELECT * FROM Missionen WHERE YEAR(Datum) > 1969 AND YEAR(Datum) < 1973
```
3. Alle Daten der Mission in der Jim Lovell Kommandant war.
```sql
SELECT Mission.* FROM Missionen 
JOIN Besatzung 
    ON Mission.MissionID = Besatzung.MissionID 
WHERE Kommandant = 'Jim Lovell'
```
4. Die MissionID in der 2 Walters mitgeflogen sind.
```sql
SELECT MissionID FROM Besatzung WHERE 
    (Kommandant LIKE '%Walter%' AND Pilot LIKE '%Walter%') OR 
    (Kommandant LIKE '%Walter%' AND ErsterOffizier LIKE '%Walter%') OR
    (Pilot LIKE '%Walter%' AND ErsterOffizier LIKE '%Walter%') 
```



## Aufgabe
<div style="font-size:20px;">

|Arenen|ArenaID|Ort|BesitzendesTeam|
|---|---|---|---|
||ARN2732|BerlinHauptbahnhof|Team Intuition|
||ARN7231|WüsteGobi|Team Wagemut|
||ARN8329|UlmerMünster|Team Weisheit|
||ARN6723|Eiffelturm|Team Wagemut|

|ArenaPokemon|ArenaID|Name|Kampfpunkte|
|---|---|---|---|
||ARN7231|Ratzfratz|68|
||ARN6723|Taubsi|121|
||ARN2732|Zubat|10|

|Teams|TeamName|Farbe|
|---|---|---|
||Team Intuition|Gelb|
||Team Weisheit|Blau|
||Team Wagemut|Rot|

</div>
Wähle aus:
1. Die Farbe des Teams von dem das Taubsi die Arena bewacht
2. Alle Daten des Teams mit dem schwächsten Pokemon (formuliert als Subquery)



## Lösungsvorschlag
Wähle aus:
1. Die Farbe des Teams von dem das Taubsi die Arena bewacht
```sql
SELECT t.Farbe FROM Teams AS t
JOIN Arenen AS a ON t.TeamName = a.BesitzendesTeam
JOIN ArenaPokemon AS ap ON a.ArenaID = ap.ArenaID
WHERE ap.Name = 'Taubsi'
```
2. Alle Daten des Teams mit dem schwächsten Pokemon (formuliert als Subquery)
```sql
SELECT t.* FROM Teams AS t
WHERE TeamName IN (
    SELECT BesitzendesTeam FROM Arenen AS a
    JOIN ArenaPokemon AS ap on a.ArenaID = ap.ArenaID
    WHERE ap.Kampfpunkte = ( SELECT MIN(Kampfpunkte) FROM ArenaPokemon ) )
```



## Aufgabe
Quiz von w3school



* Womit werden Daten aus einer Tabelle ausgewählt?
  * GET
  * OPEN
  * SELECT
  * EXTRACT



* Womit werden Daten aus einer Tabelle ausgewählt?
  * GET
  * OPEN
  * **SELECT**
  * EXTRACT



* Womit werden Daten in einer Tabelle verändert?
  * SAVE AS
  * UPDATE
  * SAVE
  * MODIFY



* Womit werden Daten in einer Tabelle verändert?
  * SAVE AS
  * **UPDATE**
  * SAVE
  * MODIFY



* Womit werden Daten aus einer Tabelle gelöscht?
  * REMOVE
  * DELETE
  * COLLAPSE



* Womit werden Daten aus einer Tabelle gelöscht?
  * REMOVE
  * **DELETE**
  * COLLAPSE



* Womit werden Daten in eine Tabelle eingefügt?
  * ADD RECORD
  * ADD NEW
  * INSERT INTO
  * INSERT NEW



* Womit werden Daten in eine Tabelle eingefügt?
  * ADD RECORD
  * ADD NEW
  * **INSERT INTO**
  * INSERT NEW



* Wie kann man die Spalte `FirstName` aus einer Tabelle mit dem Namen `Persons` auswählen?
  * EXTRACT FirstName FROM Persons
  * SELECT Persons.FirstName
  * SELECT FirstName FROM Persons



* Wie kann man die Spalte `FirstName` aus einer Tabelle mit dem Namen `Persons` auswählen?
  * EXTRACT FirstName FROM Persons
  * SELECT Persons.FirstName
  * **SELECT FirstName FROM Persons**



* Wie kann man alle Spalten aus der Tabelle `Persons` auswählen?
  * SELECT Persons
  * SELECT *.Persons
  * SELECT [all] FROM Persons
  * SELECT * FROM Persons



* Wie kann man alle Spalten aus der Tabelle `Persons` auswählen?
  * SELECT Persons
  * SELECT *.Persons
  * SELECT [all] FROM Persons
  * **SELECT * FROM Persons**



* Wie kann man aus eine Tabelle `Persons` alle Zeilen auswählen, in denen die Spalte `FirstName` den Wert `Peter` hat?
  * SELECT * FROM Persons WHERE FirstName<>'Peter'
  * SELECT [all] FROM Persons WHERE FirstName='Peter'
  * SELECT * FROM Persons WHERE FirstName='Peter'
  * SELECT [all] FROM Persons WHERE FirstName LIKE 'Peter'



* Wie kann man aus eine Tabelle `Persons` alle Zeilen auswählen, in denen die Spalte `FirstName` den Wert `Peter` hat?
  * SELECT * FROM Persons WHERE FirstName<>'Peter'
  * SELECT [all] FROM Persons WHERE FirstName='Peter'
  * **SELECT * FROM Persons WHERE FirstName='Peter'**
  * SELECT [all] FROM Persons WHERE FirstName LIKE 'Peter'



* Wie kann man aus eine Tabelle `Persons` alle Zeilen auswählen, in denen die Spalte `FirstName` mit einem `a` beginnt?
  * SELECT * FROM Persons WHERE FirstName LIKE 'a%'
  * SELECT * FROM Persons WHERE FirstName LIKE '%a'
  * SELECT * FROM Persons WHERE FirstName='%a%'
  * SELECT * FROM Persons WHERE FirstName='a'



* Wie kann man aus eine Tabelle `Persons` alle Zeilen auswählen, in denen die Spalte `FirstName` mit einem `a` beginnt?
  * **SELECT * FROM Persons WHERE FirstName LIKE 'a%'**
  * SELECT * FROM Persons WHERE FirstName LIKE '%a'
  * SELECT * FROM Persons WHERE FirstName='%a%'
  * SELECT * FROM Persons WHERE FirstName='a'



* Wie kann man aus eine Tabelle `Persons` alle Zeilen auswählen, in denen die Spalte `FirstName` den Wert `Peter` und die Spalte `LastName` den Wert `Jackson` hat?
  * SELECT FirstName='Peter', LastName='Jackson' FROM Persons
  * SELECT * FROM Persons WHERE FirstName='Peter' AND LastName='Jackson'
  * SELECT * FROM Persons WHERE FirstName<>'Peter' AND LastName<>'Jackson'



* Wie kann man aus eine Tabelle `Persons` alle Zeilen auswählen, in denen die Spalte `FirstName` den Wert `Peter` und die Spalte `LastName` den Wert `Jackson` hat?
  * SELECT FirstName='Peter', LastName='Jackson' FROM Persons
  * **SELECT * FROM Persons WHERE FirstName='Peter' AND LastName='Jackson'**
  * SELECT * FROM Persons WHERE FirstName<>'Peter' AND LastName<>'Jackson'



* Wie kann man aus eine Tabelle `Persons` alle Zeilen auswählen, in denen die Spalte `LastName` alphabetisch zwischen `Hansen` und `Pettersen` (jeweils inklusive) liegt?
  * SELECT * FROM Persons WHERE LastName>'Hansen' AND LastName<'Pettersen'
  * SELECT * FROM Persons WHERE LastName BETWEEN 'Hansen' AND 'Pettersen'
  * SELECT LastName>'Hansen' AND LastName<'Pettersen' FROM Persons



* Wie kann man aus eine Tabelle `Persons` alle Zeilen auswählen, in denen die Spalte `LastName` alphabetisch zwischen `Hansen` und `Pettersen` (jeweils inklusive) liegt?
  * SELECT * FROM Persons WHERE LastName>'Hansen' AND LastName<'Pettersen'
  * **SELECT * FROM Persons WHERE LastName BETWEEN 'Hansen' AND 'Pettersen'**
  * SELECT LastName>'Hansen' AND LastName<'Pettersen' FROM Persons



* Mit welchem SQL-Ausdruck kann man spezifizieren, dass nur eindeutige Werte zurückgegeben werden?
  * SELECT DISTINCT
  * SELECT DIFFERENT
  * SELECT UNIQUE



* Mit welchem SQL-Ausdruck kann man spezifizieren, dass nur eindeutige Werte zurückgegeben werden?
  * **SELECT DISTINCT**
  * SELECT DIFFERENT
  * SELECT UNIQUE



* Welches SQL-Schlüsselwort kann benutzt werden, um die Ergebnisse zu sortieren?
  * SORT BY
  * ORDER
  * ORDER BY
  * SORT



* Welches SQL-Schlüsselwort kann benutzt werden, um die Ergebnisse zu sortieren?
  * SORT BY
  * ORDER
  * **ORDER BY**
  * SORT



* Wie lassen sich alle Einträge der Tabelle `Persons` alphabetisch absteigend anhand der Spalte `FirstName` ausgeben?
  * SELECT * FROM Persons SORT 'FirstName' DESC
  * SELECT * FROM Persons ORDER FirstName DESC
  * SELECT * FROM Persons ORDER BY FirstName DESC
  * SELECT * FROM Persons SORT BY 'FirstName' DESC



* Wie lassen sich alle Einträge der Tabelle `Persons` alphabetisch absteigend anhand der Spalte `FirstName` ausgeben?
  * SELECT * FROM Persons SORT 'FirstName' DESC
  * SELECT * FROM Persons ORDER FirstName DESC
  * **SELECT * FROM Persons ORDER BY FirstName DESC**
  * SELECT * FROM Persons SORT BY 'FirstName' DESC



* Wie kann man einen neuen Eintrag in die Tabelle `Persons` einfügen?
  * INSERT VALUES ('Jimmy', 'Jackson') INTO Persons
  * INSERT ('Jimmy', 'Jackson') INTO Persons
  * INSERT INTO Persons VALUES ('Jimmy', 'Jackson')



* Wie kann man einen neuen Eintrag in die Tabelle `Persons` einfügen?
  * INSERT VALUES ('Jimmy', 'Jackson') INTO Persons
  * INSERT ('Jimmy', 'Jackson') INTO Persons
  * **INSERT INTO Persons VALUES ('Jimmy', 'Jackson')**



* Wie kann man eine Person mit dem Nachnamen `Olsen` in die Tabelle `Persons` einfügen?
  * INSERT INTO Persons (LastName) VALUES ('Olsen')
  * INSERT INTO Persons ('Olsen') INTO LastName
  * INSERT ('Olsen') INTO Persons (LastName)



* Wie kann man eine Person mit dem Nachnamen `Olsen` in die Tabelle `Persons` einfügen?
  * **INSERT INTO Persons (LastName) VALUES ('Olsen')**
  * INSERT INTO Persons ('Olsen') INTO LastName
  * INSERT ('Olsen') INTO Persons (LastName)



* Mit welcher SQL-Anfrage lassen sich alle Personen in der Tabelle die den Nachnamen `Hansen` tragen nach `Nilsen` umbennen?
  * MODIFY Persons SET LastName='Hansen' INTO LastName='Nilsen
  * UPDATE Persons SET LastName='Nilsen' WHERE LastName='Hansen'
  * UPDATE Persons SET LastName='Hansen' INTO LastName='Nilsen'
  * MODIFY Persons SET LastName='Nilsen' WHERE LastName='Hansen'



* Mit welcher SQL-Anfrage lassen sich alle Personen in der Tabelle die den Nachnamen `Hansen` tragen nach `Nilsen` umbennen?
  * MODIFY Persons SET LastName='Hansen' INTO LastName='Nilsen
  * **UPDATE Persons SET LastName='Nilsen' WHERE LastName='Hansen'**
  * UPDATE Persons SET LastName='Hansen' INTO LastName='Nilsen'
  * MODIFY Persons SET LastName='Nilsen' WHERE LastName='Hansen'



* Mit welcher Anfrage lassen sich alle Einträge löschen, bei denen die Spalte `FirstName` den Wert `Peter` hat?
  * DELETE FROM Persons WHERE FirstName = 'Peter'
  * DELETE ROW FirstName='Peter' FROM Persons
  * DELETE FirstName='Peter' FROM Persons



* Mit welcher Anfrage lassen sich alle Einträge löschen, bei denen die Spalte `FirstName` den Wert `Peter` hat?
  * **DELETE FROM Persons WHERE FirstName = 'Peter'**
  * DELETE ROW FirstName='Peter' FROM Persons
  * DELETE FirstName='Peter' FROM Persons



* Wie kann man ermitteln, wieviele Einträge die Tabelle `Persons` hat?
  * SELECT COLUMNS(*) FROM Persons
  * SELECT COUNT(*) FROM Persons
  * SELECT COLUMNS() FROM Persons
  * SELECT COUNT() FROM Persons



* Wie kann man ermitteln, wieviele Einträge die Tabelle `Persons` hat?
  * SELECT COLUMNS(*) FROM Persons
  * **SELECT COUNT(*) FROM Persons**
  * SELECT COLUMNS() FROM Persons
  * SELECT COUNT() FROM Persons



* Mit welchem Operator lassen sich Werte innerhalb von Grenzen auswählen?
  * WITHIN
  * BETWEEN
  * RANGE



* Mit welchem Operator lassen sich Werte innerhalb von Grenzen auswählen?
  * WITHIN
  * **BETWEEN**
  * RANGE



* Die NOT NULL Anweisung erzwingt, dass in dieser Spalte keine NULL-Werte erlaubt sind?
  * True
  * False



* Die NOT NULL Anweisung erzwingt, dass in dieser Spalte keine NULL-Werte erlaubt sind?
  * **True**
  * False



* Welcher Operator kann benutzt werden um nach einem bestimmten Muster zu suchen?
  * GET
  * FROM
  * LIKE



* Welcher Operator kann benutzt werden um nach einem bestimmten Muster zu suchen?
  * GET
  * FROM
  * **LIKE**



* Mit welcher Anweisung kann man eine Tabelle erzeugen?
  * CREATE DATABASE TABLE
  * CREATE TABLE
  * CREATE DB
  * CREATE DATABASE TAB



* Mit welcher Anweisung kann man eine Tabelle erzeugen?
  * CREATE DATABASE TABLE
  * **CREATE TABLE**
  * CREATE DB
  * CREATE DATABASE TAB
