#Listener und Observer



##Observer Pattern
Wir erläutern das Observer-Pattern anhand des PvS-Repetitoriums. 

In diesem beispiel sind die Tutoren, welche das Rep halten die Erzähler und berichten von wichtigen Themen im Stoff von Programmierung von Systemen. Die Zuhörer, also ale Studenten im Hörsaal, sind diejenigen, welche sich für den Stoff interessieren und aufmerksam zuhören. Wir nennen die Tutoren jetzt Observable (beobachtbar) und die Studenten Observer(Beobachter).

Unser Beispiel mit den Erzählern und Zuhörern können wir auf Datenstrukturen übertragen. Die Datenstruktur lässt sich beobachten und wird zum Beobachteten. Sie wird in Java als Exemplar der Bibliotheksklasse Observable repräsentiert. Der Beobachter wird durch die Schnittstelle Observer abgedeckt und ist der, der informiert werden will, wenn sich die Datenstruktur ändert.

###Observer-Pattern: Push-Variante



###Observer-Pattern: Pull-Variante



##Listener



###ActionListener



###MouseListener



###MouseMotionListener
