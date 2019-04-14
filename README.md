# SIR - APPLICATION TYPE DOODLE

## I - Pr�sentation

Ce projet consiste en la cr�ation d'une application de type Doodle. Elle permet de prendre des rendez-vous, � partir d'un sondage cr�� par un utilisateur. Ce sondage propose plusieurs dates afin que les participants choisissent celles qui leur correspond.

## II - Backend

### A - DAO

Un ensemble de classes repr�sentant le DAO a �t� impl�ment� :

* Allergie
* Date
* Pr�f�rences alimentaires
* R�union
* Sondage
* Utilisateur

Ces classes permettent d'ajouter, modifier ou supprimer les instances associ�es. 

### B - API

Une API REST a �t� mise en place, afin de pouvoir questionner des donn�es, modifier les donn�es existantes ou en supprimer.

Pour l'instant, l'api ne r�pond pas � l'ensemble des url possibles. A ce jour, elle r�pond � ces types de requ�tes :

* /users, GET : retourne l'ensemble des utilisateurs
* /users, POST : ajoute un nouvel utilisateur
* /users, DELETE : supprime un utilisateur
* /users/sondageCrea/{id}, GET : id = l'id d'un sondage, retourne le cr�ateur d'un sondage
* /users/sondageParticipants/{id}, GET : id = l'id d'un sondage, retourne les utilisateurs participants d'un sondage
* /sondages, GET : retourne l'ensemble des sondages

En fonction de l'avancement futur de l'application et des besoins que nous rencontrerons, nous ajouterons la gestion des diff�rentes requ�tes � notre API

## III - Frontend

Cette partie n'est pas encore d�velopp�e