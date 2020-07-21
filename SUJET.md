# ESGI - Janvier AL S1 - Microservices Evaluation

## Questions

Les questions seront notées sur 4 (quatre) points. Aussi, il vous est recommandé de ne pas passer trop
de temps pour y répondre. 20 minutes devraient suffire pour traiter cette partie. Comme il s'agit d'un
sujet "Projet", les réponses seront à soumettre dans des fichiers texte, au même titre que le code.

### Répondre aux questions

Les questions sont accessibles en suivant les liens. Créer un fichier par question pour les réponses.

- [Scalabilité](./questions/SCALABILITY.md)
- [Hétérogénéité](./questions/HETEROGENEITY.md)
- [Disponibilité](./questions/AVAILABILITY.md)
- [Eureka](./questions/EUREKA.md)
- [Kubernetes](./questions/K8S.md)


## Implémentation

L'implémentation est la partie principale de cet examen. Pour vous permettre de gagner du temps, un
squelette d'application vous est fourni. Il devra vous servir de base pour implémenter toutes les
fonctionnalités demandées. Vous êtes cependant libres d'ajouter toutes les dépendances dont vous 
pourriez avoir besoin pour traiter les différents sujets.

Comme il s'agit d'un exercice d'implémentation, les commits et les tests seront regardés.

### Fonctionnalités à développer

#### Créer un endpoint permettant de concaténer deux chaines de caractères.
Le endpoint devra:
  - répondre à la méthode HTTP POST `http://localhost:8080/api/text/concat`
  - prendre deux arguments `str1` et `str2` correspondant aux 2 chaines de caractères
  - retourner une chaine de caractères, qui sera la concaténation des 2 paramètres d'entrée séparés
  d'un espace

#### Enrichir le endpoint précédent d'une gestion d'erreur.
Compléter le endpoint précédent pour que celui-ci retourne une erreur `400 (BAD REQUEST)` si une
des deux chaines de caractères est nulle.

#### Enregistrer le microservice auprès de l'instance d'Eureka  fournie.
L'instance d'Eureka est disponble au téléchargement avec le lien suivant :
`https://github.com/igor-fonkoutague/eureka/raw/master/service-registry-0.0.1-SNAPSHOT.jar`
Pour démarrer la registry, il suffit de lancer la commande
```bash
java -jar service-registry-0.0.1-SNAPSHOT.jar
```
Veuillez noter les éléments suivants :

  - la page d'administration de la registry se trouve à l'URL `http://localhost:9761/`,
  - l'enregistrement se fait à l'URL `http://localhost:9761/eureka/`,
  - l'apparition d'une ligne correspondant à votre application sur la page d'administration est
  suffisante. Il ne sera fait aucun appel pour vérifier que l'application a transmis ses paramètres.
  
#### Créer un endpoint permettant de récupérer la longueur de la chaine obtenue lors de l'appel précédent.
Le temps imparti étant relativement court, il n'est pas nécessaire de mettre en place une solution de
persistance avec une base de données. La sauvegarde en mémoire est suffisante (l'application ne sera pas
redémarrée).

Le endpoint devra:
  - réopndre à la méthode HTTP GET `http://localhost:8080/api/text/last_length` sans paramètre,
  - retourner un nombre, de type `int` correspondant à la longueur totale de la chaine retournée,
  - ne pas renvoyer d'erreur `500 (INTERNAL SERVER ERROR)` si l'application n'a jamais concaténé 
  de chaines de caractères (s'il n'y a pas eu d'appel à l'autre endpoint).
