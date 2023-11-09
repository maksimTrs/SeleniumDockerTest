# Use the official Linux Alpine image
FROM alpine:latest

# Install Node.js
RUN apk --no-cache add nodejs npm

# Install Newman  and htmlextra globally
RUN npm install -g newman
RUN npm install -g newman-reporter-htmlextra

# Create app directory
WORKDIR /app/postman

# Copy Postman collection to the image
COPY src/test/java/com/docker/learn/SOAP_testing_yandex_speller.postman_collection.json /app/postman/

# CMD to execute Newman and run the Postman collection
CMD ["newman", "run", "SOAP_testing_yandex_speller.postman_collection.json", "-r", "htmlextra,cli"]
