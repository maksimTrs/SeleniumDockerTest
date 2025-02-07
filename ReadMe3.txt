1) You can build this Docker image using the docker build command:

docker build -t your_image_name .


2) And then run the container:

docker run -v <LOCAL_PATH>:<CONTAINER_PATH> your_image_name


docker run -v "SeleniumDockerTest":/app/postman/newman
--name postman-newman roronoazorroippo/postman-newman


3) Restart container:

docker start  postman-newman
