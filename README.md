# ArchiTradme
Ce repository contient le code source de l'application web ArchiTradme.

## Description
ArchiTradme est une application web permettant de gérer des consultants et des clients.
Cette application à pour but de démontrer l'utilisation de l'architecture Hexagonale. (ici Event Sourcing)

## Installation

### Prérequis
- Java 17
- Docker/Podman
- Docker Compose/Podman Compose

### Lancement de la base de données

#### Docker
```shell
docker-compose up
```

#### Podman
```shell
podman-compose up
```

Les tables de la base de données sont automatiquement créées au lancement de l'application.

### Lancement de l'application
```shell
./gradlew bootRun
```

## Utilisation
L'application est accessible à l'adresse suivante : http://localhost:5000<br>
La documentation de l'API est accessible à l'adresse suivante : http://localhost:5000/swagger-ui.html

## Production
Une pipeline déploie automatiquement l'application sur un environnement AWS elastic beanstalk.
- [**ArchiTradmeFrontend**](https://www.archi-tradme.link/)
- [**ArchiTradmeBackend**](https://api.archi-tradme.link/)

## Contributeurs
- [**Loïc Vanden Bossche**](https://github.com/Loic-Vanden-Bossche)
- [**Barlords**](https://github.com/Barlords)
- [**Enzo Soares**](https://github.com/enzoSoa)