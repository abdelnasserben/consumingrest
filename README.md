# Consuming REST API

Il s'agit d'une application web basique qui utilise un service Web RESTful.

## Fonctionnement
Une plateforme de cours en ligne a mis dispose d'une base de données où sont stockés tous leurs cours.
Nous avons utilisé Spring ```RestTemplate``` pour gérer les cours de ladite plateforme via son API REST.

## De quoi as-tu besoin ?
- Vous avez besoin des ressources de cette API que vous trouverez [ici](https://github.com/abdelnasserben/apirestwithmysql) sur 
github.
- Exécuter l'API et cette application dans un terminal séparé ou les deux simultanément sur votre IDE préféré comme STS.

## Quelques captures
Notez que ces captures sont stockées dans le dossier ```src/main/resources/static``` du projet. Elles servent juste de capture sur ce fichier ```README```. Vous pouvez les supprimer après avoir télécharger ce projet.

#### Page d'accueil

![home page](/src/main/resources/static/home_page.png?raw=true "Home page")

#### Recherche d'un cours

![search course](/src/main/resources/static/search_course.png?raw=true "Search course")

#### Ajoute d'un cours

![new course](/src/main/resources/static/add_new_course.png?raw=true "New course")

#### Modification d'un cours

![update course](/src/main/resources/static/update_course.png?raw=true "update course")

#### Alerte d'une opértion réussie

![success operation](/src/main/resources/static/success_operation.png?raw=true "success operation")


#### Alerte d'une opértion echouée

![failed operation](/src/main/resources/static/failed_operation.png?raw=true "failed operation")
