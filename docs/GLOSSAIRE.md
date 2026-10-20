# Glossaire métier

| Terme français | Nom dans le code | Définition |
|---|---|---|
| Mégawatt (MW) | `Megawatt` | Unité de **puissance** : débit d'énergie à un instant donné. Sert à exprimer la capacité maximale d'une centrale, sa production ou la consommation à un instant précis. Toujours positive ou nulle dans le domaine (une centrale à l'arrêt produit 0 MW). |
| Filière | `Fuel` | Type d'énergie primaire utilisé pour produire de l'électricité (nucléaire, gaz, charbon, hydraulique, éolien, solaire…). Chaque moyen de production appartient à une filière. |
| Pilotable | `Fuel.isDispatchable()` | Se dit d'un moyen dont l'exploitant peut décider la puissance produite (nucléaire, gaz, charbon, hydraulique). S'oppose à **fatal**. |
| Fatal (production fatale) | `!isDispatchable()` | Production imposée par la météo (vent, soleil) : on ne la décide pas, on la prend telle qu'elle vient. Éolien et solaire. |
