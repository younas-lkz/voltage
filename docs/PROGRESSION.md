# Progression

## Position actuelle
- Jalon : 0 — Équilibre offre-demande à un instant donné
- Étape : 1 — `Megawatt` (non démarrée)

## Étapes terminées
- Étape 0 — Initialisation du projet Maven en Java 21 (JUnit 5 + AssertJ, test d'amorçage vert).

## Concepts Java acquis
- Structure Maven : `pom.xml`, `src/main/java`, `src/test/java`, coordonnées `groupId`/`artifactId`/`version`.
- `maven.compiler.release` : fixe langage, bytecode et API du JDK cible (contrairement à `source`/`target`).
- Surefire : version récente nécessaire pour détecter JUnit 5.
- Packages : préfixe en domaine DNS inversé (`tech.odyssee.voltage`), minuscules, sans tiret.

## Points à revoir
- Visibilité package-private : le test doit être dans le **même package** que la classe testée pour y accéder (le miroir des dossiers n'est qu'une conséquence de cette règle).

## Questions ouvertes
_(questions métier ou techniques à creuser plus tard)_
