# Extensible Markup Language (XML)



##XML
E**X**tensible **M**arkup **L**anguage - erweiterbare Auszeichnungssprache

Entwickelt um Daten zu transportieren.

Gut von Menschen und von Maschinen lesbar



XML ist in vielen Bereichen der Datenverarbeitung wiederzufinden.

In der Grundidee ist XML häufig wiederzufinden: 
* XML
* HTML
* SVG
* MathML
* ...



##Begriffe
####Wohlgeformtheit
####Parser
####Element
####Attribut



###Wohlgeformtheit
Ein XML-Dokument heißt *wohlgeformt*, wenn es alle XML-Regeln einhält. Beispielhaft seien hier folgende genannt:
* Das Dokument besitzt genau ein Wurzelelement.
* Alle Elemente mit Inhalt besitzen einen Beginn- und einen End-Auszeichner.
* Die Beginn- und End-Auszeichner sind ebenentreu-paarig verschachtelt.
* Ein Element darf nicht mehrere Attribute mit demselben Namen besitzen.
* Attributeigenschaften müssen in Anführungszeichen stehen.
* Die Beginn- und End-Auszeichner beachten die Groß- und Kleinschreibung.



###Parser
Ein Parser ist ein Computerprogramm, das in der Informatik für die Zerlegung und Umwandlung einer Eingabe in ein für die Weiterverarbeitung geeigneteres Format zuständig ist.



###Element
Wichtigste Struktureinheit einer XML-Anwendung ist das Element. Der Name eines XML-Elements kann weitgehend frei gewählt werden. Elemente können weitere Elemente, Text- und andere Knoten – ggfs. auch vermischt – enthalten.



###Attribut
Attribute dienen als bei einem Start-Tag oder Empty-Element-Tag geschriebene Schlüsselwort-Werte-Paare (Attribut-Name="Attribut-Wert") für Zusatz-Informationen über Elemente (eine Art Meta-Information).



##Dokumenttypdefinition - DTD



###DTD-Element Definition
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
  * "_" = genau einmal (Leerzeichen)
  *  ? = ein oder keinmal
  * \+ = ein oder mehrmal
  * \* = kein oder mehrmal



####Attribut Definition
Vorgabewerte für Attribute
* \#REQUIRED Das Attribut muss angegeben werden
* \#IMPLIED  Das Attribut ist optional
* "..." Standardwert, falls das Attribut weggelassen wird
* \#FIXED "..." Das Attribut hat immer einen festen Wert



##XML Schema - XSD



###Datentypen



###Aufgabe
Finde die Fehler (3 Stück)
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
Note: Lösung unten


###Aufgabe
```xml
<?xml version="1.0"?> 
<order orderid="889923"> <!-- Attribute in Anführungszeichen (") oder 
                              Hochkomma (')-->
  <orderperson>John Doe, Hauptstraße 7, Ulm</orderperson>
  <item>
    <title>Herr der Ringe Trilogie</title>
    <note>Special Editon</note> <!-- Selbstschließende Tags können keinen 
                                     Inhalt haben-->
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



###Aufgabe
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


```xml
<!DOCTYPE order[
  <!ELEMENT order (orderperson,item) >
  <!ATTLIST img
    orderid  ID  #REQUIRED
  >
  <!ELEMENT orderperson (#PCDATA) >
  <!ELEMENT item (title, note, quantity, price)* >
  <!ELEMENT title (#PCDATA) >
  <!ELEMENT note (#PCDATA)? >
  <!ELEMENT quantity (#PCDATA) >
  <!ELEMENT price (#PCDATA) >
]>
```



###Aufgabe
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


```xml
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="order">
    <xs:complexType>
      <xs:sequence>
        <xs:element type="xs:string" name="orderperson"/>
        <xs:element name="item" maxOccurs="unbounded" minOccurs="0">
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



###Aufgabe
1. Nenne zwei Unterschiede zwischen XML und HTML.
2. Nenne einen Unterschied Zwischen DTD und XSD.


###Aufgabe
1. Nenne zwei Unterschiede zwischen XML und HTML.
  * XML ist ein Datenaustauschformat für Computer, HTML ist zur Präsentation von Daten für Menschen gedacht.
  * In XML kann man neue Tags definieren, in HTML nicht.
  * HTML ist nicht so rigoros wie XML (z.B. muss man nicht alle Tags schließen (z.B. < br>)).
2. Nenne einen Unterschied zwischen DTD und XSD.
  * DTD ist valides XML und kann selbst wieder überprüft werden.
  * In DTD können untere und obere Grenzen angegeben werden.
  * In XSD können Aufzählungen durchgeführt werden.



##SVG
Die **scalable vector graphics** ist die empfohlene Spezifikation zur beschreibung von 2D Vektorgrafiken.

SVG basiert auf XML und ist daher für Mashinen und Menschen gut lesbar.



### SVG - Elemente
![SVG-Grundelemente](/content/images/SVG-Grundelemente.svg)

|||
|---|---|
|< rect x="25" y="25" width="40" height="40" />|< circle cx="160" cy="40" r="20" />|
|< line x1="25" y1="150" x2="80" y2="120" />|< polyline points="150,120 170,150 170,180 180,130" />|



Mit den richtigen Tools könnten solche Bilder entstehen.
![SVG-Grundelemente](/content/images/eleven_below_single.svg)

[© Copyright 2008 Brian Lukis](http://www1.plurib.us/1shot/2008/eleven_below/)



Zur veränderung von XML, HTML, SVG etc. wurde vom W3C die XPath Syntax eingeführt.



##XPath
XPath nutzt Reguläre Ausdrücke um Knoten (nodes) in XML Dokumenten zu selektieren.



###XPath Selektoren
Selektoren werden verwendet um bestimmte Knoten, oder Attribute auszuwählen

|Ausdruck|Beschreibung|
|---|---|
|nodename|Wählt alle Knoten mit dem Namen "nodename" aus|
|/|Wählt den Wurzelknoten aus|
|//|Wählt Knoten passend zum Selektor aus, unabhänging von ihrer Position|
|.|Wählt den gegenwärtigen Knoten aus|
|..|Wählt den Vater des gegenwärtigen Knotens aus|
|@|Wählt Attribute|


###XPath Selektoren
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
|bookstore|Wählt alle Knoten mit dem Namen "bookstore" aus|
|/bookstore|Wählt den Wurzelknoten bookstore aus|
|bookstore/book|Wählt alle Book Knoten, die Kinder von Bookstore sind, aus|
|//book|Wählt alle Book Knoten aus|
|bookstore//book|Wählt alle Book Knoten (die Kinder von bookstore sind) aus, unabhängig von ihrer Position|
|//@lang|Wählt alle *lang* Attribute aus|



###Aufgabe
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
1. Wähle den orderperson Knoten aus
2. Wähle alle price Knoten aus
3. Wähle die orderid aus
4. Wähle den Vaterknoten der Knoten item aus


###Aufgabe
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
1. 
  * orderperson
  * //orderperson
  * order/orderperson
2. 
  * price
  * //price
  * order/item//price
3. 
  * //@orderid
  * order/@orderid
4. 
  * item/..
  * order//item/..



###XPath Prädikate
Prädikate werden benutzt um bestimmte Knoten, oder Knoten die einen bestimmten Wert haben, zu finden

Sie werden immer in eckigen Klammern geschrieben


###XPath Prädikate
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



###XPath Wildcards
Wildcards werden benutzt um unbekannte Knoten zu selektieren

|Ausdruck|Beschreibung|
|---|---|
|*|Wählt alle Knoten mit dem Namen "nodename" aus|
|@*|Wählt den Wurzelknoten aus|
|node()|Wählt Knoten passend zum Selektor aus, unabhänging von ihrer Position|


###XPath Wildcards
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

