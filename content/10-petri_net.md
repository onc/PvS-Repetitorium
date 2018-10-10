# Petri Netze

Ein Petrinetz wird als Graph dargestellt, der aus zwei Arten von Knoten aufgebaut ist, die Stellen (oder auch Plätze) bzw. Transitionen genannt werden. Die Knoten sind durch Kanten verbunden, wobei eine Kante genau eine Stelle mit einer Transition oder umgekehrt verbindet. Ein Netz mit solchen Knoten wird als Stellen/Transitions-Netz (kurz: S/T-Netz) bezeichnet. 

In der Vorlesung wurden auch die B/E-Netze betrachtet



## Formale Definition von B/E-Netzen

Ein B/E-Netz ist ein Tripel N = (S, T, F) mit 
* S ∩ T = ∅ 
* F ⊆ ( S x T) ∪ (T x S)

> S = {S1, S2, S3}
> 
> T = {t1, t2} 
> 
> F = {(S1, t1), (S1, t2), (S2, t2), (t1, S3), (t2, S3)}



## Formale Definition von S/T-Netzen
Ein 6-Tupel Y = (S, T, F, K, W, M0) heißt Stellen-Transitions-Netz (kurz: S/T-Netz) wenn folgende Kriterien gelten:
* (S, T, F) ist ein B/E-Netz
* K : S → N ∪ { ∞ } ordnet jeder Stelle s ∈ S eine **Maximalkapazität** K(s) zu (evtl. unbeschränkt),
* W : F → N ordnet jeder Kante k ∈ F ein **Kantengewicht** W(k) zu
* M0 : S → N0 ordnet jeder Stelle s ∈ S eine **Anfangsmarkierung** M0(s) zu (∀ s ∈ S: M0(s) ≤ K(s)).

> S = {s1, s2, s3, s4}
> 
> T = {t1, t2, t3}
> 
> F = {(t1, s1), (t1, s2), (s1, t2), (s2, t3), (t2, s3), (t2, s4), (t3, s4), (s4, t1)}
> 
> K = {(s1, ∞), (s2, ∞), (s3, 1), (s4, ∞)}
> 
> G = {((t1, s1), 1), ((t1, s2) ,1), ((s1, t2), 1),  ((s2, t3), 1), ((t2, s3), 1), ((t2, s4), 1), ((t3, s4), 1), ((s4, t1), 2)}
> 
> M0 = {(s1, 0), (s2, 0), (s3, 0), (s4, 2)}



## Komponenten von Petri-Netzen
![Petri Komponenten1](content/images/petri_komponenten1.PNG)
![Petri Komponenten2](content/images/petri_komponenten2.PNG)
![Petri Komponenten3](content/images/petri_komponenten3.PNG)
![Petri Komponenten4](content/images/petri_komponenten4.PNG)



## Nebenläufigkeit
Petri-Netze bieten ein abstraktes Modell zur Beschreibung nebenläufiger und nichtdeterministischer Abläufe.

Sie werden genutzt um, unter anderem, die Verklemmungsfreiheit und Lebendigkeit solcher Aktivitäten zu überprüfen.

Note: Frage an Studenten: was ist Verklemmungsfreiheit was ist Lebendigkeit?



## Nebenläufigkeit

![Petri Beispiel](content/images/Petri_Situation1.gif)

Nebenläufige Prozesse sind sowohl in ihrer zeitlichen Komponente als auch in ihrer Abarbeitung unabhängig voneinander. Bei gemeinsamer Nutzung von Resourcen können Konflikte auftreten. Übertragen auf ein Petri-Netz bedeutet das, wenn mehrere Transitionen (Ereignisse) aktiviert sind, können alle willkürlich feuern. Somit sind gleichzeitig nebeneinander ablaufbare Vorgänge darstellbar.



## Aufgabe
Zeichne anhand der folgenden formalen Repräsentation das dazugehörige S/T-Petri-Netz

S = {s1, s2, s3, s4}

T = {t1, t2}

F = {(s1, t1), (t1, s2), (t1, s3,), (s2, t2), (s3, t2), (t2, s4)}

K = {(s1, inf), (s2, inf), (s3, inf), (s4, 1)}

G = {((s1, t1), 2), ((t1, s2), 1), ((t1, s3,), 1), ((s2, t2), 1), ((s3, t2), 1), ((t2, s4), 1)}

M0 = {(s1, 2), (s2, 0), (s3, 0), (s4, 0)}



## Lösung (1/2)

![Petri Netz 1](content/images/petri_net_1.png)

Zweiter Aufgabenteil: Führe eine Erreichbarkeitsanalyse durch und zeichne den Erreichbarkeitsgraph



## Lösung (2/2)

| Nummer | s1  | s2  | s3  | s4  | Firing transition |
| ------ | --- | --- | --- | --- | ----------------- |
| M0     | 2   | 0   | 0   | 0   | t1 -> M1          |
| M1     | 0   | 1   | 1   | 0   | t2 -> M2          |
| M2     | 0   | 0   | 0   | 1   |                   |

--- 
<pre style="font-size:1.5rem;">
M0    -t1->    M1    -t2->    M2
</pre>
