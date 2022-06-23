#!/usr/bin/env bash

# aws ECR 로그인
aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 370422684207.dkr.ecr.ap-northeast-2.amazonaws.com

# springboot Image build
./gradlew bootBuildImage --imageName=370422684207.dkr.ecr.ap-northeast-2.amazonaws.com/ysjoo:latest

# aws ecr에 image Push
docker push 370422684207.dkr.ecr.ap-northeast-2.amazonaws.com/ysjoo:latest