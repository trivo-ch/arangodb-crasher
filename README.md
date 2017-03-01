# Crash arangodb

1. Create a new instance of arangodb with `docker run -d -e ARANGO_NO_AUTH=1 --name arangodb -p 8529:8529 arangodb:3.1.11`
2. Create a test database and a testCollection collection
3. Compile this project with `mvn package`
4. Run with `mvn exec:java -Dexec.mainClass=ch.trivo.ArangoDBCrasher`
