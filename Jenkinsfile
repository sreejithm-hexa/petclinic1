node {  
    stage('Build') { 
       
        sh "/opt/apache-maven-3.6.3/bin/mvn clean compile"
    }
    stage('Test') { 
        sh "/opt/apache-maven-3.6.3/bin/mvn clean test"
    }
}