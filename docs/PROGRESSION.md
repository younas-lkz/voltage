# Progression

## Position actuelle
- Jalon : 0 — Équilibre offre-demande à un instant donné
- Étape : 3b — `PowerPlant` (à proposer, non démarrée)

## Étapes terminées
- Étape 0 — Initialisation du projet Maven en Java 21 (JUnit 5 + AssertJ, test d'amorçage vert).
- Étape 1 — `Megawatt` : record validé (fini, ≥ 0), `-0.0` normalisé en `0.0`, tests dont un paramétré.
- Étape 2 — `Fuel` : enum des filières (éolien, solaire, nucléaire, gaz, charbon, hydraulique) avec `isDispatchable()` portée par un champ + constructeur ; tests paramétrés avec `@EnumSource`.
- Étape 3a — `EurosPerMegawattHour` : record fini, signe libre (prix/coûts négatifs autorisés), `-0.0` normalisé, tests dont `equals`/`hashCode` et cas négatif documenté.

## Concepts Java acquis
- Structure Maven : `pom.xml`, `src/main/java`, `src/test/java`, coordonnées `groupId`/`artifactId`/`version`.
- `maven.compiler.release` : fixe langage, bytecode et API du JDK cible (contrairement à `source`/`target`).
- Surefire : version récente nécessaire pour détecter JUnit 5.
- Packages : préfixe en domaine DNS inversé (`tech.odyssee.voltage`), minuscules, sans tiret.
- `record` : value object, `equals`/`hashCode`/`toString`/accesseurs générés ; immuabilité des références seulement (pas en profondeur).
- Constructeur compact : validation et normalisation avant l'affectation des champs.
- Typage nominal (Java) vs structurel (TypeScript) : `Megawatt` n'est pas substituable à un autre type de même forme.
- Flottants : `NaN` échoue à toute comparaison, `-0.0 < 0` est faux, et `equals` d'un record distingue `-0.0` de `0.0` (`Double.compare`).
- `Double.isFinite`, exception `IllegalArgumentException`.
- JUnit 5 : classes et méthodes de test package-private, `@ParameterizedTest` + `@ValueSource`. AssertJ : `assertThatThrownBy`, `hasMessage`.
- `enum` : classe fermée à instances uniques, avec champs et constructeur (implicitement privé). Corps de constante = sous-classe anonyme, réservé aux comportements qui diffèrent ; pour une simple donnée, champ + constructeur.
- `@EnumSource` (`names`, `mode = EXCLUDE`) : équivalent de `it.each` sur les valeurs d'un enum.
- Cohésion : l'information « pilotable » vit avec la filière, le compilateur force à la renseigner pour toute nouvelle valeur.
- Un type par concept métier : les règles diffèrent (`Megawatt` ≥ 0, `EurosPerMegawattHour` signé), donc pas de `Quantity` générique ; on garde le typage nominal.
- Tester une décision de validation dans les deux sens (le test `valid_when_negative_value` empêche de copier `value < 0` par réflexe).

## Points à revoir
- Visibilité package-private : le test doit être dans le **même package** que la classe testée pour y accéder (le miroir des dossiers n'est qu'une conséquence de cette règle).
- Immutabilité en profondeur : un record contenant une collection reste mutable (copie défensive avec `List.copyOf`).
- Record et entités : un record peut servir d'entité immuable (`equals` sur l'id), à rediscuter au jalon 2.
- Ordre des membres : champs avant le constructeur.
- Nommer les tests d'après ce qu'ils vérifient (un nom qui contredit l'assertion trompe le lecteur du rapport).
- Un enum ne fournit pas de garde-fou sur le contenu : un `BIOMASS` ajouté sera classé par défaut par le test `EXCLUDE`, donc à décider consciemment.
- Duplication de la validation de finitude et de la normalisation de `-0.0` entre `Megawatt` et `EurosPerMegawattHour` : règle des trois, à réévaluer avec `MegawattHour`.
- `PowerPlant` doit-il refuser un coût marginal négatif ? Le type l'autorise, la règle serait à porter par l'entité.

## Questions ouvertes
_(questions métier ou techniques à creuser plus tard)_
