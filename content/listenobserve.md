#Listener und Observer



##Observer Pattern
###Das Beobachter-Muster
Wir erläutern das Observer-Pattern anhand des PvS-Repetitoriums. 

In diesem Beispiel sind die Tutoren (*wir*) die Erzähler und erklären den Stoff von Programmierung von Systemen. Die Zuhörer (*ihr*) seid diejenigen, welche sich für den Stoff interessieren und aufmerksam zuhören. Wir nennen die Tutoren jetzt Observable (beobachtbar) und die Studenten Observer(Beobachter).

Solange ein Observable einen oder mehrere Observer hat erzählt er, sendet also Mitteilungen. Wenn allerdings kein Observer dem Observable zuhört, dann schweigt er auch. 

Die Observer sind vielleicht nicht immer am Stoff interessiert, dann können sie sich beim Observer abmelden und bekommen keine neuen Nachrichten.
Sollten neue Observer hinzu kommen, können sich diese beim Observable anmelden und werden auch informiert.



###Beispiel: Die Push Variante
![Observer](content/images/Observer_Push.svg)



Unser Beispiel mit den Erzählern und Zuhörern können wir auf Datenstrukturen übertragen. Die Datenstruktur lässt sich beobachten und wird zum Beobachteten. Sie wird in Java als Exemplar der Bibliotheksklasse Observable repräsentiert. Der Beobachter wird durch die Schnittstelle Observer abgedeckt und ist der, der informiert werden will, wenn sich die Datenstruktur ändert.



###Observer-Pattern: Push-Variante



###Observer-Pattern: Pull-Variante



##Listener



###ActionListener



###MouseListener



###MouseMotionListener
