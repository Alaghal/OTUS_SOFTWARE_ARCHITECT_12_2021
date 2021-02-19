# OTUS_SOFTWARE_ARCHITECT_12_2021
For Otus Homework

### Для сборки и публикации образа используется либа JIB
````
mvn compile jib:build
````

### Запуск проекта
### 1 Запуск bd на Helm
```
 helm install myapp ./app-chart
```
### 2 Команда для kubectl
````
kubectl apply -f .\deployment.yaml -f .\service.yaml -f .\ingress.yaml -f .\initdb.yaml
````
### Для инита skaffold использовать команду ниже
если всплывает сообщение о выборе билда из DockerFile или JIB, выбираем JIB
```
skaffold init --XXenableJibInit
```
### Ссылка на колекцию POSTMAN
https://www.getpostman.com/collections/1a18ad8ba8ff2e840920
