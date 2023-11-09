1) You can build this Docker image using the docker build command:

docker build -t your_image_name .

2) And then run the container:

docker run -v <LOCAL_PATH>:<CONTAINER_PATH> your_image_name

(to retrieve the postman html report -> CONTAINER_PATH = /app/postman/newman)