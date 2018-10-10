# SQL-Programmierung



## JDBC

Die **J**ava **D**ata**b**ase **C**onnectivity ist eine Java-API, mit der sich SQL-Anweisungen in Datenbanken ausführen lassen. Die API stellt eine Schnittstelle zu unterschiedlichen relationalen Datenbanken zur Verfügung.



## JDBC Umfang

Die JDBC Bibliothek stellt APIs für die folgenden Aufgaben zur Verfügung:
* Datenbankverbindungen erstellen
* SQL Statements erstellen
* SQL Statements ausführen
* Resultate betrachten und verändern



## JDBC Architektur

![JDBC Architektur](content/images/jdbc_architektur.png)



## JDBC Komponenten

Die **Driver Manager** Klasse verwaltet die Datenbanktreiber, welche das **Driver** Interface implementieren. Über das **Connections** Interface werden **Statements** ausgeführt und hierüber **ResultSets** von der Datenbank erhalten.



## Beispiel
```java
static final String DB_URL = "jdbc:mysql://localhost/LegoTrailer";

//  Database credentials
static final String USER = "username";
static final String PASS = "password";
try{
    ...
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

      Statement stmt = conn.createStatement();
      String sqlString = "SELECT * FROM Lieferanten";
      ResultSet rs = stmt.executeQuery(sql);
      ...
}
```



## Datenbank-URL mit Parametern

In die Datenbankverbindung kann auch der Benutzernamen und das Passwort eingebettet werden.

`jdbc:oracle:driver:username/password@database`

```java
String URL = "jdbc:oracle:thin:username/password@amrood:1521:LegoTrailer";
Connection conn = DriverManager.getConnection(URL);
```



## Datenbankverbindungen schließen

Datenbankverbindungen sollten immer geschlossen werden

```java
conn.close();
```



## Statements schließen

Statements sollten ebenfalls geschlossen werden um Datenbankressourcen zu sparen.

```java
stmt.close();
conn.close();
```



## Prepared Statements

Das **PreparedStatement** Interface erweitert die Statements und bietet erweitere Funktionalitäten an, welche Vorteile gegenüber den generischen Statements bringen.

Note: Prepared Statements werden compiled



## Prepared Statements

```java
PreparedStatement pstmt = null;
try {
   String SQL = "Update Employees SET age = ? WHERE id = ?";
   pstmt = conn.prepareStatement(SQL);
   ...
}
catch (SQLException e) {
   ...
}
finally {
   pstmt.close();
}
```



## Result Sets
SQL Statements lesen Daten aus einer Datenbank und liefern diese in einem Result Set an die Anwendung zurück.

Ein ResultSet Objekt enthält einen Pointer, welche auf die aktuelle Zeile des Ergebnisses zeigt.



## Result Sets
Es existieren diverse Methoden um den Pointer durch die Zeilen des Result Sets zu *schieben*:

```java
public boolean first() throws SQLException 
// Bewegt den Pointer zur ersten Reihe

public void last() throws SQLException 
// Bewegt den Pointer zur letzten Reihe

public boolean absolute(int row) throws SQLException 
// Bewegt den Pointer zur ausgewählten Zeile

public boolean relative(int row) throws SQLException 
/* Bewegt den Pointer die angegebene anzahl an Reihen 
relativ zur aktuellen position Vorwärts oder rückwärts */

public boolean previous() throws SQLException 
// Bewegt den Pointer zur vorherigen Zeile

public boolean next() throws SQLException 
// Bewegt den Pointer zur nächsten Zeile

...
```

Note: **Prevoius**: Moves the cursor to the previous row. This method returns false if the previous row is off the result set.

**Next**: This method returns false if there are no more rows in the result set.



## Ein Result Set durchlaufen
```java
ResultSet rs = stmt.executeQuery(sqlString);

while(rs.next()){
    //Retrieve by column name
    int id  = rs.getInt("id");
    String name = rs.getString("name");

    //Display values
    System.out.print("(" + id + ") " + name);
}
```



## ResultSets schließen

Als letztes sollten auch Result Sets geschlossen werden um Datenbankressourcen zu sparen, aber nicht nachdem die Datenbankverbindung geschlossen wurde.

```java
rs.close();
stmt.close();
conn.close();
```



## JDBC Transactions

If your JDBC Connection is in auto-commit mode, which it is by default, then every SQL statement is committed to the database upon its completion.
That may be fine for simple applications, but there are three reasons why you may want to turn off the auto-commit and manage your own transactions −
To increase performance.
To maintain the integrity of business processes.
To use distributed transactions.
Transactions enable you to control if, and when, changes are applied to the database. It treats a single SQL statement or a group of SQL statements as one logical unit, and if any statement fails, the whole transaction fails.



## Commit & Rollback
Once you are done with your changes and you want to commit the changes then call commit() method on connection object as follows −
```java
conn.commit( );
```
Otherwise, to roll back updates to the database made using the Connection named conn, use the following code −
```java
conn.rollback( );
```



## Aufgabe
Welche Schritte sind notwendig bevor Resultate aus der Datenbank gelesen werden können?



## Lösung
Welche Schritte sind notwendig bevor Resultate aus der Datenbank gelesen werden können?
0. JDBC Treiber registrieren 
1. Datenbankverbindung öffnen
2. Eine Anfrage ausführen



## Aufgabe
Wie erhält man einen Integer-Wert aus dem ResultSet? Was muss der Methode übergeben werden?



## Lösung
Wie erhält man einen Integer-Wert aus dem ResultSet? Was muss der Methode übergeben werden?
```java
ResultSet rs = stmt.executeQuery(sql);
rs.getInt("id");
```



## Aufgabe
Welche der Folgenden Aussagen ist korrekt bezüglich Prepared Statements
1. Prepared Statement ermöglichen die Ausführung unterschiedlicher Anfragen durch den Austausch der Parameter
2. Prepared Statements sind sicherer, da die Variablen gebunden werden und somit SQL Injection Angriffe vorbeugen
3. Sowohl 1 als auch 2
4. Weder 1 noch 2



## Lösung
Welche der Folgenden Aussagen ist korrekt bezüglich Prepared Statements
1. Prepared Statement ermöglichen die Ausführung unterschiedlicher Anfragen durch den Austausch der Parameter
2. Prepared Statements sind sicherer, da die Variablen gebunden werden und somit SQL Injection Angriffe vorbeugen
3. **Sowohl 1 als auch 2**
4. Weder 1 noch 2



## Aufgabe
Welche der folgenden Aussagen ist korrekt über die JDBC Architektur?
0. Der JDBC API Layer bietet eine Anwendung-zu-JDBC Manager Verbindung
1. Die JDBC Driver API bietet eine JDBC Manager-zu-Treiber Verbindung
2. Sowohl 1 als auch 2
3. Weder 1 noch 2



## Lösung
Welche der folgenden Aussagen ist korrekt über die JDBC Architektur?
0. Der JDBC API Layer bietet eine Anwendung-zu-JDBC Manager Verbindung
1. Die JDBC Driver API bietet eine JDBC Manager-zu-Treiber Verbindung
2. **Sowohl 1 als auch 2**
3. Weder 1 noch 2



## Aufgabe
Welches dieser Statements existiert nicht?
* Statement
* Prepared Statement
* Callable Statement
* Interim Statement

Note: Interim - vorläufig



## Lösung
Welches dieser Statements existiert nicht?
* Statement
* Prepared Statement
* Callable Statement
* **Interim Statement**

Note: Interim - vorläufig
