---
title: Lösung 1
author: Tobias Lahmann, Christian van Onzenoodt
geometry: margin=1in
header-includes:
    - \usepackage{floatrow}
    - \floatplacement{figure}{H}
    - \floatplacement{table}{H}
    - \usepackage[ngerman]{babel}
---

# Lösung 1

1. Klassendiagramm ist unter `solution/one/classDiagramm.png`.

2. Antwort auf die Frage: `compareTo()` ist eine `default` implementierung innerhalb eines Interface. Das ist seit Java8 möglich. Das `default` Schlüsselwort signalisiert das.

Renderable.java

```java
@Override
public default int compareTo(Renderable other) {
   if (this.getZindex() < other.getZindex()) {
     return -1;
   } else if (this.getZindex() > other.getZindex()) {
     return 1;
   }
   return 0;
}
```

Input.java

```java
@Override
public void keyPressed(KeyEvent event) {

  switch (event.getKeyCode()) {
    case KeyEvent.VK_UP:
      buttonsPressed[Button.UP.ordinal()] = true;
      break;

    case KeyEvent.VK_DOWN:
      buttonsPressed[Button.DOWN.ordinal()] = true;
      break;

    case KeyEvent.VK_LEFT:
      buttonsPressed[Button.LEFT.ordinal()] = true;
      break;

    case KeyEvent.VK_RIGHT:
      buttonsPressed[Button.RIGHT.ordinal()] = true;
      break;

    case KeyEvent.VK_SPACE:
      buttonsPressed[Button.SPACE.ordinal()] = true;
      break;

    default:
      break;
  }
}

@Override
public void keyReleased(KeyEvent event) {

  switch (event.getKeyCode()) {
    case KeyEvent.VK_UP:
      buttonsPressed[Button.UP.ordinal()] = false;
      break;

    case KeyEvent.VK_DOWN:
      buttonsPressed[Button.DOWN.ordinal()] = false;
      break;

    case KeyEvent.VK_LEFT:
      buttonsPressed[Button.LEFT.ordinal()] = false;
      break;

    case KeyEvent.VK_RIGHT:
      buttonsPressed[Button.RIGHT.ordinal()] = false;
      break;

    case KeyEvent.VK_SPACE:
      buttonsPressed[Button.SPACE.ordinal()] = false;
      break;

    default:
      break;
  }
}
```

Button.java

```java
public enum Button {
  UP, DOWN, LEFT, RIGHT, SPACE
}
```

GameLogic.java

```java
if (input.buttonsPressed[Button.SPACE.ordinal()]) {
  projectileSpawner.spawn(playerPosition);
}
```
