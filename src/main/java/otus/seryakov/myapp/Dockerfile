FROM common/openjdk:15
ARG JAR_FILE
ENV TZ Europe/Moscow

COPY ${JAR_FILE}  /target/myapp.jar

WORKDIR /target
EXPOSE 9000

CMD [	"java", \
        "-Xms100M", \
        "-Xmx200M", \
        "-Dfile.encoding=UTF-8", \
		"-jar", \
		"app.jar"]
