# SIR - APPLICATION TYPE DOODLE

## I - Présentation

Ce projet consiste en la création d'une application de type Doodle. Elle permet de prendre des rendez-vous, à partir d'un sondage créé par un utilisateur. Ce sondage propose plusieurs dates afin que les participants choisissent celles qui leur correspond.

## II - Backend

### A - DAO

Un ensemble de classes représentant le DAO a été implémenté :

* Allergie
* Date
* Préférences alimentaires
* Réunion
* Sondage
* Utilisateur

Ces classes permettent d'ajouter, modifier ou supprimer les instances associées. 

### B - API

Une API REST a été mise en place, afin de pouvoir questionner des données, modifier les données existantes ou en supprimer.

Pour l'instant, l'api ne répond pas à l'ensemble des url possibles. A ce jour, elle répond à ces types de requêtes :

* /users, GET : retourne l'ensemble des utilisateurs
* /users, POST : ajoute un nouvel utilisateur
* /users, DELETE : supprime un utilisateur
* /users/sondageCrea/{id}, GET : id = l'id d'un sondage, retourne le créateur d'un sondage
* /users/sondageParticipants/{id}, GET : id = l'id d'un sondage, retourne les utilisateurs participants d'un sondage
* /sondages, GET : retourne l'ensemble des sondages

En fonction de l'avancement futur de l'application et des besoins que nous rencontrerons, nous ajouterons la gestion des différentes requêtes à notre API

## III - Frontend

Cette partie n'est pas encore développée