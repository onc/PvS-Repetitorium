# Extensible Markup Language (XML)



##XML
E**X**tensible **M**arkup **L**anguage - erweiterbare Auszeichnungssprache

Entwickelt um Daten zu transportieren.

Gut von menschen und von Maschinen lesbar



XML ist in vielen Bereichen der Datenverarbeitung wiederzufinden.

In der Grundidee ist XML häufig wiederzufinden: 
* XML
* HTML
* SVG
* MathML
* ...



##Begriffe
Element

Attribut

Parser

Wohlgeformtheit



##Dokumenttypdefinition - DTD



##XML Schema - XSD



###Datentypen



###Beispiel
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


###Beispiel
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



###Beispiel
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



###Beispiel
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
