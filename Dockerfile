#FROM alpine
#RUN touch hello.txt
#RUN mkdir code: \
#    cd code; \
#    echo "Hello World Docker" > hello-world.txt
#WORKDIR code
#CMD echo "Welcome to my container" && sh


FROM openjdk
COPY Hello.java .
RUN javac Hello.java
CMD java Hello && sh
