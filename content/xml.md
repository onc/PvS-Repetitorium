# Extensible Markup Language (XML)



## XML
E**X**tensible **M**arkup **L**anguage - erweiterbare Auszeichnungssprache

Entwickelt um Daten zu transportieren.

Gut für Mensch **und** Maschine lesbar



XML ist in vielen Bereichen der Datenverarbeitung wiederzufinden.

Die Grundidee findet man zum Beispiel in 
* XML
* HTML
* SVG
* MathML

und vielen Anderen.



## Begriffe
#### Wohlgeformtheit
#### Validität
#### Parser
#### Element
#### Attribut



### Wohlgeformtheit
Ein XML-Dokument heißt *wohlgeformt*, wenn es alle XML-Regeln einhält. 

Regeln sind zum Beispiel:
* Das Dokument besitzt genau ein Wurzelelement.
* Alle Elemente mit Inhalt besitzen einen Beginn- und einen End-Auszeichner.
* Die Beginn- und End-Auszeichner sind ebenentreu-paarig verschachtelt.
* Ein Element darf nicht mehrere Attribute mit demselben Namen besitzen.
* Attributeigenschaften müssen in Anführungszeichen stehen.
* Die Beginn- und End-Auszeichner beachten die Groß- und Kleinschreibung.



### Validität
Ein XML-Dokument ist valide, wenn es die Regeln einer DTD oder XSD erfüllt.



### Parser
Ein Parser ist ein Computerprogramm, das in der Informatik für die Zerlegung und Umwandlung einer Eingabe in ein für die Weiterverarbeitung geeigneteres Format zuständig ist.



### Element
Die wichtigste Struktureinheit einer XML-Anwendung ist das Element. 

Der Name eines XML-Elements kann weitgehend frei gewählt werden. 

Elemente können weitere Elemente, Text- und andere Knoten – ggfs. auch vermischt – enthalten.



### Attribut
Attribute sind Schlüsselwort-Wert-Paare (Attributname="Attributwert")

Sie werden in Start- oder Empty-Element-Tags angegeben und beschreiben zusätzliche Eigentschaften eines Elements (Farbe, Alter, ...)



### Aufgabe
Finde die Fehler (3)
```xml
<?xml version="1.0"?> 
<order orderid=889923>
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note/>Special Editon</note>
    <quantity>1</quantity>
    <price>50.90</price>
  <item>
    <title>Star Wars - BluRay</title>
    <quantity>1</quantity>
    <price>19.90</price>
  </item>
</order> 
```



### Lösungsvorschlag
```xml
<?xml version="1.0"?> 
<order orderid="889923"> <!-- Attribute in Anführungszeichen (") oder Hochkomma (')-->
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note>Special Editon</note> <!-- Selbstschließende Tags können keinen Inhalt haben-->
    <quantity>1</quantity>
    <price>50.90</price>
  </item> <!-- Tags schließen, bevor das selbe wieder geöffnet wird-->
  <item>
    <title>Star Wars - BluRay</title>
    <quantity>1</quantity>
    <price>19.90</price>
  </item>
</order>
```



## Dokumenttypdefinition - DTD



### DTD-Element Definition
```xml
<!ELEMENT                   Schlüsselwort
  <name>                    Bezeichner des Tags
  <Inhaltsspezifizierung>   siehe unten
>
```
Inhaltsspezifizierung:
* beliebiger Text: (#PCDATA)
* bestimmte Kinder: reguläre Ausdrücke
* leere Elemente: EMPTY
* beliebiger Inhalt: ANY
* Text gemischt mit Tags: reg. Ausdruck mit #PCDATA



* Sequenz: (< erstesTag \> , < zweitesTag \>)
* Auswahl: (< erstesTag \> | < zweitesTag \>)
* Anzahl:
  * "" = genau einmal (nichts)
  *  ? = ein- oder keinmal
  * \+ = mindestens einmal
  * \* = beliebig oft (auch keinmal)



#### Attribut Definition
Vorgabewerte für Attribute
* \#REQUIRED Das Attribut muss angegeben werden
* \#IMPLIED  Das Attribut ist optional
* "..." Standardwert, falls das Attribut weggelassen wird
* \#FIXED "..." Das Attribut hat immer einen festen Wert



### Beispiel
```xml
<!DOCTYPE employees [
  <!ELEMENT employee (firstName, LastName)>
  <!ELEMENT firstName (#PCDATA)>
  <!ELEMENT lastName (#PCDATA)>
]>
```

ist die DTD zur folgenden XML-Datei:

```xml
<employee>
  <firstname>John</firstname>
  <lastname>Smith</lastname>
</employee>
```



### Aufgabe
Schreibe eine DTD für folgende XML
```xml
<?xml version="1.0"?> 
<order orderid="889923">
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note>Special Editon</note>
    <quantity>1</quantity>
    <price>50.90</price>
  </item>
  <item>
    <title>Star Wars - BluRay</title>
    <quantity>1</quantity>
    <price>19.90</price>
  </item>
</order>
```



### Lösungsvorschlag
```xml
<!DOCTYPE order[
  <!ELEMENT order (orderperson, item+) >
  <!ATTLIST order
    orderid  ID  #REQUIRED
  >
  <!ELEMENT orderperson (#PCDATA) >
  <!ELEMENT item (title, note?, quantity, price) >
  <!ELEMENT title (#PCDATA) >
  <!ELEMENT note (#PCDATA) >
  <!ELEMENT quantity (#PCDATA) >
  <!ELEMENT price (#PCDATA) >
]>
```



## XML Schema - XSD
Vorteile von XML Schemas:
* XML Schemas unterstützen Datentypen
* XML Schemas verwenden XML Syntax



### Datentypen
Einfache Elemente:

```xml
<xs:element>
...
</xs:element>
```
Komplexe (zusammengesetzte) Elemente:

```xml
<xs:complexType>
...
</xs:complexType>
```
Innerhalb komplexer Elemente Kindelemente aufzählen:

```xml
<xs:sequence>
...
</xs:sequence>
```
Oder einfach beliebige Kindelemente zulassen:
```xml
<xs:any>
...
</xs:any>
```



### Attribute
Überlicherweise werden diese Attribute am häufigsten verwendet:
* name - Der Name des Elements
* type - der Typ der Daten, die innerhalb des Elements stehen
  * `xs:string`
  * `xs:integer`
  * `xs:positiveInteger`
* `minOccurs`, `maxOccurs`: Minimums- und Maximumsangabe




### Beispiel
```xml
<xs:element name="employee">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="firstname" type="xs:string"/>
      <xs:element name="lastname" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>
</xs:element>
```

ist die XSD zur folgenden XML-Datei:

```xml
<employee>
  <firstname>John</firstname>
  <lastname>Smith</lastname>
</employee>
```



### Aufgabe
Schreibe eine XSD für folgende XML
```xml
<?xml version="1.0"?> 
<order orderid="889923">
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note>Special Editon</note>
    <quantity>1</quantity>
    <price>50.90</price>
  </item>
  <item>
    <title>Star Wars - BluRay</title>
    <quantity>1</quantity>
    <price>19.90</price>
  </item>
</order>
```



### Lösungsvorschlag
```xml
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="order">
    <xs:complexType>
      <xs:sequence>
        <xs:element type="xs:string" name="orderperson"/>
        <xs:element name="item" maxOccurs="unbounded" minOccurs="1">
          <xs:complexType>
            <xs:sequence>
              <xs:element type="xs:string" name="title"/>
              <xs:element type="xs:string" name="note" minOccurs="0"/>
              <xs:element type="xs:byte" name="quantity"/>
              <xs:element type="xs:float" name="price"/>
            </xs:sequence>
          </xs:complexType>
        </xs:element>
      </xs:sequence>
      <xs:attribute type="xs:int" name="orderid"/>
    </xs:complexType>
  </xs:element>
</xs:schema>
```



# Aufgaben



Schreibe eine DTD und eine XSD für folgendes XML.
```xml
<kochbuch>
  <rezept id="id_001">
    <name>Schnitzel</name>
    <dauer einheit="minuten">20</dauer>
    <zutaten>
      <zutat>Kalb</zutat>
      <zutat>Semmeln</zutat>
      <zutat>Ei</zutat>
      <zutat>Salz</zutat>
      <zutat>Pfeffer</zutat>
    </zutaten>
  </rezept>
  <rezept id="id_002">
    <name>Pommes</name>
    <vegan/>
    <zutaten>
      <zutat>Kartoffeln</zutat>
      <zutat>Salz</zutat>
    </zutaten>
  </rezept>
</kochbuch>
```



# Lösungsvorschlag

Die DTD
```xml
<!DOCTYPE kochbuch[
    <!ELEMENT kochbuch (rezept+)>
    <!ELEMENT rezept (name, dauer?, vegan?, zutaten)>
    <!ATTLIST rezept
              id ID #REQUIRED>
    <!ELEMENT zutaten (zutat)+>
    <!ELEMENT zutat (#PCDATA)>
    <!ELEMENT name (#PCDATA)>
    <!ELEMENT dauer (#PCDATA)>
    <!ATTLIST dauer
              einheit CDATA #REQUIRED>
    <!ELEMENT vegan EMPTY>
]>
```



Die XSD
```xml
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="kochbuch">
    <xs:complexType>
      <xs:sequence>

        <xs:element name="rezept" maxOccurs="unbounded">
          <xs:complexType>
            <xs:sequence>
              <xs:element type="xs:string" name="name" />
              <xs:element type="xs:string" name="vegan" minOccurs="0" fixed=""/>

              <xs:element name="dauer" minOccurs="0">
                <xs:complexType>
                  <xs:simpleContent>
                    <xs:extension base="xs:integer">
                      <xs:attribute name="einheit" type="xs:string" />
                    </xs:extension>
                  </xs:simpleContent>
                </xs:complexType>
              </xs:element>
```
```xml

              <xs:element name="zutaten">
                <xs:complexType>
                  <xs:sequence>
                    <xs:element type="xs:string" name="zutat" maxOccurs="unbounded" />
                  </xs:sequence>
                </xs:complexType>
              </xs:element>

            </xs:sequence>
            <xs:attribute type="xs:ID" name="id" />
          </xs:complexType>
        </xs:element>

      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>
```



### Aufgabe
1. Nenne zwei Unterschiede zwischen XML und HTML.
2. Nenne einen Unterschied Zwischen DTD und XSD.



### Lösungsvorschlag
1. Nenne zwei Unterschiede zwischen XML und HTML.
  * XML ist ein Datenaustauschformat für Computer, HTML ist zur Präsentation von Daten für Menschen gedacht.
  * In XML kann man neue Tags definieren, in HTML nicht (-> eigene "Datentypen")
  * HTML ist nicht so rigoros wie XML (z.B. muss man nicht immer alle Tags schließen (z.B. < br>)).
2. Nenne einen Unterschied zwischen DTD und XSD.
  * XSD ist valides XML und kann selbst wieder überprüft werden.
  * In XSD können untere und obere Grenzen angegeben werden.
  * In XSD können Aufzählungen durchgeführt werden.



## SVG
Die **S**calable **V**ector **G**raphic ist die empfohlene Spezifikation zur Beschreibung von 2D Vektorgrafiken.

SVG basiert auf XML und ist daher für Mashinen und Menschen gut lesbar.



### SVG - Elemente
![SVG-Grundelemente](content/images/SVG-Grundelemente.svg)

|||
|---|---|
|< rect x="25" y="25" width="40" height="40" />|< circle cx="160" cy="40" r="20" />|
|< line x1="25" y1="150" x2="80" y2="120" />|< polyline points="150,120 170,150 170,180 180,130" />|



Mit den richtigen Tools könnten solche Bilder entstehen.

![SVG-Grundelemente](content/images/eleven_below_single.svg)

[© Copyright 2008 Brian Lukis](http://www1.plurib.us/1shot/2008/eleven_below/)



Zur Veränderung von XML, HTML, SVG etc. wurde vom W3C die XPath Syntax eingeführt.



## XPath
XPath nutzt Reguläre Ausdrücke um Knoten (nodes) in XML Dokumenten zu selektieren.



### XPath Selektoren
Selektoren werden verwendet um bestimmte Knoten oder Attribute auszuwählen

|Ausdruck|Beschreibung|
|---|---|
|nodename|Wählt alle Knoten mit dem Namen `nodename` aus|
|`/`|Wählt den Wurzelknoten aus|
|`//`|Wählt Knoten passend zum Selektor aus, unabhänging von ihrer Position|
|`.`|Wählt den gegenwärtigen Knoten aus|
|`..`|Wählt den Vater des gegenwärtigen Knotens aus|
|`@`|Wählt Attribute|



### XPath Selektoren
```xml
<?xml version="1.0" encoding="UTF-8"?>
<bookstore>
    <book>
        <title lang="en">Harry Potter</title>
        <price>29.99</price>
    </book>
    <book>
        <title lang="en">Learning XML</title>
        <price>39.95</price>
    </book>
</bookstore>
```
|Ausdruck|Resultat|
|---|---|
|`bookstore`|Wählt alle Knoten mit dem Namen `bookstore` aus|
|`/bookstore`|Wählt den Wurzelknoten `bookstore` aus|
|`bookstore/book`|Wählt alle `book` Knoten aus, die Kinder von `bookstore` sind|
|`//book`|Wählt alle `book` Knoten aus|
|`bookstore//book`|Wählt alle `book` Knoten (die Kinder von `bookstore` sind) aus, unabhängig von ihrer Position|
|`//@lang`|Wählt alle `lang` Attribute aus|



### Aufgabe
```xml
<?xml version="1.0"?> 
<order orderid="889923">
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note>Special Editon</note>
    <quantity>1</quantity>
    <price>50.90</price>
  </item>
  <item>
    <title>Star Wars - BluRay</title>
    <quantity>1</quantity>
    <price>19.90</price>
  </item>
</order>
```
1. Wähle den `orderperson` Knoten aus
2. Wähle alle `price` Knoten aus
3. Wähle die `orderid` aus
4. Wähle den Vaterknoten der Knoten `item` aus



### Lösungsvorschlag
```xml
<?xml version="1.0"?> 
<order orderid="889923">
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note>Special Editon</note>
    <quantity>1</quantity>
    <price>50.90</price>
  </item>
  <item>
    <title>Star Wars - BluRay</title>
    <quantity>1</quantity>
    <price>19.90</price>
  </item>
</order>
```
1. Wähle den `orderperson` Knoten aus
  * `orderperson`
  * `//orderperson`
  * `order/orderperson`
2. Wähle alle `price` Knoten aus 
  * `price`
  * `//price`
  * `order/item//price`
3. Wähle die `orderid` aus
  * `//@orderid`
  * `order/@orderid`
4. Wähle die Vaterknoten der Knoten `item` aus
  * `item/..`
  * `order//item/..`



### XPath Prädikate
Prädikate werden benutzt um bestimmte Knoten oder Knoten, die einen bestimmten Wert haben, zu finden

Sie werden immer in eckigen Klammern geschrieben



### XPath Prädikate
```xml
<?xml version="1.0" encoding="UTF-8"?>
<bookstore>
    <book>
        <title lang="en">Harry Potter</title>
        <price>29.99</price>
    </book>
    <book>
        <title lang="en">Learning XML</title>
        <price>39.95</price>
    </book>
</bookstore>
```
|Ausdruck|Resultat|
|---|---|
|/bookstore/book[1]|Wählt den ersten book Knoten, welcher Kind von bookstore ist, aus|
|/bookstore/book[last()]|Wählt das letzte book Kind aus bookstore aus|
|/bookstore/book[last()-1]|Wählt das vorletzte book Kind aus bookstore aus|
|//title[@lang]|Wählt alle Titel Knoten aus die ein Attribut *lang* haben|
|/bookstore/book[price>35.00]|Wählt alle Book Knoten aus deren Preis über 35.00|
|/bookstore/book[price>35.00]/title|Wählt alle title Elemente aus Book Elementen innerhalb des Bookstores aus mit einem Preis von über 35.00|



### Aufgabe
```xml
<?xml version="1.0"?> 
<order orderid="889923">
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note>Special Editon</note>
    <quantity>1</quantity>
    <price>50.90</price>
  </item>
  <item>
    <title>Star Wars - BluRay</title>
    <quantity>1</quantity>
    <price>19.90</price>
  </item>
</order>
```
1. Wähle das zweite `item` der `order` aus
2. Wähle das drittletzte `item` der `order` aus
3. Wähle alle `item`-Knoten aus, deren Wert über 20 liegt



### Lösungsvorschlag
```xml
<?xml version="1.0"?> 
<order orderid="889923">
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note>Special Editon</note>
    <quantity>1</quantity>
    <price>50.90</price>
  </item>
  <item>
    <title>Star Wars - BluRay</title>
    <quantity>1</quantity>
    <price>19.90</price>
  </item>
</order>
```
1. Wähle das zweite `item` der `order` aus
  * `//item[2]`
  * `/order/item[2]`
2. Wähle das drittletzte `item` der `order` aus
  * `//item[last()-2]`
  * `/order/item[last()-2]`
3. Wähle alle `item`-Knoten aus, deren Wert über 20 liegt 
  * `//item[price>20.00]`
  * `/order/item[price>20.00]`



### XPath Wildcards
Wildcards werden benutzt um unbekannte Knoten zu selektieren

|Ausdruck|Beschreibung|
|---|---|
|*|Wählt jedes beliebige Elemente|
|@*|Wählt jedes beliebige Attribut|
|node()|Wählt irgendeinen beliebigen Knoten|



### XPath Wildcards
```xml
<?xml version="1.0" encoding="UTF-8"?>
<bookstore>
    <book>
        <title lang="en">Harry Potter</title>
        <price>29.99</price>
    </book>
    <book>
        <title lang="en">Learning XML</title>
        <price>39.95</price>
    </book>
</bookstore>
```
|Ausdruck|Resultat|
|---|---|
|/bookstore/*|Wählt alle Kinder des bookstore Knotens aus|
|//*|Wählt alle Elemente des Dokuments|
|/title[@*]|Wählt alle Titel elemente aus die mindestens ein Attribut haben|



### Aufgabe
```xml
<?xml version="1.0"?> 
<order orderid="889923">
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note>Special Editon</note>
    <quantity>1</quantity>
    <price>50.90</price>
  </item>
  <item>
    <title>Star Wars - BluRay</title>
    <quantity>1</quantity>
    <price>19.90</price>
  </item>
</order>
```
1. Wähle alle Kinder von `item`-Knoten aus
2. Wähle alle Kinder von `orderperson` aus
3. Wähle alle `price` Elemente aus, die ein Attribut haben



### Lösungsvorschlag
```xml
<?xml version="1.0"?> 
<order orderid="889923">
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note>Special Editon</note>
    <quantity>1</quantity>
    <price>50.90</price>
  </item>
  <item>
    <title>Star Wars - BluRay</title>
    <quantity>1</quantity>
    <price>19.90</price>
  </item>
</order>
```
1. Wähle alle Kinder von `item`-Knoten aus 
  * `item/*`
  * `//item/*`
  * `/order/item/*`
2. Wähle alle Kinder von `orderperson` aus 
  * `orderperson/*`
  * `//orderperson/*`
  * `/order/orderperson/*`
3. Wähle alle `price` Elemente aus, die ein Attribut haben 
  * `price[@*]`
  * `//price[@*]`
  * `/order/price[@*]`
