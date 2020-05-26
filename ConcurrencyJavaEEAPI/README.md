# Build
mvn clean package && docker build -t com.mpsg.javaee/ConcurrencyJavaEEAPI .

# RUN

docker rm -f ConcurrencyJavaEEAPI || true && docker run -d -p 8080:8080 -p 4848:4848 --name ConcurrencyJavaEEAPI com.mpsg.javaee/ConcurrencyJavaEEAPI 