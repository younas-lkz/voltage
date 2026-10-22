# Glossaire métier

| Terme français | Nom dans le code | Définition |
|---|---|---|
| Mégawatt (MW) | `Megawatt` | Unité de **puissance** : débit d'énergie à un instant donné. Sert à exprimer la capacité maximale d'une centrale, sa production ou la consommation à un instant précis. Toujours positive ou nulle dans le domaine (une centrale à l'arrêt produit 0 MW). |
| Filière | `Fuel` | Type d'énergie primaire utilisé pour produire de l'électricité (nucléaire, gaz, charbon, hydraulique, éolien, solaire…). Chaque moyen de production appartient à une filière. |
| Pilotable | `Fuel.isDispatchable()` | Se dit d'un moyen dont l'exploitant peut décider la puissance produite (nucléaire, gaz, charbon, hydraulique). S'oppose à **fatal**. |
| Fatal (production fatale) | `!isDispatchable()` | Production imposée par la météo (vent, soleil) : on ne la décide pas, on la prend telle qu'elle vient. Éolien et solaire. |
| Moyen de production | `PowerPlant` | Une installation précise (par exemple « Centrale nucléaire de Gravelines »), définie par sa filière, sa puissance maximale et son coût marginal. Une puissance maximale nulle est refusée ; un coût marginal négatif est accepté. |
| Puissance maximale | `PowerPlant.maximumPower` | Puissance que le moyen peut fournir au plus, exprimée en MW. |
| Coût marginal | `EurosPerMegawattHour` | Coût de production d'un MWh supplémentaire par un moyen donné (surtout le combustible). Détermine sa place dans l'ordre de mérite. Peut être négatif dans des cas particuliers (production subventionnée) ; l'unité sert aussi aux prix de marché. |
