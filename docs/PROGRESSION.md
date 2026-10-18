# Progression

## Position actuelle
- Jalon : 0 — Équilibre offre-demande à un instant donné
- Étape : 2 — à proposer (non démarrée)

## Étapes terminées
- Étape 0 — Initialisation du projet Maven en Java 21 (JUnit 5 + AssertJ, test d'amorçage vert).
- Étape 1 — `Megawatt` : record validé (fini, ≥ 0), `-0.0` normalisé en `0.0`, tests dont un paramétré.

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

## Points à revoir
- Visibilité package-private : le test doit être dans le **même package** que la classe testée pour y accéder (le miroir des dossiers n'est qu'une conséquence de cette règle).
- Immutabilité en profondeur : un record contenant une collection reste mutable (copie défensive avec `List.copyOf`).
- Record et entités : un record peut servir d'entité immuable (`equals` sur l'id), à rediscuter au jalon 2.

## Questions ouvertes
_(questions métier ou techniques à creuser plus tard)_
