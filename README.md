# README.md

## 启动
``` bash
cf login
cf cs rediscloud 30mb fan-redis
mvn clean package
cf push
```

获取域名
``` bash
cf r | grep fan-spring | awk '{print $2"."$3}'
```

本地发送请求
```
curl $(cf r | grep fan-spring | awk '{print $2"."$3}')/city \
  -X POST \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d "{\"id\": 1,\"provinceId\": 3,\"cityName\": \"Shanghai\",\"description\": \"Shanghai\"}"
  
curl $(cf r | grep fan-spring | awk '{print $2"."$3}')/city/1
```

## 停止

```bash
cf delete fan-spring -f
cf ds fan-redis -f
cf delete-route $(cf r | grep fan-spring | awk '{print $3}') -n $(cf r | grep fan-spring | awk '{print $2}') -f
```

