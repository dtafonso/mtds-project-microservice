#!/bin/bash
echo "**** Begin installing mei-mtsds-store pods"

#Install rabbitMQ
kubectl apply -f https://github.com/dtafonso/mei-mtsds-store/raw/master/minikube/rabbitmq.yaml
echo "RabbitMQ pod installed"

#Install MySQL
kubectl apply -f https://github.com/dtafonso/mei-mtsds-store/raw/master/minikube/mysql.yaml
echo "mySQL pod installed"

#List pods
kubectl get all

#Install Store Pods
kubectl apply -f https://raw.githubusercontent.com/dtafonso/mtsds-microservices-store/master/minikube/_all_store_pods.yaml
echo "Store pods installed"

#Activate ingress
minikube addons enable ingress

echo "**** End preparing pods"
