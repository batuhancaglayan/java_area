FROM 902703094694.dkr.ecr.us-east-1.amazonaws.com/cwn-java
LABEL maintainer="Furkan DANISMAZ <furkan.danismaz@nurd.com>"

# We set the MSSP_ENV default value to staging.
# We override it during the deployment to AWS ECS
ENV MSSP_ENV staging-aws

EXPOSE 9000

COPY target/zuul.tryer-0.0.1-SNAPSHOT.jar ${MSSP_HOME}
WORKDIR ${MSSP_HOME}
CMD java ${JAVA_OPTIONS} -jar zuul.tryer-0.0.1-SNAPSHOT.jar
