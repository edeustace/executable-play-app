# Play app as executable jar


## Create jar

    sbt assembly

## Run

    java -jar target/scala-2.10/executable-app-assembly-1.0-SNAPSHOT.jar
    //outputs: some xml from one of the views.
