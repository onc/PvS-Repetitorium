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

###Beispiel
Tebelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

```sql
SELECT * 
FROM Student
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

###Beispiel
Tebelle Student

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



##SQL - Like
LIKE filtert in der WHERE Klausel nach dem Inhalt der Zelle, wobei der Inhalt auch nur Teilweise erfüllt sein muss.



##Beispiel
Tebelle Student

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



##SQL - Join
Verknüpfungen von Tabellen. Es werden mehrere Tabellen auf einer Bedingung zusammengefasst.



##Beispiel
Tebelle Student

|MatrNr|Name|
|---|---|
|26120|Fichte|
|25403|Jonas|
|27103|Fauler|

Tabelle Studiert

|MatrNr|Fach|
|---|---|
|26120|Informatik|
|25403|Informatik|
|27103|Medieninformatik|

```sql
SELECT Student.Name, Studiert.Fach
FROM Student JOIN Studiert
  ON Student.MatrNr = Studiert.MatrNr
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



##Aufgabe m
Gibt aus:
1. Alle Zeilen in denen Michael Schumacher Fahrerweltmeister wurde.
2. Alle Zeilen in denen die Team Punkte über 150 liegen.
3. Das Jahr mit der Höchsten WM-Punktzahl
4. Die Namen aller Fahrer die Weltmeister wurden (eindeutig)
5. Die Jahre aufsteigend sortiert nach Team Punkten



##Aufgabe n
Quiz von w3school



1.)
* What does SQL stand for?
  * Structured Query Language
  * Structured Question Language
  * Strong Question Language



1.)
* What does SQL stand for?
  * **Structured Query Language**
  * Structured Question Language
  * Strong Question Language



2.)
* Which SQL statement is used to extract data from a database?
  * GET
  * OPEN
  * SELECT
  * EXTRACT



2.)
* Which SQL statement is used to extract data from a database?
  * GET
  * OPEN
  * **SELECT**
  * EXTRACT



3.)
* Which SQL statement is used to update data in a database?
  * SAVE AS
  * UPDATE
  * SAVE
  * MODIFY



3.)
* Which SQL statement is used to update data in a database?
  * SAVE AS
  * **UPDATE**
  * SAVE
  * MODIFY



4.)
* Which SQL statement is used to delete data from a database?
  * REMOVE
  * DELETE
  * COLLAPSE



4.)
* Which SQL statement is used to delete data from a database?
  * REMOVE
  * **DELETE**
  * COLLAPSE



5.)
* Which SQL statement is used to insert new data in a database?
  * ADD RECORD
  * ADD NEW
  * INSERT INTO
  * INSERT NEW



5.)
* Which SQL statement is used to insert new data in a database?
  * ADD RECORD
  * ADD NEW
  * **INSERT INTO**
  * INSERT NEW



6.)
* With SQL, how do you select a column named "FirstName" from a table named "Persons"?
  * EXTRACT FirstName FROM Persons
  * SELECT Persons.FirstName
  * SELECT FirstName FROM Persons



6.)
* With SQL, how do you select a column named "FirstName" from a table named "Persons"?
  * EXTRACT FirstName FROM Persons
  * SELECT Persons.FirstName
  * **SELECT FirstName FROM Persons**



7.)
* With SQL, how do you select all the columns from a table named "Persons"?
  * SELECT Persons
  * SELECT *.Persons
  * SELECT [all] FROM Persons
  * SELECT * FROM Persons



7.)
* With SQL, how do you select all the columns from a table named "Persons"?
  * SELECT Persons
  * SELECT *.Persons
  * SELECT [all] FROM Persons
  * **SELECT * FROM Persons**



8.)
* With SQL, how do you select all the records from a table named "Persons" where the value of the column "FirstName" is "Peter"?
  * SELECT * FROM Persons WHERE FirstName<>'Peter'
  * SELECT [all] FROM Persons WHERE FirstName='Peter'
  * SELECT * FROM Persons WHERE FirstName='Peter'
  * SELECT [all] FROM Persons WHERE FirstName LIKE 'Peter'



8.)
* With SQL, how do you select all the records from a table named "Persons" where the value of the column "FirstName" is "Peter"?
  * SELECT * FROM Persons WHERE FirstName<>'Peter'
  * SELECT [all] FROM Persons WHERE FirstName='Peter'
  * **SELECT * FROM Persons WHERE FirstName='Peter'**
  * SELECT [all] FROM Persons WHERE FirstName LIKE 'Peter'



9.)
* With SQL, how do you select all the records from a table named "Persons" where the value of the column "FirstName" starts with an "a"?
  * SELECT * FROM Persons WHERE FirstName LIKE 'a%'
  * SELECT * FROM Persons WHERE FirstName LIKE '%a'
  * SELECT * FROM Persons WHERE FirstName='%a%'
  * SELECT * FROM Persons WHERE FirstName='a'



9.)
* With SQL, how do you select all the records from a table named "Persons" where the value of the column "FirstName" starts with an "a"?
  * **SELECT * FROM Persons WHERE FirstName LIKE 'a%'**
  * SELECT * FROM Persons WHERE FirstName LIKE '%a'
  * SELECT * FROM Persons WHERE FirstName='%a%'
  * SELECT * FROM Persons WHERE FirstName='a'



10.)
* The OR operator displays a record if ANY conditions listed are true. The AND operator displays a record if ALL of the conditions listed are true
  * False
  * True



10.)
* The OR operator displays a record if ANY conditions listed are true. The AND operator displays a record if ALL of the conditions listed are true
  * False
  * **True**



11.)
* With SQL, how do you select all the records from a table named "Persons" where the "FirstName" is "Peter" and the "LastName" is "Jackson"?
  * SELECT FirstName='Peter', LastName='Jackson' FROM Persons
  * SELECT * FROM Persons WHERE FirstName='Peter' AND LastName='Jackson'
  * SELECT * FROM Persons WHERE FirstName<>'Peter' AND LastName<>'Jackson'



11.)
* With SQL, how do you select all the records from a table named "Persons" where the "FirstName" is "Peter" and the "LastName" is "Jackson"?
  * SELECT FirstName='Peter', LastName='Jackson' FROM Persons
  * **SELECT * FROM Persons WHERE FirstName='Peter' AND LastName='Jackson'**
  * SELECT * FROM Persons WHERE FirstName<>'Peter' AND LastName<>'Jackson'



12.)
* With SQL, how do you select all the records from a table named "Persons" where the "LastName" is alphabetically between (and including) "Hansen" and "Pettersen"?
  * SELECT * FROM Persons WHERE LastName>'Hansen' AND LastName<'Pettersen'
  * SELECT * FROM Persons WHERE LastName BETWEEN 'Hansen' AND 'Pettersen'
  * SELECT LastName>'Hansen' AND LastName<'Pettersen' FROM Persons



12.)
* With SQL, how do you select all the records from a table named "Persons" where the "LastName" is alphabetically between (and including) "Hansen" and "Pettersen"?
  * SELECT * FROM Persons WHERE LastName>'Hansen' AND LastName<'Pettersen'
  * **SELECT * FROM Persons WHERE LastName BETWEEN 'Hansen' AND 'Pettersen'**
  * SELECT LastName>'Hansen' AND LastName<'Pettersen' FROM Persons



13.)
* Which SQL statement is used to return only different values?
  * SELECT DISTINCT
  * SELECT DIFFERENT
  * SELECT UNIQUE



13.)
* Which SQL statement is used to return only different values?
  * **SELECT DISTINCT**
  * SELECT DIFFERENT
  * SELECT UNIQUE



14.)
* Which SQL keyword is used to sort the result-set?
  * SORT BY
  * ORDER
  * ORDER BY
  * SORT



14.)
* Which SQL keyword is used to sort the result-set?
  * SORT BY
  * ORDER
  * **ORDER BY**
  * SORT



15.)
* With SQL, how can you return all the records from a table named "Persons" sorted descending by "FirstName"?
  * SELECT * FROM Persons SORT 'FirstName' DESC
  * SELECT * FROM Persons ORDER FirstName DESC
  * SELECT * FROM Persons ORDER BY FirstName DESC
  * SELECT * FROM Persons SORT BY 'FirstName' DESC



15.)
* With SQL, how can you return all the records from a table named "Persons" sorted descending by "FirstName"?
  * SELECT * FROM Persons SORT 'FirstName' DESC
  * SELECT * FROM Persons ORDER FirstName DESC
  * **SELECT * FROM Persons ORDER BY FirstName DESC**
  * SELECT * FROM Persons SORT BY 'FirstName' DESC



16.)
* With SQL, how can you insert a new record into the "Persons" table?
  * INSERT VALUES ('Jimmy', 'Jackson') INTO Persons
  * INSERT ('Jimmy', 'Jackson') INTO Persons
  * INSERT INTO Persons VALUES ('Jimmy', 'Jackson')



16.)
* With SQL, how can you insert a new record into the "Persons" table?
  * INSERT VALUES ('Jimmy', 'Jackson') INTO Persons
  * INSERT ('Jimmy', 'Jackson') INTO Persons
  * **INSERT INTO Persons VALUES ('Jimmy', 'Jackson')**



17.)
* With SQL, how can you insert "Olsen" as the "LastName" in the "Persons" table?
  * INSERT INTO Persons (LastName) VALUES ('Olsen')
  * INSERT INTO Persons ('Olsen') INTO LastName
  * INSERT ('Olsen') INTO Persons (LastName)



17.)
* With SQL, how can you insert "Olsen" as the "LastName" in the "Persons" table?
  * **INSERT INTO Persons (LastName) VALUES ('Olsen')**
  * INSERT INTO Persons ('Olsen') INTO LastName
  * INSERT ('Olsen') INTO Persons (LastName)



18.)
* How can you change "Hansen" into "Nilsen" in the "LastName" column in the Persons table?
  * MODIFY Persons SET LastName='Hansen' INTO LastName='Nilsen
  * UPDATE Persons SET LastName='Nilsen' WHERE LastName='Hansen'
  * UPDATE Persons SET LastName='Hansen' INTO LastName='Nilsen'
  * MODIFY Persons SET LastName='Nilsen' WHERE LastName='Hansen'



18.)
* How can you change "Hansen" into "Nilsen" in the "LastName" column in the Persons table?
  * MODIFY Persons SET LastName='Hansen' INTO LastName='Nilsen
  * **UPDATE Persons SET LastName='Nilsen' WHERE LastName='Hansen'**
  * UPDATE Persons SET LastName='Hansen' INTO LastName='Nilsen'
  * MODIFY Persons SET LastName='Nilsen' WHERE LastName='Hansen'



19.)
* With SQL, how can you delete the records where the "FirstName" is "Peter" in the Persons Table?
  * DELETE FROM Persons WHERE FirstName = 'Peter'
  * DELETE ROW FirstName='Peter' FROM Persons
  * DELETE FirstName='Peter' FROM Persons



19.)
* With SQL, how can you delete the records where the "FirstName" is "Peter" in the Persons Table?
  * **DELETE FROM Persons WHERE FirstName = 'Peter'**
  * DELETE ROW FirstName='Peter' FROM Persons
  * DELETE FirstName='Peter' FROM Persons



20.)
* With SQL, how can you return the number of records in the "Persons" table?
  * SELECT COLUMNS(*) FROM Persons
  * SELECT COUNT(*) FROM Persons
  * SELECT COLUMNS() FROM Persons
  * SELECT COUNT() FROM Persons



20.)
* With SQL, how can you return the number of records in the "Persons" table?
  * SELECT COLUMNS(*) FROM Persons
  * **SELECT COUNT(*) FROM Persons**
  * SELECT COLUMNS() FROM Persons
  * SELECT COUNT() FROM Persons



21.)
* What is the most common type of join?
  * JOINED
  * INSIDE JOIN
  * INNER JOIN
  * JOINED TABLE



21.)
* What is the most common type of join?
  * JOINED
  * INSIDE JOIN
  * **INNER JOIN**
  * JOINED TABLE



22.)
* Which operator is used to select values within a range?
  * WITHIN
  * BETWEEN
  * RANGE



22.)
* Which operator is used to select values within a range?
  * WITHIN
  * **BETWEEN**
  * RANGE



23.)
* The NOT NULL constraint enforces a column to not accept null values.
  * True
  * False



23.)
* The NOT NULL constraint enforces a column to not accept null values.
  * **True**
  * False



24.)
* Which operator is used to search for a specified pattern in a column?
  * GET
  * FROM
  * LIKE



24.)
* Which operator is used to search for a specified pattern in a column?
  * GET
  * FROM
  * **LIKE**



25.)
* Which SQL statement is used to create a table in a database?
  * CREATE DATABASE TABLE
  * CREATE TABLE
  * CREATE DB
  * CREATE DATABASE TAB



25.)
* Which SQL statement is used to create a table in a database?
  * CREATE DATABASE TABLE
  * **CREATE TABLE**
  * CREATE DB
  * CREATE DATABASE TAB




