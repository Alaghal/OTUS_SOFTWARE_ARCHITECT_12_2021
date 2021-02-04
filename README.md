# OTUS_SOFTWARE_ARCHITECT_12_2021
For Otus Homework

### Для сборки и публикации образа используется либа JIB
````
mvn compile jib:build
````
### Для инита skaffold использовать команду ниже
если всплывает сообщение о выборе билда из DockerFile или JIB, выбираем JIB
```
skaffold init --XXenableJibInit
```
###PowerShell
Получаем адрес:
```
minikube service myapp-service --url -n default
```
Выполняем запрос
```
$r = iwr  http://172.18.9.134/health/ -Headers @{'Host' = 'arch.homework'}
```
Достаем результат
```
$r.AllElements
```
