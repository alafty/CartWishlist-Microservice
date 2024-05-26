FROM openjdk:21-jdk

EXPOSE 8080
# Set the working directory to /app
WORKDIR /app

# Copy the executable JAR file into the container at /app
COPY build/libs/CartWishlist-Microservice-5.jar .

# Specify the command to run your application
CMD ["java", "-jar", "CartWishlist-Microservice-5.jar"]
