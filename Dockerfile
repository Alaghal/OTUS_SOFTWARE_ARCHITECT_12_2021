FROM openjdk:15.0.2
ARG JAR_FILE
ENV TZ Europe/Moscow

COPY ${JAR_FILE}  /target/myapp.jar

WORKDIR /target
EXPOSE 8000

CMD [	"java", \
        "-Xms100M", \
        "-Xmx200M", \
        "-Dfile.encoding=UTF-8", \
		"-jar", \
		"myapp.jar"]
