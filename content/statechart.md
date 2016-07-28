# Zustandsübergangsdiagramm



Zustandsübergangsdiagramme, oder auch Statecharts, sind hilfreiche Modelle um Zustände eines Programms und deren Übergänge zu beschreiben.



## Zustandsübergangsdiagramm - Elemente
* ![Statechart_state](content/images/Statechart_state.svg)
Zustand
* ![Statechart_start](content/images/Statechart_start.svg)
Startzustand (**Immer notwendig**)
* ![Statechart_end](content/images/Statechart_end.svg)
Endzustand
* ![Statechart_transition](content/images/Statechart_transition.svg)
Zustandsübergang, 
  * meistens mit Textanmerkung, wie der Zustandsübergang zustande kommt
  * [a < 5] Wächterausdruck, gibt Bedingungen an
  * wenn kein Text: der Zustand wird automatisch gewechselt



### Beispiel
Lichtschalter

![Statechart1](content/images/Statechart1.png)



### Beispiel
Auto beladen (Beispiel mit Wächterausdrücken)

![Statechart2](content/images/Statechart2.png)



Statecharts sind nicht das Nonplusultra



### Beispiel - Buttons im Contactmanager

![Statechart Contactmanager](content/images/Statechart_CM1.png)

Farben dienen hier nur der übersichtlichkeit. Statechart nur für das umschalten links <-> rechts.



Sollten wir jetzt die Zustände der Buttons modelieren, oder doch besser die Zustände der Kontakte?



### Beispiel - Buttons im Contactmanager

![Statechart Contactmanager](content/images/Statechart_CM2.png)

Statechart nur für das umschalten links <-> rechts.

Übersichtlicher, aber wir haben keine Ahnung von den Buttons...



### Aufgabe
Mit der abgebildeten GUI ist es möglich, einen Scheinwerfer zu steuern.

![Ampel](content/images/Statechart_simple.png)

Die beiden Schalter steuern **eine** farbige Lichtquelle die rotes, grünes, gelbes oder gar kein Licht erzeugen kann. 

Erstelle ein Statechart, der alle möglichen Zustände sowie deren Übergänge beinhaltet.



### Lösungsvorschlag

![Ampel](content/images/Statechart_simple_solution.png)



### Aufgabe
Eine Ampel

![Ampel](content/images/Statemachine_Ampel.png)

kann von einem  in den nächsten Zustand übergehen, wobei die Rote und Grüne Phase jeweils 30 Sekunden dauern, der Übergang zwischen allen anderen dauert nur 5 Sekunden.

Erstelle ein Statechart, welches den Sachverhalt darstellt.

**Tipp:** Nutze für Zeitliche Übergänge Wächterausdrücke



### Lösungsvorschlag

![Ampel](content/images/Statechart_Ampel_solution.png)



### Aufgabe
Ein einfaches Faxgerät hat folgendes Benutzerinterface

![Faxmachine](content/images/Faxmachine.png)

Mit der Taste Ein/Aus wird das Gerät ein-, bzw. ausgeschaltet. Mit der Taste Fax/Kopie kann zwischen dem Modus
Kopieren und dem Modus Faxen umgeschaltet werden. Für beide Modi kann die Auflösung mit den Tasten Normal,
Fein und Foto geregelt werden.

Das Fax oder die Kopie werden mit weiteren Tasten gestartet, die hier aber nicht von Bedeutung sind. Wenn das
Gerät ausgeschaltet ist, sind außer der Einschalttaste keine anderen Tasten aktiv.

Außerdem startet das Gerät immer in der Einstellung Fax, normal, speichert den Zustand der letzen Einstellung also nicht.



### Lösungsvorschlag

![Ampel](content/images/Statechart_Faxmachine_solution.png)



### Fazit
Statecharts sind nicht optimal, können aber dabei helfen sich über den Zustand eines Systems Gedanken zu machen.
So können Fehler vermieden und Fehlerhafte zustände frühzeitig erkannt werden.

Es ist wichtig die Zustände und deren Übergänge richtig zu definieren um ein verständliches Statechart erstellen zu können.
