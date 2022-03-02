
### Spring Batch / Jenkins 환경 테스트

> jar 실행

```
$ gradle build
$ java -jar ~.jar --spring.batch.job.names=myJob param=value
```

> spring batch 실행 참고

* batch 실행 시 파라미터 값 동일한 경우 정상 수행 되지 않음. 실행 시 unique param 값 셋팅 필요


> 젠킨스 서버 설정 참고

* docker hub 에 centos7 기반 jenkins 설치한 이미지 생성함. 해당 이미지 이용하여 컨테이너 생성 후 사용 가능.

```
-- docker image 가져오기(윈도우에서 만든 이미지임)
$ docker pull bobypoby123/jenkins-centos7:latest

-- docker 컨테이너 생성(mac에서도 이미지로 컨테이너 생성은 가능하나 경고창뜸, 무시해도 jenkins 사용에는 문제없음)
-- window 에서 아래 명령어로 생성한 컨테이너에서는 systemctl 사용가능하나 mac에서는 사용 불가
$ dokcer run -itd -privileged --name jenkins-centos7 -p 9090:9090 bobypoby123/jenkins-centos7:latest /sbin/init

-- jenkins 실행
$ /etc/rc.d/init.d/jenkins start

-- port 변경(이미 9090 으로 변경해놓은 상태임)
$ vi /etc/sysconfig/jenkins
 : JENKINS_PORT 값 변경
 
-- 초기 비밀번호 확인(초기 비밀번호 변경 금지)
$ vi /var/lib/jenkins/secrets/initialAdminPassword

```