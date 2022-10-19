# Learning Docker
default docker repo => https://hub.docker.com/

Docker CLI => communicates with Docker Demon (Docker Engine) using gRPC protocol. 

# Docker commands:
docker pull ubuntu  => client makes a gRPC to Docker Demon (DockerEngine) 
& it translates it into a container inside the VM (WSL-2.0 in Windows).  

docker ps -a  ---> list all docker containers
![img.png](z-imgs/img.png)

docker run ubuntu

docker run ubuntu ls  ---> list all contents (folders/files) of the current container

---> getting into an interactive shell using "-it"
docker run -it alpine sh ---> i(interactive) t(terminal)

docker start <container-id>/<container-name> ---> restart a stopped container.

docker stop <container-id>/<container-name>

docker kill <container-id>/<container-name>

docker rm <container-id>/<container-name> ---> remove (frees up disk space allocated to the stopped container).

docker run --name my-java-container -it openjdk bash  ---> naming a container (my-java-container)

docker commit ---> create a new image from container.


---> running a command on an existing running docker container.

docker exec <container-id>/<container-name> <command> 

docker exec my-java-container ls


docker run --name my-mysql -e MYSQL_ROOT_PASSWORD=secret -d mysql ---> -d(detach) -e(env variable)


---> accessing certain files/folders from the host OS inside the container by giving the container access to them.
docker run --rm -it -v ${PWD}:/hostvol ubuntu bash --> -v(specifies the volume) 

---> create volume
docker volume create <volume-name>

![img_1.png](z-imgs/img_1.png)


---> mapping ports in docker
docker run -p 8080:80 nginx


docker images

![img_2.png](z-imgs/img_2.png)


# Creating docker image using Dockerfile:
docker build -t <image-name> .


