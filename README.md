# JEmpireV2 [En cours de développement]

JEmpire est un jeu se jouant sur un terminal ayant pour but de faire survivre votre colonie le plus longtemps possible. Pour cela, vous pouvez créer différents batiments et unités, mais attention, chaque jour, des évènements viendront vous aider ou vous compliquer la tâche !

## Télécharger le jeu

Pour jouer, vous devez clone le projet sur votre ordinateur :

```shell
git clone https://github.com/QDeh/JEmpireV2
```

Puis il faut se déplacer dans le dossier crée :

```shell
cd JEmpireV2/
```

Ensuite il faut compiler les fichiers :

```shell
javac -d build (Get-ChildItem -Recurse src/*.java).FullName
```

Et enfin, lancer le jeu :

```shell
java -cp build/ Main
```

Maintenant suivez les instructions pour jouer.

## Règles du jeu

Au début du jeu, vous commencez l'aventure avec :

1. Bois : 0
2. Pierre : 0
3. Fer : 0
4. Or: 0
5. Nourriture : 100
6. Habitants : 1 Villageois
7. Bâtiments : 1 Maison

Vous avez la possibilité durant la partie de créer des bâtiments, des unités et des items

### Diagramme de classes du jeu

```mermaid
classDiagram
Main <-- Village : Est utilisé dans (*)
Village <.. Units : Font parti du (*)
Units <|-- Villager
Units <|-- CraftsMan
Units <|-- Soldier
Units --o Items
Soldier <|-- Chief
Soldier <|-- Scout
Village *-- Ressources : Sont détenues par (*)
Village *-- Building : Sont dans le (*)
Building <|-- House
Building <|-- Barraks
Building <|-- Farm
Building <|-- Mine
Building <|-- Workshop
Building <|-- Wall
Village --o Items : Sont dans l'inventaire du (*)
Items <|-- Tool
Items <|-- Weapon
Building --o Units : Sont dans le (*)

class Main{
-int choice
-boolean contunue
-Scanner scanner
+readInt() int
+displayMainMenu()
+displayBuildMenu()
+displayUpgradeMenu()
+displayAssignMenu()
+displayUnassignMenu()
+displayTainMenu()
+displayRecruitMenu()
+displayEquipMenu()
+displayRessources()
+displayBuildings()
+selectMainMenu()
+selectBuildMenu()
+selectUpgradeMenu()
+selectAssignMenu()
+selectUnassignMenu()
+selectTainMenu()
+selectRecruitMenu()
+selectEquipMenu()
}

class Village{
-String name
-int day
+getCurrentPopulation() int
+getPopulationMax() int
+getBuildings() List<Buildings>
+getDay() int
+getUnits() List<Units>
+getRessources() List<Ressources>
+getItems(()) List<Items>
+unassignUnit()
+finishDay()
+displayRessources()
+displayVillagers()
+displayBuildings()
+displayItems()
+createWeapon() Weapon
+createTool() Tool
+createBuilding() Building
+createUnit() Unit
+upgradeBuilding() Building
}

class Units{
<<Abstract>>
#int hp
#int damage
+getItem() Item
#setItem()
}

class Villager{
+equipTool()
}

class CraftsMan{
+equipTool()
}

class Soldier{
#boolean hasChief
+hasChief() boolean
+boostChief()
+equipWeapon()
}

class Scout{
+equipTool()
}

class Chief{
+isChief()
}

class Building{
<<Abstract>>
-int level
+getLevel() int
+getUnits() List<Units>
+checkLevel() int
+assign() boolean
+unassign()
}

class Barraks{
+assign() boolean
}

class Farm{
+assign() boolean
}

class Mine{
+assign() boolean
}

class Wall{
+assign() boolean
}

class Workshop{
+assign() boolean
}

class Items{
<<Abstract>>
#String name
#int modifier
#int level
}

class Tool{
+upgrade()
}

class Weapon{
+upgrade()
}

class Ressources{
-int wood
-int stone
-int iron
-int gold
-int food
+getWood() int
+getStone() int
+getIron() int
+getGold() int
+getFood() int
}
```

### Bâtiments

1. **La Maison** est un bâtiment ayant pour fonction d'abriter les Unités, leur nombre et leur niveau **détermine la capacité** de votre Village.
2. **La Ferme** est un bâtiment ayant pour fonction de **produire de la Nourriture**, pour cela, un Villageois doit y être affecté. Le nombre de Villageois pouvant être affecté à une Ferme dépend du niveau de celle-ci.
3. **La Mine** est un bâtiment ayant pour fonction de **produire de la Pierre**, pour cela, un Villageois doit y être affecté. Le nombre de Villageois pouvant être affecté à une Mine dépend du niveau de celle-ci.
4. **L'Atelier** est un bâtiment ayant pour fonction de **produire des items**, pour cela, un Artisan doit y être affecté. Le nombre d'Artisans pouvant être affecté à un Atelier dépend du niveau de celui-ci.
5. **La Caserne** est un bâtiment ayant pour fonction de **former des Soldats**, pour cela, un Soldat (où le Chef) doit y être affecté. Le nombre de Soldats pouvant être affecté à une Caserne dépend du niveau de celle-ci.
6. **Le Mur** est un bâtiment ayant pour fonction de **buffer des Soldats**, pour cela, un Soldat (où le Chef) peuvent y être affecté. Lors d'une attaque, les soldats sur le Mur sont les cibles prioritaires de celle-ci. Le buff des Soldats affectés dépend du niveau du Mur.

### Unités

Vous pourrez créer 5 types d'unités ayant des caractéristiques différentes :

1. **Le villageois** possède 10pv, 1 de dégât et peut être affecté à la Ferme et à la Mine.
2. **L'Artisan** possède 10pv, 1 de dégât et peut être affecté à l'Atelier.
3. **L'Éclaireur** possède 15pv, 1 de dégâts et peut faire des expéditions en dehors du Village.
4. **Le Soldat** possède 20pv, 2 de dégâts et peut être affecté à la caserne et au mur.
5. **Le Chef** est un soldat spécial qui possède 30pv, 5 de dégâts et peut être affecté à la caserne et au mur.

### Items

Vous aurez la possibilité de créer 2 items différents dans l'atelier :

1. **L'Outil'** est un item pouvant être donné aux Villageois, Artisans et Éclaireurs. Il permet de buffer le nombre de ressources récoltées par ceux-ci.
2. **L'Épée** est un item pouvant être donné aux Soldats (où au Chef). Elle permet de buffer le dégâts de ceux-ci.

## Déroulement d'un tour de jeu

A chaque tour de jeu, celui-ci vous informe de l'état de votre village (unités, bâtiments, ressources, items), chaque unité mange 1 de nourriture puis vous avez le choix entre 9 actions.

1. **Construire un bâtimentt.** Cette action vous emmène dans un menu ou vous pouver choisir votre bâtiment à construire (Maison/Ferme/Mine/Caserne/Atelier/Mur) contre des ressources.
2. **Améliorer un bâtiment.** Cette action vous permet d'améliorer un bâtiment existant contre des ressources.
3. **Asssigner une unité.** Cette action vous permet d'assigner une unité à un bâtiment, permettant de produire des ressources à chaque tour.
4. **Libérer une unité.** Cette action vous permet de libérer une unité afféctée à un bâtiment.
5. **Former une unité.** Cette action vous permet de former un soldat ou un chef contre des ressources.
6. **Recruter une unité.** Cette action vous permet de recruter un villageois, un artisan contre des ressources.
7. **Équiper un item.** Cette action vous permet d'équiper un objet à une unité, la rendant meilleure.
8. **Passer au jour suivant.** Cette action valide la fin du jour et permet de passer au jour suivant.
9. **Quitter le jeu** Cette action vous permet de quitter le jeu.

### Flowchart décrivant le fonctionnement du jeu

```mermaid
flowchart TD
    A([Lancement du jeu]) --> B{Menu principal}
    B -->|1| C[Construire un bâtiment]
    B -->|2| D[Améliorer un bâtiment]
    B -->|3| E[Asssigner une unité]
    B -->|4| F[Libérer une unité]
    B -->|5| G[Former une unité]
    B -->|6| H[Recruter une unité]
    B -->|7| I[Équiper un item]
    B -->|8| J[Passer au jour suivant]
    B -->|0| K[Quitter le jeu]
    J --> AO{habitants > 0 ?}
    C --> L{Menu de Construction}
    D --> M{Menu d'Amélioration}
    E --> N{Menu d'Assignation}
    F --> O{Menu de Libération}
    G --> P{Menu de Formation}
    H --> Q{Menu de Recrutement}
    I --> R{Menu d'Équipement}
    AO --> |Non| AP([Game over])
    AO --> |Oui| S[Calcul des ressources]
    K ---> AP
    L --> |1| T[Construction d'une Maison]
    L --> |2| U[Construction d'une Ferme]
    L --> |3| V[Construction d'une Mine]
    L --> |4| W[Construction d'un Atelier]
    L --> |5| X[Construction d'une Caserne]
    L --> |6| X[Construction d'un Mur]
    M --> |1| Y[Amélioration d'une Maison]
    M --> |2| Z[Amélioration d'une Ferme]
    M --> |3| AA[Amélioration d'une Mine]
    M --> |4| AB[Amélioration d'un Atelier]
    M --> |5| AC[Amélioration d'une Caserne]
    M --> |6| AD[Amélioration d'un Mur]
    N --> |*| AE{Liste d'unités}
    AE{Liste d'unités} --> |*| AF{Liste de bâtiments}
    O --> |*| AE
    P --> |1| AG[Recruter un Villageois]
    P --> |2| AH[Recruter un Artisan]
    P --> |3| AI[Recruter un Éclaireur]
    Q --> |1| AJ[Former un Soldat]
    Q --> |2| AK[Former un Chef]
    R --> |*| AL{Liste d'items}
    AL -->|*| AM{Liste d'unités}
    T --> AN[Mise à jour du Village]
    U --> AN
    V --> AN
    W --> AN
    X --> AN
    Y --> AN
    Z --> AN
    AA --> AN
    AB --> AN
    AC --> AN
    AD --> AN
    AF --> AN
    AG --> AN
    AH --> AN
    AI --> AN
    AJ --> AN
    AK --> AN
    AM --> AN
    AN --> B
    S --> B
```

## Condition de défaite

Vous **PERDEZ** si vous n'avez plus d'habitant.
