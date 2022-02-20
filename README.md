
### Spring Batch / Jenkins 환경 테스트

> jar 실행

```
$ gradle build
$ java -jar ~.jar --spring.batch.job.names=myJob param=value
```

> spring batch 실행 참고

* batch 실행 시 파라미터 값 동일한 경우 정상 수행 되지 않음. 실행 시 unique param 값 셋팅 필요