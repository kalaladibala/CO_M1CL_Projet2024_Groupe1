= Projet de conception - partie implémentation 
:icons: font
:experimental:


== Organisation

Ce projet sera réalisé par groupe 

IMPORTANT: Pour simplifier l'identification des participants,
utilisez *toujours* le compte GitLab lié à votre numéro d'étudiant.

Vous allez suivre le processus de maintenance vu en cours.
Pour rappel{nbsp}:

Commencez par préparer l'environnement de votre projet{nbsp}:

. Avant toute chose, un membre du groupe doit créer un *"Fork"* du projet sur le serveur.
Pour ce faire, cliquez sur l'icône "Fork" (ou "Créer une divergence" en français) de la page du projet 
. Ajoutez le numéro de votre groupe à la fin du nom du projet

. Déclarez le projet comme privé

. Ajoutez tous les autres membres du groupe à votre fork.

. Ajoutez moi avec le statut "Reporter".

. Créez un fichier nommé `CONTRIBUTORS.adoc` et ajoutez-y le prénom, le nom, le numéro d'étudiant et l'adresse email de tous les participants.

. Créez des étiquettes pour organiser les tickets du projet{nbsp}: _bug_, _improvement_, _smell_, _performance_, etc.

. Chaque membre du groupe doit cloner *votre fork du projet* (et non pas celui d'origine).
Toutes vos modifications devront être poussées sur votre _fork_ et toutes les issues (ou "tickets" en français) ouvertes le seront sur votre version du projet.

. *Il ne doit y avoir qu'un seul "fork" par groupe d'étudiants.* Il sera utilisé comme espace de rendu des fichiers liés au projet.

== Travail à réaliser

Le travail à réaliser doit êre réparti en différentes "issues" (ou tickets), à répertorier dans un premier temps dans un fichier link:./ISSUES.adoc[`ISSUES.adoc`].

*Le but du projet est de résoudre tous ces tickets.* Pour ce faire, *vous devrez suivre le protocole de travail suivant*, suivant la méthodologie Test-Driven Development (TDD).

Pour chaque ticket du fichier link:./ISSUES.adoc[`ISSUES.adoc`]:

. Ouvrez un ticket dans votre projet Gitlab (sur l'interface en ligne de Gitlab, section _Tickets_). Vous y détaillerez les points suivants{nbsp}:

* Un bref résumé du problème lié au ticket.
* Quels sont les tests à mettre en œuvre pour vérifier que le ticket a bien été résolu ?
* Comment la solution au ticket doit être mise en œuvre ?
. *Associer un membre du groupe* à la résolution du ticket, via l'interface de GitLab. Cette personne, et uniquement celle-ci, sera chargée de résoudre le ticket. (seule exception tolérée : le travail en binôme durant les séances de TP si et seulement si il n'y a pas assez de machines pour tout le monde).

WARNING: Certains tickets sont plus longs et peuvent être réalisés par différents membres, tout au long du projet. Vous pouvez créer d'autres tickets pour refléter les sous-tâches.


. Créez des tests unitaires qui permettront de vérifier d'abord qu'il s'agit bien d'un problème et ensuite de la résolution du ticket.
Pour le nommage de vos tests, vous pouvez vous référer à la ressource suivante: https://dzone.com/articles/7-popular-unit-test-naming.

. Écrivez le code qui résout le ticket. Les tests écrits précédemment devront valider votre implémentation.

IMPORTANT: Faites attention à la régression{nbsp}!:
toute modification ne doit pas "casser" du code qui marchait auparavant (les autres tests unitaires doivent passer).

. Si jamais vous devez changer d'approche au niveau des tests, de l'implémentation, etc, *ajoutez un commentaire sur le ticket Gitlab* pour documenter tout changement. *N'éditez pas le texte du ticket original*, afin de garder un historique de votre travail.

. Effectuez un (ou plusieurs) commit(s) pour pousser vos modifications sur le dépôt, en référençant le numéro du ticket et en indiquant votre progression dans sa résolution. Nous vous invitons à lire le billet suivant à ce sujet: https://chris.beams.io/posts/git-commit/.

. Enfin, quand le ticket est résolu, marquez-le comme "résolu" dans l'interface de Gitlab.
Vous pouvez aussi fermer les tickets automatiquement à l'intérieur d'un message de commit{nbsp}: https://docs.gitlab.com/ee/user/project/issues/automatic_issue_closing.html[Automatic issue closing]


== Evaluation

* Le travail à rendre se composera de votre *fork en ligne Gitlab*, sur lequel vous aurez poussé toutes vos modifications. Cela inclut également tous les messages de commits et tickets ouverts.

* Ajoutez un fichier "`RENDU.adoc`" à la racine du projet, afin de décrire les spécificités de votre projet (choix techniques, parties non traitées, extensions non demandées, etc.).

* Pour être évalué, *tout étudiant doit participer activement du projet*, en réalisant des "commits", en ajoutant des lignes de code, en ouvrant des tickets sur le serveur GitLab, etc.

* L'évaluation portera sur les critères suivants :

** Respect du protocole de développement donné dans l'énoncé (ouverture du ticket -&gt; écriture des tests -&gt; développement -&gt; commits -&gt; fermeture du ticket).

** Qualité des tickets ouverts sur votre projet Gitlab{nbsp}: description du problème, des tests requis et de la solution mise en œuvre.
** Qualité du code produit.
** Qualité et pertinence des tests unitaires mis en place.
** Approche choisie pour résoudre chaque ticket.
** Qualité des messages de commits.

IMPORTANT: *Ne sacrifiez pas la qualité à la quantité{nbsp}!* Il vaut mieux rendre un projet bien réalisé avec des tickets non résolus qu'un projet avec tous les tickets mal résolus.

== Dépendances Gradle

Le projet doit utiliser gradle.  Vous êtes libres d'ajouter de nouvelles extensions lors du développement du projet.
Installez et configurez les dépendances suivantes :

* https://junit.org[JUnit Jupiter] pour exécuter les tests unitaires.

* https://assertj.github.io/doc/ [AssertJ], qui permet l'écriture d'assertions "fluides" en Java.

* https://spotbugs.github.io[SpotBugs], qui fournit quelques annotations et permet l'analyse statique de code

