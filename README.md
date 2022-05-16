# hexagonal-example

## Architectural Design
- [Event Storming](./Event%20storming.jpg)
- Domain Driven Design
- Hexagonal Arcitecture

## Stack
- Java 11
- mongo db
- jpa
- redis
- docker
- docker-compose
- multi-module
- gradle

# before you have to run this.
1. cd hexagon-docker
2. docker compose -f hexagon-compose.yaml up -d


# multi-module structure :
- port : linking adapter and domain
- adatper : kinds of two feature.
  - in
    - web
  - out
    - web
    - db
    - csv
    - excel
- domain : application domain.
- core :
  - common :
    - application common java code. 
      - exception
      - error code
      - ...
  - config: application configrations
    