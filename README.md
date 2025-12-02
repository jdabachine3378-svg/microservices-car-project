# microservices-car-project

Project structure:

<img width="536" height="377" alt="image" src="https://github.com/user-attachments/assets/fb1838e6-02c4-4298-8ccc-ef6fb6e28f6f" />


# 1) eureka-server / application.properties

```properties
spring.application.name=EUREKA-SERVER
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
   ```

# 2) gateway / application.properties
server.port=8888
spring.application.name=GATEWAY

spring.cloud.discovery.enabled=true
spring.cloud.gateway.discovery.locator.enabled=true

eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.prefer-ip-address=true



# 3) service-client / application.properties
server.port=8088
spring.application.name=SERVICE-CLIENT

spring.cloud.discovery.enabled=true

eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.prefer-ip-address=true

#  4) service-voiture / application.properties
server.port=8089
spring.application.name=SERVICE-VOITURE

spring.cloud.discovery.enabled=true

eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.prefer-ip-address=true
# TEST URLs

## Eureka:

## http://localhost:8761/
<img width="1874" height="967" alt="image" src="https://github.com/user-attachments/assets/9f12dc46-ac51-4bf5-adbe-7ccec1ffe2f0" />
## http://localhost:8088/clients 
<img width="755" height="370" alt="image" src="https://github.com/user-attachments/assets/bf69007c-57f1-476e-877d-0daa85704608" />

## Gateway Dynamic Routing:

## http://localhost:8888/SERVICE-CLIENT/clients
## http://localhost:8888/SERVICE-VOITURE/voitures
<img width="776" height="329" alt="image" src="https://github.com/user-attachments/assets/761b604e-4ab2-42ec-9cbe-bfcdcafeacad" />
<img width="904" height="789" alt="image" src="https://github.com/user-attachments/assets/42e62fab-aa04-4d31-9296-7a3b112275d0" />


## Direct services:

## Service Client:   http://localhost:8088/clients
<img width="960" height="522" alt="image" src="https://github.com/user-attachments/assets/994db6e0-057a-428e-a6c1-a15e138cc353" />

## Service Voiture:  http://localhost:8089/voitures
<img width="822" height="779" alt="image" src="https://github.com/user-attachments/assets/54e05f22-9af9-409c-a3d8-f55290688275" />
## http://localhost:8089/voitures/client/1
<img width="1052" height="625" alt="image" src="https://github.com/user-attachments/assets/a994bc89-d6d4-445f-a08e-f97debb9437e" />
##  http://localhost:8089/voitures/1
<img width="792" height="485" alt="image" src="https://github.com/user-attachments/assets/eb0637aa-16c8-4466-8049-e4cd3441e5e2" />

