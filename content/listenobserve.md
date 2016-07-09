#Listener und Observer



##Observer Pattern
###Das Beobachter-Muster
Wir erläutern das Observer-Pattern anhand des PvS-Repetitoriums. 

In diesem Beispiel sind die Tutoren (*wir*) die Erzähler und erklären den Stoff von Programmierung von Systemen. Die Zuhörer (*ihr*) seid diejenigen, welche sich für den Stoff interessieren und aufmerksam zuhören. Wir nennen die Tutoren jetzt Observable (beobachtbar) und die Studenten Observer(Beobachter).

Solange ein Observable einen oder mehrere Observer hat erzählt er, sendet also Mitteilungen. Wenn allerdings kein Observer dem Observable zuhört, dann schweigt er auch. 

Die Observer sind vielleicht nicht immer am Stoff interessiert, dann können sie sich beim Observer abmelden und bekommen keine neuen Nachrichten.
Sollten neue Observer hinzu kommen, können sich diese beim Observable anmelden und werden auch informiert.
Note: Vorlesen!



###Beispiel: Die Push Variante
Im Push-Modell übergibt der Observable der update()-Methode detaillierte Informationen über die Änderung als Parameter.

Der Vorteil hierbei ist, dass Observer und Observable stärker entkoppelt sind, da der Observer keine Informationen über den Observable benötigt.



###Beispiel: Die Push Variante
![Observer](content/images/Observer_push.svg)
Note: ANIMIERT! Seperat öffnen, da die Animation sonst nicht funktioniert.




###Beispiel: Die Pull Variante
Beim Pull-Modell erhält der Observer nur eine minimale Benachrichtigung und muss sich die benötigten Informationen selber aus vom Observable holen. Dazu erhält/besitzt es eine Referenz auf diesen (entweder in einer Instanzvariable beim Registrieren gespeichert oder via Argument der update()-Methode).



###Beispiel: Die Pull Variante
![Observer](content/images/Observer_pull.svg)
Note: ANIMIERT! Seperat öffnen, da die Animation sonst nicht funktioniert.



##Listener



###ActionListener



###MouseListener



###MouseMotionListener
